/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Usuario;
import java.util.Optional;

/**
 *
 * @author Juli
 */
public interface IUsuarioService {
    
    public void saveUsuario(Usuario usuario);
    public Optional<Usuario> findOneByEmail(String email);
}
