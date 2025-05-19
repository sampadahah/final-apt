package com.aptcoursework.controller.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.aptcoursework.controller.database.DatabaseConnection;
import com.aptcoursework.model.Order;
import com.aptcoursework.model.OrderItem;

public class OrderDAO {
    private Connection conn;

    public OrderDAO() throws ClassNotFoundException, SQLException {
        this.conn = DatabaseConnection.getConnection();
    }

    public List<Order> getOrdersForUser(int userId) {
        List<Order> orders = new ArrayList<>();

        String orderQuery = "SELECT * FROM orders WHERE user_id = ?";
        String itemQuery = """
            SELECT oi.product_id, p.product_name, oi.quantity_ordered, oi.price_each
            FROM order_item oi
            JOIN product p ON oi.product_id = p.product_id
            WHERE oi.order_id = ?
        """;

        try {
            PreparedStatement psOrder = conn.prepareStatement(orderQuery);
            psOrder.setInt(1, userId);
            ResultSet rsOrder = psOrder.executeQuery();

            while (rsOrder.next()) {
                int orderId = rsOrder.getInt("order_id");
                Timestamp orderDate = rsOrder.getTimestamp("order_date");
                String status = rsOrder.getString("status");

                List<OrderItem> items = new ArrayList<>();

                PreparedStatement psItem = conn.prepareStatement(itemQuery);
                psItem.setInt(1, orderId);
                ResultSet rsItem = psItem.executeQuery();

                while (rsItem.next()) {
                    OrderItem item = new OrderItem(
                        rsItem.getInt("product_id"),
                        rsItem.getString("product_name"),
                        rsItem.getInt("quantity_ordered"),
                        rsItem.getDouble("price_each")
                    );
                    items.add(item);
                }

                rsItem.close();
                psItem.close();

                orders.add(new Order(orderId, orderDate, status, items));
            }

            rsOrder.close();
            psOrder.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}