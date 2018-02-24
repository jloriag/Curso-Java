/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.universidadAutogenerado.bo;

import cr.ac.una.icai.universidadAutogenerado.dao.ProfesorDao;
import cr.una.una.icai.clases.Profesor;

/**
 *
 * @author Estudiante
 */
public class ProfesorBo {
    private ProfesorDao profeDao;

    public ProfesorBo() {
        profeDao=new ProfesorDao();
    }
    
    public boolean insertar(Profesor elProfe){
        return profeDao.insertar(elProfe);
    }

    public ProfesorDao getProfeDao() {
        return profeDao;
    }

    public void setProfeDao(ProfesorDao profeDao) {
        this.profeDao = profeDao;
    }
    
    
}
