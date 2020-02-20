<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CoWorkSpace</title>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="banner">
	<div id="logo">
		<img src="./img/workspaceLogo.PNG">
		
	</div>
</div>
<%
if (session != null) {
	if (session.getAttribute("un") != null) {
		String name = (String) session.getAttribute("un");
		out.print("please login again");
	} else {
		response.sendRedirect("login.html");
	}
}
%>
	<div class="back">
		
	</div>
	<div class="login-box">
	<h1>Login here</h1>
<form action="logout" method="get">
<p>Username</p>
<input type="text" name="uname">
<p>Password</p>
<input type="Password" name="pass">
<a href="#">
<input type="submit"  value="Login"></a>

<br>
<br>
<a href="forgot.html">Forgot Password</a>
<br>
<br>
<br>
<br>
<div id="new-user">
<a href="registration.html">New User?Register Here.</a>
</div>
</form>	
</div>

</form>
</body>
</html>

</body>
</html>