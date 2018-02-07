/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bean;

import cr.ac.una.icai.videojsf.bo.ClienteBo;
import cr.ac.una.icai.videojsf.clases.Cliente;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Estudiante
 */
public class ClienteBean {

    /**
     * Creates a new instance of PeliculaBean
     */
    
    private Cliente elCliente;
    private ClienteBo clienteBo;
    private FacesMessage msj;
    
    public ClienteBean() {
        elCliente = new Cliente();
        clienteBo = new ClienteBo();
        msj = new FacesMessage();
    }
    
    
    public String agregar(){
        if(validarDatos()){
            int i = clienteBo.insertar(elCliente);
            
            this.msj = new FacesMessage();
            switch(i){
                case 0:
                    this.msj.setSummary("Cliente agregado correctamente.");
                    elCliente=  new Cliente();
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
    
    public boolean validarDatos(){
        //Validar que datos correspondan
        return true;
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


    
    
}
