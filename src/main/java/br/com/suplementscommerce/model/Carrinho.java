package br.com.suplementscommerce.model;

import br.com.suplementscommerce.repository.entities.Cliente;
import br.com.suplementscommerce.repository.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrinho {

    @Autowired
    private Cliente cliente;
    private Produto produto;
    private Integer quantidade;

}
