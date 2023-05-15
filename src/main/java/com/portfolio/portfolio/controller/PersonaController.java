/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Persona;
import com.portfolio.portfolio.service.IPersonaService;
import com.portfolio.portfolio.service.IStorageService;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Juli
 */

@RestController
@RequestMapping("/api/persona")
@AllArgsConstructor 
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    private final IStorageService storageService;
    private final HttpServletRequest request;
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestParam("nombre") String nombre,
                                    @RequestParam("apellido") String apellido,
                                    @RequestParam("descripcion") String descripcion,
                                    @RequestParam("titulo") String titulo,
                                    @RequestParam("file") MultipartFile multipartFile) {
                
            try {
                    String path = storageService.store(multipartFile);
                    String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
                    String url = ServletUriComponentsBuilder
                    .fromHttpUrl(host)
                    .path("/api/persona/media/")
                    .path(path)
                    .toUriString();
            
                 Persona persona = new Persona(nombre, apellido, descripcion, url, titulo);
                 personaService.savePersona(persona);
                 
                return ResponseEntity.status(HttpStatus.CREATED).body("Persona creada");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            }
            
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/media/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) throws IOException{
        Resource file = storageService.loadAsResource(filename);
        String contentType = Files.probeContentType(file.getFile().toPath());
            
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .body(file);
    }
        
    @CrossOrigin(origins = "*")
    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        
            try {
                
		Map<String, Object> map = new HashMap<>();
                Persona persona = personaService.findById(id);
		
		if(persona != null) {
			map.put("nombre", persona.getNombre());
			map.put("apellido", persona.getApellido());
			map.put("descripcion", persona.getDescripcion());
                        map.put("url_foto", persona.getUrl_foto());
                        map.put("titulo", persona.getTitulo());
               
                        return ResponseEntity.status(HttpStatus.OK).body(map);  
                        
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la persona");
                }
			
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            }
            
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,
                                  @RequestParam String nombre,
                                  @RequestParam String apellido,
                                  @RequestParam String descripcion,
                                  @RequestParam String titulo,
                                  @RequestParam(value="file", required = false) MultipartFile multipartFile) {
        
        try {
            
                Persona persona = personaService.findById(id);
		
		if(persona != null) {
                        persona.setNombre(nombre);
                        persona.setApellido(apellido);
                        persona.setDescripcion(descripcion);
                        if(multipartFile != null){   
                            
                            String path = storageService.store(multipartFile);
                            String host = request.getRequestURL().toString().replace(request.getRequestURI(), "");
                            String url = ServletUriComponentsBuilder
                                .fromHttpUrl(host)
                                .path("/api/persona/media/")
                                .path(path)
                                .toUriString();
                            
                            persona.setUrl_foto(url);
                        }                      
                        persona.setTitulo(titulo);
                        personaService.savePersona(persona);
 
                        return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("respuesta", "Se modificaron los datos"));  
                        
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("respuesta", "No se encontró la persona")); 
                }
			
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage())); 
            }
        
    }
    
  
}
