/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juli
 */

@Getter @Setter
@Entity
public class TipoTrabajo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_trabajo;
    @Column(name = "nombre")
    private String nombre_trabajo;
    
    //@OneToMany(mappedBy = "tipoTrabajo")
    //private Set<Experiencia> experiencias;

        
}
