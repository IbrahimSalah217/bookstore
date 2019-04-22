/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webproject.bookstore.controller.servlets.admin;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.webproject.bookstore.controller.services.AdminServices;
import com.webproject.bookstore.controller.services.HomeServices;
import com.webproject.bookstore.controller.services.ServicesFactory;
import com.webproject.bookstore.model.dal.dto.BookBean;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Barchart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try{
        HomeServices adminServices = ServicesFactory.getHomeServices();
        List<BookBean> topSeller = adminServices.getBestSeller(10);
        PrintWriter out = resp.getWriter();
        String[] names = new String[topSeller.size()];
        int[] count = new int[topSeller.size()];
        JsonArray jArray = new JsonArray();
        JsonArray jArray2 = new JsonArray();
        for (int i = 0; i < topSeller.size(); i++) {
            JsonPrimitive element = new JsonPrimitive(topSeller.get(i).getAuthorName());
           jArray.add(element);
           JsonPrimitive element2 = new JsonPrimitive(topSeller.get(i).getSoldAmount());
           jArray2.add(element2);
//            names[i] = topSeller.get(i).getAuthorName();
//            count[i] = topSeller.get(i).getSoldAmount();
        }
        jArray.addAll(jArray2);

//        String text = "{}";
//        String namesGson = new Gson().toJson(names, String [].class);
//        String countsGson = new Gson().toJson(count, int [].class);
//        Gson gson=new Gson();
//        JsonObject json = gson.fromJson(text, JsonObject.class);
//        json.addProperty("labels", namesGson);
//        json.addProperty("values", countsGson);
//        System.out.println("================="+json);
//        System.out.println("nnnnnnnnnnnn"+namesGson);
//        System.out.println("vvvvvvvvvvvvvvvvv"+countsGson);
//        out.print(json);
        
        
        out.print(jArray);
       }catch (HibernateException ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=database");
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.sendRedirect("error.jsp?ex=any");
        }
    }

}
