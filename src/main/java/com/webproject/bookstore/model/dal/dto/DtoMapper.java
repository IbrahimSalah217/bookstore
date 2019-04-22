/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.dto;

import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.CategoryDao;
import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.BookOrder;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.Offer;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserCartBook;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserCartBookId;
import com.webproject.bookstore.model.dal.hibrnate.util.DaoFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

public class DtoMapper {

    public BookBean createBookBean(Book book) throws HibernateException {

        BookBean bookBean = new BookBean(book.getCategory().getCategoryName(), book.getOffer().getOfferPercentage(),
                book.getTitle(), book.getDescription(), book.getAuthorName(), book.getPrice(), book.getImg(),
                book.getVisits(), ((int) (book.getRate()) / book.getReviews()), book.getQuantity(), book.getPagesNumber(), book.getSoldAmount(),
                book.getAvailable(), book.getKeys(),book.getImgsCount());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        bookBean.setOfferDate(dateFormat.format(book.getOffer().getExpireDate()));
        bookBean.setBookId(book.getBookId());
        bookBean.setReviews(book.getReviews());
        return bookBean;
    }

    public Book convertToBook(BookBean bookBean) throws ParseException, HibernateException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        Category category = DaoFactory.getCategoryDao().getByName(bookBean.getCategoryName());

        Date expireDate
                =/*new Date(bookBean.getOfferDate());*/ dateFormat.parse(bookBean.getOfferDate());

        System.out.println("dddddddddd" + expireDate + "\n hhhhhhhh" + bookBean.getOfferPercent());
        Book oldBook = DaoFactory.getBookDao().getBookByID(bookBean.getBookId());
        Offer offer = DaoFactory.getOfferDao().getByPercentandDate(bookBean.getOfferPercent(), expireDate);
        Book book = new Book(category, offer, bookBean.getTitle(), bookBean.getDescription(),

                bookBean.getAuthorName(), bookBean.getPrice(), bookBean.getImg(), bookBean.getVisits(),
                bookBean.getRate()+oldBook.getRate(), bookBean.getQuantity(), bookBean.getPagesNumber(), bookBean.getSoldAmount(),
                bookBean.isAvailable(), bookBean.getKeys(),bookBean.getImgsCount());
        book.setBookId(bookBean.getBookId());
        book.setReviews(bookBean.getReviews());
        return book;
    }

    public UserBean createUserBean(User user) throws HibernateException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        UserBean userBean = new UserBean(user.getName(), dateFormat.format(user.getBirthDate()),
                user.getPassword(), user.getJob(), user.getEmail(), user.getCreditLimit(), user.getAddress(),
                user.getPhone(), user.getGender());
        userBean.setUserId(user.getUserId());
        List<Category> categories = DaoFactory.getCategoryDao().getUserInterests(user.getUserId());
        List<String> interests = new ArrayList<>();
        categories.forEach((category) -> {
            interests.add(category.getCategoryName());
        });
        userBean.setIntersts((interests.toArray(new String[0])));
        return userBean;
    }

    public User convertToUser(UserBean userBean) throws ParseException, HibernateException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        User user = new User(userBean.getUserId(), userBean.getName(), dateFormat.parse(userBean.getBirthDate()), userBean.getPassword(),
                userBean.getJob(), userBean.getEmail(), userBean.getCreditLimit(), userBean.getAddress(),
                userBean.getPhone(), userBean.getGender());
        return user;
    }

    public CartBean createCartBean(UserCartBook cart) throws HibernateException {
        int bookId = cart.getBook().getBookId();
        BookDao bookDao = DaoFactory.getBookDao();
        Book book = bookDao.getBookByID(bookId);
        BookBean bookBean = createBookBean(book);
        CartBean cartBean = new CartBean(bookBean, cart.getReqQuantity(), cart.getUser().getUserId());
        double total = bookBean.getPrice() * cartBean.getReqQuantity();
        cartBean.setTotal(total);
        return cartBean;
    }

    public UserCartBook convertToUserCart(CartBean cartBean) throws ParseException {

        BookBean bookBean = cartBean.getBookBean();
        Book book = convertToBook(bookBean);
        User user = DaoFactory.getUserDao().getUserById(cartBean.getUserId());
        UserCartBookId cartId = new UserCartBookId(user.getUserId(), book.getBookId());
        UserCartBook userCartBook = new UserCartBook(cartId, book, user, cartBean.getReqQuantity(),
                book.getQuantity());
        
        return userCartBook;
    }

    public OrderBean createOrderBean(BookOrder bookOrder) throws HibernateException {
        int bookId = bookOrder.getBook().getBookId();
        BookDao bookDao = DaoFactory.getBookDao();
        Book book = bookDao.getBookByID(bookId);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        OrderBean orderBean = new OrderBean(createBookBean(book), bookOrder.getId().getOrderId(),
                 dateFormat.format(bookOrder.getDeliveryDate()), bookOrder.getQuantity());
        return orderBean;
    }
}
