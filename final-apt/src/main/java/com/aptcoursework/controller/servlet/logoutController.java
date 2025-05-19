package com.aptcoursework.controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutController")
public class logoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public logoutController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get current session, if exists
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Destroys the session
        }
        System.out.println("session invalidated");
        // Redirect back to login page
        response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
    }
}
