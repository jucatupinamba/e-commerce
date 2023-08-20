package br.com.suplementscommerce.controller;


import br.com.suplementscommerce.repository.entities.Produto;
import br.com.suplementscommerce.repository.entities.SubCategoria;
import br.com.suplementscommerce.service.SubCategoriaService;
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
@RequestMapping(value = "/subcategorias", produces = {"application/json"})
@Tag(name = "Subcategoria")
public class SubcategoriaController {
    @Autowired
    private SubCategoriaService subCategoriaService;

    @Operation(summary = "Busca todas as subcategorias", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Requisição realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a requisição o arquivo"),
    })
    @GetMapping
    public ResponseEntity<List<SubCategoria>> buscarTodos(@Valid @RequestBody SubCategoria subCategoria){
        List<SubCategoria> todasAsCategorias = subCategoriaService.findAll(subCategoria);
        return ResponseEntity.ok(todasAsCategorias);
    }

    @Operation(summary = "Busca o nome da subcategoria pelo ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nome encontrado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar o arquivo"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<SubCategoria> buscarNome(@PathVariable Long id){
        SubCategoria obj = subCategoriaService.findById(id);
        if(obj == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }

    @Operation(summary = "Salva o nome da subcategoria", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nome salvo com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar o arquivo"),
    })
    @PostMapping
    public ResponseEntity<SubCategoria> insert(@RequestBody SubCategoria obj){
        obj = subCategoriaService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @Operation(summary = "Atualiza o nome da subcategoria", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nome atualizado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar o arquivo"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<SubCategoria> atualizar(@PathVariable Long id, @Valid @RequestBody SubCategoria categoria){
        SubCategoria existente = subCategoriaService.findById(id);

        if(existente == null){
            return ResponseEntity.notFound().build();
        }
        BeanUtils.copyProperties(categoria, existente, "id");

        return ResponseEntity.ok(subCategoriaService.salvar(existente));

    }

    @Operation(summary = "Apaga o arquivo da subcategoria", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Nome deletado com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar o arquivo"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id){
        SubCategoria subCategoria = subCategoriaService.findById(id);
        if(subCategoria == null){
            return ResponseEntity.notFound().build();
        }
        subCategoriaService.delete(subCategoria);

        return ResponseEntity.noContent().build();
    }

}
