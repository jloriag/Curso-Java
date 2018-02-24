/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.videojsf.dao;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Estudiante
 */
public abstract class PadreDao {


    protected Session currentSession() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }


    public boolean insertar(Object obj) {
        try {
            Transaction tx = currentSession().beginTransaction();
            currentSession().save(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean modificar(Object obj){
        try {
            currentSession().HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = currentSession().beginTransaction();
            currentSession().merge(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
