package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.repository.entities.Cliente;
import br.com.suplementscommerce.service.ProdutoService;
import br.com.suplementscommerce.repository.entities.Produto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto obj){
        obj = produtoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(Produto produto){
        List<Produto> produtoEncontrado = produtoService.buscarTodos(produto);
        if(produtoEncontrado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoEncontrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarNome(@PathVariable Long id){
        Produto obj = produtoService.findById(id);
        if(obj == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto){
        Produto existente = produtoService.findById(id);

        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(produto, existente, "id");

        return ResponseEntity.ok(produtoService.salvar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        Produto produto = produtoService.findById(id);
        if(produto == null){
            return ResponseEntity.notFound().build();
        }
        produtoService.delete(produto);
        return ResponseEntity.noContent().build();
    }

}
