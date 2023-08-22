package br.com.suplementscommerce.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "tb_produtos")
public class Produto {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotBlank
    private String urlImage;
    @NotNull
    private Double preco;

    @ManyToMany
    @JoinTable(name = "tb_produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    public Produto(){}

    public Produto(final Long id, final String nome, final String descricao, final String urlImage, final Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.urlImage = urlImage;
        this.preco = preco;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImage() {
        return this.urlImage;
    }

    public void setUrlImage(final String urlImage) {
        this.urlImage = urlImage;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(final Double preco) {
        this.preco = preco;
    }

    public Set<Categoria> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(final Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (null == o || this.getClass() != o.getClass()) return false;
        final Produto produto = (Produto) o;
        return Objects.equals(this.id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
