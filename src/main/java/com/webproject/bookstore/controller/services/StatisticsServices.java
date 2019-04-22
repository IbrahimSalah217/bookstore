/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.services;

import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.SuperDao;
import com.webproject.bookstore.model.dal.hibrnate.util.DaoFactory;
import org.hibernate.HibernateException;

/**
 *
 * @author Ibrahim
 */
public class StatisticsServices {
    SuperDao daoObject;
    BookDao bookDao;
    public StatisticsServices() throws UnsupportedOperationException,HibernateException{
    }
    
    public long getUsersCount() throws ClassNotFoundException,HibernateException{
        long count;
        daoObject =DaoFactory.getUserDao();
        count = daoObject.getEntityCount();
        return count;
    }
    
    public long getBookssCount() throws ClassNotFoundException,HibernateException{
        long count;
        daoObject =DaoFactory.getBookDao();
        count = daoObject.getEntityCount();
        return count;
    }
    
    public long getOrdersCount() throws ClassNotFoundException,HibernateException{
        long count;
        daoObject =DaoFactory.getOrderDao();
        count = daoObject.getEntityCount();
        return count;
    }
    
    public long getBooksVisitsCount() throws ClassNotFoundException,HibernateException{
        long count;
        daoObject =DaoFactory.getUserVisitBookDao();
        count = daoObject.getEntityCount();
        return count;
    }
    
    public long getCategoriesCount() throws ClassNotFoundException,HibernateException{
        long count;
        daoObject =DaoFactory.getCategoryDao();
        count = daoObject.getEntityCount();
        return count;
    }
    
    public long getSalesCount() throws HibernateException{
        long count;
        bookDao =DaoFactory.getBookDao();
        count = bookDao.getSalesCount();
        return count;
    }
    
    public long getAvailableBooksCount()throws HibernateException{
        long count;
        bookDao =DaoFactory.getBookDao();
        count = bookDao.getAvailableCounts();
        return count;
    }
    
    public long getAuthorsCount()throws HibernateException{
        long count;
        bookDao =DaoFactory.getBookDao();
        count = bookDao.getAuthorsCounts();
        return count;
    }
    
}
