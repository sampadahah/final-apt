<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.aptcoursework.model.CartItem" %>
<%@ page import="com.aptcoursework.model.Order"%>
<%@ page import="com.aptcoursework.model.OrderItem" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <style>
        body {
          /* background-color: #fff0f5;*/
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 1000px;
            margin: 60px auto;
            background-color: #ffe4ec;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #d63384;
            text-align: center;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 0 10px rgba(248, 204, 224, 0.6);
        }

        th, td {
            padding: 15px;
            text-align: center;
            border-bottom: 1px solid #f2c1d7;
        }

        th {
            background-color: #f8cce0;
            color: #d63384;
            font-size: 18px;
        }

        td {
            font-size: 16px;
            color: #333;
        }

        .total-row td {
            font-weight: bold;
            background-color: #ffe4ec;
            color: #b0206a;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Your Cart</h2>

    <%
        List<CartItem> items = (List<CartItem>) request.getAttribute("cartItems");
        double grandTotal = 0;
    %>

    <table>
        <thead>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price Each</th>
            <th>Total</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
<%
    if (items != null && !items.isEmpty()) {
        for (CartItem item : items) {
            double itemTotal = item.getQuantity() * item.getPriceEach();
            grandTotal += itemTotal;
%>
<tr>
    <td><%= item.getProductId() %></td>
    <td><%= item.getProductName() %></td>
    <td>
        <form action="updateCart" method="post" style="display:inline;">
            <input type="hidden" name="productId" value="<%= item.getProductId() %>" />
            <input type="hidden" name="action" value="decrease" />
            <button type="submit" style="padding: 6px 10px; background-color: #ffc4dd; border: none; border-radius: 4px; font-weight: bold;">-</button>
        </form>
        <span style="margin: 0 12px; font-weight: bold;"><%= item.getQuantity() %></span>
        <form action="updateCart" method="post" style="display:inline;">
            <input type="hidden" name="productId" value="<%= item.getProductId() %>" />
            <input type="hidden" name="action" value="increase" />
            <button type="submit" style="padding: 6px 10px; background-color: #ffc4dd; border: none; border-radius: 4px; font-weight: bold;">+</button>
        </form>
    </td>
    <td>Rs. <%= item.getPriceEach() %></td>
    <td>Rs. <%= itemTotal %></td>
    <td>
	  <form action="updateCart" method="post" onsubmit="return confirm('Remove this item?');">
	    <input type="hidden" name="productId" value="<%= item.getProductId() %>" />
	    <input type="hidden" name="action" value="delete" />
	    <button type="submit" style="background-color: transparent; border: none; color: #d63384; font-size: 16px; font-weight: bold; cursor: pointer;">
	      Delete
	    </button>
	  </form>
	</td>

</tr>
<% } %>
<tr class="total-row">
    <td colspan="5" style="text-align:right; font-size: 18px;">Grand Total:</td>
    <td colspan="2" style="text-align:left; font-weight: bold;font-size:18px">Rs. <%= grandTotal %></td>
</tr>
<%
    } else {
%>
<tr>
    <td colspan="6">Your cart is empty.</td>
</tr>
<% } %>
</tbody>
    </table>
    <% if (items != null && !items.isEmpty()) { %>
		<div style="text-align: center; margin-top: 20px;">
		  <form action="placeOrder" method="post">
		    <button type="submit" style="background-color: #d63384;color: white;border: none;padding: 12px 25px;
		    font-size: 16px;border-radius: 8px;cursor: pointer;">Place Order</button>
		  </form>
		</div>
		<% } %>

</div>
		<%
    List<Order> orders = (List<Order>) request.getAttribute("orders");
%>

<div class="container">
    <h2>Your Orders</h2>

    <% if (orders != null && !orders.isEmpty()) { %>
    <table>
        <thead>
            <tr>
                <th>Order ID</th>
                <th>Date</th>
                <th>Status</th>
                <th>Total Items</th>
                <th>Total Price</th>
            </tr>
        </thead>
        <tbody>
        <% for (Order order : orders) { %>
            <tr>
                <td><%= order.getOrderId() %></td>
                <td><%= order.getOrderDate() %></td>
                <td><%= order.getStatus() %></td>
                <td><%= order.getTotalItems() %></td>
                <td>Rs. <%= order.getTotalPrice() %></td>
            </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
        <p style="text-align:center;">You haven’t placed any orders yet.</p>
    <% } %>
</div>
</body>
</html>

<%@ include file="footer.jsp" %>


