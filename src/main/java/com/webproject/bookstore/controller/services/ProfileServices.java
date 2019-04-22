/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.services;

import com.webproject.bookstore.model.dal.dto.DtoMapper;
import com.webproject.bookstore.model.dal.dto.UserBean;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.CategoryDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserDao;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.util.DaoFactory;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.HibernateException;

/**
 *
 * @author Ibrahim
 */
public class ProfileServices {
    DtoMapper mapper;
    UserDao userDao;
    CategoryDao categoryDao;
    public ProfileServices() throws UnsupportedOperationException,HibernateException{
        if(mapper==null){
            mapper=new DtoMapper();
        }
        if(userDao==null){
            userDao = DaoFactory.getUserDao();
        }
        categoryDao = DaoFactory.getCategoryDao();
    }
    
    
    public UserBean editProfile(UserBean userBean) throws ParseException,HibernateException{
        boolean isDone=true;
       User user=mapper.convertToUser(userBean);
       userDao.update(user);
       String[] interests = userBean.getIntersts();
        Set<Category> categories = new HashSet<Category>();
        Set<User> users = new HashSet<>();
        users.add(user);
        for (int i = 0; i < interests.length; i++) {
            categories.add(categoryDao.getByName(interests[i]));
        }
        user.setCategories(categories);
        categories.forEach((category) -> {
            users.addAll(userDao.getUsersbyCategory(category.getCategoryId()));
            category.setUsers(users);
            categoryDao.update(category);
        });
        userDao.update(user);
        
        System.out.println("//////////////////////////////////Done!");
        return mapper.createUserBean(user);
        
    }
}
