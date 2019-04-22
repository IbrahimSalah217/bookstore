/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.util;

import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookOrderDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.CategoryDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.OfferDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.SuperDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserCartBookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserOrderDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserVisitBookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoInt.AbstractDaoInt;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Ibrahim
 */
public class DaoFactory{

    public static CategoryDao getCategoryDao() throws UnsupportedOperationException,HibernateException{
        Session session = SessionManager.getSession();
        return new CategoryDao(session);
    }
    
    public static BookDao getBookDao() throws UnsupportedOperationException,HibernateException{
        Session session = SessionManager.getSession();
        return new BookDao(session);
    }
    
    public static BookOrderDao getBookOrderDao() throws UnsupportedOperationException,HibernateException{
        Session session = SessionManager.getSession();
        return new BookOrderDao(session);
    }
    
    public static OfferDao getOfferDao() throws UnsupportedOperationException,HibernateException{
        Session session = SessionManager.getSession();
        return new OfferDao(session);
    }
    
    public static UserDao getUserDao() throws UnsupportedOperationException,HibernateException{
        Session session = SessionManager.getSession();
        return new UserDao(session);
    }
    
    public static UserCartBookDao getCartBookDao() throws UnsupportedOperationException,HibernateException{
        Session session = SessionManager.getSession();
        return new UserCartBookDao(session);
    }
    
    public static UserOrderDao getOrderDao() throws UnsupportedOperationException,HibernateException{
        Session session = SessionManager.getSession();
        return new UserOrderDao(session);
    }
    
    public static UserVisitBookDao getUserVisitBookDao() throws UnsupportedOperationException,HibernateException{
        Session session = SessionManager.getSession();
        return new UserVisitBookDao(session);
    }
    
    
    
}
