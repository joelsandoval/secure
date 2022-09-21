/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scan.secure.model;

/**
 *
 * @author Administrador
 */
public interface IMenuP {    
    
    Integer getId();    
    String getAccion();
    Integer getAccionId();
    String getColor();
    String getIcono();    
    String getEstatus();
    Integer getProceso();
    Integer getSentido();
    Integer getEtapa();
    Integer getEfecto();
    Integer getNivel();
    String getPermiso();
    Boolean getActivo();
    String getSituacion();    
    Integer getAreaId(); 
    String getAreaSinat();
    String getDependencia();
    Integer getEntidad();
    String getArea();
    Boolean getFutura();
}
