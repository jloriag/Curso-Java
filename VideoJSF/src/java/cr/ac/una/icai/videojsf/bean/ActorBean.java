/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bean;

import cr.ac.una.icai.videojsf.bo.ActorBo;
import cr.ac.una.icai.videojsf.clases.Actor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
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
    private ActorBo actorBo;
    private FacesMessage msj;
    
    private List<Actor> listaActores;
    private HtmlDataTable tableActores;
    private Boolean agregando;
    
    public ActorBean() {
       reiniciarBean();
    }
    
    
    public String agregar(){
        if(validarDatos()){
            int i = actorBo.insertar(elActor);
            
            this.msj = new FacesMessage();
            switch(i){
                case 0:
                    reiniciarBean();
                    this.msj.setSummary("Actor agregado correctamente.");
                     
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
    
    public String modificar() {
        if (validarDatos()) {
            int i = actorBo.modificar(elActor);

            switch (i) {
                case 0:
                    msj.setSummary("Cliente modificado correctamente");
                    reiniciarBean();
                    break;
                case 1:
                    msj.setSummary("No se pudo conectar a la BD");
                    break;
                case 2:
                    msj.setSummary("Error modificando el cliente");
                    break;
            }
            FacesContext.getCurrentInstance().addMessage(null, msj);
            elActor = new Actor();
            agregando = true;
        }
        return "";
    }
    
    public String eliminar() {
        elActor = (Actor) tableActores.getRowData();
        int i = actorBo.eliminar(elActor);
        switch (i) {
            case 0:
                reiniciarBean();
                msj.setSummary("Actor eliminado correctamente");
                break;
            case 1:
                msj.setSummary("No se pudo conectar a la BD");
                break;
            case 2:
                msj.setSummary("Error eliminando el actor");
                break;
        }
        return "";
    }
    
    public String limpiar() {
        reiniciarBean();
        return "";
    }
    
    public void regresar() throws IOException {

        FacesContext.getCurrentInstance().getExternalContext().redirect("../");

    }
    
      public String consXCodigo() {
        if (elActor.getCodigoActor()== null) {
            msj = new FacesMessage();
            msj.setSummary("Ingrese una codigo a buscar");
            FacesContext.getCurrentInstance().addMessage("form1:txtCodigo", msj);
        } else {
            Actor client = actorBo.consXcodigo(elActor.getCodigoActor());
            if (client == null) {
                msj = new FacesMessage();
                msj.setSummary("No se encontro un cliente con esa cedula");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            } else {
                listaActores.clear();
                listaActores.add(client);
            }

        }
        return "";
    }
    
    public String consXNombre() {
        if (elActor.getNombre()== null) {
            msj = new FacesMessage();
            msj.setSummary("Ingrese un nombre a buscar");
            FacesContext.getCurrentInstance().addMessage("form1:txtNombre", msj);
        } else {
            List<Actor> client = actorBo.consXnombre(elActor.getNombre());
            if (client == null) {
                msj = new FacesMessage();
                msj.setSummary("No se encontro un actor con ese nombre");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            } else {
                listaActores = client;
            }
        }
        return "";
    }
    
    public String seleccionar() {
        elActor = (Actor) tableActores.getRowData();
        agregando = false;
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
        return actorBo;
    }

    public void setActorBo(ActorBo actorBo) {
        this.actorBo = actorBo;
    }

    public FacesMessage getMsj() {
        return msj;
    }

    public void setMsj(FacesMessage msj) {
        this.msj = msj;
    }

    private void reiniciarBean() {
        elActor = new Actor();
        actorBo = new ActorBo();
        msj = new FacesMessage();
        
        listaActores = new ArrayList<>();
        tableActores = new HtmlDataTable();
        agregando = true;
    }

    public List<Actor> getListaActores() {
        if(listaActores.isEmpty()){
            listaActores=actorBo.consultaTodos();
        }
        return listaActores;
    }

    public void setListaActores(List<Actor> listaActores) {
        this.listaActores = listaActores;
    }

    public HtmlDataTable getTableActores() {
        return tableActores;
    }

    public void setTableActores(HtmlDataTable tableActores) {
        this.tableActores = tableActores;
    }

    public Boolean getAgregando() {
        return agregando;
    }

    public void setAgregando(Boolean agregando) {
        this.agregando = agregando;
    }


    
    
}
