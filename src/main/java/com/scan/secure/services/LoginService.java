package com.scan.secure.services;

import com.scan.secure.model.JwtAuthenticationRequest;
import com.scan.secure.model.User;
import com.scan.secure.model.UserTokenState;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ... Esta es la clase controller de la clase LoginRest.java donde se
 * lleva el proceso de autenticacion y la obtención de credenciales
 *
 */
@Service
@Controller
public class LoginService implements ILoginService {

    Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    TokenService tokenHelper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService service;

//    @Autowired
//    private ILogController log;
    /**
     * Metodo que se encarga de validar los roles y el nombre de los usuarios
     *
     * @param authenticationRequest
     * @param role
     * @return
     */
    @Override
    public UserTokenState loginAuthentication(JwtAuthenticationRequest authenticationRequest, String role) {

        UserTokenState result = new UserTokenState();

        LOGGER.info("Login: {}, rol: {} ", authenticationRequest.getUsername(), role);

        User user = null;
        String folio = "";

        try {
            
            final Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            user = (User) authentication.getPrincipal();
            folio = authenticationRequest.getFolio();

            String jws = tokenHelper.generateToken(user.getUsername(), user.getPassword(), user.getAuthorities(), role, user.getId());
            int expiresIn = tokenHelper.getExpiredIn();
            result = new UserTokenState(jws, expiresIn);

        } catch (Exception e) {
            LOGGER.error("Error en la asignación de credenciales {}", e.getMessage());
        }
        return result;
    }

    /**
     *
     * @param folio
     * @return
     *
     * Metodo que se utiliza para saber si es un tramite fisico o electronico
     */
    public boolean isFisico(String folio) {
        boolean isFisico = false;
        if (folio.contains("-")) {
            isFisico = true;
        }
        return isFisico;
    }

    public boolean isWeb(String folio) {
        boolean isFisico = false;
        if (folio.contains("W")) {
            isFisico = true;
        }
        return isFisico;
    }

    @Override
    public ResponseEntity<?> refresh(HttpServletRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
