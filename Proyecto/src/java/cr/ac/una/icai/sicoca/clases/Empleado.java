package cr.ac.una.icai.sicoca.clases;
// Generated 24-feb-2018 12:13:50 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private int cedula;
     private Area area;
     private String nombre;
     private String apellido1;
     private String apellido2;
     private String telefono;
     private String correo;
     private Set<Matricula> matriculas = new HashSet<Matricula>(0);

    public Empleado() {
    }

	
    public Empleado(int cedula) {
        this.cedula = cedula;
    }
    public Empleado(int cedula, Area area, String nombre, String apellido1, String apellido2, String telefono, String correo, Set<Matricula> matriculas) {
       this.cedula = cedula;
       this.area = area;
       this.nombre = nombre;
       this.apellido1 = apellido1;
       this.apellido2 = apellido2;
       this.telefono = telefono;
       this.correo = correo;
       this.matriculas = matriculas;
    }
   
    public int getCedula() {
        return this.cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public Area getArea() {
        return this.area;
    }
    
    public void setArea(Area area) {
        this.area = area;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return this.apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return this.apellido2;
    }
    
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Set<Matricula> getMatriculas() {
        return this.matriculas;
    }
    
    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }




}


