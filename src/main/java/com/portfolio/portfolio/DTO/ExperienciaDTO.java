/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Juli
 */
@Getter @Setter
public class ExperienciaDTO {

    private Long id_experiencia;
    private String url_foto;
    private String descripcion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fecha_desde;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Nullable
    private LocalDate fecha_hasta;
    private int actualmente;
    private int id_persona;
    private Long id_tipo_trabajo;
    private String nombre_trabajo;
    private String nombre;
    
    public ExperienciaDTO(Long id_experiencia, String url_foto, String descripcion, LocalDate fecha_desde, LocalDate fecha_hasta, int actualmente, int id_persona, Long id_tipo_trabajo, String nombre_trabajo, String nombre) {
        this.id_experiencia = id_experiencia;
        this.url_foto = url_foto;
        this.descripcion = descripcion;
        this.fecha_desde = fecha_desde;
        this.fecha_hasta = fecha_hasta;
        this.actualmente = actualmente;
        this.id_persona = id_persona;
        this.id_tipo_trabajo = id_tipo_trabajo;
        this.nombre_trabajo = nombre_trabajo;
        this.nombre = nombre;
    }
}
