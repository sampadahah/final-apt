package com.aptcoursework.controller.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aptcoursework.controller.dao.CartDAO;
import com.aptcoursework.controller.dao.OrderDAO;
import com.aptcoursework.model.CartItem;
import com.aptcoursework.model.Order;

/**
 * Servlet implementation class ViewCartServlet
 */

@WebServlet("/ViewCartServlet")
public class ViewCartServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user_id") == null) {
            response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("user_id");

        try {
            CartDAO cartDAO = new CartDAO();
            List<CartItem> cartItems = cartDAO.getCartItems(userId);
            request.setAttribute("cartItems", cartItems);
            
            int totalItems = cartDAO.getCartItemCount(userId);
            session.setAttribute("cart_count", totalItems);
            
            OrderDAO orderDAO = new OrderDAO();
            List<Order> orders = orderDAO.getOrdersForUser(userId);
            request.setAttribute("orders", orders);

            request.getRequestDispatcher("/pages/cartPage.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath()+"/pages/ErrorPage.jsp");
        }
    }
}
