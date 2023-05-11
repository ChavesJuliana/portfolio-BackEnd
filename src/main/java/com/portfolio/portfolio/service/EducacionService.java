/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Educacion;
import com.portfolio.portfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juli
 */

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    private EducacionRepository educacionRepository;

    @Override
    public Educacion saveEducacion(Educacion educacion) {
        return educacionRepository.saveAndFlush(educacion);
    }

    @Override
    public List<Educacion> getAllEducacion() {
        List<Educacion> listaEducacion = educacionRepository.findAll();
        return listaEducacion;
    }

    @Override
    public void deleteEducacion(Long id) {
        educacionRepository.deleteById(id);
    }

    @Override
    public Educacion getEducacionById(Long id) {
        Educacion educacion = educacionRepository.findById(id).orElse(null);
        return educacion;
    }
    


}
