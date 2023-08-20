package br.com.suplementscommerce.controller;

import br.com.suplementscommerce.repository.entities.Categoria;
import br.com.suplementscommerce.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping(value = "/categorias", produces = {"application/json"})
@Tag(name = "Categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @Operation(summary = "Busca todas as categorias", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a requisição o arquivo"),
    })
    @GetMapping
    public ResponseEntity<List<Categoria>> buscarTodos(){
        List<Categoria> todasAsCategorias = categoriaService.findAll();
        return ResponseEntity.ok().body(todasAsCategorias);
    }

    @Operation(summary = "Busca o nome da categoria pelo ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nome encontrado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar o arquivo"),
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @Operation(summary = "Salva o nome da categoria", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nome salvo com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar o arquivo"),
    })
    @PostMapping
    public ResponseEntity<Categoria> insert(@RequestBody Categoria obj){
        obj = categoriaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @Operation(summary = "Atualiza o nome da categoria", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nome atualizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar o arquivo"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria){
        Categoria existente = categoriaService.findById(id);

        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(categoria, existente, "id");

        return ResponseEntity.ok(categoriaService.salvar(existente));

    }
    @Operation(summary = "Apaga o arquivo da categoria", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nome deletado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar o arquivo"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        Categoria categoria = categoriaService.findById(id);
        if(categoria == null){
            return ResponseEntity.notFound().build();
        }
        categoriaService.delete(categoria);

        return ResponseEntity.noContent().build();
    }

}
