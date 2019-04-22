/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.admin;

import com.webproject.bookstore.controller.services.AdminServices;
import com.webproject.bookstore.controller.services.HomeServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.model.dal.dto.BookBean;
import com.webproject.bookstore.model.dal.hibrnate.entities.Category;
import com.webproject.bookstore.model.dal.hibrnate.entities.Offer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.hibernate.HibernateException;

/**
 *
 * @author hd
 */
@MultipartConfig
public class AddProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HomeServices homeServices = ServicesFactory.getHomeServices();
            AdminServices adminServices = ServicesFactory.getAdminServices();
            List<Category> allCategories = homeServices.getAllCategories();
            List<Offer> offers = adminServices.getAllOffers();
            resp.setContentType("text/html");
            req.setAttribute("categories", allCategories);
            req.setAttribute("offers", offers);
            req.getRequestDispatcher("admin/AddBook.jsp").forward(req, resp);
        } catch (HibernateException ex) {
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            resp.sendRedirect("error.jsp?ex=any");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BookBean bookBean = new BookBean();
            String title = req.getParameter("title");
            bookBean.setTitle(title);
            bookBean.setAuthorName(req.getParameter("author"));
            bookBean.setDescription(req.getParameter("desc"));
            bookBean.setQuantity((Integer.parseInt(req.getParameter("quantity"))));
            bookBean.setPagesNumber((Integer.parseInt(req.getParameter("pages"))));
            bookBean.setPrice(Double.parseDouble(req.getParameter("price")));
            bookBean.setAvailable((Integer.parseInt(req.getParameter("quantity"))) > 0 ? true : false);
            //Upload Image
            resp.setContentType("text/html;charset=UTF-8");

            int imgsCount = 0;
            final Part filePart = req.getPart("img");
            String imageName = formateName(title);
            //OutputStream out = null;
            final PrintWriter writer = resp.getWriter();
            String prefix = getServletContext().getRealPath("/images/product/books/");
            try {
                filePart.write(prefix + imageName + ".jpg");
                bookBean.setImg("books/" + imageName + ".jpg");
            } catch (FileNotFoundException fne) {
                resp.sendRedirect("error.html?ex=upladImg");
            }

            final Part filePart2 = req.getPart("img2");
            if (filePart2 != null) {
                imgsCount++;
                //OutputStream out = null;
                final PrintWriter writer2 = resp.getWriter();

                try {
                    filePart2.write(prefix + imageName + "1" + ".jpg");
                } catch (FileNotFoundException fne) {
                    resp.sendRedirect("error.html?ex=upladImg");
                }
            }

            final Part filePart3 = req.getPart("img3");
            if (filePart3 != null) {
                imgsCount++;
                //OutputStream out = null;
                final PrintWriter writer3 = resp.getWriter();

                try {
                    filePart3.write(prefix + imageName + "2" + ".jpg");
                } catch (FileNotFoundException fne) {
                    resp.sendRedirect("error.html?ex=upladImg");
                } catch (HibernateException ex) {
                    resp.sendRedirect("error.jsp?ex=database");
                } catch (Exception ex) {
                    resp.sendRedirect("error.jsp?ex=any");
                }
            }

            bookBean.setImgsCount(imgsCount);
            bookBean.setCategoryName(req.getParameter("categ"));
            System.out.println("cate" + req.getParameter("categ"));
            String offerValues[] = req.getParameter("offer").split(",");
            int offerPercent = Integer.parseInt(offerValues[0]);
            System.out.println("off" + offerPercent);
            String offerDate = offerValues[1];
            System.out.println("date" + offerDate);
            bookBean.setOfferPercent(offerPercent);
            bookBean.setOfferDate(offerDate);
            AdminServices adminServices = new AdminServices();
            adminServices.addNewBook(bookBean);
            req.setAttribute("bookAdded", "Book Added Successfully");
            req.getRequestDispatcher("admin/AddBook.jsp").forward(req, resp);

        } catch (ParseException ex) {
            resp.sendRedirect("error.html?ex=formating");
        }  catch (HibernateException ex) {
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            resp.sendRedirect("error.jsp?ex=any");
        }

    }

    public void download() {

    }

    public String formateName(String title) {

        String imageName = Arrays.stream(title.trim().split(" ")).collect(Collectors.joining());
        imageName = imageName.replace("/", "").replace("\\", "").replace("?", "")
                .replace(">", "").replace("*", "").replace("|", "").replace("<", "")
                .replace(":", "").replace("\"", "").replace("\'", "&apos;").replace("..", "")
                .replace(".", "").replace("―", "").replace("/", "").replace("\\", "").replace("?", "");
        return imageName;

    }

}
