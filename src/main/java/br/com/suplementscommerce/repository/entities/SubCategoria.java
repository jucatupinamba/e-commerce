package br.com.suplementscommerce.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subcategoria")
public class SubCategoria {
    @Id
    private Long id;
    @NotBlank
    private String nomeSubCategoria;
<<<<<<< Updated upstream
    @NotBlank
    @OneToOne
    private Categoria categoria;
=======
>>>>>>> Stashed changes
}
