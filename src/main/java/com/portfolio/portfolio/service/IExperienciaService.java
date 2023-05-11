/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Experiencia;
import java.util.List;

/**
 *
 * @author Juli
 */
public interface IExperienciaService {
    
    public Experiencia saveExperiencia(Experiencia experiencia);
    public List<Experiencia> getExperiencias();
    public Experiencia getExperienciaById(Long id);
    public void deleteExperiencia(Long id);
}
