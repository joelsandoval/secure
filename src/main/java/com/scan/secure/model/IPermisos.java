/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scan.secure.model;

/**
 *
 * @author Joel Sandoval Reyes
 */
public interface IPermisos {    
    Integer getId();
    String getEstatus();
    String getColor();          
    Integer getGrupoID();
    Integer getSentido();
    Integer getPermisoID();
    String getPermisoD();
    Integer getProceso();
}
