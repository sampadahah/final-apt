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

@WebServlet("/loadCleansers")
public class loadCleansers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserProductDAO dao;
        try {
            dao = new UserProductDAO();
            List<Product> cleanserList = dao.getCleansers();  // Get cleansers from DAO

          
            System.out.println("Number of cleansers fetched: " + cleanserList.size());

            if (cleanserList != null && !cleanserList.isEmpty()) {
                request.setAttribute("products", cleanserList);  // Set products in the request
                System.out.println("Number of cleansers found: " + cleanserList.size());  
            } else {
                request.setAttribute("error", "No products found");
                System.out.println("No products found.");
            }

            // Forward to the JSP (productCleanser.jsp)
            request.getRequestDispatcher("/pages/productCleanser.jsp").forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }}