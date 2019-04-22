/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.daoImp;

import com.webproject.bookstore.model.dal.hibrnate.entities.Admin;
import org.hibernate.Session;

/**
 *
 * @author Ibrahim
 */
public class AdminDao extends SuperDao<Admin> {

    public AdminDao(Session sessoin) throws UnsupportedOperationException {
        super(sessoin,new Admin());
    }

}
