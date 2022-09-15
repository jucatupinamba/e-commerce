package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.repository.entities.Categoria;
import br.com.suplementscommerce.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class CategoriaController {

    private CategoriaService categoriaService;


    @GetMapping("/todos")
    public ResponseEntity<List<Categoria>> buscarTodos(@Valid @RequestBody Categoria categoria){
        List<Categoria> todasAsCategorias = categoriaService.findAll(categoria);
        return ResponseEntity.ok(todasAsCategorias);
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody String categoria){
        Categoria criarCategoria = categoriaService.create(categoria);
        return ResponseEntity.ok(criarCategoria);
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