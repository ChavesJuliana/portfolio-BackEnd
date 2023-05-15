/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;
import com.portfolio.portfolio.model.Educacion;
import com.portfolio.portfolio.service.IEducacionService;
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
@RequestMapping("/api/educacion")
@CrossOrigin(origins = "https://portfolio-fronted.web.app/login")
public class EducacionController {
    
    @Autowired
    private IEducacionService educacionService;
    
    @CrossOrigin(origins = "*")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody Educacion educacion) {
        
        try {
            Educacion insertado = educacionService.saveEducacion(educacion);
            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("id", insertado.getId_educacion()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/getTodos")
    public ResponseEntity<?> getAll() {
        
        try {
            
           List<Educacion> lista = educacionService.getAllEducacion();
           if(lista.isEmpty()){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("respuesta", "No se encontraron registros"));
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
            educacionService.deleteEducacion(id);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("respuesta", "Registro borrado"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage()));
        }
            
    }
    
    @CrossOrigin(origins = "*")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id,
                                  @RequestParam String nombre,
                                  @RequestParam String institucion,
                                  @RequestParam LocalDate fecha_desde,
                                  @RequestParam (required = false) LocalDate fecha_hasta,
                                  @RequestParam int actualmente) {
        
        try {
            
                Educacion educacion = educacionService.getEducacionById(id);

		if(educacion != null) {
                        educacion.setNombre(nombre);
                        educacion.setInstitucion(institucion);
                        educacion.setFecha_desde(fecha_desde);
                        educacion.setFecha_hasta(fecha_hasta);
                        educacion.setActualmente(actualmente);
                        Educacion insertado = educacionService.saveEducacion(educacion);
                        return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap("id", insertado.getId_educacion()));

                        
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("respuesta", "No se encontró el registro")); 
                }
			
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap("respuesta", e.getMessage())); 
            }
        
    }
    
    
    
    
   
  
}
