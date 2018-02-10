/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bean;

import cr.ac.una.icai.videojsf.bo.PeliculaBo;
import cr.ac.una.icai.videojsf.clases.Pelicula;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Estudiante
 */
public final class PeliculaBean {

    /**
     * Creates a new instance of PeliculaBean
     */
    private Pelicula laPelicula;
    private PeliculaBo peliBo;
    private FacesMessage msj;

    private List<Pelicula> listaPeliculas;
    private HtmlDataTable tablePeliculas;
    private Boolean agregando;

    public PeliculaBean() {
        reiniciarBean();
    }

    public void reiniciarBean() {
        laPelicula = new Pelicula();
        peliBo = new PeliculaBo();
        msj = new FacesMessage();
        listaPeliculas = new ArrayList<>();
        tablePeliculas = new HtmlDataTable();
        agregando = true;
    }

    public String agregar() {
        if (validarDatos()) {
            int i = peliBo.insertar(laPelicula);

            this.msj = new FacesMessage();
            switch (i) {
                case 0:
                    this.msj.setSummary("Pelicula agregada correctamente.");
                    laPelicula = new Pelicula();
                    break;
                case 1:
                    this.msj.setSummary("No se pudo conectar a la BD.");
                    break;
                case 2:
                    this.msj.setSummary("Error insertando la pelicula.");
                    break;
                case 3:
                    this.msj.setSummary("Ya existe una pelicula con ese codigo.");
                    break;
            }

            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
        return "";
    }

    public boolean validarDatos() {
        //Validar que datos correspondan
        return true;
    }

    public List<SelectItem> llenaTipo() {
        List<SelectItem> lista = new ArrayList<>();
        lista.add(new SelectItem(0, "--Seleccione--"));
        lista.add(new SelectItem(1, "Acción"));
        lista.add(new SelectItem(2, "Comedia"));
        lista.add(new SelectItem(3, "Suspenso"));
        lista.add(new SelectItem(4, "Romantica"));
        return lista;
    }

    public List<SelectItem> llenaTaquillera() {
        List<SelectItem> lista = new ArrayList<>();
        lista.add(new SelectItem(1, "SI"));
        lista.add(new SelectItem(2, "NO"));
        return lista;
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

    public List<Pelicula> getListaPeliculas() {
        if (listaPeliculas.isEmpty()) {
            listaPeliculas = peliBo.consultaTodos();
        }
        return listaPeliculas;
    }

    public void setListaPeliculas(List<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public HtmlDataTable getTablePeliculas() {
        return tablePeliculas;
    }

    public void setTablePeliculas(HtmlDataTable tablePeliculas) {
        this.tablePeliculas = tablePeliculas;
    }

    public Boolean getAgregando() {
        return agregando;
    }

    public void setAgregando(Boolean agregando) {
        this.agregando = agregando;
    }

    public String seleccionar() {
        laPelicula = (Pelicula) tablePeliculas.getRowData();
        agregando = false;
        return "";
    }

    public String modificar() {
        if (validarDatos()) {
            int i = peliBo.modificar(laPelicula);

            switch (i) {
                case 0:
                    msj.setSummary("Pelicula modificada correctamente");
                    reiniciarBean();
                    break;
                case 1:
                    msj.setSummary("No se pudo conectar a la BD");
                    break;
                case 2:
                    msj.setSummary("Error modificando la pelicula");
                    break;
            }
            FacesContext.getCurrentInstance().addMessage(null, msj);
            laPelicula = new Pelicula();
            agregando = true;
        }
        return "";
    }

    public String eliminar() {
        laPelicula = (Pelicula) tablePeliculas.getRowData();
        int i = peliBo.eliminar(laPelicula);
        switch (i) {
            case 0:
                msj.setSummary("Pelicular eliminada correctamente");
                reiniciarBean();
                break;
            case 1:
                msj.setSummary("No se pudo conectar a la BD");
                break;
            case 2:
                msj.setSummary("Error modificando la pelicula");
                break;
        }
        return "";
    }

    public String consXCodigo() {
        if (laPelicula.getCodigo() == null) {
            msj = new FacesMessage();
            msj.setSummary("Ingrese un codigo a buscar");
            FacesContext.getCurrentInstance().addMessage("form1:txtCodigo", msj);
        } else {
            Pelicula pel = peliBo.consXcodigo(laPelicula.getCodigo());
            if (pel == null) {
                msj = new FacesMessage();
                msj.setSummary("No se encontro una pelicula con ese codigo");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            } else {
                listaPeliculas.clear();
                listaPeliculas.add(pel);
            }

        }
        return "";
    }

    public String consXNombre() {
        if (laPelicula.getNombre() == null) {
            msj = new FacesMessage();
            msj.setSummary("Ingrese un nombre a buscar");
            FacesContext.getCurrentInstance().addMessage("form1:txtNombre", msj);
        } else {
            List<Pelicula> pel = peliBo.consXnombre(laPelicula.getNombre());
            if (pel == null) {
                msj = new FacesMessage();
                msj.setSummary("No se encontro una pelicula con ese nombre");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            } else {
                listaPeliculas = pel;
            }
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
    
    public List<SelectItem> llenaPeliculas(){
        List<SelectItem> lista=new ArrayList<>();
        List<Pelicula> pelis=peliBo.consultaTodos();
        
        pelis.forEach((peli) -> {
            lista.add(new SelectItem(peli.getCodigo(),peli.getNombre()));
        });
        
        return lista;
     }
}
