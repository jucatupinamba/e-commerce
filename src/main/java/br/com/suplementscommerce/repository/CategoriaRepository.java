package br.com.suplementscommerce.repository;

import br.com.suplementscommerce.repository.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
