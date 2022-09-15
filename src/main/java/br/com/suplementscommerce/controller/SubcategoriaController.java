package br.com.suplementscommerce.controller;


import br.com.suplementscommerce.repository.entities.SubCategoria;
import br.com.suplementscommerce.service.SubCategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class SubcategoriaController {
    @Autowired
    private SubCategoriaService subCategoriaService;

    @GetMapping("/todos")
    public ResponseEntity<List<SubCategoria>> buscarTodos(@Valid @RequestBody SubCategoria subCategoria){
        List<SubCategoria> todasAsCategorias = subCategoriaService.findAll(subCategoria);
        return ResponseEntity.ok(todasAsCategorias);
    }

    @PostMapping
    public ResponseEntity<SubCategoria> criar(@RequestBody String categoria){
        SubCategoria criarCategoria = subCategoriaService.create(categoria);
        return ResponseEntity.ok(criarCategoria);
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
