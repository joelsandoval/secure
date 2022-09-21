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
@Table(name = "seg_areas_config")
public class SegAreasConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "area")
    private int area;
    @Column(name = "prefijo")
    private String prefijo;
    @Column(name = "prefijo_ingreso")
    private String prefijoIngreso;

    public SegAreasConfig() {
    }

    public SegAreasConfig(Integer id) {
        this.id = id;
    }

    public SegAreasConfig(Integer id, int area) {
        this.id = id;
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public String getPrefijoIngreso() {
        return prefijoIngreso;
    }

    public void setPrefijoIngreso(String prefijoIngreso) {
        this.prefijoIngreso = prefijoIngreso;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SegAreasConfig)) {
            return false;
        }
        SegAreasConfig other = (SegAreasConfig) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.semarnat.ws.model.seguridad.SegAreasConfig[ id=" + id + " ]";
    }
    
}
