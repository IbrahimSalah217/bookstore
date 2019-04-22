/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.daoImp;

import com.webproject.bookstore.model.dal.hibrnate.entities.Offer;
import com.webproject.bookstore.model.dal.hibrnate.util.SessionManager;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ibrahim
 */
public class OfferDao extends SuperDao<Offer> {

    public OfferDao(Session sessoin) throws UnsupportedOperationException {
        super(sessoin,new Offer());
    }

    public Offer getByID(int id) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria offerCriteria = session.createCriteria(Offer.class).add(Restrictions.idEq(id));
        Offer offer = (Offer) offerCriteria.uniqueResult();
        session.getTransaction().commit();
        return offer;
    }

    public Offer getByPercentandDate(int percent, Date date) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria offerCriteria = session.createCriteria(Offer.class)
                .add(Restrictions.eq("offerPercentage", percent)).add(Restrictions.eq("expireDate", date));
        
        Offer offer = (Offer) offerCriteria.uniqueResult();
        session.getTransaction().commit();
        return offer;
    }

    public List<Offer> getAllOffers() throws HibernateException {
        List<Offer> offers = null;
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria offerCriteria = session.createCriteria(Offer.class);
        offers = offerCriteria.list();
        session.getTransaction().commit();

        return offers;
    }
}
