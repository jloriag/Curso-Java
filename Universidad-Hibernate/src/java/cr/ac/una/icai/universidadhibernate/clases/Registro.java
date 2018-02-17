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
public class Registro implements Serializable{
    private RegistroID id;
    private Curso elcurso;
    private String observaciones;

    public Registro() {
        id=new RegistroID();
        elcurso=new Curso();
    }

    public RegistroID getId() {
        return id;
    }

    public void setId(RegistroID id) {
        this.id = id;
    }

    public Curso getElcurso() {
        return elcurso;
    }

    public void setElcurso(Curso elcurso) {
        this.elcurso = elcurso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Registro other = (Registro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
