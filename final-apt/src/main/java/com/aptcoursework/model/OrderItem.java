package com.aptcoursework.model;

public class OrderItem {
    private int productId;
    private String productName;
    private int quantity;
    private double priceEach;

    public OrderItem(int productId, String productName, int quantity, double priceEach) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.priceEach = priceEach;
    }

    public int getProductId() { 
    	return productId; 
    }
    public String getProductName() { 
    	return productName; 
    }
    public int getQuantity() { 
    	return quantity;
    }
    public double getPriceEach() { 
    	return priceEach; 
    }
    public double getTotal() { 
    	return priceEach * quantity; 
    }
}
