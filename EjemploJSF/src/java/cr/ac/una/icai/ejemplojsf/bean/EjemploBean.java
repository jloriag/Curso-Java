/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.ejemplojsf.bean;

import cr.ac.una.icai.ejemplojsf.clases.Estudiante;

/**
 *
 * @author Estudiante
 */
public class EjemploBean {
    private Estudiante elEstudiante;

    public EjemploBean() {
        elEstudiante=new Estudiante();
    }

    public Estudiante getElEstudiante() {
        return elEstudiante;
    }

    public void setElEstudiante(Estudiante elEstudiante) {
        this.elEstudiante = elEstudiante;
    }
    
    public String agregar() {
        return "";
    }
    
    
}
