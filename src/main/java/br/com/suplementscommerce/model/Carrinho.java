package br.com.suplementscommerce.model;

import br.com.suplementscommerce.repository.entities.Cliente;
import br.com.suplementscommerce.repository.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrinho {

    @Autowired
    private Cliente cliente;
    private List<Produto> listaProduto;                      //necessário autowired?

    public Double subtotal(Produto produto, Integer quantidade){
        Double subTotalProduto = produto.getPreco() * quantidade;
        return subTotalProduto;
    }

    public Double totalCarrinho(List<Produto> produtoList){
        Double totalGasto = 0.0d;
        for(int i=0; i< produtoList.size(); i++){
            totalGasto = subtotal(produtoList.get(i), produtoList.get(i).getQuantidade());
        }
        return totalGasto;
    }

}
