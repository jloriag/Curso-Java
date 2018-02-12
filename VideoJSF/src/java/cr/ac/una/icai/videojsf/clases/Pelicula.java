/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.clases;


/**
 *
 * @author Estudiante
 */
public class Pelicula {
    
    private Integer codigo;
    private String nombre;
    private String productora;
    private Integer tipo;
            //1)Acción - 2)Comedia - 3)Suspenso - 4)Romantica
    private Integer taquillera;
            //1)SI - 2)NO

    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTaquillera() {
        return taquillera;
    }

    public void setTaquillera(Integer taquillera) {
        this.taquillera = taquillera;
    }
    
    
}
