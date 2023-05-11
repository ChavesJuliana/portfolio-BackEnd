/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Experiencia;
import com.portfolio.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juli
 */

@Service
public class ExperienciaService implements IExperienciaService{
    
    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Override
    public Experiencia saveExperiencia(Experiencia experiencia) {
        return experienciaRepository.saveAndFlush(experiencia);
    }

    @Override
    public List<Experiencia> getExperiencias() {
        List<Experiencia> listaExperiencias = experienciaRepository.findAll();
        return listaExperiencias;
    }

    @Override
    public void deleteExperiencia(Long id) {
        experienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia getExperienciaById(Long id) {
        Experiencia experiencia = experienciaRepository.findById(id).orElse(null);
        return experiencia;
    }
    


}
