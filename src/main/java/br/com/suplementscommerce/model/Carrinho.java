package br.com.suplementscommerce.model;

import br.com.suplementscommerce.repository.entities.Cliente;
import br.com.suplementscommerce.repository.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

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

}
