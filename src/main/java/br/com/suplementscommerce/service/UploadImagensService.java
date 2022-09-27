package br.com.suplementscommerce.service;

import br.com.suplementscommerce.repository.UploadImagensRepository;
import br.com.suplementscommerce.repository.entities.Produto;
import br.com.suplementscommerce.repository.entities.UploadImagens;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UploadImagensService {
    @Autowired
    private UploadImagensRepository uploadImagensRepository;

    public UploadImagens salvar(String file){
        UploadImagens uploadImagensTemp = new UploadImagens();
        uploadImagensTemp.setFileName(file);
        return uploadImagensRepository.save(uploadImagensTemp);
    }

    public List<UploadImagens> buscarTodos(Produto produto) {
        List<UploadImagens> todasAsImagens = uploadImagensRepository.findAll();
        return todasAsImagens;
    }

    public UploadImagens apagar(UploadImagens uploadImagens) {
        uploadImagensRepository.delete(uploadImagens);
        return uploadImagens;
    }
}
