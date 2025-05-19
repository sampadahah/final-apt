/*
 * package com.aptcoursework.model;
 * 
 * public class CartItem {
 * 
 * private int cartItemId; // Primary Key in the cart_item table private int
 * cartId; // Foreign Key to the cart table private int productId; // Foreign
 * Key to the product table private int quantityInCart; // Quantity of the
 * product in the cart private String productName; // Product name (fetched from
 * the product table) private double price; // Product price (fetched from the
 * product table)
 * 
 * // Default constructor public CartItem() { }
 * 
 * // Getters and Setters public int getCartItemId() { return cartItemId; }
 * 
 * public void setCartItemId(int cartItemId) { this.cartItemId = cartItemId; }
 * 
 * public int getCartId() { return cartId; }
 * 
 * public void setCartId(int cartId) { this.cartId = cartId; }
 * 
 * public int getProductId() { return productId; }
 * 
 * public void setProductId(int productId) { this.productId = productId; }
 * 
 * public int getQuantityInCart() { return quantityInCart; }
 * 
 * public void setQuantityInCart(int quantityInCart) { this.quantityInCart =
 * quantityInCart; }
 * 
 * public String getProductName() { return productName; }
 * 
 * public void setProductName(String productName) { this.productName =
 * productName; }
 * 
 * public double getPrice() { return price; }
 * 
 * public void setPrice(double price) { this.price = price; } }
 */
package com.aptcoursework.model;

public class CartItem {
    private int productId;
    private String productName;
    private int quantity;
    private double priceEach;

    // Constructors
    public CartItem() {}

    public CartItem(int productId, String productName, int quantity, double priceEach) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.priceEach = priceEach;
    }

    // Getters
    public int getProductId() { 
    	return productId; }
    public String getProductName() { 
    	return productName; }
    public int getQuantity() { 
    	return quantity; }
    public double getPriceEach() { 
    	return priceEach; }

    // Setters
    public void setProductId(int productId) { this.productId = productId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPriceEach(double priceEach) { this.priceEach = priceEach; }

    // Total for this item
    public double getTotal() {
        return quantity * priceEach;
    }
}
