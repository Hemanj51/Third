<%@page import="com.space.db.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Office</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
		html,body
{   
padding:0;
margin:0px; 
position:relative;
width:auto;
height:auto;
background-color:#AF9B82;
}

#logo img{
	position: absolute;
	height: 80px;
	width: 340px;
	float: left;
}
.banner{
	height: 81px;
	background-color: black;
}
#re table{
width:800px;
padding:0;
border-collapse: collapse;
margin-left:350px;
}
.navigate{
	float: right;
	list-style: none;
	margin-top: 30px;
}
.navigate li{
	display: inline-block;
}
.navigate li a {
	color: white;
	text-decoration: none;
	padding: 5px 20px;
	font-family: "verdana","sans-serif";
	font-size: 20px
}
.navigate li a:hover {
	border: 1px solid grey;
	border-radius:20px; 
	background-color: #717D7E;
}
.sidenav {
  height: 763px;
  width: 200px;
  position: absolute;
  margin-top: 81px;
  margin-bottom: 100px;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  padding-top: 40px;
}

.sidenav a {
  padding: 22px 31px 18px 35px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.main {
  margin-left: 200px;
}

@media screen and (max-height: 486px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
.footer{
	background:#303036;
	color: #d3d3d3;
	height: 400px;
	margin-top: 500px;
	position: relative;

}
.footer .footer-content{
	height: 400px;
	display: flex;
}
.footer .footer-content .footer-section{
	flex: 1;
	padding: 25px;
}
.footer .footer-content h1,
.footer .footer-content h2,{
	color: white;
}
.footer .footer-content .about h1 span{
	color: #05f7ff;
}
.footer .footer-content .about .contact span{
	display: block;
	font-size: 1.1em;
	margin-bottom: 8px;
}
.footer .footer-content .about .socials a{
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
.footer .footer-content .about .socials a:hover{
	border: 1px solid white;
	color: white;
	transition: all .3s;
}
.footer .footer-content .links ul a{
	color: white;
	display: block;
	margin-bottom: 10px;
	font-size: 1.2em; 
	transition: all .3s;
}
.footer .footer-content .links ul a:hover{
	color: white;
	margin-left: 15px;
	transition: all .3s;
}
.footer .footer-content .contact-form .contact-input{
	background:#272727;
	color: #bebdbd;
	margin-bottom: 10px;
	line-height: 1.5rem;
	padding: .7rem 1.2rem;
	border:none;
	border-radius: 10px;
}
.footer .footer-content .contact-form .contact-input:focus{
	background:#1a1a1a;
}
.footer .footer-content .contact-form .contact-btn{
	float: right;
}
.btn-big{
	padding: .7rem 1.3rem;
	line-height: 1.3rem;
	border-radius: 10px;
	background-color: #05f7ff;
}


.footer .footer-bottom{
	background-color: #343a40;
	color: white;
	height: 50px;
	width: 100%;
	text-align:center;
	position: absolute;
	bottom: 0px;
	left: 0px;
	padding-top: 20px;
}
	</style>
	<script type="text/javascript">
      function office(){
    	  var oname=document.getElementById("oname").value;
    	  var price=document.getElementById("price").value;
    	  var seat=document.getElementById("seats").value;
    	  
    	  var a=/^[a-zA-Z]+$/;
    	  var b=/^[1-9]{1}[0-9]+$/;
    	  var c=/^[0-9]+$/;
    	 
    	  if(oname==""){
   		   document.getElementById("officename").innerHTML="**please enter the required fields ";
   		   return false;
   	   } else
   	  if(a.test(oname)){
   		  document.getElementById("officename").innerHTML="";
   		  
   	  }else{
   		  document.getElementById("officename").innerHTML="**please enter only character ex:officenames";
   		  return false;
   	  }
   	  
   	  
   	  if(price==""){
   		   document.getElementById("officeprice").innerHTML="**please enter the required fields ";
   		   return false;
   	   } else
   	  if(b.test(price)){
   		  document.getElementById("officeprice").innerHTML="";
   		  
   	  }else{
   		  document.getElementById("officeprice").innerHTML="**please enter only digits ex:1000";
   		  return false;
   	  }
   	  
   	  
   	  if(seat==""){
   		   document.getElementById("officeseat").innerHTML="**please enter the required fields ";
   		   return false;
   	   } else
   	  if(c.test(seat)){
   		  document.getElementById("officeseat").innerHTML="";
   		  
   	  }else{
   		  document.getElementById("officeseat").innerHTML="**please enter only digits ex:40";
   		  return false;
   	  }
      }
</script>

</head>
<body>
<div class="banner">
	<div id="logo">
		<img src="./img/workspaceLogo.PNG">
		<nav>
			<ul class="navigate">
			 <li><a href="./Admin.html"><i class="w3-large w3-spin fa fa-home"></i> Home</a></li>
			<li><a href="./Adminlogin.html"><i class="w3-large w3-spin fa fa-sign-out"></i> Logout</a></li>
			</ul>
		</nav>
	</div>
	<div class="sidenav">
  <a href="./adamenities.jsp">Aminities</a>
  <a href="./adbranch.jsp">Branch</a>
  <a href="./adlocation.jsp">location</a>
  <!-- <a href="./adoffice.jsp">Office</a> -->
  <a href="./aduser.jsp">UserDetails</a>
  <a href="./adreservation.jsp">User Reservation</a>
</div>
   </div>
 <div class="container">
	<center>
		<h1>
			<u>ADD OFFICE</u>
		</h1>
	</center>
	<%
		Connection con = SpaceDBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from branch");
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
	%>
	<form action="addoffice" method="post" onsubmit="return office()">
		<table align="center" >
			<div class="form-group">
			<tr>
				<td>Office Name</td>
				<td><input type="text" name="officename" id="oname" class="form-control" />
				<span id="officename" class="text-danger font-weight-bold"></span></td>
			</tr>
			</div>
			<div class="form-group">
			<tr>
			<td>Office Price</td>
			<td><input type="text" name="officeprice" id="price" class="form-control" />
			<span id="officeprice" class="text-danger font-weight-bold"></span></td>
			</tr>
			</div>
			<div class="form-group">
			<tr>
				<td>Select branch</td>
				<td><select name="branchid" class="form-control" >
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
			<tr>
			<td>Seats</td>
			<td><input type="text" name="seats" id="seats" class="form-control" />
			<span id="officeseat" class="text-danger font-weight-bold"></span></td>
			</tr>
			</div>
			<tr>
				<td><input type="submit" value="INSERT" class="btn btn-primary"/></td>
				<td><input type="reset" value="CANCEL" class="btn btn-danger"/></td>
			</tr>
		</table>
	</form>
	</div>

	<%-- <center>
		<h1>
			<u>Add Office</u>
		</h1>
	</center>
	<%
		Connection con = SpaceDBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from branch");
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
	%>
	<form action="addoffice" method="post">
		<table align="center">
			
			<tr>
				<td>Office Name</td>
				<td><input type="text" name="officename" /></td>
			</tr>
			<tr>
			<td>Office Price</td>
			<td><input type="text" name="officeprice"/></td>
			</tr>
			<tr>
				<td>Select branch</td>
				<td><select name="branchid">
						<%
							while (rs.next()) {
						%>
						<option value=<%=rs.getInt(1)%>><%=rs.getString(2)%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
			<td>Seats</td>
			<td><input type="text" name="seats"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="INSERT" /></td>
				<td><input type="reset" value="CANCEL" /></td>
			</tr>
		</table>
	</form> --%>
	
	<div class="ListOfOffices">
		<%
			
			PreparedStatement ps1 = con.prepareStatement("select * from office");
			ResultSet rs1 = ps1.executeQuery();
			ResultSetMetaData rsmd1 = rs1.getMetaData();
		%>
		<center><h1><u>List of Offices</u></h1></center>
		<div id="re">
		<table align="center" border="1">
			<tr>
				<th><%=rsmd1.getColumnName(1)%></th>
				<th><%=rsmd1.getColumnName(2)%></th>
				<th><%=rsmd1.getColumnName(3)%></th>
				<th><%=rsmd1.getColumnName(4)%></th>
				<th><%=rsmd1.getColumnName(5)%></th>
				<th colspan="2">Action</th>
			</tr>
			<%
				while (rs1.next()) {
			%>
			<tr>
				<td><%=rs1.getInt(1)%></td>
				<td><%=rs1.getString(2)%></td>
				<td><%=rs1.getDouble(3)%></td>
				<td><%=rs1.getInt(4)%></td>
				<td><%=rs1.getInt(5)%></td>
				<td><a href="./adupdateoffice.jsp?officeid=<%=rs1.getInt(1)%>">Update</a></td>
				<td><a href="./deleteoffice?officeid=<%=rs1.getInt(1)%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
		</div>
	<div class="footer">
		<div class="footer-content">
		    <div class="footer-section about">
				<h1 class="logo-text"><span>WOrk</span>Space4U</h1>
				<p>Workspace4U is an arrangement in which several workers from different companies share an office space, allowing cost savings and convenience through the use of common infrastructure</p>
			
			<div class="contact">
				<span><i class="fa fa-phone"></i> &nbsp; 1800 000 000</span>
				<span><i class="fa fa-envelope"></i> &nbsp; info@workspace4u.com</span>
			</div>
			<div class="socials">
				<a href="#"><i class="fa fa-facebook"style="font-size:28px;color: #3b5998"></i></a>
				<a href="#"><i class="fa fa-instagram"style="font-size:28px;color:#3f729b"></i></a>
				<a href="#"><i class="fa fa-twitter"style="font-size:28px;color:#00acee"></i></a>
				<a href="#"><i class="fa fa-youtube"style="font-size:28px;color:#c4302b"></i></a>
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
					<input type="email" name="email" class="text-input contact-input" placeholder="Your email Address.."><br><br>
					<textarea name="message" class="text-input contact-input" placeholder="Your Message"></textarea><br>
					<button type="submit" class="btn btn-big">
						<i class="fa fa-envelope"></i>
						send
					</button>
				</form>
			</div>
		</div>
		<div class="footer-bottom">
			&copy;WorkSpace4U | Designed by R3SCHPNBJ
		</div>
	</div>
</body>
</html>