/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bean;

import cr.ac.una.icai.videojsf.bo.AlquilerBo;
import cr.ac.una.icai.videojsf.bo.ClienteBo;
import cr.ac.una.icai.videojsf.bo.PeliculaBo;
import cr.ac.una.icai.videojsf.clases.Alquiler;
import cr.ac.una.icai.videojsf.clases.Cliente;
import cr.ac.una.icai.videojsf.clases.Pelicula;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Estudiante
 */
public final class AlquilerBean {

    /**
     * Creates a new instance of PeliculaBean
     */
    
    private Alquiler elAlquiler;
    private AlquilerBo alquilerBo;
    private PeliculaBo peliculaBo;
    private ClienteBo clienteBo;
    private FacesMessage msj;
    
    private List<Alquiler> listaAlquileres;
    private HtmlDataTable tableAlquileres;
    private Boolean agregando;
    
    public AlquilerBean() {
        reiniciarBean();

    }
    
    public void reiniciarBean(){
        elAlquiler = new Alquiler();
        alquilerBo = new AlquilerBo();
        peliculaBo=new PeliculaBo();
        clienteBo=new ClienteBo();
        msj = new FacesMessage();
        listaAlquileres = new ArrayList<>();
        tableAlquileres = new HtmlDataTable();
        agregando = true;
    }
    
    
    public String agregar(){
        if(validarDatos()){
            int i = alquilerBo.insertar(elAlquiler);
            
            this.msj = new FacesMessage();
            switch(i){
                case 0:
                    this.msj.setSummary("Alquiler agregado correctamente.");
                    reiniciarBean();
                    break;
                case 1:
                    this.msj.setSummary("No se pudo conectar a la BD.");
                    break;
                case 2:
                    this.msj.setSummary("Error insertando el alquiler.");
                    break;
                case 3:
                    this.msj.setSummary("Ya existe un alquiler con ese codigo.");
                    break;
            }
            
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
        return "";
    }
    
    public String modificar() {
        if (validarDatos()) {
            int i = alquilerBo.modificar(elAlquiler);

            switch (i) {
                case 0:
                    msj.setSummary("Alquiler modificado correctamente");
                    reiniciarBean();
                    break;
                case 1:
                    msj.setSummary("No se pudo conectar a la BD");
                    break;
                case 2:
                    msj.setSummary("Error modificando el alquiler");
                    break;
            }
            FacesContext.getCurrentInstance().addMessage(null, msj);
            elAlquiler = new Alquiler();
            agregando = true;
        }
        return "";
    }
    
    public boolean validarDatos(){
        //Validar que datos correspondan
        return true;
    }
    
    public List<SelectItem> llenaPelicula() {
        List<SelectItem> lista = new ArrayList<>();
        List<Pelicula> peliculas=peliculaBo.consultaTodos();
        lista.add(new SelectItem(0, "--Seleccione--"));
        peliculas.forEach((peli) -> {
            lista.add(new SelectItem(peli.getCodigo(),peli.getNombre()));
        });
        return lista;
    }
    
    public List<SelectItem> llenaCliente() {
        List<SelectItem> lista = new ArrayList<>();
        List<Cliente> peliculas=clienteBo.consultaTodos();
        lista.add(new SelectItem(0, "--Seleccione--"));
        peliculas.forEach((cliente) -> {
            lista.add(new SelectItem(cliente.getCedula(),cliente.getNombre()));
        });
        return lista;
    }
    
    public List<SelectItem> llenaAlquileres(){
        List<SelectItem> lista=new ArrayList<>();
        List<Alquiler> alquiler=alquilerBo.consultaTodos();
        
        alquiler.forEach((client) -> {
           // lista.add(new SelectItem(client.getCedula(),client.getNombre()));
        });
        
        return lista;
     }
    
    public String eliminar() {
        elAlquiler = (Alquiler) tableAlquileres.getRowData();
        int i = alquilerBo.eliminar(elAlquiler);
        switch (i) {
            case 0:
                reiniciarBean();
                msj.setSummary("Alquiler eliminado correctamente");
                break;
            case 1:
                msj.setSummary("No se pudo conectar a la BD");
                break;
            case 2:
                msj.setSummary("Error eliminando el alquiler");
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
    
    public String consXCedula() {
        if (elAlquiler.getCedula()== null) {
            msj = new FacesMessage();
            msj.setSummary("Ingrese una cedula a buscar");
            FacesContext.getCurrentInstance().addMessage("form1:txtCodigo", msj);
        } else {
            Alquiler client = alquilerBo.consXcedula(elAlquiler.getCedula());
            if (client == null) {
                msj = new FacesMessage();
                msj.setSummary("No se encontro un alquiler con esa cedula");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            } else {
                listaAlquileres.clear();
                listaAlquileres.add(client);
            }

        }
        return "";
    }
    
    public String consXNombre() {
        if (elAlquiler.getCedula() == null) {
            msj = new FacesMessage();
            msj.setSummary("Ingrese un nombre a buscar");
            FacesContext.getCurrentInstance().addMessage("form1:txtNombre", msj);
        } else {
            List<Alquiler> client = alquilerBo.consXnombre(elAlquiler.getCedula().toString());
            if (client == null) {
                msj = new FacesMessage();
                msj.setSummary("No se encontro un alquiler con ese nombre");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            } else {
                listaAlquileres = client;
            }
        }
        return "";
    }
    
    public String seleccionar() {
        elAlquiler = (Alquiler) tableAlquileres.getRowData();
        agregando = false;
        return "";
    }
    

    
    public Alquiler getElAlquiler() {
        return elAlquiler;
    }

    public void setElAlquiler(Alquiler elAlquiler) {
        this.elAlquiler = elAlquiler;
    }

    public AlquilerBo getAlquilerBo() {
        return alquilerBo;
    }

    public void setAlquilerBo(AlquilerBo alquilerBo) {
        this.alquilerBo = alquilerBo;
    }

    public FacesMessage getMsj() {
        return msj;
    }

    public void setMsj(FacesMessage msj) {
        this.msj = msj;
    }

    public List<Alquiler> getListaAlquileres() {
        if(listaAlquileres.isEmpty()){
            listaAlquileres=alquilerBo.consultaTodos();
        }
        return listaAlquileres;
    }

    public void setListaAlquileres(List<Alquiler> listaAlquileres) {
        this.listaAlquileres = listaAlquileres;
    }

    public HtmlDataTable getTableAlquileres() {
        return tableAlquileres;
    }

    public void setTableAlquileres(HtmlDataTable tableAlquileres) {
        this.tableAlquileres = tableAlquileres;
    }

    public Boolean getAgregando() {
        return agregando;
    }

    public void setAgregando(Boolean agregando) {
        this.agregando = agregando;
    }

    
    
    
}
