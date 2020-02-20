<%@page import="java.sql.*,com.space.db.SpaceDBUtil"%>
<!DOCTYPE html>
<html>
<head>
<title>HyderabadPage</title>
<link rel="stylesheet" type="text/css" href="hyd.css">
 <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="hyd.js"></script>
</head>
<body>
	<div class="banner">
		<div id="logo">
			<img src="./img/workspaceLogo.PNG">
		</div>
		<div id="info">
		<a href="User.jsp"><i class="w3-large w3-spin fa fa-home"></i> Home</a>
			<a href="UserHomePage.html"><i class="w3-large w3-spin fa fa-sign-out" ></i>Logout</a> 
			<!-- <a href="#" class="w3-large w3-spin fa fa-home">Logout</a> -->
		</div>
	</div>

	<div class="back"></div>
	
	<%
		Connection con = SpaceDBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from office");
		PreparedStatement ps1 = con.prepareStatement("select * from branch where locationid='5'");
		PreparedStatement ps2 = con.prepareStatement("select * from userdetails");
		PreparedStatement ps3 = con.prepareStatement("select * from amenities");
		PreparedStatement ps4 = con.prepareStatement("select * from location");
		PreparedStatement ps5 = con.prepareStatement("select userid from userdetails where username=?");
		ps5.setString(1, (String) (session.getAttribute("un")));
		ResultSet rs = ps.executeQuery();
		ResultSet rs1 = ps1.executeQuery();
		ResultSet rs2 = ps2.executeQuery();
		ResultSet rs3 = ps3.executeQuery();
		ResultSet rs4 = ps4.executeQuery();
		ResultSet rs5 = ps5.executeQuery();

		ResultSetMetaData rsmd = rs.getMetaData();
		ResultSetMetaData rsmd1 = rs1.getMetaData();
		ResultSetMetaData rsmd2 = rs2.getMetaData();
		ResultSetMetaData rsmd3 = rs3.getMetaData();
		ResultSetMetaData rsmd4 = rs4.getMetaData();
	%>
	<br>
	 
	<div class="container">
		<div id="he">
			<h2>Our Branches in Hyderabad</h2>
		</div><br>
		<div id="map">
		<p>
			<iframe
				src="https://www.google.com.qa/maps/d/u/0/embed?mid=1ESG4S34KfuuVXNK3xaNBKwcHj5F_V--B"
				width="970" height="570"></iframe>
		</p></div>
	
	

	 <div class="reserv">
		 <form action="reservationservlet" method="post"> 
			<table align="right" width="30%" height="20%">	
				<div class="branch">
					<tr>
					<td>BRANCH LOCATION</td></tr><tr>
						<td><select name="branchid" class="form-control">
								<%
									while (rs1.next()) {
								%>
								<option value=<%=rs1.getInt(1)%>><%=rs1.getString(2)%></option>
								<%
									}
								%>
						</select></td>
					</tr>
				</div>


				<div class="userid">
					<tr><td>USER</td></tr><tr>
						<td><select name="userid" class="form-control">
								<%
									int userId = 0;
									while (rs5.next()) {
										userId = rs5.getInt(1);
										session.setAttribute("userId", userId);
								%>
								<option value=<%=rs5.getInt(1)%>><%=(String) session.getAttribute("un")%></option>


								<%
									}
								%>
						</select></td>
					</tr>
				</div>

				<div class="type">
					<tr><td>OFFICE</td>
					</tr>
					<tr>
					
					
						<td><select name="officeid" class="form-control">
								<%
									while (rs.next()) {
								%>
								<option value=<%=rs.getInt(1)%>><%=rs.getString(2)%></option>
								<%
									}
								%>
						</select></td>
					</tr>
				</div>
							<div class="form-group">
				<tr><td>START DATE</td></tr>
				<tr>
					<td><input type="date" name="startdate" id="start date"
						class="form-control"></td>
						</tr>
						</div>
						<div class="form-group">
						<tr>
						<td>END DATE</td>
						</tr>
						<tr>
					<td><input type="date" name="enddate" id="end date"
						class="form-control"></td>
				</tr>
</div>

				<div id="aminities" >
					<tr>
						<td>AMENITIES</td>
                         </tr>
                         <tr>
						<td>
							<%
								while (rs3.next()) {
							%> <input type="checkbox" name="amenityid" 
							value=<%=rs3.getInt(1)%>><%=rs3.getString(2)%></input> <%
 	}
 %> 
						</td>
					</tr>
				</div>

				<div class="form-group">
					<tr>
						<td>SEATS</td>
						</tr>
						<tr>
						<td><input type="text" name="bookedseats"
							class="form-control" /></td>
					</tr>
				</div>
				

				<tr>
					<td><a href="./User.jsp"><input type="submit" class="btn btn-primary"
							name="submit"></a> <input type="reset" name="reset" class="btn btn-danger"></td>
				</tr>


			</table>
		</form>
		</div>
</div>
	<br>
		<!-- Slideshow container -->
<!-- <div class="slideshow-container">

  Full-width images with number and caption text
  <div class="mySlides fade">
    <div class="numbertext">1 / 4</div>
    <img src="./img/private.jpg" style="width:100%"><br><br>
    <div class="text"><b>public desk</b></div>
  </div>

  <div class="mySlides fade">
    <div class="numbertext">2 / 4</div>
    <img src="./img/single.jpg" style="width:100%"><br><br>
    <div class="text"><b>Hotdesk</b></div>
  </div>

  <div class="mySlides fade">
    <div class="numbertext">3 / 4</div>
    <img src="./img/conference.jpg" style="width:100%"><br><br>
    <div class="text"><b>Conferenece Romm</b></div>
  </div>
  <div class="mySlides fade">
    <div class="numbertext">4 / 4</div>
    <img src="./img/hotdesk.jpg" style="width:100%"><br><br>
    <div class="text"><b>private desk</b></div>
  </div>
<br>
<br>
  Next and previous buttons
  <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
  <a class="next" onclick="plusSlides(1)">&#10095;</a>
</div>
<br> -->
	
	
	
	
	
	
	
	
	
	
	<div class="aminities">
		<img src="./img/workspace.JPG">
	</div>
	<div class="fo">
		<center><h2>About WorkingSpace in Hyderabad</h2></center>
		<b>A few Workafacts exclusively for you!</b> <br>
		<p>Choose WorkSpace4U potpourri of benefits for you.OurCoworking
			space in Hyderabad offers you</p>
		<br> <b>Coworking space in Hyderabad</b> <br>
		<p>Our office space in Hyderabad is spread across the city. With
			multiple centres around, you have the luxury of choosing the location
			that’s most preferred for you.</p>
		<br> <b>Affordability and flexibility</b> <br>
		<p>Are you an entrepreneur looking out for a professional space?
			Are you looking to grow your team? Whether you have a requirement for
			a single seat or for a whole office, we have it for you. Add as you
			scale, customise your office space, hot desk from any Workafella
			location of your choice.</p>
		<br> <b>Amenities and Lifestyle benefits</b>
		<p>Our Coworking space in Hyderabad provides unlimited Wi-Fi,
			telephone calls, CCTV, security, unlimited tea/coffee, front desk,
			IT, HR, maintenance, utilities, food court, projectors and
			housekeeping. As a value ad, we have kept traffic in mind hence
			providing valet parking services. For last minute help, we are
			facilitated with kettle, steam iron and shower. Workafella also
			provides you with runner boys who can come in handy throughout.</p>
		<br> <b>Events and Networking</b> <br>
		<p>Every business needs networking to grow and we enable that in
			the right way. By closely working with people from different fields,
			you’re also open for building new possibilities and explore new
			territories. To add a streak of fun, we also conduct various events
			to lighten up the moment for all of us. We strongly believe that a
			little of fun can make our productivity better.</p>
		<br>
		<p>The best Coworking space in Hyderabad is here for you. Make the
			choice today.</p>
		<br> <b>Think workspace?</b>
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