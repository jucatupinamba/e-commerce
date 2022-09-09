package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.service.ClienteService;
import br.com.suplementscommerce.repository.entities.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastro")
    public Cliente create(Cliente clienteForm){
        return clienteService.create(clienteForm);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente cliente = clienteService.findById(id);
        if(cliente == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);}
    @PutMapping("/{id}")  //transferir a lógica para service
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente){
        Cliente existente = clienteService.findById(id);

        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(cliente, existente, "id");

        return clienteService.salvar(existente);

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

}


   /* @PostMapping
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cadastro.html");
        return mv;
    }*/


/* estudar MVC & Rest & Data
mapear tabela no java
        relacionamento*/