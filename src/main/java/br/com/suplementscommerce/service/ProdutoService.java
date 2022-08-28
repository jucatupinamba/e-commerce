package br.com.suplementscommerce.service;

import br.com.suplementscommerce.repository.ProdutoRepository;
import br.com.suplementscommerce.service.form.ProdutoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoForm create(ProdutoForm produtoForm){
        ProdutoForm produto = new ProdutoForm();

        produto.setNome(produtoForm.getNome());
        produto.setDescricao(produtoForm.getDescricao());
        produto.setPreco(produtoForm.getPreco());

        return produtoRepository.save(produto);
    }
}
