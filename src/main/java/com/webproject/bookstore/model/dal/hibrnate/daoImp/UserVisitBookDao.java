/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.daoImp;


import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserVisitBook;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserVisitBookId;
import com.webproject.bookstore.model.dal.hibrnate.util.SessionManager;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ibrahim
 */
public class UserVisitBookDao extends SuperDao<UserVisitBook> {

    public UserVisitBookDao(Session session) throws UnsupportedOperationException {
        super(session,new UserVisitBook());
    }

    @Override
    public synchronized UserVisitBook insert(UserVisitBook userVisitBook) throws HibernateException {
        return super.insert(userVisitBook);
    }

    public List<UserVisitBook> getUsersVisitBookByBookId(int id) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(UserVisitBook.class)
                .add(Restrictions.eq("bookID", id));

        List<UserVisitBook> userVisitBook = (List<UserVisitBook>) bookCriteria.list();
        session.getTransaction().commit();
        return userVisitBook;
    }

    public List<UserVisitBook> getUserVisitBookByUserId(User user) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria userCriteria = session.createCriteria(UserVisitBook.class).addOrder(Order.desc("visitsNumber"))
                .createCriteria("user")
                .add(Restrictions.idEq(user.getUserId()));

        List<UserVisitBook> userVisitBook = (List<UserVisitBook>) userCriteria.list();
        session.getTransaction().commit();
        return userVisitBook;

    }

    public UserVisitBook getVisitsByUserAndBookId(UserVisitBookId id) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria visitsCriteria = session.createCriteria(UserVisitBook.class)
                .add(Restrictions.idEq(id));
        UserVisitBook userVisitBook = (UserVisitBook) visitsCriteria.uniqueResult();
        session.getTransaction().commit();
        return userVisitBook;
    }

    public void updateVisits(UserVisitBookId id) throws HibernateException{

        int visits = 1;
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria visitsCriteria = session.createCriteria(UserVisitBook.class)
                .add(Restrictions.idEq(id));
        UserVisitBook userVisitBook = (UserVisitBook) visitsCriteria.uniqueResult();
        session.getTransaction().commit();
        if (userVisitBook == null) {
            UserVisitBook newUserVisitBook = new UserVisitBook();
            newUserVisitBook.setId(id);
            newUserVisitBook.setVisitsNumber(visits);
            super.insert(newUserVisitBook);
        } else {
            int currentVisits = userVisitBook.getVisitsNumber();
            visits = ++currentVisits;
            userVisitBook.setVisitsNumber(visits);
            super.update(userVisitBook);
            
            
        }
    }

    
    

}
