/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.services;

import com.webproject.bookstore.model.dal.dto.DtoMapper;
import com.webproject.bookstore.model.dal.dto.OrderBean;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookOrderDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserCartBookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserOrderDao;
import com.webproject.bookstore.model.dal.hibrnate.entities.BookOrder;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserOrder;
import com.webproject.bookstore.model.dal.hibrnate.util.DaoFactory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Bishoy
 */
public class OrderServices {
    UserCartBookDao cart;
    BookDao bookDao;
    UserDao userDao;
    UserOrderDao userOrderDao;
    BookOrderDao bookOrderDao;
    DtoMapper dtoMapper;

    public OrderServices() throws UnsupportedOperationException,HibernateException{
        cart = DaoFactory.getCartBookDao();
        bookDao = DaoFactory.getBookDao();
        userDao = DaoFactory.getUserDao();
        userOrderDao = DaoFactory.getOrderDao();
        bookOrderDao = DaoFactory.getBookOrderDao();
        dtoMapper = new DtoMapper();
    }
    
    public List<OrderBean> getUserOrder(int userId) throws HibernateException{
        User user = userDao.getUserById(userId);
        List<UserOrder> userOrderList = userOrderDao.getOrdersByUser(user);
        List<BookOrder> bookOrderList = new ArrayList<>();
        userOrderList.forEach((userOrder) -> {
            bookOrderList.addAll(bookOrderDao.getBookOredrsByOrderId(userOrder.getOrderId()));
        });
        List<OrderBean> orderBeanList = new ArrayList<>();
        bookOrderList.forEach((bookOrder) -> {
            orderBeanList.add(dtoMapper.createOrderBean(bookOrder));
        });
        return orderBeanList;
    }
}
