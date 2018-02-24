/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.icai.universidadAutogenerado.dao;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Estudiante
 */
public abstract class PadreDao {

    protected Session session;

    public PadreDao() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public boolean insertar(Object obj) {
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.save(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
}
