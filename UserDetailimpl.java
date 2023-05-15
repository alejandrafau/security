/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringBoot.security;

import com.example.SpringBoot.model.Persona;
import java.util.Collection;
import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author JGM
 */
@AllArgsConstructor
public class UserDetailimpl implements UserDetails {
    
    private final Persona pers;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.emptyList();
    }

    @Override
    public String getPassword(){
        return pers.getPassword();
    }

    @Override
    public String getUsername() {
        return pers.getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    
    @Override
    public boolean isCredentialsNonExpired() {
return true;
    }      

    @Override
    public boolean isEnabled() {
return true;
       
    }
    
    public String getNombre(){
        return pers.getNombrecomp();
    }
    
    }
    

