package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.repository.entities.Cliente;
import br.com.suplementscommerce.service.ProdutoService;
import br.com.suplementscommerce.repository.entities.Produto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos", produces = {"application/json"})
@Tag(name = "Produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @Operation(summary = "Busca todos os produtos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a requisição o arquivo"),
    })
    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(Produto produto){
        List<Produto> produtoEncontrado = produtoService.buscarTodos(produto);
        if(produtoEncontrado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoEncontrado);
    }

    @Operation(summary = "Busca o produto pelo ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar o arquivo"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarNome(@PathVariable Long id){
        Produto obj = produtoService.findById(id);
        if(obj == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }

    @Operation(summary = "Salva o produto", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar o arquivo"),
    })
    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto obj){
        obj = produtoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @Operation(summary = "Atualiza os dados do produto", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar o arquivo"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto){
        Produto existente = produtoService.findById(id);

        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(produto, existente, "id");

        return ResponseEntity.ok(produtoService.salvar(existente));
    }

    @Operation(summary = "Aapaga o produto e todos os seus dados", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar o arquivo"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        Produto produto = produtoService.findById(id);
        if(produto == null){
            return ResponseEntity.notFound().build();
        }
        produtoService.delete(produto);
        return ResponseEntity.noContent().build();
    }

}
