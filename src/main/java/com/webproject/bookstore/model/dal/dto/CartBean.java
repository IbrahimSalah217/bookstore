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
public class CartBean {
     private BookBean bookBean;
     private int userId;
     private int reqQuantity;
     private double total;
     
    public CartBean() {
    }

    public CartBean(BookBean bookBean, int reqQuantity, int userId) {
        this.bookBean = bookBean;
        this.reqQuantity = reqQuantity;
        this.userId = userId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserName(int userId) {
        this.userId = userId;
    }

    public int getReqQuantity() {
        return reqQuantity;
    }

    public void setReqQuantity(int reqQuantity) {
        this.reqQuantity = reqQuantity;
    }

    public BookBean getBookBean() {
        return bookBean;
    }

    public void setBookBean(BookBean bookBean) {
        this.bookBean = bookBean;
    }
     
}
