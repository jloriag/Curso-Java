/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bean;

import cr.ac.una.icai.videojsf.bo.ClienteBo;
import cr.ac.una.icai.videojsf.clases.Cliente;
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
public final class ClienteBean {

    /**
     * Creates a new instance of PeliculaBean
     */
    
    private Cliente elCliente;
    private ClienteBo clienteBo;
    private FacesMessage msj;
    
    private List<Cliente> listaClientes;
    private HtmlDataTable tableClientes;
    private Boolean agregando;
    
    public ClienteBean() {
        reiniciarBean();

    }
    
    public void reiniciarBean(){
        elCliente = new Cliente();
        clienteBo = new ClienteBo();
        msj = new FacesMessage();
        listaClientes = new ArrayList<>();
        tableClientes = new HtmlDataTable();
        agregando = true;
    }
    
    
    public String agregar(){
        if(validarDatos()){
            int i = clienteBo.insertar(elCliente);
            
            this.msj = new FacesMessage();
            switch(i){
                case 0:
                    this.msj.setSummary("Cliente agregado correctamente.");
                    reiniciarBean();
                    break;
                case 1:
                    this.msj.setSummary("No se pudo conectar a la BD.");
                    break;
                case 2:
                    this.msj.setSummary("Error insertando el cliente.");
                    break;
                case 3:
                    this.msj.setSummary("Ya existe un cliente con ese codigo.");
                    break;
            }
            
            FacesContext.getCurrentInstance().addMessage(null, msj);
        }
        return "";
    }
    
    public String modificar() {
        if (validarDatos()) {
            int i = clienteBo.modificar(elCliente);

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
            elCliente = new Cliente();
            agregando = true;
        }
        return "";
    }
    
    public boolean validarDatos(){
        //Validar que datos correspondan
        return true;
    }
    
    public List<SelectItem> llenaClientes(){
        List<SelectItem> lista=new ArrayList<>();
        List<Cliente> cliente=clienteBo.consultaTodos();
        
        cliente.forEach((client) -> {
            lista.add(new SelectItem(client.getCedula(),client.getNombre()));
        });
        
        return lista;
     }
    
    public String eliminar() {
        elCliente = (Cliente) tableClientes.getRowData();
        int i = clienteBo.eliminar(elCliente);
        switch (i) {
            case 0:
                reiniciarBean();
                msj.setSummary("Cliente eliminado correctamente");
                break;
            case 1:
                msj.setSummary("No se pudo conectar a la BD");
                break;
            case 2:
                msj.setSummary("Error eliminando el cliente");
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
        if (elCliente.getCedula()== null) {
            msj = new FacesMessage();
            msj.setSummary("Ingrese una cedula a buscar");
            FacesContext.getCurrentInstance().addMessage("form1:txtCodigo", msj);
        } else {
            Cliente client = clienteBo.consXcedula(elCliente.getCedula());
            if (client == null) {
                msj = new FacesMessage();
                msj.setSummary("No se encontro un cliente con esa cedula");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            } else {
                listaClientes.clear();
                listaClientes.add(client);
            }

        }
        return "";
    }
    
    public String consXNombre() {
        if (elCliente.getNombre() == null) {
            msj = new FacesMessage();
            msj.setSummary("Ingrese un nombre a buscar");
            FacesContext.getCurrentInstance().addMessage("form1:txtNombre", msj);
        } else {
            List<Cliente> client = clienteBo.consXnombre(elCliente.getNombre());
            if (client == null) {
                msj = new FacesMessage();
                msj.setSummary("No se encontro un cliente con ese nombre");
                FacesContext.getCurrentInstance().addMessage(null, msj);
            } else {
                listaClientes = client;
            }
        }
        return "";
    }
    
    public String seleccionar() {
        elCliente = (Cliente) tableClientes.getRowData();
        agregando = false;
        return "";
    }
    

    
    public Cliente getElCliente() {
        return elCliente;
    }

    public void setElCliente(Cliente elCliente) {
        this.elCliente = elCliente;
    }

    public ClienteBo getClienteBo() {
        return clienteBo;
    }

    public void setClienteBo(ClienteBo clienteBo) {
        this.clienteBo = clienteBo;
    }

    public FacesMessage getMsj() {
        return msj;
    }

    public void setMsj(FacesMessage msj) {
        this.msj = msj;
    }

    public List<Cliente> getListaClientes() {
        if(listaClientes.isEmpty()){
            listaClientes=clienteBo.consultaTodos();
        }
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public HtmlDataTable getTableClientes() {
        return tableClientes;
    }

    public void setTableClientes(HtmlDataTable tableClientes) {
        this.tableClientes = tableClientes;
    }

    public Boolean getAgregando() {
        return agregando;
    }

    public void setAgregando(Boolean agregando) {
        this.agregando = agregando;
    }

    
    
    
}
