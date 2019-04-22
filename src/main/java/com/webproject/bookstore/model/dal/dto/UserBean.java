/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.model.dal.dto;

import java.util.Date;

/**
 *
 * @author Ibrahim
 */
public class UserBean {

    private int userId;
    private String name;
    private String birthDate;
    private String password;
    private String job;
    private String email;
    private double creditLimit;
    private String address;
    private String phone;
    private String gender;
    private String[] intersts;
    
    public UserBean() {
    
    }

    public UserBean(String name, String birthDate, String password, String job, String email, double creditLimit, String address, String phone, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.password = password;
        this.job = job;
        this.email = email;
        this.creditLimit = creditLimit;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
    }

    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public String[] getIntersts() {
		return intersts;
	}

	public void setIntersts(String[] intersts) {
		this.intersts = intersts;
	}

	public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
