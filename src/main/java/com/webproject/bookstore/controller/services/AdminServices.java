/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.services;

import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.dto.DtoMapper;
import com.webproject.bookstore.model.dal.dto.OrderBean;
import com.webproject.bookstore.model.dal.dto.UserBean;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookOrderDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.CategoryDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.OfferDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserOrderDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserVisitBookDao;
import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.BookOrder;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.Offer;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserOrder;
import com.webproject.bookstore.model.dal.hibrnate.util.DaoFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.hibernate.HibernateException;

/**
 *
 * @author Ibrahim
 */
public class AdminServices {

    BookDao bookDao;
    UserDao userDao;
    CategoryDao cateoryDao;
    DtoMapper dtoMapper;
    UserVisitBookDao userVisitsDao;
    UserOrderDao userOrderDao;
    BookOrderDao bookOrderDao;
    OfferDao offerDao;

    public AdminServices() {
        bookDao = DaoFactory.getBookDao();
        dtoMapper = new DtoMapper();
        userVisitsDao = DaoFactory.getUserVisitBookDao();
        cateoryDao = DaoFactory.getCategoryDao();
        userOrderDao = DaoFactory.getOrderDao();
        bookOrderDao = DaoFactory.getBookOrderDao();
        offerDao = DaoFactory.getOfferDao();
        userDao = DaoFactory.getUserDao();
    }

    public UserBean addNewUSer(UserBean userBean) throws HibernateException, ParseException {
        boolean isEmailUsed = userDao.isEmailExist(userBean.getEmail());
        if (!isEmailUsed) {
            User user = dtoMapper.convertToUser(userBean);
            user = userDao.insert(user);
            return dtoMapper.createUserBean(user);
        } else {
            return null;
        }
    }

    public BookBean addNewBook(BookBean bookBean) throws ParseException, HibernateException {
        Book book = dtoMapper.convertToBook(bookBean);
        book.setBookId(0);
        book = bookDao.insert(book);
        return dtoMapper.createBookBean(book);
    }

    public void updateBook(BookBean bookBean) throws HibernateException, ParseException {
        Book book = dtoMapper.convertToBook(bookBean);
        bookDao.update(book);
    }

    public List<UserBean> getAllUsers() throws HibernateException{
        List<User> userList = userDao.getAllUsers();
        List<UserBean> userBeanList = new ArrayList<>();
        userList.forEach((user) -> {
            userBeanList.add(dtoMapper.createUserBean(user));
        });
        return userBeanList;
    }

    public List<UserBean> getAllMales() throws HibernateException{
        List<User> userList = userDao.getAllMales();
        List<UserBean> userBeanList = new ArrayList<>();
        userList.forEach((user) -> {
            userBeanList.add(dtoMapper.createUserBean(user));
        });
        return userBeanList;
    }

    public List<UserBean> getAllFemales() throws HibernateException{
        List<User> userList = userDao.getAllFemales();
        List<UserBean> userBeanList = new ArrayList<>();
        userList.forEach((user) -> {
            userBeanList.add(dtoMapper.createUserBean(user));
        });
        return userBeanList;
    }

    public List<BookBean> getAvailableBooks() throws HibernateException{
        List<Book> bookList = bookDao.getAvailableBooks(1000);
        List<BookBean> bookBeanList = new ArrayList<>();
        bookList.forEach((book) -> {
            bookBeanList.add(dtoMapper.createBookBean(book));
        });
        return bookBeanList;
    }

    public Map<String, List<OrderBean>> getAllOrders() throws HibernateException{
        Map<String, List<OrderBean>> orderMap = new HashMap<>();
        List<User> usersHasOrder = userOrderDao.getUsersHasOrers();
//        usersHasOrder.forEach((user) -> {
//            List<UserOrder> currentUserOrders = userOrderDao.getOrdersByUser(user);
//        });
        usersHasOrder.forEach((user) -> {
            List<OrderBean> ordersBean = ServicesFactory.getOrderServices().getUserOrder(user.getUserId());
            orderMap.put(user.getName(), ordersBean);
        });
        return orderMap;
    }

    public List<Offer> getAllOffers() throws HibernateException {
        List<Offer> offers = offerDao.getAllOffers();
        return offers;
    }

    public void removeBooks(int[] ids) throws HibernateException {
        for (int id : ids) {
            Book book = bookDao.getBookByID(id);
            bookDao.delete(book);
        }
    }

    public void addOffer(int offerPercent, String offerDate) throws ParseException,HibernateException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date expireDate = dateFormat.parse(offerDate);
        Offer offer = new Offer(0, offerPercent, expireDate);
        offerDao.insert(offer);
        System.out.println("com.webproject.bookstore.controller.services.AdminServices.addOffer()//////////////////////////////////////////done");
    }

    public void addCategory(Category category) throws HibernateException{
        cateoryDao.insert(category);
    }

    public int getMaleCount() throws HibernateException{
        int count = userDao.getMaleCount();
        return count;
    }

    public int getFemaleCount() throws HibernateException{
        int count = userDao.getFemaleCount();
        return count;
    }
}
