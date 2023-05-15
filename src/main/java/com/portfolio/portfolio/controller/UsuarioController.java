/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Usuario;
import com.portfolio.portfolio.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juli
 */

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService usuarioService;
    
    @CrossOrigin(origins = "*")
    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Usuario usuario) {
        
            try {
                usuarioService.saveUsuario(usuario);
                return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            }
            
    }
    
    
    
}
