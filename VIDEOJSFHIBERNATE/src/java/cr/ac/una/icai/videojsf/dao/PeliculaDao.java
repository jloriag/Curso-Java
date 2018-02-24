/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.dao;

import cr.ac.una.icai.videojsf.clases.Pelicula;

/**
 *
 * @author Estudiante
 */
public class PeliculaDao extends PadreDao{

    public PeliculaDao() {
        super();
    }
    
    public boolean insertar(Pelicula peli){
        return super.insertar(peli);
    }
    
    public boolean modificar(Pelicula peli){
        return super.modificar(peli);
    }
    
}
