/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.universidadhibernate.clases;

import java.io.Serializable;


public class Profesor implements Serializable {


    private Integer cedulaprofe;
    private String nombre;
    private Integer annosexperiencia;
    private String correo;

    public Profesor() {
    }

    public Profesor(Integer cedulaprofe) {
        this.cedulaprofe = cedulaprofe;
    }

    public Integer getCedulaprofe() {
        return cedulaprofe;
    }

    public void setCedulaprofe(Integer cedulaprofe) {
        this.cedulaprofe = cedulaprofe;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnnosexperiencia() {
        return annosexperiencia;
    }

    public void setAnnosexperiencia(Integer annosexperiencia) {
        this.annosexperiencia = annosexperiencia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedulaprofe != null ? cedulaprofe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.cedulaprofe == null && other.cedulaprofe != null) || (this.cedulaprofe != null && !this.cedulaprofe.equals(other.cedulaprofe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.icai.universidadhibernate.clases.Profesor[ cedulaprofe=" + cedulaprofe + " ]";
    }
    
}
