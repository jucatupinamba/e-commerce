package br.com.suplementscommerce.repository.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeCategoria;

    public Categoria(final Long id, final String nomeCategoria) {
        this.id = id;
        this.nomeCategoria = nomeCategoria;
    }

    public Categoria(){}

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return this.nomeCategoria;
    }

    public void setNomeCategoria(final String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
}


