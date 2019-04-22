/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.daoImp;

import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.util.SessionManager;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class UserDao extends SuperDao<User> {

    public UserDao(Session session) throws UnsupportedOperationException {
        super(session,new User());
    }

    public List<User> getAllUsers() throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria usersCriteria = session.createCriteria(User.class);
        List<User> users = usersCriteria.list();
        System.out.println("list>>>>>>>>>>>>>>>>>>>>>>" + users.size());
        session.getTransaction().commit();
        return users;
    }

    public List<User> getAllFemales() throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria usersCriteria = session.createCriteria(User.class)
                .add(Restrictions.eq("gender", "Female"));
        List<User> users = usersCriteria.list();
        session.getTransaction().commit();
        return users;
    }

    public List<User> getAllMales() throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria usersCriteria = session.createCriteria(User.class)
                .add(Restrictions.eq("gender", "Male"));
        List<User> users = usersCriteria.list();
        session.getTransaction().commit();
        return users;
    }

    public boolean isExist(String email, String password) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        boolean isExist = false;
        session.beginTransaction();
        Criteria usersCriteria = session.createCriteria(User.class)
                .add(Restrictions.eq("email", email))
                .add(Restrictions.eq("password", password));
        List<User> user = usersCriteria.list();
        if (user.size() > 0) {
            isExist = true;
        }
        session.getTransaction().commit();
        return isExist;
    }

    public User getUserByEmail(String email) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria usersCriteria = session.createCriteria(User.class)
                .add(Restrictions.eq("email", email));

        User user = (User) usersCriteria.uniqueResult();
        session.getTransaction().commit();
        return user;
    }

    public List<User> getUserByName(String name) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria usersCriteria = session.createCriteria(User.class)
                .add(Restrictions.eq("name", name));
        List<User> users = usersCriteria.list();
        session.getTransaction().commit();
        return users;
    }

    public boolean isEmailExist(String email) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        boolean isExist = false;
        session.beginTransaction();
        Criteria usersCriteria = session.createCriteria(User.class)
                .add(Restrictions.eq("email", email));
        List<User> user = usersCriteria.list();
        if (user.size() > 0) {
            isExist = true;
        }
        session.getTransaction().commit();
        return isExist;
    }

    public User getUserById(int userId) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria usersCriteria = session.createCriteria(User.class)
                .add(Restrictions.eq("userId", userId));
        User user = (User) usersCriteria.uniqueResult();
        session.getTransaction().commit();
        return user;
    }

    public List<User> getUsersWishBook(int bookID) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria usersCriteria = session.createCriteria(User.class)
                .createCriteria("books")
                .add(Restrictions.idEq(bookID));
        List<User> userList = usersCriteria.list();
        session.getTransaction().commit();
        return userList;
    }

    public List<User> getUsersbyCategory(int categoryId) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria usersCriteria = session.createCriteria(User.class)
                .createCriteria("categories")
                .add(Restrictions.idEq(categoryId));
        List<User> userList = usersCriteria.list();
        session.getTransaction().commit();
        return userList;
    }

    public int getMaleCount() throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria usersCriteria = session.createCriteria(User.class)
                .add(Restrictions.eq("gender", "Male"))
                .setProjection(Projections.rowCount());
        long c =(long) usersCriteria.uniqueResult();
        int count =(int)c;
        session.getTransaction().commit();
        return count;
    }

    public int getFemaleCount() throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        
        Criteria usersCriteria = session.createCriteria(User.class)
                .add(Restrictions.eq("gender", "Female"))
                .setProjection(Projections.rowCount());
       long c =(long) usersCriteria.uniqueResult();
        int count =(int)c;
        session.getTransaction().commit();
        return count;
    }
}
