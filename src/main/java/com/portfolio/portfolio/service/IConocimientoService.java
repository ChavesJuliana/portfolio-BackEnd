/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Conocimiento;
import java.util.List;

/**
 *
 * @author Juli
 */
public interface IConocimientoService {
    
    public Conocimiento saveConocimiento(Conocimiento conocimiento);
    public List<Conocimiento> getConocimientos();
    public Conocimiento getConocimientoById(Long id);
    public void deleteConocimiento(Long id);
}
