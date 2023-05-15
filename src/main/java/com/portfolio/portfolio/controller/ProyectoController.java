/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Proyecto;
import com.portfolio.portfolio.service.IProyectoService;
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
@RequestMapping("/api/proyecto")
@CrossOrigin(origins = "https://portfolio-fronted.web.app/login")
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyectoService;
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Proyecto proyecto) {
        
        try {
            Proyecto insertado = proyectoService.saveProyecto(proyecto);
            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("id", insertado.getId_proyecto()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @GetMapping("/getTodos")
    public ResponseEntity<?> getAll() {
        
        try {
            
           List<Proyecto> lista = proyectoService.getProyectos();
           if(lista.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("respuesta", "No se encontro algun proyecto"));
           }
           return ResponseEntity.status(HttpStatus.OK).body(lista);
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        
        try {
            proyectoService.deleteProyecto(id);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("respuesta", "Proyecto borrado"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,
                                  @RequestParam String nombre,
                                  @RequestParam String descripcion, 
                                  @RequestParam String url_proyecto, 
                                  @RequestParam LocalDate fecha_desde,
                                  @RequestParam (required = false) LocalDate fecha_hasta,
                                  @RequestParam int actualmente,
                                  @RequestParam (required = false) String url_foto) {
        
        try {
            
                Proyecto proyecto = proyectoService.getProyectoById(id);

		if(proyecto != null) {
                        proyecto.setUrl_foto(url_foto);
                        proyecto.setDescripcion(descripcion);
                        proyecto.setUrl_proyecto(url_proyecto);
                        proyecto.setFecha_desde(fecha_desde);
                        proyecto.setFecha_hasta(fecha_hasta);
                        proyecto.setNombre(nombre);
                        proyecto.setActualmente(actualmente);
                        Proyecto insertado = proyectoService.saveProyecto(proyecto);
                        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("id", insertado.getId_proyecto()));

                        
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("respuesta", "No se encontro el proyecto")); 
                }
			
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage())); 
            }
        
    }
    
    
    
    
   
  
}
