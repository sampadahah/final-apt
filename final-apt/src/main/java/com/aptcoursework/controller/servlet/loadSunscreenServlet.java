package com.aptcoursework.controller.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aptcoursework.controller.dao.UserProductDAO;
import com.aptcoursework.model.Product;

@WebServlet("/loadSunscreen")
public class loadSunscreenServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserProductDAO dao;
        try {
            dao = new UserProductDAO();
            List<Product> sunscreenList = dao.getSunscreen(); 

          
            System.out.println("Number of sunscreen fetched: " + sunscreenList.size());

            if (sunscreenList != null && !sunscreenList.isEmpty()) {
                request.setAttribute("products", sunscreenList);  // Set products in the request
                System.out.println("Number of sunscreen found: " + sunscreenList.size());  
            } else {
                request.setAttribute("error", "No products found");
                System.out.println("No products found.");
            }
            request.getRequestDispatcher("/pages/productSunscreen.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }}