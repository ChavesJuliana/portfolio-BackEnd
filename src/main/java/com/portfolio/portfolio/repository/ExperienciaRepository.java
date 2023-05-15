/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.DTO.ExperienciaDTO;
import com.portfolio.portfolio.model.Experiencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juli
 */

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Long>{
    
    @Query("SELECT new com.portfolio.portfolio.DTO.ExperienciaDTO(e.id_experiencia, e.url_foto, e.descripcion, e.fecha_desde, e.fecha_hasta, e.actualmente, e.id_persona, t.id_tipo_trabajo, t.nombre_trabajo, e.nombre) FROM Experiencia e JOIN e.tipoTrabajo t")
    public List<ExperienciaDTO> getAllWithTipo();

}
