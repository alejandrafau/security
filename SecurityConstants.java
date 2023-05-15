/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.SpringBoot.security;

/**
 *
 * @author JGM
 */
public class SecurityConstants {
  public static final String SECRET = "SECRET_KEY";
  public static final long EXPIRATION_TIME = 900_000; // 15 mins
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String SIGN_UP_URL = "/api/services/controller/user";
}   

