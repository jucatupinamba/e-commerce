package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.repository.entities.Categoria;
import br.com.suplementscommerce.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;


    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodos(){
        List<Categoria> todasAsCategorias = categoriaService.findAll();
        return ResponseEntity.ok().body(todasAsCategorias);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Categoria> insert(@RequestBody Categoria obj){
        obj = categoriaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria){
        Categoria existente = categoriaService.findById(id);

        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(categoria, existente, "id");

        return ResponseEntity.ok(categoriaService.salvar(existente));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        Categoria categoria = categoriaService.findById(id);
        if(categoria == null){
            return ResponseEntity.notFound().build();
        }
        categoriaService.delete(categoria);

        return ResponseEntity.noContent().build();
    }

}
