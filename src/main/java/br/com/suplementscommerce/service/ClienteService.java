package br.com.suplementscommerce.service;

import br.com.suplementscommerce.repository.ClienteRepository;
import br.com.suplementscommerce.repository.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente create(Cliente clienteForm){

        Cliente cliente = new Cliente();
        cliente.setNome(clienteForm.getNome());
        cliente.setIdade(clienteForm.getIdade());
        cliente.setCpf(clienteForm.getCpf());
        cliente.setEmail(clienteForm.getEmail());
        cliente.setEndereco(clienteForm.getEndereco());

        return clienteRepository.save(cliente);
    }

    public Cliente findById(Long id){
        return clienteRepository.findById(id);}

    public ResponseEntity<Cliente> salvar(Cliente existente) {
        return clienteRepository.save(existente);
    }

    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
}
