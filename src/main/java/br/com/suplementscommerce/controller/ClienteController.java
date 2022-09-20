package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.repository.ClienteRepository;
import br.com.suplementscommerce.service.ClienteService;
import br.com.suplementscommerce.repository.entities.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;    //Apenas para teste da View com bd

    @GetMapping("/cadastro")
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("cadastro",clienteRepository.findAll());
        return mv;
    }

    @GetMapping(value = "/clientes")
    public ModelAndView clientes(){
        ModelAndView andView = new ModelAndView("/clientes");
        Iterable<Cliente> clientesIt = clienteRepository.findAll();
        andView.addObject("clientes", clientesIt);
        return andView;
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente){
        Cliente criarCliente = clienteService.create(cliente);
        return ResponseEntity.ok(criarCliente);
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