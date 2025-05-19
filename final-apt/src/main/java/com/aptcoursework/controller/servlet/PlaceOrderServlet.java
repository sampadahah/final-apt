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
import com.aptcoursework.model.CartItem;

/**
 * Servlet implementation class PlaceOrderServlet
 */
@WebServlet("/placeOrder")
public class PlaceOrderServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user_id") == null) {
            response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("user_id");

        try {
            CartDAO cartDAO = new CartDAO();
            int cartId = cartDAO.getOrCreateCartId(userId);
            List<CartItem> cartItems = cartDAO.getCartItems(userId);

            if (!cartItems.isEmpty()) {
                // Step 1: Insert into orders table
                int orderId = cartDAO.insertOrder(userId);

                // Step 2: Insert each cart item into order_item table
                for (CartItem item : cartItems) {
                    cartDAO.insertOrderItem(orderId, item);
                }

                // Step 3: Clear the user's cart
                cartDAO.clearCart(cartId);
            }

            response.sendRedirect("ViewCartServlet");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath()+"/pages/ErrorPage.jsp");
        }
    }
}
