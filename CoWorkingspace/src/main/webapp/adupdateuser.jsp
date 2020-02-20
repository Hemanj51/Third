<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.sql.*,com.space.db.*,com.space.query.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
  height: 793px;
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

   function myfun(){
	   
	   
	   var fname=document.getElementById("fname").value;
	   var lname=document.getElementById("lname").value;
	   var uname=document.getElementById("uname").value;
	   var retype=document.getElementById("retype").value;
	   var pass=document.getElementById("pass").value;
	   var email=document.getElementById("email").value;
	   var mobile=document.getElementById("mobile").value;
	   
	   var a=/^[a-zA-z]+$/;
	   var b=/(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,16}/;
	   var c=/[A-Za-z_0-9]{3,}@[A-Za-z]{3,}[.]{1}[A-Za-z]{2,6}/;
	   var d=/^[789]{1}[0-9]{9}$/;
	   var e=/^[a-zA-z]+$/;
	   var f=/^[a-zA-Z0-9]{6,20}$/;

	   if(fname==""){
		   document.getElementById('firstname').innerHTML="**please enter the required fields ";
		   return false;
	   } else
   if(a.test(fname)){
	   document.getElementById('firstname').innerHTML=" ";
	   }else{
		   document.getElementById('firstname').innerHTML="**please enter only characters ex:java ";
		   return false;  
	   }
	   if(lname==""){
		   document.getElementById('lastname').innerHTML="**please enter the required fields ";
		   return false;
	   }else
   
   if(e.test(lname)){
	   document.getElementById('lastname').innerHTML=" ";
	   }else{
		   document.getElementById('lastname').innerHTML="**please enter only characters ex:javaproject ";
		   return false;  
	   }
	   if(uname==""){
		   document.getElementById('username').innerHTML="**please enter the required fields ";
		   return false;
	   }else
		      
   if(f.test(uname)){
	   document.getElementById('username').innerHTML=" ";
	   }else{
		   document.getElementById('username').innerHTML="**please enter atleast six characters containing numbers ex:user1234 or username ";
		   return false;  
	   } 
	   if(retype==""){
		   document.getElementById('retypepassword').innerHTML="**please enter the required fields ";
		   return false;
	   }else
   
     if(b.test(retype)){
	   document.getElementById('retypepassword').innerHTML=" ";
	   }else{
		   document.getElementById('retypepassword').innerHTML="**must be atleast 8 characters with numbers,symbols ex:1@abcdfe";
		   return false;  
	
  	   }
	   if(pass==""){
		   document.getElementById('password').innerHTML="**please enter the required fields ";
		   return false;
	   }else

    if(retype.match(pass)){
	   document.getElementById('password').innerHTML=" ";
	   }else{
		   document.getElementById('password').innerHTML="** password is miss matching enter above password only ex:1@abcdef";

		   return false;  
	
  	   }
	   if(email==""){
		   document.getElementById('emailid').innerHTML="**please enter the required fields ";
		   return false;
	   }else
   if(c.test(email)){
	   document.getElementById('emailid').innerHTML=" ";
	   }else{
		   document.getElementById('emailid').innerHTML="**please enter valid email ex:projectj51@gmail.com ";
		   return false;  
	   }
	   if(mobile==""){
		   document.getElementById('mobileno').innerHTML="**please enter the required fields ";
		   return false;
	   }else
   if(d.test(mobile)){
	   document.getElementById('mobileno').innerHTML=" ";
	   }else{
		   document.getElementById('mobileno').innerHTML="**please enter 10digits number ex:7981254536 must be start with 7,8,9 ";
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
	</div>
	<div class="container">
	<%
		int userid = Integer.parseInt(request.getParameter("userid"));
		Connection con = SpaceDBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from userdetails where userid=? and Status='Active'");
		ps.setInt(1, userid);
		ResultSet rs = ps.executeQuery();
	%>
	<center>
		<h1 class="text-dark">
			<u>Enter User Update</u>
		</h1>
	</center>

	<form action="updateuser" method="post" onsubmit="return myfun()">


			<%
				while (rs.next()) {
			%>
			<table align="center">
			<div class="form-group">
			<tr>
				<td>User Id</td>
				<td><input type="text" name="userid" readonly="readonly"  class="form-control"
					value="<%=rs.getInt(1)%>" />
					</td>
			</tr>
			</div>
			<div class="form-group">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstname" id="fname" class="form-control" value="<%=rs.getString(2)%>" />
				<span id="firstname" class="text-danger font-weight-bold"></span></td>
			</tr>
			</div>
			<div class="form-group">
			
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastname" id="lname"  class="form-control" value="<%=rs.getString(3)%>" />
				<span id="lastname" class="text-danger font-weight-bold"></span></td>
				
			</tr>
			</div>
			<div class="form-group">
			
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" id="uname"  class="form-control" value="<%=rs.getString(4)%>" />
				<span id="username" class="text-danger font-weight-bold"></span></td>
			</tr>
			</div>
		
		<div class="form-group">
			
		       <tr>
				<td> Password</td>
				<td><input type="text" name="retypepassword" id="retype"  class="form-control" value="<%=rs.getString(5)%>" />
				<span id="retypepassword" class="text-danger font-weight-bold"></span></td>
			</tr>
			</div>
			<div class="form-group">
			
		       <tr>
				<td>Retype Password</td>
				<td><input type="text" name="password" id="pass"  class="form-control" value="<%=rs.getString(5)%>" />
				<span id="password" class="text-danger font-weight-bold"></span></td>
			</tr>
			</div>
		<div class="form-group">
			<tr>
				<td>EmailId</td>
				<td><input type="text" name="emailid" id="email"  class="form-control" value="<%=rs.getString(6)%>" />
				<span id="emailid" class="text-danger font-weight-bold"></span></td>
			</tr>
			</div>
			
			<div class="form-group">
		
			<tr>
				<td>MobileNo</td>
				<td><input type="text" name="mobile" id="mobile"  class="form-control" value="<%=rs.getLong(7)%>" />
				<span id="mobileno" class="text-danger font-weight-bold"></span></td>
			</tr>
			</div>
			<div class="form-group">
			<tr>
				<td>Type</td>
				<td><input type="text" name="type" readonly="readonly"  class="form-control"
					value="<%=rs.getString(8)%>" /></td>
			</tr>
			</div>
			<div class="form-group">
			<tr>
				<td>Status</td>
				<td><select name="status"  class="form-control">
						<option value="<%=rs.getString(9)%>">Active</option>
						<option value="<%=rs.getString(9)%>" selected>Inactive</option>
				</select></td>
			</tr>
			</div>
			<tr>
				<td><input type="submit" value="insert" class="btn btn-primary"/></td>
				<td><input type="reset" value="reset" class="btn btn-danger"/></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
</div>
	
	<%-- <%
		int userid = Integer.parseInt(request.getParameter("userid"));
		Connection con = SpaceDBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from userdetails where userid=? and Status='Active'");
		ps.setInt(1, userid);
		ResultSet rs = ps.executeQuery();
	%>
	<center>
		<h1>
			<u>Update UserDetails</u>
		</h1>
	</center>
	<form action="updateuser" method="post">
		<table align="center">
			<%
				while (rs.next()) {
			%>
			<tr>
				<td>User Id</td>
				<td><input type="text" name="userid" readonly="readonly"
					value="<%=rs.getInt(1)%>" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstname"
					value="<%=rs.getString(2)%>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastname"
					value="<%=rs.getString(3)%>" /></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username"
					value="<%=rs.getString(4)%>" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"
					value="<%=rs.getString(5)%>" /></td>
			</tr>
			<tr>
				<td>EmailId</td>
				<td><input type="email" name="emailid"
					value="<%=rs.getString(6)%>" /></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile" value="<%=rs.getLong(7)%>" /></td>
			</tr>
			<tr>
				<td>Type</td>
				<td><input type="text" name="type" readonly="readonly"
					value="<%=rs.getString(8)%>" /></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><select name="status">
						<option value="<%=rs.getString(9)%>">Active</option>
						<option value="<%=rs.getString(9)%>" selected>Inactive</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="insert" /></td>
				<td><input type="reset" value="reset" /></td>
			</tr>
			<%
				}
			%>
		</table>
	</form>
</div> --%>
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