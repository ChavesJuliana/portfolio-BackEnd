/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Proyecto;
import java.util.List;

/**
 *
 * @author Juli
 */
public interface IProyectoService {
    
    public Proyecto saveProyecto(Proyecto proyecto);
    public List<Proyecto> getProyectos();
    public Proyecto getProyectoById(Long id);
    public void deleteProyecto(Long id);
}
