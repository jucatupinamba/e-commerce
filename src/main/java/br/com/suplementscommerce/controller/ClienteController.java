package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.repository.ClienteRepository;
import br.com.suplementscommerce.service.ClienteService;
import br.com.suplementscommerce.repository.entities.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody Cliente obj){
        obj = clienteService.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Cliente>> buscarTodos(@Valid @RequestBody Cliente cliente){
        List<Cliente> todosOsClientes = clienteService.findAll(cliente);
        return ResponseEntity.ok(todosOsClientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente){
        Cliente existente = clienteService.findById(id);

        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(cliente, existente, "id");

        return ResponseEntity.ok(clienteService.salvar(existente));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        Cliente cliente = clienteService.findById(id);
        if(cliente == null){
            return ResponseEntity.notFound().build();
        }
        clienteService.delete(cliente);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/buscarNome")
    public ResponseEntity<List<Cliente>> buscarNome(@RequestParam("nome") String nome){
        List<Cliente> cliente = clienteService.buscarNome(nome.trim().toUpperCase());
        if(cliente == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);}


}





/* estudar MVC & Rest & Data
mapear tabela no java
        relacionamento*/