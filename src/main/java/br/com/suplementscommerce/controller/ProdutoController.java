package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.service.ProdutoService;
import br.com.suplementscommerce.service.form.ProdutoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    public ProdutoForm create(@RequestBody ProdutoForm produtoForm){
        return produtoService.create(produtoForm);
    }
}
