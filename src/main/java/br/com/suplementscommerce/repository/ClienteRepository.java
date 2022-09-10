package br.com.suplementscommerce.repository;

import br.com.suplementscommerce.repository.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT n FROM Cliente n WHERE upper(trim(n.nome)) like %?1%")
    List<Cliente> buscarNome(@Param("nome")String nome);
}
