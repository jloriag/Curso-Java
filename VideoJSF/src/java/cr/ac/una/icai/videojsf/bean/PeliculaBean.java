/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bean;

import cr.ac.una.icai.videojsf.clases.Pelicula;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Estudiante
 */
public class PeliculaBean {

    private Pelicula laPelicula;

    /**
     * Creates a new instance of PeliculaBean
     */
    public PeliculaBean() {
        laPelicula = new Pelicula();
    }

    public Pelicula getLaPelicula() {
        return laPelicula;
    }

    public void setLaPelicula(Pelicula laPelicula) {
        this.laPelicula = laPelicula;
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
}
