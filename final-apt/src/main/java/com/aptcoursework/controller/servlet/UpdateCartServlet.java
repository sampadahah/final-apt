package com.aptcoursework.controller.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aptcoursework.controller.dao.CartDAO;

/**
 * Servlet implementation class UpdateCartServlet
 */
@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        HttpSession session = request.getSession(false);
	        if (session == null || session.getAttribute("user_id") == null) {
	            response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
	            return;
	        }

	        int userId = (int) session.getAttribute("user_id");
	        int productId = Integer.parseInt(request.getParameter("productId"));
	        String action = request.getParameter("action");

	        try {
	            CartDAO cartDAO = new CartDAO();
	            int cartId = cartDAO.getOrCreateCartId(userId);

	            switch (action) {
	                case "increase":
	                    cartDAO.updateCartItem(cartId, productId, 1); break;
	                case "decrease":
	                    cartDAO.updateCartItem(cartId, productId, -1); break;
	                case "delete":
	                    cartDAO.removeCartItem(cartId, productId); break;
	            }

	            // update cart count in session
	            int count = cartDAO.getCartItemCount(userId);
	            session.setAttribute("cart_count", count);

	            response.sendRedirect("ViewCartServlet");

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect(request.getContextPath()+"/pages/ErrorPage.jsp");
	        }
	    }
	}

