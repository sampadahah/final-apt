package com.aptcoursework.controller.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aptcoursework.controller.dao.UserDAO;
import com.aptcoursework.model.user;
import com.aptcoursework.utility.EncryptDecrypt;

/**
 * Servlet implementation class LogInController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/loginController" })
public class loginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public loginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	/*doGet(request,response);*/
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String emailToCheck = request.getParameter("email");
        String passwordToCheck = request.getParameter("password");

        try {
            UserDAO userdao = new UserDAO();
            //String encryptedPassword = EncryptDecrypt.encrypt(passwordToCheck);   //checking the user entered password
            user user = userdao.login(emailToCheck, EncryptDecrypt.encrypt(passwordToCheck));
            if (user != null) {
            	//session creation for logged-in user
                HttpSession session = request.getSession();
                session.setAttribute("userWithSession", user);
                
                session.setAttribute("user_id", user.getUserId());
                session.setAttribute("username", user.getName());
                session.setAttribute("email", user.getEmail());
                session.setAttribute("phone_no", user.getPhone()); // must match "phone_no" used in JSP
                session.setAttribute("address", user.getAddress());
                session.setMaxInactiveInterval(30*60); 
                
                System.out.println(session.getId());
                
                Cookie usernameCookie=new Cookie("username",user.getName());
                Cookie emailCookie=new Cookie("email",user.getEmail());
                usernameCookie.setMaxAge(30*60);
                emailCookie.setMaxAge(30*60);
                
                response.addCookie(usernameCookie);
                response.addCookie(emailCookie);
                
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        System.out.println("Cookie Name: " + cookie.getName() + ", Value: " + cookie.getValue());
                    }
                } else {
                    System.out.println("No cookies found.");
                }

                // Check user role and redirect accordingly
                if ("Customer".equalsIgnoreCase(user.getRole())) {
                    response.sendRedirect(request.getContextPath() + "/home"); // Redirect to home for customer
                   
                }else if ("Admin".equalsIgnoreCase(user.getRole())) {
                    response.sendRedirect(request.getContextPath() + "/pages/adminDashboard.jsp"); // Redirect to dashboard for admin
                 
                } else {
                    // If role is not recognized, redirect to home or show error
                    response.sendRedirect(request.getContextPath() + "/pages/home.jsp");
                }
            } else  {
                request.setAttribute("loginError", "Invalid email or password. Please try again.");
                request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            request.setAttribute("errorMessage", "A system error occurred. Please try again later.");
            request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
        
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}



