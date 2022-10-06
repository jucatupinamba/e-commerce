package br.com.suplementscommerce.repository.entities;

import br.com.suplementscommerce.model.Carrinho;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToOne
    private Carrinho carrinho;
}
