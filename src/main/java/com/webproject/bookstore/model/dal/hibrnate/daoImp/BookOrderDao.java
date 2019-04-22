/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.daoImp;

import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.BookOrder;
import com.webproject.bookstore.model.dal.hibrnate.entities.BookOrderId;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserOrder;
import com.webproject.bookstore.model.dal.hibrnate.util.SessionManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class BookOrderDao extends SuperDao<BookOrder> {

    public BookOrderDao(Session sessoin) throws UnsupportedOperationException {
        super(sessoin, new BookOrder());
    }

    public ArrayList<Book> getBooksByBookOrderId(BookOrderId bookOrderId) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(BookOrder.class)
                .add(Restrictions.eq("id", bookOrderId));
        ArrayList<Book> bookList = (ArrayList<Book>) bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }

    public ArrayList<Book> getBooksByDeliveryDate(Date date) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(BookOrder.class)
                .add(Restrictions.eq("deliveryDate", date));
        ArrayList<Book> bookList = (ArrayList<Book>) bookCriteria.list();
        session.getTransaction().commit();
        return bookList;
    }

    public ArrayList<Book> getBooksByPrice(double price) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(BookOrder.class)
                .add(Restrictions.eq("price", price));
        ArrayList<Book> bookList = (ArrayList<Book>) bookCriteria.list();
        session.getTransaction().commit();

        return bookList;
    }

    public List<BookOrder> getBookOredrsByOrderId(int orderID) throws HibernateException {
        if (!session.isOpen()) {
            session = SessionManager.getSession();
        }
        session.beginTransaction();
        Criteria bookCriteria = session.createCriteria(BookOrder.class);
        List<BookOrder> oldBookOrderList = bookCriteria.list();
        List<BookOrder> bookOrderList = new ArrayList<>();
        oldBookOrderList.forEach((bookOrder) -> {
            if (bookOrder.getId().getOrderId() == orderID) {
                bookOrderList.add(bookOrder);
            }
        });
        session.getTransaction().commit();
        return bookOrderList;
    }
}
