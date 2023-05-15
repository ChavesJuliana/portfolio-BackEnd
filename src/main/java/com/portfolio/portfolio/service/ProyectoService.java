/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Proyecto;
import com.portfolio.portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juli
 */

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    public Proyecto saveProyecto(Proyecto proyecto) {
        return proyectoRepository.saveAndFlush(proyecto);
    }

    @Override
    public List<Proyecto> getProyectos() {
        List<Proyecto> listaProyectos = proyectoRepository.findAll();
        return listaProyectos;
    }

    @Override
    public void deleteProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto getProyectoById(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
        return proyecto;
    }


}
