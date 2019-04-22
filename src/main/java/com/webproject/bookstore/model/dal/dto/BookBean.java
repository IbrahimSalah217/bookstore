/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.dto;

import java.io.Serializable;

/**
 *
 * @author Ibrahim
 */
public class BookBean implements Serializable{

    private int bookId;
    private String categoryName;
    private int offerPercent;
    private String title;
    private String description;
    private String authorName;
    private double price;
    private String img;
    private int visits;
    private int rate;
    private int quantity;
    private int pagesNumber;
    private int soldAmount;
    private boolean available;
    private String keys;
    private String offerDate;
    private int imgsCount;
    private int reviews;
    
    public BookBean() {
    }
    
    public BookBean(String categoryName, int offerPercent, String title, String description, String authorName, double price, String img, int visits, int rate,
            int quantity, int pagesNumber, int soldAmount, boolean available, String keys,int imgsCount) {
        this.categoryName = categoryName;
        this.offerPercent = offerPercent;
        this.title = title;
        this.description = description;
        this.authorName = authorName;
        this.price = price;
        this.img = img;
        this.visits = visits;
        this.rate = rate;
        this.quantity = quantity;
        this.pagesNumber = pagesNumber;
        this.soldAmount = soldAmount;
        this.available = available;
        this.keys = keys; 
        this.imgsCount=imgsCount;
    }

    public int getBookId() {
        return bookId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public double getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public int getVisits() {
        return visits;
    }

    public int getRate() {
        return rate;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public int getSoldAmount() {
        return soldAmount;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getKeys() {
        return keys;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    public void setSoldAmount(int soldAmount) {
        this.soldAmount = soldAmount;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public int getOfferPercent() {
        return offerPercent;
    }

    public void setOfferPercent(int offerPercent) {
        this.offerPercent = offerPercent;
    }

    public String getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(String offerDate) {
        this.offerDate = offerDate;
    }
     public void setImgsCount(int imgsCount) {
        this.imgsCount = imgsCount;
    }

    public int getImgsCount() {
        return imgsCount;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
    
    
  
}
