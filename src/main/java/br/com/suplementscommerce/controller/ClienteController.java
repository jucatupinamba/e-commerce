package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.service.ClienteService;
import br.com.suplementscommerce.repository.entities.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente){
        clienteService.create(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/todos")
    public ResponseEntity<Cliente> buscarTodos(@RequestBody Cliente cliente){
        clienteService.findAll(cliente);
        return ResponseEntity.ok(cliente);
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


   /* @PostMapping
    public ModelAndView cadastrar(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("cadastro.html");
        return mv;
    }*/


/* estudar MVC & Rest & Data
mapear tabela no java
        relacionamento*/