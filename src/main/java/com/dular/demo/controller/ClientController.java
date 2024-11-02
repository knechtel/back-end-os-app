package com.dular.demo.controller;
import com.dular.demo.domain.Client;

import com.dular.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dular.demo.DTO.ClientDto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/**
 * Created by maiquelknechtel on 10/07/24.
 */
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;
    @CrossOrigin(origins = "http://127.0.0.1:5173")
    @PostMapping(value = "client-create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client create(@RequestBody ClientDto clientDto){
        return clientService.create(clientDto.toBuild(clientDto));
    }
    @PostMapping(value = "client-update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody ClientDto clientDto){
        clientService.update(clientDto.toBuild(clientDto));
    }
    @RequestMapping(value = "client-findAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Client> findAll(){
        return clientService.FindAll();
    }

    @PostMapping(value = "client-delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@RequestBody ClientDto clientDto){
        clientService.delete(clientDto.toBuild(clientDto));
    }
    @PostMapping(value = "client-findById", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client findById(@RequestBody ClientDto clientDto){
        return clientService.findById(clientDto.getId());
    }
    @PostMapping(value = "client-findByAllEquipment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client findByAllEquipment(@RequestBody ClientDto clientDto){
        return clientService.findAllEquipment(clientDto.toBuild(clientDto));
    }

    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> downloadPdf(@RequestParam("id")Integer id) throws IOException {
        // Caminho do arquivo PDF
        String pdfFilePath = "/Users/maiquelknechtel/eclipse-workspace/generatePDF_maven/pdf/dynamic1.pdf";

        ProcessBuilder processBuilder = new ProcessBuilder();


        File jarDirectory = new File("/Users/maiquelknechtel/eclipse-workspace/generatePDF_maven/");

        // Nome do arquivo .jar que você quer executar
        String jarFileName = "exec.jar";

        // Argumentos para passar para o JAR (se houver)
        String[] jarArgs=new String[1]; // Substitua pelos seus argumentos
        jarArgs[0]=id.toString();
        // Monta o comando para executar o .jar
        processBuilder.directory(jarDirectory);

        processBuilder.command("java", "-jar", jarFileName, jarArgs[0]);

        // Define o diretório de trabalho



        processBuilder.start();
        System.out.println("FIM process builder");
        try {
            // Pausa a execução da thread atual por 3000 milissegundos (3 segundos)
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // Se a thread for interrompida durante o sleep, essa exceção será lançada
            System.out.println("A thread foi interrompida enquanto estava em sleep.");
        }
        System.out.println("passei aqui--------");
        // Carregar o arquivo em um FileInputStream
        File pdfFile = new File(pdfFilePath);
        FileInputStream fis = new FileInputStream(pdfFile);

        // Definir headers para o ResponseEntity
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=arquivo.pdf");

        // Retornar o arquivo como InputStreamResource
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(fis));
    }
}