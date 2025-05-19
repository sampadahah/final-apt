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

@WebServlet("/loadSerums")
public class loadSerumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserProductDAO dao;
        try {
            dao = new UserProductDAO();
            List<Product> serumList = dao.getSerum(); 

          
            System.out.println("Number of serums fetched: " + serumList.size());

            if (serumList != null && !serumList.isEmpty()) {
                request.setAttribute("products", serumList);  // Set products in the request
                System.out.println("Number of serums found: " + serumList.size());  
            } else {
                request.setAttribute("error", "No products found");
                System.out.println("No products found.");
            }
            request.getRequestDispatcher("/pages/productSerum.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }}