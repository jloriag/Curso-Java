
package cr.ac.una.icai.videojsf.clases;


/**
 *
 * @author josue
 */

public class Actor  {


    private Integer codigoActor;
    private String nombre;
    private String nacionalidad;

    public Actor() {
    }

    public Actor(Integer codigoActor) {
        this.codigoActor = codigoActor;
    }

    public Integer getCodigoActor() {
        return codigoActor;
    }

    public void setCodigoActor(Integer codigoActor) {
        this.codigoActor = codigoActor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoActor != null ? codigoActor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actor)) {
            return false;
        }
        Actor other = (Actor) object;
        if ((this.codigoActor == null && other.codigoActor != null) || (this.codigoActor != null && !this.codigoActor.equals(other.codigoActor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.icai.videojsf.clases.Actor[ codigoActor=" + codigoActor + " ]";
    }
    
}
