/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bean;

import cr.ac.una.icai.videojsf.bo.PeliculaBo;
import cr.ac.una.icai.videojsf.clases.Pelicula;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Estudiante
 */
public class PeliculaBean {

    private Pelicula laPelicula;
    private PeliculaBo peliBo;
    private FacesMessage msj;

    /**
     * Creates a new instance of PeliculaBean
     */
    public PeliculaBean() {
        laPelicula = new Pelicula();
        peliBo=new PeliculaBo();
        msj=new FacesMessage();
    }

    public Pelicula getLaPelicula() {
        return laPelicula;
    }

    public void setLaPelicula(Pelicula laPelicula) {
        this.laPelicula = laPelicula;
    }

    public PeliculaBo getPeliBo() {
        return peliBo;
    }

    public void setPeliBo(PeliculaBo peliBo) {
        this.peliBo = peliBo;
    }

    public FacesMessage getMsj() {
        return msj;
    }

    public void setMsj(FacesMessage msj) {
        this.msj = msj;
    }
    
    
    public List<SelectItem> llenaTipo() {
        List<SelectItem> lista = new ArrayList();
        lista.add(new SelectItem(0, "---Seleccione----"));
        lista.add(new SelectItem(1, "Accion"));
        lista.add(new SelectItem(2, "Comedia"));
        lista.add(new SelectItem(3, "Suspenso"));
        lista.add(new SelectItem(4, "Romanticda"));
        return lista;

    }

    public List<SelectItem> llenaTaquillera() {
        List<SelectItem> lista =new ArrayList<>();
        lista.add(new SelectItem(1,"Si"));
        lista.add(new SelectItem(2,"No"));
        return lista;
    }
    
    public String agregar(){
        if(validaDatos()){
           int i= peliBo.insertar(laPelicula);
           switch(i){
               case 0:
                   this.msj.setSummary("Pelicula agregada correctamente");
                   break;
               case 1:
                   this.msj.setSummary("No se pudo conectar a la BD");
                   break;
               case 2:
                   this.msj.setSummary("Error insertando la pelicula");
                   break;
                case 3:
                   this.msj.setSummary("Ya existe");
                   break;
           }
           
           FacesContext.getCurrentInstance().addMessage(null, msj);
        }
    return "";
    }

    private boolean validaDatos() {
        return true;
    }
}
