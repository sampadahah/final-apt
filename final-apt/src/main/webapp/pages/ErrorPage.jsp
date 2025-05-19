<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error - Something Went Wrong</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #ffe4ec;
        margin: 0;
        padding: 0;
    }

    .container {
        max-width: 600px;
        margin: 100px auto;
        background-color: #fff;
        padding: 40px;
        border-radius: 15px;
        text-align: center;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
    }

    h1 {
        color: #d63384;
        font-size: 36px;
        margin-bottom: 20px;
    }

    p {
        color: #333;
        font-size: 18px;
        margin-bottom: 30px;
    }

    .btn {
        background-color: #d63384;
        color: white;
        padding: 12px 25px;
        text-decoration: none;
        border-radius: 8px;
        font-size: 16px;
        transition: background 0.3s;
    }

    .btn:hover {
        background-color: #b0206a;
    }

    .code {
        font-size: 14px;
        color: #666;
        background-color: #fce4ec;
        padding: 10px;
        border-radius: 8px;
        margin-top: 20px;
        display: inline-block;
        word-break: break-word;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Oops! Something went wrong</h1>
    <p>We’re sorry for the inconvenience. Please try again later.</p>

    <a href="<%= request.getContextPath() %>/pages/home.jsp" class="btn">Go to Home</a>

    <% if (exception != null) { %>
        <div class="code">
            <strong>Error:</strong> <%= exception.getMessage() %>
        </div>
    <% } %>
</div>
</body>
</html>
