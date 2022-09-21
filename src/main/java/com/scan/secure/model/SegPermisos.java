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

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "seg_permisos")
public class SegPermisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "sentido")
    private Integer sentido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accion")
    private String accion;
    @Basic(optional = false)
    @NotNull    
    @Column(name = "estatus")
    private String estatus;
    @Basic(optional = false)
    @NotNull    
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proceso")
    private int proceso;
    @Column(name = "etapa")
    private int etapa;
    @Column(name = "efecto")
    private Integer efecto;    
    @Column(name = "permiso")
    private String permiso;    
    @Column(name = "icono")
    private String icono;
    @Column(name = "activo")
    private Integer activo;

    

    public SegPermisos() {
    }

    public SegPermisos(Integer id) {
        this.id = id;
    }

    public SegPermisos(Integer id, String accion, String estatus, String color, int proceso) {
        this.id = id;
        this.accion = accion;
        this.estatus = estatus;
        this.color = color;
        this.proceso = proceso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getSentido() {
        return sentido;
    }
    public void setSentido(Integer sentido) {
        this.sentido = sentido;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProceso() {
        return proceso;
    }

    public void setProceso(int proceso) {
        this.proceso = proceso;
    }    

    public Integer getEfecto() {
        return efecto;
    }

    public void setEfecto(Integer efecto) {
        this.efecto = efecto;
    }

    public String getPermiso() {
        return permiso;
    }    

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public int getEtapa() {
        return etapa;
    }

    public void setEtapa(int etapa) {
        this.etapa = etapa;
    }
    
    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

}
