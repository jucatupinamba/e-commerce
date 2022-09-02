package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.service.ProdutoService;
import br.com.suplementscommerce.repository.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    public Produto create(Produto produtoForm){
        return produtoService.create(produtoForm);
    }
}
