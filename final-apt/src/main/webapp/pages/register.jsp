<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/register.css">
    <style>
		.alert {
		background-color: #ffe5e5;
		color: #d63333;
		padding: 12px;
		border-radius: 8px;
		border: 1px solid #d63333;
		margin-top: 15px;
		text-align: center;
		font-weight: bold;
}
</style>
    	
</head>
<body>
	  <h1 class="brand">kasam</h1>
	  <div class="container">
	  <h2>Create a New Account</h2>
	  <p style="text-align: center; margin-bottom: 25px;">It's quick and easy – just like your skincare routine.</p>
<%-- 	  <% if (request.getAttribute("errorMessage")!=null){%>
	  <div class="alert alert-danger mt-2" style="text-align:center" >
		<%=request.getAttribute("errorMessage") %>
	  </div>
	  <% } %> --%>
	  <% if (request.getAttribute("errorMessage") != null) { %>
  		<div class="alert">
    	<%= request.getAttribute("errorMessage") %>
 		 </div>
		<% } %>
	  
	     <form action="<%= request.getContextPath() %>/registerController" method="post">
	    <!--  //oldsampadacode -->
	    <!-- <div>
	      <label>Username:</label>
	      <input type="text" name="username">
	    </div>
	    <div>
	      <label>Email:</label>
	      <input type="email" name="email">
	    </div>
	    <div>
	      <label>Phone Number:</label>
	      <input type="text" name="phone">
	    </div>
	    <div>
	      <label>Address:</label>
	      <input type="text" name="address">
	    </div>
	    <div>
	      <label>Role:</label>
	      <select name="role">
	        <option>Customer</option>
	        <option>Admin</option>
	      </select>
	    </div>
	    <div>
 	 		<label>Registered Date:</label>
  			<input type="datetime-local" name="registeredDate" required>
		</div>
	    <div>
	      <label>Password:</label>
	      <input type="password" name="password">
	    </div>
	    <div>
	      <label>Confirm Password:</label>
	      <input type="password" name="confirmPassword">
	    </div>
	    <div class="full-width">
	      <button type="submit">Sign Up</button>
	    </div> -->
	        <div>
                <label>Username:</label>
                <input type="text" name="username" required>
            </div>
            <div>
                <label>Email:</label>
                <input type="email" name="email" required>
            </div>
			<div>
    			<label>Phone Number:</label>
    			<input type="tel" name="phone" pattern="[0-9]{10}" title="Enter a 10-digit phone number" required>
			</div>

            <div>
                <label>Address:</label>
                <input type="text" name="address" required>
            </div>
            <div>
                <label>Role:</label>
                <select name="role" required>
                    <option value="">Select Role</option>
                    <option value="Customer">Customer</option>
                    <option value="Admin">Admin</option>
                </select>
            </div>
            <div>
                <label>Registered Date:</label>
                <input type="datetime-local" name="registeredDate" required>
            </div>
            <div>
                <label>Password:</label>
                <input type="password" name="password" required>
            </div>
            <div>
                <label>Confirm Password:</label>
                <input type="password" name="confirmPassword" required>
            </div>
            <div class="full-width">
                <button type="submit">Sign Up</button>
            </div>
	    </form>
	    <div class="login-link">
			<a href="<%= request.getContextPath() %>/pages/login.jsp">Already have an account?</a>
    	</div>
	</div>
  	      <a href="<%= request.getContextPath() %>/pages/home.jsp" style="color: #d63384;padding:60% 45%;
  			 font-size: 18px;font-weight:bold;cursor: pointer;">← Explore For Now</a>
</body>
</html>
