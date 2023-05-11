/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Persona;
import com.portfolio.portfolio.repository.PersonaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juli
 */

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona);
    }
    
    @Override
    public Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

}
