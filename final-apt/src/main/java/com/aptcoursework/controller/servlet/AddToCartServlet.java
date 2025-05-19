package com.aptcoursework.controller.servlet;
import com.aptcoursework.controller.dao.CartDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //getting sessions and users
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user_id") == null) {
        	response.sendRedirect(request.getContextPath() + "/pages/login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("user_id");
        System.out.println(userId);
        int productId = Integer.parseInt(request.getParameter("product_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            CartDAO cartDAO = new CartDAO();

            //creating cart if the user who logged in doesnt have an active cart
            int cartId = cartDAO.getOrCreateCartId(userId);

            // checking if product already exists
            if (cartDAO.isProductInCart(cartId, productId)) {
                cartDAO.updateCartItem(cartId, productId, quantity);
            } else {
                cartDAO.insertCartItem(cartId, productId, quantity);
            }
            
            int totalItems = cartDAO.getCartItemCount(userId);
            session.setAttribute("cart_count", totalItems);  //update the count in the nav bar

            String referer = request.getHeader("referer");
            response.sendRedirect(referer != null ? referer : request.getContextPath()+"/pages/login.jsp");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath()+"/pages/ErrorPage.jsp");
        }
    }
}

