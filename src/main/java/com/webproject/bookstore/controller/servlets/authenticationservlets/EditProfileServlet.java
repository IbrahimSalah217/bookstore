/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.authenticationservlets;

import com.webproject.bookstore.controller.services.Authentication;
import com.webproject.bookstore.controller.services.ProfileServices;
import com.webproject.bookstore.model.dal.dto.UserBean;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;

/**
 *
 * @author hd
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {

    public EditProfileServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                UserBean currentUSer = (UserBean) session.getAttribute("user");
                UserBean userBean = new UserBean();
                String userName = request.getParameter("username");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String brithDate = request.getParameter("BirthOfDate");
                String job = request.getParameter("job");
                String phone = request.getParameter("phone");
                String Address = request.getParameter("address");
                String credit = request.getParameter("creditLimit");
                double creditLimit = Double.parseDouble(credit);
                String[] interests = request.getParameterValues("interests");
                int id = currentUSer.getUserId();
                userBean.setUserId(id);
                userBean.setGender(currentUSer.getGender());
                userBean.setName(userName);
                userBean.setEmail(email);
                userBean.setPassword(password);
                userBean.setBirthDate(brithDate);
                userBean.setJob(job);
                userBean.setPhone(phone);
                userBean.setAddress(Address);
                userBean.setCreditLimit(creditLimit);
                userBean.setIntersts(interests);

                ProfileServices services = new ProfileServices();
                try {
                    UserBean newUser = services.editProfile(userBean);
                    session.setAttribute("user", newUser);
                    response.sendRedirect("userhome");
                } catch (ParseException ex) {
                    response.sendRedirect("error.html?ex=formating");
                }
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=any");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
