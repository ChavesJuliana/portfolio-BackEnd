/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juli
 */

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_persona;
    private String nombre;
    private String apellido;
    private String descripcion;
    private String url_foto;
    private String titulo;
    
    public Persona(){
    }
    
    public Persona(String nombre, String apellido, String descripcion, 
            String url_foto, String titulo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.url_foto = url_foto;
        this.titulo = titulo;
    }
}


