package com.aptcoursework.model;

import java.sql.Timestamp;
import java.util.List;

public class Order {
	    private int orderId;
	    private Timestamp orderDate;
	    private String status;
	    private List<OrderItem> items;

	    public Order(int orderId, Timestamp orderDate, String status, List<OrderItem> items) {
	        this.orderId = orderId;
	        this.orderDate = orderDate;
	        this.status = status;
	        this.items = items;
	    }

	    public int getOrderId() { 
	    	return orderId; 
	    }
	    public Timestamp getOrderDate() { 
	    	return orderDate;
	    }
	    public String getStatus() { 
	    	return status; 
	    }
	    public List<OrderItem> getItems() { 
	    	return items; 
	    }
	    public int getTotalItems() {
	        int total = 0;
	        for (OrderItem item : items) {
	            total += item.getQuantity();
	        }
	        return total;
	    }

	    public double getTotalPrice() {
	        double total = 0;
	        for (OrderItem item : items) {
	            total += item.getQuantity() * item.getPriceEach();
	        }
	        return total;
	    }

}
