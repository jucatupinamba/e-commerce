package br.com.suplementscommerce.service;

import br.com.suplementscommerce.repository.SubCategoriaRepository;
import br.com.suplementscommerce.repository.entities.SubCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SubCategoriaService {
    @Autowired
    private SubCategoriaRepository subCategoriaRepository;

    public SubCategoria create(SubCategoria obj){
        return subCategoriaRepository.save(obj);
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
