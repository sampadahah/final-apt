package com.aptcoursework.controller.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.aptcoursework.controller.database.DatabaseConnection;
import com.aptcoursework.model.CartItem;

public class CartDAO {
	private Connection conn;
	private PreparedStatement ps;

	public CartDAO() throws ClassNotFoundException, SQLException {
		this.conn = DatabaseConnection.getConnection();
	}

	// Gets an existing cart_id for user or creates a new one
	public int getOrCreateCartId(int userId) {
		int cartId = -1;
		String checkQuery = "SELECT cart_id FROM cart WHERE user_id = ?";
		String insertQuery = "INSERT INTO cart (user_id) VALUES (?)";

		try {
			ps = conn.prepareStatement(checkQuery);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				cartId = rs.getInt("cart_id");
			} else {
				ps = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, userId);
				ps.executeUpdate();
				rs = ps.getGeneratedKeys();
				if (rs.next()) {
					cartId = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // TODO: Replace with proper logging
		}
		return cartId;
	}

	// Checks if a product is already in the user's cart
	public boolean isProductInCart(int cartId, int productId) {
		boolean found = false;
		String query = "SELECT * FROM cart_item WHERE cart_id = ? AND product_id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, cartId);
			ps.setInt(2, productId);
			ResultSet rs = ps.executeQuery();
			found = rs.next();
		} catch (SQLException e) {
			e.printStackTrace(); // TODO: Replace with proper logging
		}
		return found;
	}

	// updating the quantity of an existing cart item
	public boolean updateCartItem(int cartId, int productId, int qty) {
		boolean updated = false;
		String query = "UPDATE cart_item SET quantity_in_cart = quantity_in_cart + ? WHERE cart_id = ? AND product_id = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, qty);
			ps.setInt(2, cartId);
			ps.setInt(3, productId);
			if (ps.executeUpdate() > 0) {
				updated = true;
			}
		} catch (SQLException e) {
			e.printStackTrace(); // TODO: Replace with proper logging
		}
		return updated;
	}

	// inserting a new product into the cart
	public boolean insertCartItem(int cartId, int productId, int qty) {
		boolean inserted = false;
		String query = "INSERT INTO cart_item (cart_id, product_id, quantity_in_cart) VALUES (?, ?, ?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, cartId);
			ps.setInt(2, productId);
			ps.setInt(3, qty);
			if (ps.executeUpdate() > 0) {
				inserted = true;
			}
		} catch (SQLException e) {
			e.printStackTrace(); // TODO: Replace with proper logging
		}
		return inserted;
	}
	
	public List<CartItem> getCartItems(int userId) {
	    List<CartItem> items = new ArrayList<>();
	    String query = """
	        SELECT p.product_id, p.product_name, p.price, ci.quantity_in_cart
	        FROM cart_item ci
	        JOIN cart c ON ci.cart_id = c.cart_id
	        JOIN product p ON ci.product_id = p.product_id
	        WHERE c.user_id = ?
	    """;

	    try {
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, userId);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            CartItem item = new CartItem();
	            item.setProductId(rs.getInt("product_id"));
	            item.setProductName(rs.getString("product_name"));
	            item.setPriceEach(rs.getDouble("price"));
	            item.setQuantity(rs.getInt("quantity_in_cart"));
	            items.add(item);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // TODO: Replace with proper logging
	    }
	    return items;
	}
	
	//counting items in cart
	public int getCartItemCount(int userId) {
	    int count = 0;
	    String query = """
	        SELECT SUM(ci.quantity_in_cart) AS total
	        FROM cart_item ci
	        JOIN cart c ON ci.cart_id = c.cart_id
	        WHERE c.user_id = ?
	    """;

	    try {
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, userId);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt("total");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	
	//inserting a new order and returns the generated order_id
	public int insertOrder(int userId) {
	    int orderId = -1;
	    String query = "INSERT INTO orders (user_id, order_date, status) VALUES (?, NOW(), 'Pending')";
	    try {
	        ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        ps.setInt(1, userId);
	        ps.executeUpdate();
	        ResultSet rs = ps.getGeneratedKeys();
	        if (rs.next()) {
	            orderId = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return orderId;
	}

	// inserting a single cart item into order_item table
	public void insertOrderItem(int orderId, CartItem item) {
	    String query = "INSERT INTO order_item (order_id, product_id, quantity_ordered, price_each) VALUES (?, ?, ?, ?)";
	    try {
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, orderId);
	        ps.setInt(2, item.getProductId());
	        ps.setInt(3, item.getQuantity());
	        ps.setDouble(4, item.getPriceEach());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	// clear cart when user clicks on delete
	public void clearCart(int cartId) {
	    String query = "DELETE FROM cart_item WHERE cart_id = ?";
	    try {
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, cartId);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void removeCartItem(int cartId, int productId) {
		String query="DELETE FROM cart_item WHERE cart_id = ? AND product_id = ?";
	    try {
	        ps=conn.prepareStatement(query);
	        ps.setInt(1, cartId);
	        ps.setInt(2, productId);
	        ps.executeUpdate();
	        ps.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}



}
