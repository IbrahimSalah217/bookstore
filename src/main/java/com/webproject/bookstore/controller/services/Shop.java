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
import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.util.DaoFactory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

public class Shop {

    BookDao bookDao;
    CategoryDao categoryDao;
    DtoMapper dtoMapper;

    public Shop() throws UnsupportedOperationException,HibernateException{
        bookDao = DaoFactory.getBookDao();
        categoryDao = DaoFactory.getCategoryDao();
        dtoMapper = new DtoMapper();
    }

    public List<BookBean> getTopBooks(String categoryName, int maxNumber) throws HibernateException {
        List<Book> bookList = bookDao.getTopRatedBooks(200);
        List<BookBean> bookBeanList = new ArrayList<>();

        if (bookList.size() != 0) {
            bookList.forEach((book) -> {
                if (book.getCategory().getCategoryName().equals(categoryName)) {
                    bookBeanList.add(dtoMapper.createBookBean(book));
                }
            });
        }
        if (bookBeanList.size() >= maxNumber) {
            return bookBeanList.subList(0, maxNumber);
        } else {
            return bookBeanList;
        }
    }

    public List<BookBean> getFilteredBooks(String OrderType, boolean orderAcend, String categoryName, int returnedMaxNumber,
            double minPrice, double maxPrice, boolean availableState, double minRate, double maxRate, int minVisits) throws HibernateException {

        String[] propertyNames = {"category", "price", "available", "rate", "visits"};
        Category categoryObject = categoryDao.getByName(categoryName);
        System.out.println("com.webproject.bookstore.controller.services.Shop.getFilteredBooks()          " + categoryObject.getCategoryId());
        Object[] propertyValues = {categoryObject, minPrice, maxPrice, availableState, minRate, maxRate, minVisits};
        List<Book> bookList = bookDao.FilterByProperty(OrderType, orderAcend, returnedMaxNumber, propertyValues, propertyNames);
        List<BookBean> bookBeanList = new ArrayList<>();
        if (bookList.size() > 0) {
            bookList.forEach((book) -> {
                book.getCategory().getCategoryName();
                bookBeanList.add(dtoMapper.createBookBean(book));
            });
        }
        return bookBeanList;
    }

    public List<BookBean> searchForBook(String keyWord, int maxReturnedNumber) throws HibernateException {
        List<Book> bookList = bookDao.searchForBooks(keyWord, maxReturnedNumber);
        List<BookBean> bookBeanList = new ArrayList<>();
        bookList.forEach((book) -> {
            bookBeanList.add(dtoMapper.createBookBean(book));
        });
        return bookBeanList;
    }

    public List<BookBean> getAllBooksinCategory(String categoryName, int maxReturnedNumber) throws HibernateException {
        List<Book> bookList = bookDao.getAllBooksInCategory(categoryName, maxReturnedNumber);
        List<BookBean> bookBeanList = new ArrayList<>();
        bookList.forEach((book) -> {
            bookBeanList.add(dtoMapper.createBookBean(book));
        });
        return bookBeanList;
    }

    public List<BookBean> getFilteredSearch(String[] categories, String OrderType, boolean orderAcend, int returnedMaxNumber,
            double minPrice, double maxPrice, boolean availableState, double minRate, double maxRate, String keyWord) throws HibernateException {

        String[] propertyNames = {"price", "available", "rate", "keys"};
        Object[] propertyValues = {minPrice, maxPrice, availableState, minRate, maxRate, keyWord};
        List<Book> bookList = bookDao.FilterByProperty(OrderType, orderAcend, returnedMaxNumber, propertyValues, propertyNames);
        List<BookBean> bookBeanList = new ArrayList<>();
        if (bookList.size() > 0) {
            bookList.forEach((book) -> {
                bookBeanList.add(dtoMapper.createBookBean(book));
            });
        }
        if (categories != null) {
            List<BookBean> bookBeanCatList = new ArrayList<>();
            bookBeanList.forEach((bookB) -> {
                for (String category : categories) {
                    if (bookB.getCategoryName().equalsIgnoreCase(category)) {
                        bookBeanCatList.add(bookB);
                    }
                }
            });
            return bookBeanCatList;
        }
        return bookBeanList;
    }
}
