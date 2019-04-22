/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.services;

import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.dto.DtoMapper;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.CategoryDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.OfferDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserVisitBookDao;
import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.Offer;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserVisitBook;
import com.webproject.bookstore.model.dal.hibrnate.util.DaoFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;

/**
 *
 * @author Ibrahim
 */
public class HomeServices {

    BookDao bookDao;
    UserDao userDao;
    CategoryDao cateoryDao;
    DtoMapper dtoMapper;
    UserVisitBookDao userVisitsDao;

    public HomeServices() throws UnsupportedOperationException,HibernateException{
        bookDao = DaoFactory.getBookDao();
        dtoMapper = new DtoMapper();
        userVisitsDao = DaoFactory.getUserVisitBookDao();
        cateoryDao = DaoFactory.getCategoryDao();
        userDao = DaoFactory.getUserDao();
    }

    public List<BookBean> getBestSeller(int maxNumber) throws HibernateException {
        List<Book> bookList = bookDao.getBestSeller(maxNumber);
        List<BookBean> bookBeanList = new ArrayList<>();
        if (bookList.size() > 0) {
            bookList.forEach((book) -> {
                bookBeanList.add(dtoMapper.createBookBean(book));
            });
        }
        return bookBeanList;
    }

    public List<BookBean> getMostVisited(int maxNumber) throws HibernateException {
        List<Book> bookList = bookDao.getMostVisitedBooks(maxNumber);
        List<BookBean> bookBeanList = new ArrayList<>();
        if (bookList.size() > 0) {
            bookList.forEach((book) -> {
                bookBeanList.add(dtoMapper.createBookBean(book));
            });
        }
        return bookBeanList;
    }

    public List<BookBean> getHistoryForUser(int userId, int maxNumber) throws HibernateException {
        User user = userDao.getUserById(userId);
        List<UserVisitBook> userVisitsList = userVisitsDao.getUserVisitBookByUserId(user);
        //Set<UserVisitBook> userVisitsSet = new HashSet<>(userVisitsList);
        List<BookBean> bookBeanList = new ArrayList<>();
        if (userVisitsList.size() > 0) {
            userVisitsList.forEach((userVisits) -> {
                Book book = bookDao.getBookByID(userVisits.getId().getBookId());
                bookBeanList.add(dtoMapper.createBookBean(book));
                System.out.println("////////////////////////////////serv////////////"+book.getTitle());
            });
        }
        if (bookBeanList.size() >= maxNumber) {
            return bookBeanList.subList(0, maxNumber);
        } else {
            return bookBeanList;
        }
    }

    public List<BookBean> getAllBooks(int maxNumber) throws HibernateException {
        List<Book> bookList = bookDao.getAllBooks(maxNumber);
        List<BookBean> bookBeanList = new ArrayList<>();
        if (bookList.size() > 0) {
            bookList.forEach((book) -> {
                bookBeanList.add(dtoMapper.createBookBean(book));
            });
        }
        return bookBeanList;
    }
    
    

    public List<BookBean> getAllBooks(int userId, int maxNumber) throws HibernateException{
        User user = userDao.getUserById(userId);
        List<Category> categoryList = cateoryDao.getUserInterests(user.getUserId());
        List<Book> bookList = new ArrayList<>();
        categoryList.forEach((category) -> {
            bookList.addAll(bookDao.getAllBooksInCategory(category.getCategoryName(), 500));
        });
        List<BookBean> bookBeanList = new ArrayList<>();
        if (bookList.size() > 0) {
            bookList.forEach((book) -> {
                bookBeanList.add(dtoMapper.createBookBean(book));
            });
        }
        return bookBeanList;
    }

    public List<BookBean> getTopRated(int maxNumber) throws HibernateException {
        List<Book> bookList = bookDao.getTopRatedBooks(maxNumber);
        List<BookBean> bookBeanList = new ArrayList<>();
        if (bookList.size() > 0) {
            bookList.forEach((book) -> {
                bookBeanList.add(dtoMapper.createBookBean(book));
            });
        }
        return bookBeanList;
    }

    public List<BookBean> getBooksWithOffers(int maxNumber) throws HibernateException {
        List<Book> bookList = bookDao.getBookinSales(maxNumber);
        List<BookBean> bookBeanList = new ArrayList<>();
        if (bookList.size() > 0) {
            bookList.forEach((book) -> {
                bookBeanList.add(dtoMapper.createBookBean(book));
            });
        }
        return bookBeanList;
    }
    
    public List<BookBean> getNewArrivals(int maxNumber)throws HibernateException{
        List<Book> bookList = bookDao.FilterByProperty("bookId", false, maxNumber,new Integer[0]);
        List<BookBean> bookBeanList = new ArrayList<>();
        if (bookList.size() > 0) {
            bookList.forEach((book) -> {
                bookBeanList.add(dtoMapper.createBookBean(book));
            });
        }
        return bookBeanList;
    }
    
    public List<Category> getAllCategories()throws HibernateException{
        List<Category> categoryList= cateoryDao.getAllCategories();
        return categoryList;
    }
    
    

}
