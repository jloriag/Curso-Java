/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bean;

import cr.ac.una.icai.videojsf.bo.ActorBo;
import cr.ac.una.icai.videojsf.clases.Actor;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Estudiante
 */
public class ActorBean {

    /**
     * Creates a new instance of PeliculaBean
     */
    
    private Actor elActor;
    private ActorBo clienteBo;
    private FacesMessage msj;
    
    public ActorBean() {
        elActor = new Actor();
        clienteBo = new ActorBo();
        msj = new FacesMessage();
    }
    
    
    public String agregar(){
        if(validarDatos()){
            int i = clienteBo.insertar(elActor);
            
            this.msj = new FacesMessage();
            switch(i){
                case 0:
                    this.msj.setSummary("Actor agregado correctamente.");
                    elActor=  new Actor();
                    break;
                case 1:
                    this.msj.setSummary("No se pudo conectar a la BD.");
                    break;
                case 2:
                    this.msj.setSummary("Error insertando el actor.");
                    break;
                case 3:
                    this.msj.setSummary("Ya existe un actor con ese codigo.");
                    break;
            }
            
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
        return "";
    }
    
    public boolean validarDatos(){
        //Validar que datos correspondan
        return true;
    }
    
    public Actor getElActor() {
        return elActor;
    }

    public void setElActor(Actor elActor) {
        this.elActor = elActor;
    }

    public ActorBo getActorBo() {
        return clienteBo;
    }

    public void setActorBo(ActorBo clienteBo) {
        this.clienteBo = clienteBo;
    }

    public FacesMessage getMsj() {
        return msj;
    }

    public void setMsj(FacesMessage msj) {
        this.msj = msj;
    }


    
    
}
