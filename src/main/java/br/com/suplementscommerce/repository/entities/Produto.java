package br.com.suplementscommerce.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @OneToMany
    private List<UploadImagens> nomeImagem;
    @NotNull
    private Double preco;
    @NotNull
    private Integer quantidade;
    @NotBlank
    @OneToOne
    private SubCategoria subcategoria;



}
