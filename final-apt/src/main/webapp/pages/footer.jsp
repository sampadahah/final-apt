<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 
	.footer {
	  background-color: #ffe4ec;
	  padding: 40px;
	  margin-top: 40px;
	}
	
	.footer-links {
	  display: flex;
	  justify-content: space-between;
	  flex-wrap: wrap;
	}
	
	.footer-column {
	  flex: 1;
	  min-width: 150px;
	  margin-bottom: 20px;
	}
	
	.footer-column h4 {
	  font-size: 18px;
	  color: #d63384;
	  margin-bottom: 10px;
	}
	
	.footer-column ul {
	  list-style: none;
	  padding: 0;
	}
	
	.footer-column ul li {
	  margin-bottom: 8px;
	}
	
	.footer-column ul li a {
	  text-decoration: none;
	  color: #333;
	  font-size: 14px;
	}
	
	.footer-column ul li a:hover {
	  color: #d63384;
	}
	
	.footer-column-right {
	  flex: 2;
	  min-width: 250px;
	}
	
	.footer-column-right h3 {
	  font-size: 20px;
	  color: #d63384;
	  margin-bottom: 10px;
	}
	
	.footer-column-right p {
	  font-size: 14px;
	  color: #333;
	  margin-bottom: 15px;
	}
	
	.subscribe {
	  display: flex;
	  margin-bottom: 15px;
	}
	
	.subscribe input[type="email"] {
	  padding: 8px;
	  border: 1px solid #ccc;
	  border-radius: 6px 0 0 6px;
	  outline: none;
	  width: 60%;
	}
	
	.subscribe button {
	  padding: 8px 12px;
	  background-color: #d63384;
	  color: #fff;
	  border: none;
	  border-radius: 0 6px 6px 0;
	  cursor: pointer;
	}
	
	.subscribe button:hover {
	  background-color: #c21870;
	}
	
	.footer-icons {
	  display: flex;
	  align-items: center;
	  gap: 15px;
	  flex-wrap: wrap;
	}
	
	.footer-icons a {
	  color: #333;
	  text-decoration: none;
	  font-size: 18px;
	}
	
	.footer-icons a:hover {
	  color: #d63384;
	}	
	.copyright{
      width: 2000px;
      text-align: center;
	}	 */
	
	
	
	.footer {
	  background-color: #ffe4ec;
	  padding: 40px;
	  margin-top: 40px;
	}
	
.footer-links {
	  display: flex;
	  justify-content: space-between;
	  flex-wrap: wrap;
	}
	
.footer-column {
	  flex: 1;
	  min-width: 150px;
	  margin-bottom: 20px;
	  font-family:  'Arial', sans-serif;
	}
	
.footer-column h4 {
	  font-size: 18px;
	  color: #d63384;
	  margin-bottom: 10px;
	}
	
.footer-column ul {
	  list-style: none;
	  padding: 0;
	}
	
.footer-column ul li {
	  margin-bottom: 8px;
	}
	
.footer-column ul li a {
	  text-decoration: none;
	  color: #333;
	  font-size: 14px;
	}
	
.footer-column ul li a:hover {
	  color: #d63384;
	}
	
.footer-column-right {
	  flex: 2;
	  min-width: 250px;
	  font-family:  'Arial', sans-serif;
	}
	
.footer-column-right h3 {
	  font-size: 20px;
	  color: #d63384;
	  margin-bottom: 10px;
	}
	
.footer-column-right p {
	  font-size: 14px;
	  color: #333;
	  margin-bottom: 15px;
	}
	
.subscribe {
	  display: flex;
	  margin-bottom: 15px;
	}
	
.subscribe input[type="email"] {
	  padding: 8px;
	  border: 1px solid #ccc;
	  border-radius: 6px 0 0 6px;
	  outline: none;
	  width: 60%;
	}
	
.subscribe button {
	  padding: 8px 12px;
	  background-color: #d63384;
	  color: #fff;
	  border: none;
	  border-radius: 0 6px 6px 0;
	  cursor: pointer;
	}
	
.subscribe button:hover {
	  background-color: #c21870;
	}
	
.footer-icons {
	  display: flex;
	  align-items: center;
	  gap: 15px;
	  flex-wrap: wrap;
	}
	
.footer-icons a {
	  color: #333;
	  text-decoration: none;
	  font-size: 18px;
	}
	
.footer-icons a:hover {
	  color: #d63384;
	}	
.copyright{
      width: 2000px;
      text-align: center;
	}	
</style>
</head>
<body>
  <footer class="footer">
    <div class="footer-links">
      <div class="footer-column">
        <h4>Shop</h4>
        <ul>
          <li><a href="#">Cleanser</a></li>
          <li><a href="#">Toner</a></li>
          <li><a href="#">Serum</a></li>
          <li><a href="#">Moisturizer</a></li>
          <li><a href="#">Sunscreen</a></li>
          <li><a href="#">Lipcare</a></li>
        </ul>
      </div>
      <div class="footer-column">
        <h4>Learn</h4>
        <ul>
          <li><a href="#">Blogs</a></li>
          <li><a href="#">Features</a></li>
          <li><a href="#">Rewards</a></li>
          <li><a href="#">Newsletters</a></li>
        </ul>
      </div>
      <div class="footer-column">
        <h4>Help</h4>
        <ul>
          <li><a href="#">Contact Us</a></li>
          <li><a href="#">Policies</a></li>
          <li><a href="#">FAQs</a></li>
        </ul>
      </div>
      <div class="footer-column-right">
        <h3>KASAM, the promise to your skin.</h3>
        <p>Sign up for expert skincare tips and previews!</p>
        <div class="subscribe">
          <input type="email" placeholder="Your email">
          <button>Subscribe</button>
        </div>
        <div class="footer-icons">
          <a href="#"><i class="fab fa-instagram"></i></a>
          <a href="#"><i class="fab fa-facebook"></i></a>
          <a href="#"><i class="fab fa-youtube"></i></a>
          <a href="#"><i class="fab fa-twitter"></i></a>
          <span><i class="fas fa-phone"></i> 061-891045</span>
        </div>
      </div>
    </div>
    <div class="copyright">
      <p class="size">©2025 KASAM Skincare</p>
    </div>
  </footer>
</body>
</html>