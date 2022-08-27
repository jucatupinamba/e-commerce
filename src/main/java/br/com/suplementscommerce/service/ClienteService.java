package br.com.suplementscommerce.service;

import br.com.suplementscommerce.repository.ClienteRepository;
import br.com.suplementscommerce.service.form.ClienteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public ClienteForm create(ClienteForm clienteForm){

        ClienteForm cliente = new ClienteForm();
        cliente.setNome(clienteForm.getNome());
        cliente.setIdade(clienteForm.getIdade());
        cliente.setCpf(clienteForm.getCpf());
        cliente.setEmail(clienteForm.getEmail());
        cliente.setEndereco(clienteForm.getEndereco());

        return clienteRepository.save(cliente);


    }

}
