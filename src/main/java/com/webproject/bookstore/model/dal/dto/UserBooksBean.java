/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.dto;

/**
 *
 * @author Ibrahim
 */
public class UserBooksBean {
     private BookBean book;
     private UserBean user;
     private int visitsNumber;

    public UserBooksBean() {
    }

    public UserBooksBean(BookBean book, int visitsNumber) {
        this.book = book;
        this.visitsNumber = visitsNumber;
    }

    public UserBooksBean(BookBean book, UserBean user, int visitsNumber) {
        this.book = book;
        this.user = user;
        this.visitsNumber = visitsNumber;
    }
    

    public BookBean getBook() {
        return book;
    }

    public void setBook(BookBean book) {
        this.book = book;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getVisitsNumber() {
        return visitsNumber;
    }

    public void setVisitsNumber(int visitsNumber) {
        this.visitsNumber = visitsNumber;
    }
     
     
}
