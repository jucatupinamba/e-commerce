package br.com.suplementscommerce.service;

import br.com.suplementscommerce.repository.CategoriaRepository;
import br.com.suplementscommerce.repository.entities.Categoria;


import java.util.List;
import java.util.Optional;

public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public Categoria create(String nomeCategoria){
        Categoria categoriaTemp = new Categoria();
        categoriaTemp.setNomeCategoria(nomeCategoria);
        return categoriaRepository.save(categoriaTemp);
    }

    public Categoria findById(Long id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElse(null);}

    public Categoria salvar(Categoria existente) {
        return categoriaRepository.save(existente);
    }

    public void delete(Categoria cliente) {
        categoriaRepository.delete(cliente);
    }

    public List<Categoria> findAll(Categoria categoria) {
        List<Categoria> todosAsCategorias = categoriaRepository.findAll();
        return todosAsCategorias;
    }
}
