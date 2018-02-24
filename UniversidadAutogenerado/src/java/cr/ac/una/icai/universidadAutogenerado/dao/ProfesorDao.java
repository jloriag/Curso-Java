/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.universidadAutogenerado.dao;

import cr.una.una.icai.clases.Profesor;
import hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Transaction;

/**
 *
 * @author Estudiante
 */
public class ProfesorDao extends PadreDao{

    public ProfesorDao() {
        super();
    }

    public boolean insertar(Profesor elprofe) {
       return super.insertar(elprofe);
    }
    
    public boolean modificar(Profesor elprofe){
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.merge(elprofe);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public List<Profesor> consultaTodos(){
      try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            List<Profesor> profes=session.createQuery("From Profesor").list();
            session.close();
            return profes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Profesor> consultaXNombre(String nombre){
      try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            List<Profesor> profes=session.createQuery("From Profesor where nombre="+nombre).list();
            session.close();
            return profes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Profesor consultaXCedula(Integer cedula){
      try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            List<Profesor> profes=session.createQuery("From Profesor where cedulaprofe="+cedula).list();
            session.close();
            if(profes.isEmpty()){
                return null;
            }else{
                return profes.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
}
