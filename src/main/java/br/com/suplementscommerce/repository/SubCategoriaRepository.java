package br.com.suplementscommerce.repository;

import br.com.suplementscommerce.repository.entities.SubCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoria, Long> {

}
