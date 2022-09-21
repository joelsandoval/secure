package com.scan.secure.rest;

import com.scan.secure.model.JwtAuthenticationRequest;
import com.scan.secure.services.LoginService;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * 
 * @author qualtop
 * 
 *Esta clase esta diseñada para mantener la seguridad
 *en la aplicacion, utilizando Tokens de autenticacion  
 *
 */
@CrossOrigin
@RestController
public class LoginREST {

	@Autowired
	private LoginService loginController;
  
	/**
	 * 
	 * @param authenticationRequest
	 * @param response
	 * @param role
	 * @return
	 * @throws AuthenticationException
	 * @throws IOException
	 * 
	 * Este metodo es el encargado de asignar los roles 
	 */
    @PostMapping(value = "/login/{role}")
    public ResponseEntity<?> createAuthenticationToken(
            		@RequestBody JwtAuthenticationRequest authenticationRequest,
            		HttpServletResponse response,
            		@PathVariable String role
    ) throws AuthenticationException, IOException {

        return ResponseEntity.ok( loginController.loginAuthentication(authenticationRequest, role) );
    }

}
