package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.service.ClienteService;
import br.com.suplementscommerce.repository.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastro")
    public Cliente create(Cliente clienteForm){
        return clienteService.create(clienteForm);
    }



}

/* estudar MVC & Rest & Data
mapear tabela no java
        relacionamento*/