package br.com.suplementscommerce.repository.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant momento;
    @JsonIgnore
    @OneToOne
    @MapsId
    private Pedido pedido;

    public Pagamento(){}

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

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(final Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (null == o || this.getClass() != o.getClass()) return false;
        final Pagamento pagamento = (Pagamento) o;
        return Objects.equals(this.id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
