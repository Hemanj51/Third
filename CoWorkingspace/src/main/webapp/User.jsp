<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.sql.*,com.space.db.*,java.io.*,java.util.*"%>
<%
	if (session != null) {
		if (session.getAttribute("un") != null) {
			String name = (String) session.getAttribute("un");
			//out.print("please login again");
		}
	} else {
		response.sendRedirect("login.html");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CoWorkSpace</title>
<link rel="stylesheet" type="text/css" href="style1.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
#data {
	text-align: center;
	color: white;
	font-size: 2.1em;
}

#logout {
	float: left;
	margin: -10px;
}
</style>
</head>
<body>
	<div class="banner">
		<div id="logo">
			<img src="./img/workspaceLogo.PNG">
			<div id="data">
				<%
					out.print("Welcome to ");
				%>
				<%=(String) session.getAttribute("un")%>
			</div>

			<nav>
			<ul class="navigate">

				<div id="logout">
					<li><a href="UserHomePage.html">logout</a></li>
					<li><a href="viewhyd.jsp">View Orders</a></li>
					<li><a href="pdf.jsp">PDF</a></li>
					<!-- <li><a href="./viewhyd">View Orders</a></li> -->
				</div>

				<!--  <li class="ho"><a href="">Home</a></li>
			<li> <a href="login.html">Login</a></li>
			<li> <a href="aboutus.html">About</a></li>
			<li> <a href="#footer-bottom">ContactUs</a></li>-->
			</ul>
			</nav>
		</div>
	</div>
	<div class="page-wrapper">
		<div class="back"></div>
		<div class="heading">
			<h1>Our Centers In Your City</h1>
		</div>
		<div class="contain"></div>
		<div class="hyderabad">
			<!--  <a href="hyd.html"> -->
			<a href="hyd1.jsp">
				<h1>Hyderabad</h1>
			</a>
		</div>
		<div class="hyd">
			<img src="./img/building.jpg">
			<div id="line">
				<p>Workspace4U has ample space to work & room to grow. This
					centre is a treat for the senses and is filled with enthusiastic
					professionals. With a prominent locality in the IT hub, backed up
					by complete functionality, this centre allows your business to run
					smoothly.</p>
			</div>
		</div>
		<div class="containe"></div>
		<div class="bangalore">
			<a href="bang2.jsp">
				<h1>Bangalore</h1>
			</a>
		</div>
		<div class="bag">
			<img src="./img/building1.jpg">
			<div id="lineb">
				<p>Workspace4U has ample space to work & room to grow. This
					centre is a treat for the senses and is filled with enthusiastic
					professionals. With a prominent locality in the IT hub, backed up
					by complete functionality, this centre allows your business to run
					smoothly.</p>
			</div>
		</div>
		<div class="chennai">
			<a href="chennai1.jsp">
				<h1>Chennai</h1>
			</a>
		</div>
		<div class="container"></div>
		<div class="chen">
			<img src="./img/chennai.jpg">
			<div id="linec">
				<p>Workspace4U has ample space to work & room to grow. This
					centre is a treat for the senses and is filled with enthusiastic
					professionals. With a prominent locality in the IT hub, backed up
					by complete functionality, this centre allows your business to run
					smoothly.</p>
			</div>
		</div>
		<div class="para">
			<h2>Our different Flexible Workspaces</h2>
		</div>

		<div class="pics">
			<ul>
				<li><img src="./img/hotdesk.jpg"></li>
				<li><img src="./img/conference.jpg"></li>
			</ul>
		</div>
		<div class="pic">
			<ul>
				<li><img src="./img/single.jpg"></li>
				<li><img src="./img/private.jpg"></li>
			</ul>
		</div>
	</div>


	<div class="footer">
		<div class="footer-content">
			<div class="footer-section about">
				<h1 class="logo-text">
					<span>WOrk</span>Space4U
				</h1>
				<p>Workspace4U is an arrangement in which several workers from
					different companies share an office space, allowing cost savings
					and convenience through the use of common infrastructure</p>

				<div class="contact">
					<span><i class="fa fa-phone"></i> &nbsp; 1800 000 000</span> <span><i
						class="fa fa-envelope"></i> &nbsp; info@workspace4u.com</span>
				</div>
				<div class="socials">
					<a href="https://www.facebook.com/"><i class="fa fa-facebook"
						style="font-size: 28px; color: #3b5998"></i></a> <a
						href="https://www.instagram.com/?hl=en"><i
						class="fa fa-instagram" style="font-size: 28px; color: #3f729b"></i></a>
					<a
						href="https://twitter.com/Twitter?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"><i
						class="fa fa-twitter" style="font-size: 28px; color: #00acee"></i></a>
					<a href="https://www.youtube.com/"><i class="fa fa-youtube"
						style="font-size: 28px; color: #c4302b"></i></a>
				</div>
			</div>

			<div class="footer-section links">
				<h2>Links</h2>
				<br>
				<ul>
					<a href=""><li>KnowMore</li></a>
					<a href=""><li>WorkSpace4U</li></a>
					<a href=""><li>About</li></a>
					<a href=""><li>Terms and Conditions</li></a>

				</ul>
			</div>
			<div class="footer-section contact-form">
				<h2>Contact us</h2>
				<br>
				<form action="" method="post">
					<input type="email" name="email" class="text-input contact-input"
						placeholder="Your email Address.."><br>
					<br>
					<textarea name="message" class="text-input contact-input"
						placeholder="Your Message"></textarea>
					<br>
					<button type="submit" class="btn btn-big">
						<i class="fa fa-envelope"></i> send
					</button>
				</form>
			</div>
		</div>
		<div class="footer-bottom">&copy;WorkSpace4U | Designed by
			R3SCHPNBJ</div>

	</div>
</body>
</html>