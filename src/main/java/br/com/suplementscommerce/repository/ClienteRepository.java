package br.com.suplementscommerce.repository;

import br.com.suplementscommerce.service.form.ClienteForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteForm, Long> {
}
