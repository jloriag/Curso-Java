package cr.una.una.icai.clases;
// Generated 17/02/2018 12:09:47 PM by Hibernate Tools 4.3.1



/**
 * MatriculaId generated by hbm2java
 */
public class MatriculaId  implements java.io.Serializable {


     private int cedula;
     private int idcurso;

    public MatriculaId() {
    }

    public MatriculaId(int cedula, int idcurso) {
       this.cedula = cedula;
       this.idcurso = idcurso;
    }
   
    public int getCedula() {
        return this.cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public int getIdcurso() {
        return this.idcurso;
    }
    
    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MatriculaId) ) return false;
		 MatriculaId castOther = ( MatriculaId ) other; 
         
		 return (this.getCedula()==castOther.getCedula())
 && (this.getIdcurso()==castOther.getIdcurso());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCedula();
         result = 37 * result + this.getIdcurso();
         return result;
   }   


}


