/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Conocimiento;
import com.portfolio.portfolio.service.IConocimientoService;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/api/conocimiento")
@CrossOrigin(origins = "https://portfolio-fronted.web.app/login")
public class ConocimientoController {
    
    @Autowired
    private IConocimientoService conocimientoService;
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Conocimiento conocimiento) {
        
        try {
            Conocimiento insertado = conocimientoService.saveConocimiento(conocimiento);
            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("id", insertado.getId_conocimiento()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @GetMapping("/getTodos")
    public ResponseEntity<?> getAll() {
        
        try {
            
           List<Conocimiento> lista = conocimientoService.getConocimientos();
           if(lista.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("respuesta", "No se encontraron conocimientos"));
           }
           return ResponseEntity.status(HttpStatus.OK).body(lista);
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        
        try {
            conocimientoService.deleteConocimiento(id);
            System.out.print("holaaaXD");
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("respuesta", "Conocimiento borrado"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,
                                  @RequestParam String nombre,
                                  @RequestParam int porcentaje) {
        
        try {
            
                Conocimiento conocimiento = conocimientoService.getConocimientoById(id);

		if(conocimiento != null) {
                        conocimiento.setNombre(nombre);
                        conocimiento.setPorcentaje(porcentaje);
                        Conocimiento insertado = conocimientoService.saveConocimiento(conocimiento);
                        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("id", insertado.getId_conocimiento()));

                        
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("respuesta", "No se encontró el conocimiento")); 
                }
			
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage())); 
            }
        
    }
    
    
    
    
   
  
}
