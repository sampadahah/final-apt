<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Categories</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
            text-align: center;
            overflow-x: hidden; /* Hides horizontal scroll */
        }

        .category-container {
            display: grid;
            grid-template-columns: repeat(2, 1fr); /* 2 items per row */
            gap: 40px;
            padding: 80px 60px;
            max-width: 1000px;
            margin: auto;
        }

        .category-name {
            background-color: white;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0,0,0,0.1);
            padding: 40px 20px;
            transition: transform 0.2s, background-color 0.2s;
            background-color: #ffe4ec;
        }

        .category-name:hover {
            transform: scale(1.05);
            background-color: #d63384;
        }

        .category-name h3, .category-name p {
            margin: 10px 0;
            color: #333;
            transition: color 0.2s;
        }

        .category-name:hover h3,
        .category-name:hover p {
            color: white;
        }

        a {
            text-decoration: none;
            display: block;
        }
    </style>
</head>
<body>
	<%@ include file="header.jsp" %>
    <h1 style="font-size:50px; color:#d63384">Our Categories</h1>
    <p style="margin-top: 40px; font-size: 1.2em; color: #555;">Safe ingredients. Gentle skincare.</p>
    <div class="category-container">
        <a href="<%= request.getContextPath() %>/loadCleansers" class="category-name">
            <h3>Cleansers</h3>
            <p>Remove dirt & makeup</p>
        </a>
        <a href="<%= request.getContextPath() %>/loadMoisturizers" class="category-name">
            <h3>Moisturizers</h3>
            <p>Hydrate your skin</p>
        </a>
        <a href="<%= request.getContextPath() %>/loadSerums" class="category-name">
            <h3>Serums</h3>
            <p>Target specific concerns</p>
        </a>
        <a href="<%= request.getContextPath() %>/loadSunscreen" class="category-name">
            <h3>Sunscreens</h3>
            <p>Protect from UV rays</p>
        </a>
    </div>
    <%@ include file="footer.jsp" %>
    
</body>
</html>