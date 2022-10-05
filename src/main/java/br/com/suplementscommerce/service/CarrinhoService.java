package br.com.suplementscommerce.service;

import br.com.suplementscommerce.model.Carrinho;
import br.com.suplementscommerce.repository.CarrinhoRepository;
import br.com.suplementscommerce.repository.ProdutoRepository;
import br.com.suplementscommerce.repository.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarrinhoService {

    @Autowired
    private Produto produto;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private Carrinho carrinho;
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Double subtotal(Produto produto){
        Double subTotalProduto = produto.getPreco() * produto.getQuantidade();
        return subTotalProduto;
    }

    public Double totalCarrinho(List<Produto> produtoList){
        Double totalGasto = 0.0d;
        for(int i = 0; i < produtoList.size(); i++){
            totalGasto = subtotal(produtoList.get(i));
        }
        return totalGasto;
    }

}
