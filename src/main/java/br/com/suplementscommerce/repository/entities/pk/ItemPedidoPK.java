package br.com.suplementscommerce.repository.entities.pk;

import br.com.suplementscommerce.repository.entities.ItemPedido;
import br.com.suplementscommerce.repository.entities.Pedido;
import br.com.suplementscommerce.repository.entities.Produto;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class ItemPedidoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(final Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(final Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (null == o || this.getClass() != o.getClass()) return false;
        final ItemPedidoPK that = (ItemPedidoPK) o;
        return Objects.equals(this.pedido, that.pedido) && Objects.equals(this.produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pedido, this.produto);
    }
}
