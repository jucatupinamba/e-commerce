package br.com.suplementscommerce.repository.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Pedido {

    @Id
    private Long id;
    @OneToOne
    @NotNull
    private Cliente cliente;
    @NotNull
    @OneToOne
    private Set<Produto> listaPedido;

    //lógica soma produtos
}
