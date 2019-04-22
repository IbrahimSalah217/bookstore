/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.services;

import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.dto.DtoMapper;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserDao;
import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
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
public class WishListServices {

    UserDao userDao;
    BookDao bookDao;
    DtoMapper dtoMapper;

    public WishListServices() throws UnsupportedOperationException,HibernateException{
        this.userDao = DaoFactory.getUserDao();
        this.bookDao = DaoFactory.getBookDao();
        this.dtoMapper = new DtoMapper();
    }

    public List<BookBean> getUserWishList(int userID) throws HibernateException{
        List<Book> bookList = bookDao.getUserWishList(userID);
        //Set<Book> bookSet = new HashSet<>(bookList);
        List<BookBean> bookBeanList = new ArrayList<>();
        if (bookList.size() > 0) {
            bookList.forEach((book) -> {
                bookBeanList.add(dtoMapper.createBookBean(book));
            });
        }
        return bookBeanList;
    }

    public void addToUserWishList(int userID, int bookID) throws HibernateException{
        User user = userDao.getUserById(userID);
        Book book = bookDao.getBookByID(bookID);
        boolean bookIsExist = false;
        List<Book> bookList = bookDao.getUserWishList(userID);
        Set<Book> bookSet = new HashSet<>(bookList);
        //Set<Book> bookSet = user.getBooks();
        List<User> userList = userDao.getUsersWishBook(bookID);
        Set<User> userSet = new HashSet<>(userList);
        //Set<User> userSet = book.getUsers();
        for (Book oldBook : bookSet) {
            if (oldBook.getBookId() == bookID) {
                bookIsExist = true;
            }
        }
        if (bookIsExist) {
            bookSet.removeIf((oldBook) -> {
                return oldBook.getBookId() == bookID;
            });
            user.setBooks(bookSet);
            userSet.removeIf((oldUser) -> {
                return oldUser.getUserId() == userID;
            });
            book.setUsers(userSet);
        } else {
            bookSet.add(book);
            user.setBooks(bookSet);
            userSet.add(user);
            book.setUsers(userSet);
        }
        userDao.update(user);
        bookDao.update(book);
    }

    public boolean isBookInUserWishList(int userID, int bookID) throws HibernateException{
        Book book = bookDao.getBookByID(bookID);
        boolean bookIsExist = false;
        List<Book> bookList = bookDao.getUserWishList(userID);
        Set<Book> bookSet = new HashSet<>(bookList);
        //Set<Book> bookSet = user.getBooks();
        for (Book oldBook : bookSet) {
            if (oldBook.getBookId() == bookID) {
                bookIsExist = true;
            }
        }
        return bookIsExist;
    }

}
