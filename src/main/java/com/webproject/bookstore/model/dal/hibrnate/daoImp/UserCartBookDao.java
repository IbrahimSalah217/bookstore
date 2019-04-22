/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.daoImp;

import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserCartBook;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserCartBookId;
import com.webproject.bookstore.model.dal.hibrnate.util.SessionManager;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ibrahim
 */
public class UserCartBookDao extends SuperDao<UserCartBook> {
    
    public UserCartBookDao(Session session) throws UnsupportedOperationException {
        super(session,new UserCartBook());
    }

    public void setUserCart(UserCartBook userCart) throws HibernateException {
        UserCartBook userCartBook = getUserCartById(userCart.getId());
        if (userCartBook != null) {
            super.update(userCart);
        } else {
            super.insert(userCart);
        }
    }

    private UserCartBook getUserCartById(UserCartBookId cartId) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria userCartBookCriteria = session.createCriteria(UserCartBook.class).add(Restrictions.idEq(cartId));
        UserCartBook userCartBook = (UserCartBook) userCartBookCriteria.uniqueResult();
        session.getTransaction().commit();
        return userCartBook;
    }
    
    public List<UserCartBook> getUserCart(User user)throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria userCartBookCriteria = session.createCriteria(UserCartBook.class).add(Restrictions.eq("user" , user));
        List<UserCartBook> userCart = userCartBookCriteria.list();
        session.getTransaction().commit();
        return userCart;
    }
    
    public List<UserCartBook> getUserCart(int userId) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria userCriteria = session.createCriteria(User.class).add(Restrictions.idEq(userId));
        User user = (User) userCriteria.uniqueResult();
        Criteria userCartBookCriteria = session.createCriteria(UserCartBook.class).add(Restrictions.eq("user" , user));
        List<UserCartBook> userCart = userCartBookCriteria.list();
        session.getTransaction().commit();
        return userCart;
    }
    
    public void removeCart(UserCartBook userCart)throws HibernateException{
        super.delete(userCart);
    }
}