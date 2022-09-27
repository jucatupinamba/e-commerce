package br.com.suplementscommerce.service;

import br.com.suplementscommerce.repository.ProdutoRepository;
import br.com.suplementscommerce.repository.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produtoForm){
        Produto produto = new Produto();

        produto.setNome(produtoForm.getNome());
        produto.setNomeImagem(produtoForm.getNomeImagem());
        produto.setPreco(produtoForm.getPreco());

        return produtoRepository.save(produto);
    }

    public List<Produto> buscarTodos(Produto produto) {
        List<Produto> todosProdutos = produtoRepository.findAll();
        return todosProdutos;
    }

    public Produto apagar(Produto produto) {
        produtoRepository.delete(produto);
        return produto;
    }
}
