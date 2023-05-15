/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringBoot.security;

import com.example.SpringBoot.model.Persona;
import com.example.SpringBoot.repository.PersonaInterface;
import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
//import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author JGM
 */
@Service
public class UserDetailServiceimp implements UserDetailsService {
    
    @Autowired
   private PersonaInterface persoRepo;
   

@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
         Persona persona= persoRepo.findOneBymail(mail);
          
          return new UserDetailimpl(persona);
        }
}
            
		


