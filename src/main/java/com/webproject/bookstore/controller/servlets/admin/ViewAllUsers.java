/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.admin;

import com.webproject.bookstore.controller.services.AdminServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.controller.services.StatisticsServices;
import com.webproject.bookstore.model.dal.dto.UserBean;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;

/**
 *
 * @author hd
 */
public class ViewAllUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminServices adminServices = ServicesFactory.getAdminServices();
        List<UserBean> allUsers = adminServices.getAllUsers();
        request.setAttribute("allUsers", allUsers);

        try {
            StatisticsServices statisticsServices = ServicesFactory.getStatisticsServices();

            int usersCount = (int) statisticsServices.getUsersCount();
            int booksCount = (int) statisticsServices.getBookssCount();
            int categoriesCount = (int) statisticsServices.getCategoriesCount();
            int ordersCount = (int) statisticsServices.getOrdersCount();
            int visitsCount = (int) statisticsServices.getBooksVisitsCount();
            int salesCount = (int) statisticsServices.getSalesCount();
            int authorsCount = (int) statisticsServices.getAuthorsCount();
            int availablesCount = (int) statisticsServices.getAvailableBooksCount();

            request.setAttribute("users", usersCount);
            request.setAttribute("books", booksCount);
            request.setAttribute("categories", categoriesCount);
            request.setAttribute("orders", ordersCount);
            request.setAttribute("visits", visitsCount);
            request.setAttribute("sales", salesCount);
            request.setAttribute("authors", authorsCount);
            request.setAttribute("availables", availablesCount);

            request.getRequestDispatcher("admin/CustomerDetails.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            response.sendRedirect("error.html?ex=notfound");
        }catch (HibernateException ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=any");
        }

    }

}
