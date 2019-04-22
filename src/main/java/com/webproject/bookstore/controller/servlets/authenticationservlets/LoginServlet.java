package com.webproject.bookstore.controller.servlets.authenticationservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webproject.bookstore.controller.services.Authentication;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.controller.services.UserCartServices;
import com.webproject.bookstore.model.dal.dto.UserBean;
import org.hibernate.HibernateException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		UserBean userBean=new UserBean();
	    Authentication authentication=new Authentication();
            UserCartServices userCart = ServicesFactory.getUserCartServices();
		String email=request.getParameter("useremail");
		String password=request.getParameter("password");
		
		userBean=authentication.logIn(email, password);
		if(userBean != null) {
			HttpSession session=request.getSession(true);
			session.setAttribute("user", userBean);
			session.setAttribute("userId",userBean.getUserId());
			System.out.println("userbean not null");
                        session.setAttribute("userCart", userCart.getUserCart(userBean.getUserId()));
			RequestDispatcher rd =request.getRequestDispatcher("userhome");
			System.out.println("after dispatcher");
			rd.forward(request, response);
		}
		else if (userBean == null) {
//			RequestDispatcher rd =request.getRequestDispatcher("login.jsp?err=invalid");
//			rd.forward(request, response);
                        response.sendRedirect("login.jsp?err=invalid");
		}
        }catch (HibernateException ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            response.sendRedirect("error.jsp?ex=any");
        }	
	}

}
