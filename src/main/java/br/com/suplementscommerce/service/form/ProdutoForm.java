package br.com.suplementscommerce.service.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.awt.image.BufferedImage;
@Entity
@Table(name = "tb_produtos")
public class ProdutoForm {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String descricao;
    //private BufferedImage imagem;
    private Double preco;

    public ProdutoForm(){}

    public ProdutoForm(Long id, String nome, String descricao, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao =
                descricao;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
