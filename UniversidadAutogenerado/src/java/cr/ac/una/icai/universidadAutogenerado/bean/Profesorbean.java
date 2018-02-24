/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.universidadAutogenerado.bean;

import cr.ac.una.icai.universidadAutogenerado.bo.ProfesorBo;
import cr.una.una.icai.clases.Profesor;

/**
 *
 * @author Estudiante
 */
public class Profesorbean {

    private Profesor elprofe;
    private ProfesorBo profeBo;
    public Profesorbean() {
        elprofe=new Profesor();
        profeBo=new ProfesorBo();
    }

    public Profesor getElprofe() {
        return elprofe;
    }

    public void setElprofe(Profesor elprofe) {
        this.elprofe = elprofe;
    }

    public ProfesorBo getProfeBo() {
        return profeBo;
    }

    public void setProfeBo(ProfesorBo profeBo) {
        this.profeBo = profeBo;
    }
    
    
    public String agregar(){
        if(profeBo.insertar(elprofe)){
            
        }else{
            
        }
        elprofe=new Profesor();
        return "";
    }
}
