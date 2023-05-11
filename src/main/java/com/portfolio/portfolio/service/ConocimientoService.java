/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Conocimiento;
import com.portfolio.portfolio.repository.ConocimientoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juli
 */

@Service
public class ConocimientoService implements IConocimientoService{
    
    @Autowired
    private ConocimientoRepository conocimientoRepository;

    @Override
    public Conocimiento saveConocimiento(Conocimiento conocimiento) {
        return conocimientoRepository.saveAndFlush(conocimiento);
    }

    @Override
    public List<Conocimiento> getConocimientos() {
        List<Conocimiento> listaConocimientos = conocimientoRepository.findAll();
        return listaConocimientos;
    }

    @Override
    public void deleteConocimiento(Long id) {
        conocimientoRepository.deleteById(id);
    }

    @Override
    public Conocimiento getConocimientoById(Long id) {
        Conocimiento conocimiento = conocimientoRepository.findById(id).orElse(null);
        return conocimiento;
    }
    


}
