/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.universidadhibernate.clases;

import java.util.Objects;

/**
 *
 * @author estudiante
 */
public class MatriculaID {
    private Curso elcurso;
    private Estudiante elestudiante;

    public MatriculaID() {
        elcurso=new Curso();
        elestudiante=new Estudiante();
    }

    public Curso getElcurso() {
        return elcurso;
    }

    public void setElcurso(Curso elcurso) {
        this.elcurso = elcurso;
    }

    public Estudiante getElestudiante() {
        return elestudiante;
    }

    public void setElestudiante(Estudiante elestudiante) {
        this.elestudiante = elestudiante;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.elcurso);
        hash = 17 * hash + Objects.hashCode(this.elestudiante);
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
        final MatriculaID other = (MatriculaID) obj;
        if (!Objects.equals(this.elcurso, other.elcurso)) {
            return false;
        }
        if (!Objects.equals(this.elestudiante, other.elestudiante)) {
            return false;
        }
        return true;
    }
    
    
}
