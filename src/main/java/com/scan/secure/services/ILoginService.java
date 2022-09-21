/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.scan.secure.services;

import com.scan.secure.model.JwtAuthenticationRequest;
import com.scan.secure.model.UserTokenState;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Joel
 */
public interface ILoginService {

    public UserTokenState loginAuthentication(
            JwtAuthenticationRequest authenticationRequest, String role);

    public ResponseEntity<?> refresh(HttpServletRequest request);
}
