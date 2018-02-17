/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bo;

import cr.ac.una.icai.videojsf.clases.Alquiler;
import cr.ac.una.icai.videojsf.dao.AlquilerAD;
import java.util.List;

/**
 *
 * @author josue
 */
public class AlquilerBo {
    private AlquilerAD alquilerDao;

    public AlquilerBo() {
        alquilerDao=new AlquilerAD();
    }
    
    public Integer insertar(Alquiler alquiler){
        return this.alquilerDao.insertar(alquiler);
    }
    
    public Integer modificar(Alquiler alquiler){
        return this.alquilerDao.modificar(alquiler);
    }

    public List<Alquiler> consultaTodos() {
        return alquilerDao.consultaTodos();
    }

    public int eliminar(Alquiler elAlquiler) {
        return alquilerDao.eliminar(elAlquiler);
    }
    
    public Alquiler consXcedula(Integer cedula){
        return alquilerDao.consultaXCedula(cedula);
    }
    
    public List<Alquiler> consXnombre(String nombre){
        return alquilerDao.consultaXNombre(nombre);
    }
}
