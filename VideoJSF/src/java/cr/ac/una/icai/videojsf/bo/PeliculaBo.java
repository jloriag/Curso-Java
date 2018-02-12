/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bo;

import cr.ac.una.icai.videojsf.clases.Pelicula;
import cr.ac.una.icai.videojsf.dao.PeliculaAD;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class PeliculaBo {
    private PeliculaAD peliDao;

    public PeliculaBo() {
        peliDao = new PeliculaAD();
    }
    
    public Integer insertar(Pelicula peli){
        return this.peliDao.insertar(peli);
    }
    
    public List<Pelicula> consultaTodos(){
        
        return peliDao.consultaTodos();
    }

    public int modificar(Pelicula laPelicula) {
        return peliDao.modificar(laPelicula);
    }

    public int eliminar(Pelicula laPelicula) {
        return peliDao.eliminar(laPelicula);
    }

    public Pelicula consXcodigo(Integer codigo) {
        return peliDao.consultaXCodigo(codigo);
    }

    public List<Pelicula> consXnombre(String nombre) {
        return peliDao.consultaXNombre(nombre);
    }
    
    
}
