/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scan.secure.model;

import java.util.List;

/**
 *
 * @author Administrador
 */
public class SegCredenciales {          
    List<String> permisos;  
    SegUsuarios user;
    List<SegAreas> areas;
    List<Integer> areasId;
    List<Integer> perfiles;
    Integer areaMain;
    Integer areaDir;
           
    public SegCredenciales() {  
        //hacer algo.
    }   

    public List<String> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<String> permisos) {
        this.permisos = permisos;
    }

    
    public SegUsuarios getUser() {
        return user;
    }

    public void setUser(SegUsuarios user) {
        this.user = user;
    }

    public List<SegAreas> getAreas() {
        return areas;
    }

    public void setAreas(List<SegAreas> areas) {
        this.areas = areas;
    }          

    public Integer getAreaMain() {
        return areaMain;
    }

    public void setAreaMain(Integer areaMain) {
        this.areaMain = areaMain;
    }

    public List<Integer> getAreasId() {
        return areasId;
    }

    public void setAreasId(List<Integer> areasId) {
        this.areasId = areasId;
    }

    public List<Integer> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Integer> perfiles) {
        this.perfiles = perfiles;
    }


    public Integer getAreaDir() {
        return areaDir;
    }

    public void setAreaDir(Integer areaDir) {
        this.areaDir = areaDir;
    }
    
}
