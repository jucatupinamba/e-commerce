package br.com.suplementscommerce.service;

import br.com.suplementscommerce.repository.SubCategoriaRepository;
import br.com.suplementscommerce.repository.entities.SubCategoria;

import java.util.List;
import java.util.Optional;

public class SubCategoriaService {

    private SubCategoriaRepository subCategoriaRepository;

    public SubCategoria create(String nomeSubCategoria){
        SubCategoria subCategoriaTemp = new SubCategoria();
        subCategoriaTemp.setNomeSubCategoria(nomeSubCategoria);
        return subCategoriaRepository.save(subCategoriaTemp);
    }

    public SubCategoria findById(Long id){
        Optional<SubCategoria> obj = subCategoriaRepository.findById(id);
        return obj.orElse(null);}

    public SubCategoria salvar(SubCategoria existente) {
        return subCategoriaRepository.save(existente);
    }

    public void delete(SubCategoria subCategoria) {
        subCategoriaRepository.delete(subCategoria);
    }

    public List<SubCategoria> findAll(SubCategoria categoria) {
        List<SubCategoria> todosAsSubCategorias = subCategoriaRepository.findAll();
        return todosAsSubCategorias;
    }

}
