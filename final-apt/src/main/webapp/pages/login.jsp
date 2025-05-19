<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/login.css">
<style>
.alert {
  background-color: #ffe5e5;  /* Light reddish-white background */
  color: #d63333;             /* Red text */
  padding: 12px;
  border-radius: 8px;
  border: 1px solid #d63333;  /* Red border */
  margin-top: 15px;
  text-align: center;
  font-weight: bold;
}



</style>
</head>
<body>
  <div class="brand">KASAM</div>

  <div class="login-box">
    <h2>Login to your account</h2>
    <!-- Error Message Display -->
	<% if (request.getAttribute("errormessage")!=null){%>
	<div class="alert alert-danger mt-2">
		<%=request.getAttribute("errorMessage") %>
	</div>
	<% } %>
	<% if (request.getAttribute("loginError")!=null){%>
	<div class="alert alert-danger mt-2" style="text-align:center">
		<%=request.getAttribute("loginError") %>
	</div>
	<% } %>
    <form action="<%= request.getContextPath() %>/loginController" method="post">
      <input type="text" name="email" placeholder="Email" required>
      <input type="password" name="password" placeholder="Password" required>
      <button type="submit">Login</button>
    </form>
    <div class="signup-link">
      Don't have an account? <a href="<%= request.getContextPath() %>/pages/register.jsp">Sign up</a>
    </div>
  </div>
      <a href="<%= request.getContextPath() %>/pages/home.jsp" style="color: #d63384;padding: 25px 25px;
		    font-size: 18px;font-weight:bold;cursor: pointer;">← Explore For Now</a>
</body>
</html>
