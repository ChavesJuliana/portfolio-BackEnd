/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.DTO.ExperienciaDTO;
import com.portfolio.portfolio.model.Experiencia;
import com.portfolio.portfolio.model.TipoTrabajo;
import com.portfolio.portfolio.service.IExperienciaService;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
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
@RequestMapping("/api/experiencia")
@CrossOrigin(origins = "https://portfolio-fronted.web.app/login")
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService experienciaService;
    
    @CrossOrigin(origins = "*")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Experiencia experiencia) {
        
        try {
            Experiencia insertado = experienciaService.saveExperiencia(experiencia);
            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("id", insertado.getId_experiencia()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/getTodos")
    public ResponseEntity<?> getAll() {
        
        try {
            
           List<Experiencia> lista = experienciaService.getExperiencias();
           if(lista.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("respuesta", "No se encontro alguna experiencia"));
           }
           return ResponseEntity.status(HttpStatus.OK).body(lista);
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/getTodosConTipo")
    public ResponseEntity<?> getAllConTipo() {
        
        try {
            
           List<ExperienciaDTO> lista = experienciaService.getAllWithTipo();
           if(lista.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("respuesta", "No se encontro alguna experiencia"));
           }
           return ResponseEntity.status(HttpStatus.OK).body(lista);
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        
        try {
            experienciaService.deleteExperiencia(id);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("respuesta", "Experiencia borrada"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,
                                  @RequestParam (required = false) String url_foto,
                                  @RequestParam String descripcion,
                                  @RequestParam LocalDate fecha_desde,
                                  @RequestParam (required = false) LocalDate fecha_hasta,
                                  @RequestParam int actualmente,
                                  @RequestParam TipoTrabajo tipo_trabajo,
                                  @RequestParam String nombre) {
        
        try {
            
                Experiencia experiencia = experienciaService.getExperienciaById(id);

		if(experiencia != null) {
                        experiencia.setUrl_foto(url_foto);
                        experiencia.setDescripcion(descripcion);
                        experiencia.setFecha_desde(fecha_desde);
                        experiencia.setFecha_hasta(fecha_hasta);
                        experiencia.setActualmente(actualmente);
                        experiencia.setTipoTrabajo(tipo_trabajo);
                        experiencia.setNombre(nombre);
                        Experiencia insertado = experienciaService.saveExperiencia(experiencia);
                        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("id", insertado.getId_experiencia()));
                     
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("respuesta", "No se encontro la experiencia")); 
                }
			
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage())); 
            }
        
    }
    
    
    
    
   
  
}
