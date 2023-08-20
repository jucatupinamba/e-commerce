package br.com.suplementscommerce.repository.entities;

import br.com.suplementscommerce.repository.entities.pk.ItemPedidoPK;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_itemPedido")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private Integer quantidade;
    private Double preco;

    public ItemPedido(){}
    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        id.setPedido(pedido);
        id.setProduto(produto);
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido(){
        return id.getPedido();
    }

    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(final Double preco) {
        this.preco = preco;
    }
}
