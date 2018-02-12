/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bo;

import cr.ac.una.icai.videojsf.clases.Cliente;
import cr.ac.una.icai.videojsf.dao.ClienteAD;
import java.util.List;

/**
 *
 * @author josue
 */
public class ClienteBo {
    private ClienteAD clienteDao;

    public ClienteBo() {
        clienteDao=new ClienteAD();
    }
    
    public Integer insertar(Cliente cliente){
        return this.clienteDao.insertar(cliente);
    }
    
    public Integer modificar(Cliente cliente){
        return this.clienteDao.modificar(cliente);
    }

    public List<Cliente> consultaTodos() {
        return clienteDao.consultaTodos();
    }

    public int eliminar(Cliente elCliente) {
        return clienteDao.eliminar(elCliente);
    }
    
    public Cliente consXcedula(Integer cedula){
        return clienteDao.consultaXCedula(cedula);
    }
    
    public List<Cliente> consXnombre(String nombre){
        return clienteDao.consultaXNombre(nombre);
    }
}
