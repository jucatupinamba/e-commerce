package br.com.suplementscommerce.service.form;

import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name = "tb_clientes")
public class ClienteForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idade;
    private String email;
    @Column(unique = true)
    private String cpf;
    private String endereco;

    public ClienteForm(String nome, String idade, String email, String cpf, String endereco) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public ClienteForm(){}

    public String getNome() {
        return this.nome;
    }

    public void setNome( String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return this.idade;
    }

    public void setIdade( String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail( String email) {
        this.email = email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco( String endereco) {
        this.endereco = endereco;
    }

}
