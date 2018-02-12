/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bo;

import cr.ac.una.icai.videojsf.clases.Actor;
import cr.ac.una.icai.videojsf.dao.ActorAD;

/**
 *
 * @author josue
 */
public class ActorBo {
    private ActorAD clienteDao;

    public ActorBo() {
        clienteDao=new ActorAD();
    }
    
    public Integer insertar(Actor cliente){
        return this.clienteDao.insertar(cliente);
    }
}
