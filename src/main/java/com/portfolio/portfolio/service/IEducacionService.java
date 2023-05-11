/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Educacion;
import java.util.List;

/**
 *
 * @author Juli
 */
public interface IEducacionService {
    
    public Educacion saveEducacion(Educacion educacion);
    public List<Educacion> getAllEducacion();
    public Educacion getEducacionById(Long id);
    public void deleteEducacion (Long id);
}
