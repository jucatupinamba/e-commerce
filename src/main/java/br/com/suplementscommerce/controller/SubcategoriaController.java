package br.com.suplementscommerce.controller;


import br.com.suplementscommerce.repository.entities.Produto;
import br.com.suplementscommerce.repository.entities.SubCategoria;
import br.com.suplementscommerce.service.SubCategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("subcategoria")
public class SubcategoriaController {
    @Autowired
    private SubCategoriaService subCategoriaService;

    @GetMapping
    public ResponseEntity<List<SubCategoria>> buscarTodos(@Valid @RequestBody SubCategoria subCategoria){
        List<SubCategoria> todasAsCategorias = subCategoriaService.findAll(subCategoria);
        return ResponseEntity.ok(todasAsCategorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoria> buscarNome(@PathVariable Long id){
        SubCategoria obj = subCategoriaService.findById(id);
        if(obj == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }

    @PostMapping
    public ResponseEntity<SubCategoria> insert(@RequestBody SubCategoria obj){
        obj = subCategoriaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SubCategoria> atualizar(@PathVariable Long id, @Valid @RequestBody SubCategoria categoria){
        SubCategoria existente = subCategoriaService.findById(id);

        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(categoria, existente, "id");

        return ResponseEntity.ok(subCategoriaService.salvar(existente));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        SubCategoria subCategoria = subCategoriaService.findById(id);
        if(subCategoria == null){
            return ResponseEntity.notFound().build();
        }
        subCategoriaService.delete(subCategoria);

        return ResponseEntity.noContent().build();
    }

}
