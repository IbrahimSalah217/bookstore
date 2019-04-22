/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.services;

import org.hibernate.HibernateException;

/**
 *
 * @author Ibrahim
 */
public class ServicesFactory {
    
    public static BookPageServices getBookpageServices(){
        return new BookPageServices();
    }
    
    public static HomeServices getHomeServices()throws UnsupportedOperationException,HibernateException{
        return new HomeServices();
    }
    
    public static OrderServices getOrderServices()throws UnsupportedOperationException,HibernateException{
        return new OrderServices();
    }
    
    public static ProfileServices getProfileServices()throws UnsupportedOperationException,HibernateException{
        return new ProfileServices();
    }
    
    public static Shop getShopServices()throws UnsupportedOperationException,HibernateException{
        return new Shop();
    }
    
    public static UserCartServices getUserCartServices()throws UnsupportedOperationException,HibernateException{
        return new UserCartServices();
    }
    
    public static WishListServices getWishListServices()throws UnsupportedOperationException,HibernateException{
        return new WishListServices();
    }
    
    public static AdminServices getAdminServices()throws UnsupportedOperationException,HibernateException{
        return new AdminServices();
    }
    
    public static Authentication getAuthenticationServices()throws UnsupportedOperationException,HibernateException{
        return new Authentication();
    }
    
    public static StatisticsServices getStatisticsServices()throws UnsupportedOperationException,HibernateException{
        return new StatisticsServices();
    }
}
