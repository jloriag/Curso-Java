/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bo;

import cr.ac.una.icai.videojsf.clases.Actor;
import cr.ac.una.icai.videojsf.dao.ActorAD;
import java.util.List;

/**
 *
 * @author josue
 */
public class ActorBo {
    private ActorAD actorDao;

    public ActorBo() {
        actorDao=new ActorAD();
    }
    
    public Integer insertar(Actor cliente){
        return this.actorDao.insertar(cliente);
    }
    
    public Integer modificar(Actor cliente){
        return this.actorDao.modificar(cliente);
    }

    public List<Actor> consultaTodos() {
        return actorDao.consultaTodos();
    }

    public int eliminar(Actor elActor) {
        return actorDao.eliminar(elActor);
    }
    
    public Actor consXcodigo(Integer cedula){
        return actorDao.consultaXCodigo(cedula);
    }
    
    public List<Actor> consXnombre(String nombre){
        return actorDao.consultaXNombre(nombre);
    }
}
