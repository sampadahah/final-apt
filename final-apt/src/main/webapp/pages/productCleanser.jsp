<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.aptcoursework.model.Product" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cleansers</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/Category.css">
</head>
<body>
<%@ include file="header.jsp" %>

<h1>Cleansers</h1>
<div class="product-container">
<%
    // Retrieve the 'products' attribute from the request
    List<Product> products = (List<Product>) request.getAttribute("products");

/*     // Debugging: Check if products is null or empty
    if (products == null) {
        out.println("<p>Products attribute null</p>");
    } else if (products.isEmpty()) {
        out.println("<p>Products list empty.</p>");
    } else {
        out.println("Number of products: " + products.size());  // Debugging: Print number of products
    }
 */
    if (products != null && !products.isEmpty()) {
        for (Product p : products) {
%>
            <div class="product-card">
                <a href="<%= request.getContextPath() %>/productDetails?productId=<%= p.getId() %>">
    				<img src="<%= request.getContextPath() + p.getImagePath() %>" alt="<%= p.getName() %>" class="product-img">
				</a>
				<div class="product-info">
                <h3><%= p.getName() %></h3>
                <p class="product-description"><%= p.getDescription() %></p>
                <p class="price">Rs. <%= p.getPrice() %></p>
                </div>
                <form action="addToCart" method="post">
				    <input type="hidden" name="product_id" value="<%= p.getId() %>"/>
				    <input type="hidden" name="quantity" value="1"/>
				    <button type="submit" class="add-to-cart" title="Add to Cart">
				        <i class="fas fa-cart-plus"></i> 
				    </button>
				</form>
            </div>
<%
        }
    } else {
        out.println("<p>No products found.</p>");
    }
%>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>

