package br.com.suplementscommerce.repository.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    private String idade;
    @NotBlank
    private String email;
    @Column(unique = true)
    private String cpf;
    @NotBlank
    private String endereco;

    public Cliente(final Long id, final String nome, final String idade, final String email, final String cpf, final String endereco) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Cliente(){}

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

    public String getIdade() {
        return this.idade;
    }

    public void setIdade(final String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(final String cpf){
        this.cpf = cpf;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(final String endereco) {
        this.endereco = endereco;
    }
}
