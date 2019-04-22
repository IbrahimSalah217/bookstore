/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.services;

import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.dto.DtoMapper;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserVisitBookDao;
import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserVisitBookId;
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
public class BookPageServices {

    /*
    ////////////////////// intvisits update bookVisits()
            visits +1
       
    ///////////////////// int visitsbookuser update uservisitBooks(username,bookname)
            get user and book
            check if user visit book before
                    increas visitnumber for book and user
            if not insert new visit book user
            return visitsbookuser number
    
    ////////////////////BookBean getBookByName(bookName)
            get book
            convert to BookBean
    
    ///////////////////Update bookRatebyUser(bookName,user rate)
            equation for calculate new book rate .......................................................... 
    
    ///////////////////List<bookBean> get related book(bookName)
            get 10 books from the same category 
            get 10 books from the same auther
            get 10 books by search for books with half name
            add all these to book bean list and return
     */
    BookDao bookDao;
    UserVisitBookDao userVisitBookDao;
    DtoMapper dtoMapper;

    public BookPageServices() throws UnsupportedOperationException,HibernateException{
        bookDao = DaoFactory.getBookDao();
        userVisitBookDao = DaoFactory.getUserVisitBookDao();
        dtoMapper = new DtoMapper();
    }

    /**
     * Visits +1
     *
     * @param bookId
     */
    public void updateBookVisits(int bookId) throws HibernateException{
        Book book = bookDao.getBookByID(bookId);
        int visits = book.getVisits() + 1;
        book.setVisits(visits);
        bookDao.update(book);
    }

    /**
     * Update User Visit Book
     *
     * @param userId
     * @param bookId
     */
    public void updateUserVisitBook(int userId, int bookId) throws HibernateException{
        UserVisitBookId userVisitBookId = new UserVisitBookId(userId, bookId);
        userVisitBookDao.updateVisits(userVisitBookId);
    }

    public BookBean getBookBean(String bookName) throws HibernateException{
        Book book = bookDao.getBookByName(bookName);
        BookBean bookBean = dtoMapper.createBookBean(book);
        return bookBean;
    }

    public BookBean getBookBean(int bookId) throws HibernateException{
        Book book = bookDao.getBookByID(bookId);
        BookBean bookBean = dtoMapper.createBookBean(book);
        return bookBean;
    }

    public void updateBookRate(int bookId, int rate, int userId) throws HibernateException{
        Book book = bookDao.getBookByID(bookId);
        double oldRate = book.getRate();
        int oldReviews = book.getReviews();
        int newReviews = ++oldReviews;
        book.setReviews(newReviews);
        double newRate = oldRate + rate;
        book.setRate(newRate);
        bookDao.update(book);
    }

    public List<Book> getRelatedBooks(Book book) throws HibernateException{
        List<Book> relatedCategory = bookDao.getAllBooksInCategory(book.getCategory().getCategoryName(), 10);
        List<Book> relatedAuthor = bookDao.getAllBooksforAuthor(book.getAuthorName(), 10);
        List<Book> relatedTitle = bookDao.searchForBooks(book.getTitle().split(" ")[0], 10);
        List<Book> relatedBooksList = new ArrayList<>();
        relatedBooksList.addAll(relatedTitle);
        relatedBooksList.addAll(relatedCategory);
        relatedBooksList.addAll(relatedAuthor);
        return relatedBooksList;
    }

    public List<BookBean> getRelatedBooks(int bookId) throws HibernateException{
        Book book = bookDao.getBookByID(bookId);
        List<Book> relatedCategory = bookDao.getAllBooksInCategory(book.getCategory().getCategoryName(), 10);
        Set<Book> relatedCategorySet = new HashSet<>(relatedCategory);
        List<Book> relatedAuthor = bookDao.getAllBooksforAuthor(book.getAuthorName(), 10);
        List<Book> relatedTitle;
        if (book.getTitle().split(" ")[0].equalsIgnoreCase("the")) {
            relatedTitle = bookDao.searchForBooks(book.getTitle().split(" ")[1], 10);
        } else {
            relatedTitle = bookDao.searchForBooks(book.getTitle().split(" ")[0], 10);
        }
        List<BookBean> relatedBooksList = new ArrayList<>();
        Set<Book> relatedBooksSet = new HashSet<>();
        relatedBooksSet.addAll(relatedTitle);
//        relatedBooksSet.forEach((t) -> {
//            relatedCategorySet.removeIf((k) -> {
//                return k.getBookId()==t.getBookId();
//            });
//        });
//        
        relatedBooksSet.addAll(relatedCategorySet);
//        relatedBooksSet.forEach((t) -> {
//            relatedAuthor.removeIf((k) -> {
//                return k.getBookId()==t.getBookId();
//            });
//        });
        relatedBooksSet.addAll(relatedAuthor);
        relatedBooksSet.removeIf((bookR) -> {
            return bookR.getBookId() == bookId;
        });
        relatedBooksSet.forEach((t) -> {
            relatedBooksList.add(dtoMapper.createBookBean(t));
        });
//        relatedCategory.forEach((t) -> {
//            relatedBooksList.add(dtoMapper.createBookBean(t));
//        });
//        relatedAuthor.forEach((t) -> {
//            relatedBooksList.add(dtoMapper.createBookBean(t));
//        });
        return relatedBooksList;
    }
}
