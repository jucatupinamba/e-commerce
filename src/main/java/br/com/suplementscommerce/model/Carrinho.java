package br.com.suplementscommerce.model;

import br.com.suplementscommerce.repository.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

<<<<<<< Updated upstream
import javax.persistence.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carrinho {
    @Id
    Long id;
    @OneToMany
    @JoinColumn(name = "produto")
    private Produto produto;
    private Integer quantidade;
=======
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Carrinho {

    @Autowired
    private Set<Produto> produto;
>>>>>>> Stashed changes

}
