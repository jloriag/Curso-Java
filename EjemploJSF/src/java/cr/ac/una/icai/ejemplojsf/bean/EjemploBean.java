/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.ejemplojsf.bean;

import cr.ac.una.icai.ejemplojsf.clases.Estudiante;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Estudiante
 */
public class EjemploBean {
    private Estudiante elEstudiante;
    private FacesMessage msj;

    public EjemploBean() {
        elEstudiante=new Estudiante();
        this.msj=new FacesMessage();
    }

    public Estudiante getElEstudiante() {
        return elEstudiante;
    }

    public void setElEstudiante(Estudiante elEstudiante) {
        this.elEstudiante = elEstudiante;
    }

    public FacesMessage getMsj() {
        return msj;
    }

    public void setMsj(FacesMessage msj) {
        this.msj = msj;
    }
    
    
    public String agregar() {
        if(validarDatos()){
            this.msj=new FacesMessage();
            this.msj.setSummary("Estudiante agregado correctamente");
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
        return "";
    }

    private boolean validarDatos() {
        boolean todoBien=true;
        
        if(elEstudiante.getNombre().trim().length()==0) { 
            this.msj=new FacesMessage();
            this.msj.setSummary("Ingrese un nombre");
            FacesContext.getCurrentInstance().addMessage("form1:txtNombre", msj);
            todoBien=true;
        }
        
        if(elEstudiante.getCedula()==null){
            this.msj=new FacesMessage();
            this.msj.setSummary("Ingrese una cedula");
            FacesContext.getCurrentInstance().addMessage("form1:txtCedula", msj);
            todoBien=true;
        }
        return todoBien;
    }
    
    
}
