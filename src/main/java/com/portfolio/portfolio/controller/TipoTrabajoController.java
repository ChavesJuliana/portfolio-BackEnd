/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;
import com.portfolio.portfolio.model.TipoTrabajo;
import com.portfolio.portfolio.service.ITipoTrabajoService;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juli
 */

@RestController
@RequestMapping("/api/tipotrabajo")
@CrossOrigin(origins = "https://portfolio-fronted.web.app/login")
public class TipoTrabajoController {
    
    @Autowired
    private ITipoTrabajoService tipoTrabajoService;
     
    @GetMapping("/getTodos")
    public ResponseEntity<?> getAll() {
        
        try {
            
           List<TipoTrabajo> lista = tipoTrabajoService.getAll();
           if(lista.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("respuesta", "No se encontraron tipos de trabajo"));
           }
           return ResponseEntity.status(HttpStatus.OK).body(lista);
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    
    
   
  
}
