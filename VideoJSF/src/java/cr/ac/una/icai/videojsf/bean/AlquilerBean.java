/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.bean;

import cr.ac.una.icai.videojsf.clases.Alquiler;

/**
 *
 * @author Josue
 */
public class AlquilerBean {
    
    private Alquiler elAlquiler;

    /**
     * Creates a new instance of AlquilerBean
     */
    public AlquilerBean() {
        elAlquiler=new Alquiler();
    }

    public Alquiler getElAlquiler() {
        return elAlquiler;
    }

    public void setElAlquiler(Alquiler elAlquiler) {
        this.elAlquiler = elAlquiler;
    }
    
    
}
