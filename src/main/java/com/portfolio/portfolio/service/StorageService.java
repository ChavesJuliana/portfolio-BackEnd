/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Juli
 */

@Service
public class StorageService implements IStorageService{

    @Value("${media.location}")
    private String mediaLocation;
    
    private Path rootLocation;
    
    @Override
    @PostConstruct
    public void init() {
        try {
            rootLocation = Paths.get(mediaLocation);
            Files.createDirectories(rootLocation);
        } catch (IOException ex) {
            Logger.getLogger(StorageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String store(MultipartFile file) {
        try {
            if(file.isEmpty()) {
                throw new RuntimeException("Archivo vacio");
            }
            String filename = file.getOriginalFilename();
            Path destinationFile = rootLocation.resolve(Paths.get(filename))
                    .normalize().toAbsolutePath();
            
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            return filename;
        } catch (IOException e){
            throw new RuntimeException("Error ", e);
        }
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource((file.toUri()));
            
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }   else {
                throw new RuntimeException("No se pudo leer el archivo");
            }
            
        } catch (MalformedURLException e){
            throw new RuntimeException("No se pudo leer el archivo ");
        }
    }
    
}
