/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.daoImp;

import com.webproject.bookstore.model.dal.hibrnate.daoInt.AbstractDaoInt;
import com.webproject.bookstore.model.dal.hibrnate.util.SessionManager;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

/**
 *
 * @author Ibrahim
 */
public abstract class SuperDao<DAO> implements AbstractDaoInt<DAO> {

    Session session;
    DAO dao;

    public SuperDao(Session sessoin,DAO dao) throws UnsupportedOperationException {
        this.session = sessoin;
        this.dao = dao;
    }

    @Override
    public DAO insert(DAO daoObject) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        session.save(daoObject);
        List<DAO> daoList = session.createCriteria(daoObject.getClass()).list();
        DAO returnedObject = daoList.get(daoList.size() - 1);
        session.getTransaction().commit();
        return returnedObject;
    }

    @Override
    public void delete(DAO daoObject) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        session.delete(daoObject);
        session.getTransaction().commit();
    }

    @Override
    public void update(DAO daoObject) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        session.update(daoObject);
        session.getTransaction().commit();
    }
    
    public long getEntityCount() throws ClassNotFoundException,HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        long entityCount;
        session.beginTransaction();
        entityCount = (long) session.createCriteria(dao.getClass())
                .setProjection(Projections.rowCount()).uniqueResult();
        session.getTransaction().commit();
        return entityCount;
    }

}
