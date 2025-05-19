<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>-->
<%@ page import="com.aptcoursework.model.user" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>KASAM - Home</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <style>
        .header-btn {
            display: flex;
            align-items: center;
            color: #d63384;
            text-decoration: none;
            font-size: 16px;
            font-weight: 500;
            gap: 5px;
            transition: color 0.3s ease;
        }

        .header-btn:hover {
            color: #c12374;
        }

        .header-btn i {
            font-size: 18px;
        }

        .header-icons i, .user-icon i {
            color: #d63384;
            font-size: 20px;
            transition: color 0.3s ease;
        }

        .user-icon i:hover {
            color: #c12374;
        }

        .header-top {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px 40px;
            background-color: #fff;
            border-bottom: 1px solid #ddd;
        }

        .brand-logo {
            font-weight: bold;
            font-size: 24px;
            color: #d63384;
            font-family: 'Arial', sans-serif;
        }

        .search-bar {
            display: flex;
            align-items: center;
            background-color: #ffe4ec;
            padding: 5px 10px;
            border-radius: 8px;
            width: 400px;
            margin-left: 110px;
        }

        .search-bar input {
            border: none;
            background: none;
            outline: none;
            width: 100%;
            padding: 8px;
        }

        .search-bar button {
            background: none;
            border: none;
            cursor: pointer;
            font-size: 18px;
        }

        .search-bar form {
            display: flex;
            align-items: center;
            width: 100%;
        }

        .header-icons {
            display: flex;
            align-items: center;
            gap: 20px;
            font-size: 20px;
        }

        .header-icons a {
            color: #333;
            text-decoration: none;
            display: flex;
            align-items: center;
            gap: 5px;
            font-size: 16px;
        }

        .header-icons a:hover {
            color: #d63384;
        }

        .nav-bar {
            background-color: #ffe4ec;
            display: flex;
            justify-content: center;
            padding: 10px 0;
            gap: 40px;
            font-family: 'Arial', sans-serif;
        }

        .nav-bar a {
            text-decoration: none;
            color: #333;
            font-weight: 500;
        }

        .nav-bar a:hover {
            color: #d63384;
        }

        .auth-button {
            background-color: #d63384;
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 6px;
            font-weight: bold;
            display: flex;
            align-items: center;
            gap: 8px;
            cursor: pointer;
            font-family: 'Arial', sans-serif;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: background-color 0.3s ease, box-shadow 0.3s ease;
        }

        .auth-button:hover {
            background-color: #c12374;
            box-shadow: 0 6px 10px rgba(0, 0, 0, 0.15);
        }

        .auth-button i,
        .auth-button span {
            color: white;
        }

        .auth-button span {
            font-size: 16px;
        }
    </style>
</head>
<body>
<header>
    <div class="header-top">
        <div class="brand-logo">KASAM</div>

        <div class="search-bar">
            <form action="<%= request.getContextPath() %>/pages/search.jsp" method="get">
                <input type="text" name="query" placeholder="Search for products" required>
                <button type="submit"><i class="fas fa-search"></i></button>
            </form>
        </div>

        <div class="header-icons">
            <c:choose>
                <c:when test="${not empty sessionScope.userWithSession}">
                    <a href="${pageContext.request.contextPath}/pages/profile.jsp" class="user-icon"><i class="fas fa-user"></i></a>

                    <c:if test="${sessionScope.userWithSession.role == 'Customer'}">
                        <%
                            int cartCount = 0;
                            if (session.getAttribute("cart_count") != null) {
                                cartCount = (int) session.getAttribute("cart_count");
                            }
                        %>
                        <a href="${pageContext.request.contextPath}/ViewCartServlet"><i class="fas fa-shopping-cart"></i> (<%= cartCount %>)</a>
                    </c:if>

                    <form action="${pageContext.request.contextPath}/logoutController" method="get" class="logout-form">
                        <button type="submit" class="auth-button">
                            <i class="fas fa-sign-out-alt"></i> <span>Logout</span>
                        </button>
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="${pageContext.request.contextPath}/pages/login.jsp" method="get" class="logout-form">
                        <button type="submit" class="auth-button">
                            <i class="fas fa-sign-in-alt"></i> <span>Login</span>
                        </button>
                    </form>

                    <form action="${pageContext.request.contextPath}/pages/register.jsp" method="get" class="logout-form">
                        <button type="submit" class="auth-button">
                            <i class="fas fa-user-plus"></i> <span>Signup</span>
                        </button>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <nav class="nav-bar">
        <c:choose>
            <c:when test="${not empty sessionScope.userWithSession and sessionScope.userWithSession.role == 'Admin'}">
                <a href="${pageContext.request.contextPath}/pages/adminDashboard.jsp">Dashboard</a>
                <a href="${pageContext.request.contextPath}/pages/category.jsp">Category</a>
                <a href="${pageContext.request.contextPath}/pages/addproduct.jsp">Product</a>
                <a href="${pageContext.request.contextPath}/pages/viewUsers.jsp">Users</a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/pages/home.jsp">Home</a>
                <a href="${pageContext.request.contextPath}/pages/productCategory.jsp">Products</a>
                <a href="${pageContext.request.contextPath}/pages/blog.jsp">Blog</a>
                <a href="${pageContext.request.contextPath}/pages/aboutUs.jsp">About Us</a>
            </c:otherwise>
        </c:choose>
    </nav>
</header>
</body>
</html>
