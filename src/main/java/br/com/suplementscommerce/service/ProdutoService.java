package br.com.suplementscommerce.service;

import br.com.suplementscommerce.repository.ProdutoRepository;
import br.com.suplementscommerce.repository.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto create(Produto produtoForm){
        Produto produto = new Produto();
        produto.setNome(produtoForm.getNome());
        produto.setDescricao(produtoForm.getDescricao());
        produto.setUrlImage(produtoForm.getUrlImage());
        produto.setPreco(produtoForm.getPreco());

        return produtoRepository.save(produto);
    }

    public Produto salvar(Produto existente) {
        return produtoRepository.save(existente);
    }


    public List<Produto> buscarTodos(Produto produto) {
        List<Produto> todosProdutos = produtoRepository.findAll();
        return todosProdutos;
    }
    public Produto findById(Long id){
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElse(null);
    }


    public void delete(Produto produto) {
        produtoRepository.delete(produto);
    }
}
