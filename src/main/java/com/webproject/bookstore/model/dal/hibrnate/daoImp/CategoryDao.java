/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.daoImp;

import com.webproject.bookstore.model.dal.hibrnate.daoInt.AbstractDaoInt;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.util.SessionManager;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ibrahim
 */
public class CategoryDao extends SuperDao<Category> {

    public CategoryDao(Session sessoin) throws UnsupportedOperationException {
        super(sessoin,new Category());
    }

    public  Category getByName(String CategoryName) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria categoryCriteria = session.createCriteria(Category.class)
                .add(Restrictions.eq("categoryName", CategoryName));
        Category category = (Category) categoryCriteria.uniqueResult();
        session.getTransaction().commit();
        System.out.println("doneeeeeeeeeeeee");
        return category;
    }

    public Category getByID(int id) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria categoryCriteria = session.createCriteria(Category.class).add(Restrictions.idEq(id));
        Category category = (Category) categoryCriteria.uniqueResult();
        session.getTransaction().commit();
        return category;
    }
    
    public List<Category> getUserInterests(int userID) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria categoryCriteria = session.createCriteria(Category.class).createCriteria("users")
                .add(Restrictions.idEq(userID));
        List<Category> categoryList = categoryCriteria.list();
        session.getTransaction().commit();
        return categoryList;
    }
    
    public List<Category> getAllCategories() throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria categoryCriteria = session.createCriteria(Category.class);
        List<Category> categoryList = categoryCriteria.list();
        session.getTransaction().commit();
        return categoryList;
    }
}
