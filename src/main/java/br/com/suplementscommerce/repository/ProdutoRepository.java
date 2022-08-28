package br.com.suplementscommerce.repository;

import br.com.suplementscommerce.service.form.ProdutoForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoForm, Long> {
}
