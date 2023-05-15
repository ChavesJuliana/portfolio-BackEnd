/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.TipoTrabajo;
import com.portfolio.portfolio.repository.TipoTrabajoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juli
 */

@Service
public class TipoTrabajoService implements ITipoTrabajoService{
    
    @Autowired
    private TipoTrabajoRepository tipoTrabajoRepository;


    @Override
    public List<TipoTrabajo> getAll() {
        List<TipoTrabajo> listaTipoTrabjo = tipoTrabajoRepository.findAll();
        return listaTipoTrabjo;
    }



}
