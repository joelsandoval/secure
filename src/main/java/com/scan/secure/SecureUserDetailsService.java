/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.scan.secure;

import com.scan.secure.model.SegCredenciales;
import com.scan.secure.model.SegGrupos;
import com.scan.secure.model.SegUsuarios;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Joel
 */
@Service
public class SecureUserDetailsService implements UserDetailsService {

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UserDetails usuario = null;
        SegUsuarios user = null;
        List<SegGrupos> roleUser;
        String role = "";
        List<SegCredenciales> grantedAuthorities = new ArrayList<>();

        //user = userMapper.findByUsernameEva(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Usuario no encontrado con este nombre", username));
        }
       
//        List<String> authorities = userMapper.getRolesEva(user.getUsername());
//        if (authorities != null && !authorities.isEmpty()) {
//            for (String roli : authorities) {
//                grantedAuthorities.add(new Authority(roli));
//            }
//            user.setAuthorities(grantedAuthorities);
//        }

        return usuario;
    }

}
