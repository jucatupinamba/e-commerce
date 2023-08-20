package br.com.suplementscommerce.repository.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_subcategoria")
public class SubCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeSubCategoria;

    public SubCategoria(){}

    public SubCategoria(final Long id, final String nomeSubCategoria) {
        this.id = id;
        this.nomeSubCategoria = nomeSubCategoria;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNomeSubCategoria() {
        return this.nomeSubCategoria;
    }

    public void setNomeSubCategoria(final String nomeSubCategoria) {
        this.nomeSubCategoria = nomeSubCategoria;
    }
}
