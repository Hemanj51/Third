<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.sql.*,com.space.db.*,java.io.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
<style>
html, body {
	padding: 0;
	margin: 0px;
	position: relative;
	width: auto;
	height: 100%;
}

#logo img {
	position: absolute;
	height: 80px;
	width: 340px;
	float: left;
}

.banner {
	height: 81px;
	background-color: black;
}

#info {
	margin-top: 15.5px;
	margin-right: 40px;
	padding: 5px 20px;
	font-family: Helvetica Narrow, sans-serif;
	font-size: 20px;
	color: white;
	float: right;
}

.footer {
	background: #303036;
	color: #d3d3d3;
	height: 400px;
	margin-top: 200px;
	position: relative;
}

.footer .footer-content {
	height: 400px;
	display: flex;
}

.footer .footer-content .footer-section {
	flex: 1;
	padding: 25px;
}

.footer

 

.footer-content

 

h1
,
.footer

 

.footer-content

 

h2
,
{
color


:

 

white


;
}
.footer .footer-content .about h1 span {
	color: #05f7ff;
}

.footer .footer-content .about .contact span {
	display: block;
	font-size: 1.1em;
	margin-bottom: 8px;
}

.footer .footer-content .about .socials a {
	color: white;
	border: 1px solid grey;
	width: 45px;
	height: 38px;
	padding-top: 5px;
	margin-right: 5px;
	text-align: center;
	display: inline-block;
	font-size: 1.3em;
	border-radius: 5px;
	transition: all .3s;
}

.footer .footer-content .about .socials a:hover {
	border: 1px solid white;
	color: white;
	transition: all .3s;
}

.footer .footer-content .links ul a {
	color: white;
	display: block;
	margin-bottom: 10px;
	font-size: 1.2em;
	transition: all .3s;
}

.footer .footer-content .links ul a:hover {
	color: white;
	margin-left: 15px;
	transition: all .3s;
}

.footer .footer-content .contact-form .contact-input {
	background: #272727;
	color: #bebdbd;
	margin-bottom: 10px;
	line-height: 1.5rem;
	padding: .7rem 1.2rem;
	border: none;
	border-radius: 10px;
}

.footer .footer-content .contact-form .contact-input:focus {
	background: #1a1a1a;
}

.footer .footer-content .contact-form .contact-btn {
	float: right;
}

.btn-big {
	padding: .7rem 1.3rem;
	line-height: 1.3rem;
	border-radius: 10px;
	background-color: #05f7ff;
}

.footer .footer-bottom {
	background-color: #343a40;
	color: white;
	height: 50px;
	width: 100%;
	text-align: center;
	position: absolute;
	bottom: 0px;
	left: 0px;
	padding-top: 20px;
}
</style>
</head>
<body>
	<div class="banner">
		<div id="logo">
			<img src="./img/workspaceLogo.PNG">
		</div>
		<div id="info">
		<a href="pdf.jsp" style=color:white>PDF</a>&nbsp;
			ContactUS: <span><i class="fa fa-phone"></i> &nbsp; 1800 000
				000</span> <span><i class="fa fa-envelope"></i> &nbsp;
				info@workspace4u.com</span>
				
		</div>
	</div>
	<div class="back"></div>
	<div class="listofreservations">
		<%
			Connection con = SpaceDBUtil.getConnection();
			PreparedStatement pss = con.prepareStatement("select userid from userdetails where username=?");
			pss.setString(1, (String) session.getAttribute("un"));
			ResultSet rss = pss.executeQuery();
			rss.next();
			int userId = rss.getInt(1);
			PreparedStatement ps8 = con.prepareStatement("select * from reservations where userid=?");
			ps8.setInt(1, userId);
			ResultSet rs8 = ps8.executeQuery();
			ResultSetMetaData rsmd8 = rs8.getMetaData();
		%>
		<br> <br>
		<center>
			<h1>List of Reservations</h1>
		</center>
		<table align="center" border="1">
			<tr>
				<th><%=rsmd8.getColumnName(1)%></th>
				<th><%=rsmd8.getColumnName(2)%></th>
				<th><%=rsmd8.getColumnName(3)%></th>
				<th><%=rsmd8.getColumnName(4)%></th>
				<th><%=rsmd8.getColumnName(5)%></th>
				<th><%=rsmd8.getColumnName(6)%></th>
				<th><%=rsmd8.getColumnName(7)%></th>
				<th><%=rsmd8.getColumnName(8)%></th>
				<th colspan="1">Action</th>
			</tr>
			<%
				if (rs8 != null) {
					while (rs8.next()) {
			%>
			<tr>
				<td><%=rs8.getInt(1)%></td>
				<td><%=rs8.getString(2)%></td>
				<td><%=rs8.getString(3)%></td>
				<td><%=rs8.getInt(4)%></td>
				<td><%=rs8.getInt(5)%></td>
				<td><%=rs8.getInt(6)%></td>
				<td><%=rs8.getDouble(7)%></td>
				<td><%=rs8.getInt(8)%></td>


				<td><a
					href="./cancelation.jsp?reservationid=<%=rs8.getInt(1)%>&bsno=<%=rs8.getInt(8)%>&oid=<%=rs8.getInt(4)%>">Canclation</a></td>
				<%-- <td><a href="./deletebranch?branchid=<%=rs1.getInt(1)%>">Delete</a></td>  --%>
			</tr>
			<%
				}
				} else {
					while (rs8.previous()) {
			%>
			<tr>
				<td><%=rs8.getInt(1)%></td>
				<td><%=rs8.getString(2)%></td>
				<td><%=rs8.getString(3)%></td>
				<td><%=rs8.getInt(4)%></td>
				<td><%=rs8.getInt(5)%></td>
				<td><%=rs8.getInt(6)%></td>
				<td><%=rs8.getDouble(7)%></td>
				<td><%=rs8.getInt(8)%></td>


				<td><a
					href="./cancelation.jsp?reservationid=<%=rs8.getInt(1)%>&bsno=<%=rs8.getInt(8)%>&oid=<%=rs8.getInt(4)%>">Canclation</a></td>
				<%-- <td><a href="./deletebranch?branchid=<%=rs1.getInt(1)%>">Delete</a></td>  --%>
			</tr>
			<%
				}
				}
			%>
		</table>
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
					<a href="#"><i class="fa fa-facebook"
						style="font-size: 28px; color: #3b5998"></i></a> <a href="#"><i
						class="fa fa-instagram" style="font-size: 28px; color: #3f729b"></i></a>
					<a href="#"><i class="fa fa-twitter"
						style="font-size: 28px; color: #00acee"></i></a> <a href="#"><i
						class="fa fa-youtube" style="font-size: 28px; color: #c4302b"></i></a>
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
						placeholder="Your email Address.."><br> <br>
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