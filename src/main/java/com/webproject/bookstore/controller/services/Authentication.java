package com.webproject.bookstore.controller.services;

import com.webproject.bookstore.model.dal.dto.DtoMapper;
import com.webproject.bookstore.model.dal.dto.UserBean;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.CategoryDao;
import com.webproject.bookstore.model.dal.hibrnate.daoImp.UserDao;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.User;
import com.webproject.bookstore.model.dal.hibrnate.util.DaoFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;

public class Authentication {

    UserDao userDao;
    DtoMapper dtoMapper;
    CategoryDao categoryDao;

    public Authentication() throws HibernateException{
        this.userDao = DaoFactory.getUserDao();
        dtoMapper = new DtoMapper();
        categoryDao = DaoFactory.getCategoryDao();
    }
      
    public UserBean logIn(String email,String password) { 
    	User user=userDao.getUserByEmail(email);
    	if(user==null || !(user.getPassword().equals(password))) {
    		return null;
    	}
    	return dtoMapper.createUserBean(user);
    }

    public UserBean register(UserBean userBean) throws HibernateException, ParseException {
        User user = dtoMapper.convertToUser(userBean);
        user = userDao.insert(user);
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
        return dtoMapper.createUserBean(user);
    }

//    public userBean register(userBean);
//            check for email unique
//            convert to user bean
//            return null if email exist else return userBean
//    
    public UserBean getUserDetails(int userId) throws HibernateException {
        User user = userDao.getUserById(userId);
        UserBean userBean = dtoMapper.createUserBean(user);
        return userBean;
    }

    public boolean isEmailNotUsed(String email) {
        return (!userDao.isEmailExist(email));
    }

}
