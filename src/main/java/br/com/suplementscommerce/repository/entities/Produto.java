package br.com.suplementscommerce.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produtos")
public class Produto {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String descricao;
    //private BufferedImage imagem;
    private Double preco;


}
