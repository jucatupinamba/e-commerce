package br.com.suplementscommerce.repository.entities;

import br.com.suplementscommerce.repository.entities.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant momento;

    private Integer statusPedido;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "id.pedido", cascade = CascadeType.ALL)
    private Set<ItemPedido> items = new HashSet<>();
    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public Pedido(){}

    public Pedido(Long id, Instant momento, StatusPedido statusPedido, Cliente cliente) {
        this.id = id;
        this.momento = momento;
        setStatusPedido(statusPedido);
        this.cliente = cliente;
        this.items = items;
        this.pagamento = pagamento;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return this.momento;
    }

    public void setMomento(final Instant momento) {
        this.momento = momento;
    }

    public StatusPedido getStatusPedido() {
        return StatusPedido.valueOf(statusPedido);
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        if(statusPedido!= null) {
            this.statusPedido = statusPedido.getCodigo();
        }
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(final Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<ItemPedido> getItems() {
        return this.items;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }

    public void setPagamento(final Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (null == o || this.getClass() != o.getClass()) return false;
        final Pedido pedido = (Pedido) o;
        return Objects.equals(this.id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
