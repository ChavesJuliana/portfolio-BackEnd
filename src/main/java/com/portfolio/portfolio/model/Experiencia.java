/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juli
 */

@Getter @Setter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_experiencia;
    private String url_foto;
    private String descripcion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha_desde;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Nullable
    private LocalDate fecha_hasta;
    private int actualmente;
    @Column(name = "persona_id_persona")
    private int id_persona;
    @ManyToOne()
    @JoinColumn(name = "tipo_trabajo_id_tipo_trabajo", referencedColumnName="id_tipo_trabajo")
    @JsonProperty("tipoTrabajo")
    private TipoTrabajo tipoTrabajo;
    //@Column(name = "tipo_trabajo_id_tipo_trabajo")
    private String nombre;
}
