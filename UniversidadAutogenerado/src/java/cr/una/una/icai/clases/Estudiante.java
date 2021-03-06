package cr.una.una.icai.clases;
// Generated 17/02/2018 12:09:47 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Estudiante generated by hbm2java
 */
public class Estudiante  implements java.io.Serializable {


     private int cedula;
     private String nombre;
     private String direccion;
     private Integer telefono;
     private Set<Matricula> matriculas = new HashSet<Matricula>(0);

    public Estudiante() {
    }

	
    public Estudiante(int cedula) {
        this.cedula = cedula;
    }
    public Estudiante(int cedula, String nombre, String direccion, Integer telefono, Set<Matricula> matriculas) {
       this.cedula = cedula;
       this.nombre = nombre;
       this.direccion = direccion;
       this.telefono = telefono;
       this.matriculas = matriculas;
    }
   
    public int getCedula() {
        return this.cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Integer getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    public Set<Matricula> getMatriculas() {
        return this.matriculas;
    }
    
    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.cedula;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (this.cedula != other.cedula) {
            return false;
        }
        return true;
    }




}


