/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bo;

import cr.ac.una.icai.videojsf.clases.Cliente;
import cr.ac.una.icai.videojsf.dao.ClienteAD;

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
}
