/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scan.secure.model;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public interface IAreaAdscripcion {
    Integer getId();
    Integer getAreaId();
    String getArea();        
    String getCorto();
    Integer getNivel();    
    Integer getPadre();
    Integer getPadreNivel();
    Integer getAbuelo();
    Integer getAbueloNivel();
    Integer getEntidad();    
    String getSinatArea();
    String getSinatDependencia();
    String getCargo();
    Boolean getEstatus();
    Integer getUserId();
    String getUserNombre();
    String getUserPaterno();
    String getUserMaterno();
    String getUserCorto();
    String getSiglas();
    Integer getHijos();
    Integer getGrupo();
    Boolean getMira();
    Integer getPrincipal();
    Date getFechaInicio();
}
