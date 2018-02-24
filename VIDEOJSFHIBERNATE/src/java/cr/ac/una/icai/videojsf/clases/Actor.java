package cr.ac.una.icai.videojsf.clases;
// Generated 24-feb-2018 11:29:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Actor generated by hbm2java
 */
public class Actor  implements java.io.Serializable {


     private int codigoActor;
     private String nombre;
     private String nacionalidad;
     private Set<Pelicula> peliculas = new HashSet<Pelicula>(0);

    public Actor() {
    }

	
    public Actor(int codigoActor) {
        this.codigoActor = codigoActor;
    }
    public Actor(int codigoActor, String nombre, String nacionalidad, Set<Pelicula> peliculas) {
       this.codigoActor = codigoActor;
       this.nombre = nombre;
       this.nacionalidad = nacionalidad;
       this.peliculas = peliculas;
    }
   
    public int getCodigoActor() {
        return this.codigoActor;
    }
    
    public void setCodigoActor(int codigoActor) {
        this.codigoActor = codigoActor;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNacionalidad() {
        return this.nacionalidad;
    }
    
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public Set<Pelicula> getPeliculas() {
        return this.peliculas;
    }
    
    public void setPeliculas(Set<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }




}


