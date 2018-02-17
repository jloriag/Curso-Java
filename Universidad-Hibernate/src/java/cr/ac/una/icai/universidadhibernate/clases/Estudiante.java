/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.universidadhibernate.clases;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author estudiante
 */

public class Estudiante implements Serializable {


    private Integer cedula;
    private String nombre;
    private String direccion;
    private Integer telefono;

    public Estudiante() {
    }

    public Estudiante(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.cedula);
        return hash;
    }


    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        return !((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula)));
    }

    @Override
    public String toString() {
        return "cr.ac.una.icai.universidadhibernate.clases.Estudiante[ cedula=" + cedula + " ]";
    }
    
}
