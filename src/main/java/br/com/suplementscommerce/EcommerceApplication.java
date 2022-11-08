package br.com.suplementscommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.*")
<<<<<<< Updated upstream
@EntityScan(basePackages = {"br.com.suplementscommerce.model"})
=======
@EntityScan(basePackages = {"br.com.suplementscommerce.model", "br.com.suplementscommerce.repository.entity"})
>>>>>>> Stashed changes
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
