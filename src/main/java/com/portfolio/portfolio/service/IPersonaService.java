/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Persona;

/**
 *
 * @author Juli
 */
public interface IPersonaService {
    
    public void savePersona(Persona persona);
    public Persona findById(Long id);
    
}
