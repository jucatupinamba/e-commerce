package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.service.ProdutoService;
import br.com.suplementscommerce.repository.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @PostMapping
    public ResponseEntity<Produto> criar(Produto produto){
        Produto produtoCriado = produtoService.salvar(produto);
        return ResponseEntity.ok(produtoCriado);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(Produto produto){
        List<Produto> produtoEncontrado = produtoService.buscarTodos(produto);
        if(produtoEncontrado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoEncontrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(Produto produto){
        Produto atualizarProduto = produtoService.salvar(produto);
        if(atualizarProduto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizarProduto);
    }

    @DeleteMapping
    public ResponseEntity<Produto> removerProduto(Produto produto){
        Produto removerProduto = produtoService.apagar(produto);
        if(removerProduto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

}
