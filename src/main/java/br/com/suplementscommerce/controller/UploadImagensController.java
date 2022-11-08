package br.com.suplementscommerce.controller;


import br.com.suplementscommerce.service.UploadImagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class UploadImagensController {

<<<<<<< Updated upstream
=======
    //@Autowired
    private UploadImagensService uploadImagensService;

>>>>>>> Stashed changes
    @PostMapping
    public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile file){
        String fileName = file.getOriginalFilename();

        try {
            file.transferTo(new File("www.imagemaqui.com.gr" + fileName));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(fileName);
    }
}
