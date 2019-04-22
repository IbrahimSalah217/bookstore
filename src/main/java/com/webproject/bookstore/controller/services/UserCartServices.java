/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.services;

import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.dto.CartBean;
import com.webproject.bookstore.model.dal.dto.DtoMapper;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.BookOrderDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserCartBookDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserOrderDao;
import com.webproject.bookstore.model.dal.hibrnate.entities.Book;
import com.webproject.bookstore.model.dal.hibrnate.entities.BookOrder;
import com.webproject.bookstore.model.dal.hibrnate.entities.BookOrderId;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserCartBook;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserCartBookId;
import com.webproject.bookstore.model.dal.hibrnate.entities.UserOrder;
import com.webproject.bookstore.model.dal.hibrnate.util.DaoFactory;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Ibrahim
 */
public class UserCartServices {

    UserCartBookDao cart;
    BookDao bookDao;
    UserDao userDao;
    UserOrderDao userOrderDao;
    BookOrderDao bookOrderDao;
    DtoMapper dtoMapper;

    public UserCartServices() throws UnsupportedOperationException,HibernateException{
        cart = DaoFactory.getCartBookDao();
        bookDao = DaoFactory.getBookDao();
        userDao = DaoFactory.getUserDao();
        userOrderDao = DaoFactory.getOrderDao();
        bookOrderDao = DaoFactory.getBookOrderDao();
        dtoMapper = new DtoMapper();
    }

    public List<CartBean> getUserCart(int userId) throws HibernateException{

        List<UserCartBook> userCartList = cart.getUserCart(userId);
        List<CartBean> cartBeanList = new ArrayList<>();
        userCartList.forEach((cartObj) -> {
            cartBeanList.add(dtoMapper.createCartBean(cartObj));
        });
        return cartBeanList;
    }

    public List<CartBean> getUserCart(User user) throws HibernateException{

        List<UserCartBook> userCartList = cart.getUserCart(user);
        List<CartBean> cartBeanList = new ArrayList<>();
        userCartList.forEach((cartObj) -> {
            cartBeanList.add(dtoMapper.createCartBean(cartObj));
        });
        return cartBeanList;
    }

    public void removeCartItem(CartBean cartBean) throws ParseException ,HibernateException{
        UserCartBook userCartBook = dtoMapper.convertToUserCart(cartBean);
        cart.removeCart(userCartBook);
    }

    public void removeCartItem(int UserId, int bookId)throws HibernateException{
        UserCartBook userCartItem = new UserCartBook();
        UserCartBookId userCartBookId = new UserCartBookId(UserId, bookId);
        userCartItem.setId(userCartBookId);
        cart.delete(userCartItem);
    }

    public void saveUserCart(CartBean cartBean) throws ParseException {
        UserCartBook userCartBook = dtoMapper.convertToUserCart(cartBean);
        cart.setUserCart(userCartBook);
    }

    public void addToCart(int userId, int bookId, int reqQuantity) throws HibernateException{
        boolean added = false;
        
            UserCartBookId cartId = new UserCartBookId(userId, bookId);
            UserCartBook userCart = new UserCartBook();
            userCart.setId(cartId);
            userCart.setReqQuantity(reqQuantity);
            cart.setUserCart(userCart);
            added = true;
        
        
    }

    public boolean checkOut(List<CartBean> cartBeanList,int userId) throws HibernateException{
        boolean available = false;
        UserOrder userOrder = new UserOrder();
        User user = userDao.getUserById(userId);
        userOrder.setUser(user);
        userOrder = userOrderDao.insert(userOrder);
        final int orderId = userOrder.getOrderId();
        final UserOrder newUserOrder = userOrder;
        double totalCart = 0;
        for(int i=0;i<cartBeanList.size();i++){
            totalCart = cartBeanList.get(i).getTotal();
        }
        double userLimit = user.getCreditLimit();
        if(userLimit<totalCart){
            available = false;
        }else{
            available = true;
        user.setCreditLimit(userLimit-totalCart);
        userDao.update(user);
        cartBeanList.forEach((cartBean) -> {
            try {if(!cartBean.getBookBean().isAvailable()){
                
            }else{
                removeCartItem(cartBean);
                int availableQuantity = cartBean.getBookBean().getQuantity();
                int newQuantity = availableQuantity - cartBean.getReqQuantity();
                int soldAmount = cartBean.getBookBean().getSoldAmount();
                int newSoldAmount = soldAmount+cartBean.getReqQuantity();

                BookBean bookBean = cartBean.getBookBean();
                System.out.println("                                       "+bookBean.getBookId());
                Book book = dtoMapper.convertToBook(bookBean);
                if(newQuantity == 0){
                    book.setAvailable(false);
                }
                book.setQuantity(newQuantity);
                book.setSoldAmount(newSoldAmount);
                bookDao.update(book);
                BookOrder bookOrder = new BookOrder(new BookOrderId(orderId, book.getBookId()),
                        book, newUserOrder, new Date(), cartBean.getReqQuantity(), book.getPrice());
                bookOrderDao.insert(bookOrder);

            }
            } catch (ParseException ex) {
                Logger.getLogger(UserCartServices.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
            
        }
        return available;
    }
}