/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Persona;
import com.portfolio.portfolio.service.IPersonaService;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 *
 * @author Juli
 */

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Persona persona) {
        
            try {
                personaService.savePersona(persona);
                return ResponseEntity.status(HttpStatus.CREATED).body("Persona creada");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            }
            
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
                                  @RequestParam (required = false) String url_foto,
                                  @RequestParam String titulo) {
        
        try {
            
                Persona persona = personaService.findById(id);
		
		if(persona != null) {
                        persona.setNombre(nombre);
                        persona.setApellido(apellido);
                        persona.setDescripcion(descripcion);
                        if(!url_foto.isEmpty()){                            
                            persona.setUrl_foto(url_foto);
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
