/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringBoot.security;

import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import static org.springframework.security.config.web.server.ServerHttpSecurity.http;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;





@Configuration
@AllArgsConstructor
public class WebSecurityConfig  {
    private final UserDetailsService userdetails;
    private final JWTAuthorizationFilter jwtAuthorizationfilter;
  
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager ) throws Exception{
        
     
         return http
                                            	
                        .csrf().disable()
                        .authorizeHttpRequests(authorize -> authorize                                  
			.requestMatchers("sumar/persona").permitAll()  
                        .anyRequest().authenticated()
                        .and()
                        .addFilter(new JWTAuthenticationFilter(authManager))
                        .addFilterBefore(jwtAuthorizationfilter,UsernamePasswordAuthenticationFilter.class)
                        )
                 .sessionManagement()
                 .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                 .and()
               
                 .build();
         
                                  
    }
                
    

    
    @Bean
AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception{
return http.getSharedObject(AuthenticationManagerBuilder.class)
.userDetailsService (userdetails)
.passwordEncoder(passwordEncoder())
.and()
.build();
}

@Bean
PasswordEncoder passwordEncoder(){
return new BCryptPasswordEncoder();
}
}
                        
 


	