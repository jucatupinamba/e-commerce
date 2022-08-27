package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.service.ClienteService;
import br.com.suplementscommerce.service.form.ClienteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteForm create(@RequestBody ClienteForm clienteForm){
        return clienteService.create(clienteForm);
    }

}
