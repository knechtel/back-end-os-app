package com.dular.demo.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Created by maiquelknechtel on 21/11/24.
 */

@RestController
@RequestMapping("/api/images")
public class ImageUploadController {

    private static final String UPLOAD_DIR = "uploads/";

    public ImageUploadController() {
        // Cria o diretório de upload se não existir
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Arquivo vazio");
        }

        try {
            // Define o caminho completo do arquivo
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);

            // Salva o arquivo no diretório
            Files.write(filePath, file.getBytes());

            return ResponseEntity.ok("Arquivo salvo com sucesso: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar o arquivo");
        }
    }
}
