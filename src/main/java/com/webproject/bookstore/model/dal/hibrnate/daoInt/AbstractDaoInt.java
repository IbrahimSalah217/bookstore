/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.hibrnate.daoInt;

import java.sql.SQLException;
import org.hibernate.HibernateException;

/**
 *
 * @author Ibrahim
 */
public interface AbstractDaoInt<DAO> {
    public DAO insert(DAO object) throws HibernateException;
    public void delete(DAO object) throws HibernateException;
    public void update(DAO object)throws HibernateException;
    public long getEntityCount() throws ClassNotFoundException,HibernateException;
}
