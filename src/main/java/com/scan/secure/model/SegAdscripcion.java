/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scan.secure.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.Basic;


/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "vw_seg_adscripcion")
public class SegAdscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "area_id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "area")
    private String area;
    @Size(max = 2147483647)
    @Column(name = "corto")
    private String corto;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "padre")
    private Integer padre;
    @Column(name = "abuelo")
    private Integer abuelo;
    @Column(name = "entidad")
    private Integer entidad;
    @Size(max = 2147483647)
    @Column(name = "sinat_area")
    private String sinatArea;
    @Size(max = 2147483647)
    @Column(name = "sinat_dependencia")
    private String sinatDependencia;
    @Size(max = 2147483647)
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "estatus")
    private Boolean estatus;
    @Column(name = "user_id")
    private Integer userId;
    @Size(max = 2147483647)
    @Column(name = "user_nombre")
    private String userNombre;
    @Size(max = 2147483647)
    @Column(name = "user_paterno")
    private String userPaterno;
    @Size(max = 2147483647)
    @Column(name = "user_materno")
    private String userMaterno;
    @Size(max = 10)
    @Column(name = "siglas")
    private String siglas;
    @Size(max = 2147483647)
    @Column(name = "user_corto")
    private String userCorto; 
    @Column(name = "hijos")
    private Integer hijos;
    @Column(name = "eia")
    private Boolean eia;
    @Column(name = "principal")
    private Integer principal;
    
    public SegAdscripcion() {
        //hacer algo.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCorto() {
        return corto;
    }

    public void setCorto(String corto) {
        this.corto = corto;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getPadre() {
        return padre;
    }

    public void setPadre(Integer padre) {
        this.padre = padre;
    }

    public Integer getAbuelo() {
        return abuelo;
    }

    public void setAbuelo(Integer abuelo) {
        this.abuelo = abuelo;
    }

    public Integer getEntidad() {
        return entidad;
    }

    public void setEntidad(Integer entidad) {
        this.entidad = entidad;
    }

    public String getSinatArea() {
        return sinatArea;
    }

    public void setSinatArea(String sinatArea) {
        this.sinatArea = sinatArea;
    }

    public String getSinatDependencia() {
        return sinatDependencia;
    }

    public void setSinatDependencia(String sinatDependencia) {
        this.sinatDependencia = sinatDependencia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNombre() {
        return userNombre;
    }

    public void setUserNombre(String userNombre) {
        this.userNombre = userNombre;
    }

    public String getUserPaterno() {
        return userPaterno;
    }

    public void setUserPaterno(String userPaterno) {
        this.userPaterno = userPaterno;
    }

    public String getUserMaterno() {
        return userMaterno;
    }

    public void setUserMaterno(String userMaterno) {
        this.userMaterno = userMaterno;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getUserCorto() {
        return userCorto;
    }

    public void setUserCorto(String userCorto) {
        this.userCorto = userCorto;
    }

    public Integer getHijos() {
        return hijos;
    }

    public void setHijos(Integer hijos) {
        this.hijos = hijos;
    }

    public Boolean getEia() {
        return eia;
    }

    public void setEia(Boolean eia) {
        this.eia = eia;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }
    
    
    
}
