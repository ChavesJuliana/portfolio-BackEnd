/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolio.security;

import com.portfolio.portfolio.model.Usuario;
import com.portfolio.portfolio.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juli
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUsuarioService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + email + "no existe."));
        return new UserDetailsImpl(usuario);
    }
    
}
