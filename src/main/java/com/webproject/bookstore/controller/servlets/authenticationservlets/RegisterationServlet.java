package com.webproject.bookstore.controller.servlets.authenticationservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webproject.bookstore.controller.services.Authentication;
import com.webproject.bookstore.model.dal.dto.UserBean;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

@WebServlet(name = "RegisterationServlet", urlPatterns = {"/RegisterationServlet"})
public class RegisterationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        Authentication authentication = new Authentication();
        boolean validEmail = authentication.isEmailNotUsed(email);
        if (validEmail) {
            response.getWriter().print("valid");
        } else {
            response.getWriter().print("invalid");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserBean userBean = new UserBean();
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String brithDate = request.getParameter("BirthOfDate");
        String job = request.getParameter("job");
        String phone = request.getParameter("phone");
        String Address = request.getParameter("address");
        String gender = request.getParameter("genderradio");
        String credit = request.getParameter("creditLimit");
        double creditLimit = Double.parseDouble(credit);
        String[] interests = request.getParameterValues("interests");
        userBean.setName(userName);
        userBean.setEmail(email);
        userBean.setPassword(password);
        userBean.setBirthDate(brithDate);
        userBean.setJob(job);
        userBean.setPhone(phone);
        userBean.setAddress(Address);
        userBean.setGender(gender);
        userBean.setCreditLimit(creditLimit);
        userBean.setIntersts(interests);
        Authentication authentication = new Authentication();
        try {
            userBean = authentication.register(userBean);
        } catch (HibernateException ex) {
            response.sendRedirect("error.html?ex=database");
        } catch (ParseException ex) {
            response.sendRedirect("error.html?ex=formating");
        }catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=any");
        }
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }
}
