/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scan.secure.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "seg_areas")
public class SegAreas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "area")
    private String area;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "corto")
    private String corto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private int nivel;
    @Column(name = "padre")
    private Integer padre;
    @Column(name = "eia")
    private Boolean eia;
    @Column(name = "entidad")
    private Integer entidad;
    @Column(name = "sinat_area")
    private String sinatArea;
    @Column(name = "sinat_dependencia")
    private String sinatDependencia;
    @Column(name = "sinat_nombre")
    private String sinatNombre;
    @Column(name = "principal")
    private Integer principal;
    

    public SegAreas() {
    }


    public SegAreas(Integer id) {
        this.id = id;
    }

    public SegAreas(Integer id, String area, String corto, int nivel) {
        this.id = id;
        this.area = area;
        this.corto = corto;
        this.nivel = nivel;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Integer getPadre() {
        return padre;
    }

    public void setPadre(Integer padre) {
        this.padre = padre;
    }

    public Boolean getEia() {
        return eia;
    }

    public void setEia(Boolean eia) {
        this.eia = eia;
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

    public String getSinatNombre() {
        return sinatNombre;
    }

    public void setSinatNombre(String sinatNombre) {
        this.sinatNombre = sinatNombre;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }
    
    
    
}
