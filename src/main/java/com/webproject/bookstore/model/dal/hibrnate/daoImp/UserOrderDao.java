/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.daoImp;

import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserOrder;
import com.webproject.bookstore.model.dal.hibrnate.util.SessionManager;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class UserOrderDao extends SuperDao<UserOrder> {

/*-------------------------------------------------------------------------------------------------------------------- */

    public UserOrderDao(Session session) throws UnsupportedOperationException {
        super(session,new UserOrder());
    }
/*-------------------------------------------------------------------------------------------------------------------- */

    public UserOrder getOrderById(int id) throws HibernateException{
    	if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
    	 UserOrder userOrder=(UserOrder) session.createCriteria(UserOrder.class).add(Restrictions.idEq(id));
         session.getTransaction().commit();
         return userOrder;
    }
    
/*------------------------------------------------------------------------------------------------------------------- */

    public ArrayList<UserOrder> getOrdersByUser(User user) throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
    	ArrayList<UserOrder> list=(ArrayList<UserOrder>) session.createCriteria(UserOrder.class)
       		 .add(Restrictions.eq("user",user)).list();
    	session.getTransaction().commit();
    	return list;
    }
/*--------------------------------------------------------*/
    
    public ArrayList<UserOrder> getAllOrders() throws HibernateException{
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
    	ArrayList<UserOrder> list=(ArrayList<UserOrder>)session.createCriteria(UserOrder.class).list();
    	session.getTransaction().commit();
    	return list;
    }
    
    public List<User> getUsersHasOrers() throws HibernateException{
       if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
    	List<User> usersList=(ArrayList<User>)session.createCriteria(UserOrder.class).
                setProjection(Projections.property("user"))
                .list();
        usersList.forEach((t) -> {
            System.out.println(t.getAddress());
        });
    	session.getTransaction().commit();
    	return usersList;
    }
    
}
