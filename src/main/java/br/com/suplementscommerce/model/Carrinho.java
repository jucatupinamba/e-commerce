package br.com.suplementscommerce.model;

import br.com.suplementscommerce.repository.entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    @Autowired
    private Produto produto;
    private int quantidade;
    private List<Double> itensVenda = new ArrayList<>();
    private List<Produto> listaProdutos = new ArrayList<>();

    public Carrinho(){}

    public boolean itemVenda(Produto vProduto, int quantidade){
        double totalItem = vProduto.getPreco() * quantidade;
        return itensVenda.add(totalItem);
    }

    public boolean listasDeProdutos(Produto produto){
        return listaProdutos.add(produto);
    }
}

//estudando a lógica para criar carrinho