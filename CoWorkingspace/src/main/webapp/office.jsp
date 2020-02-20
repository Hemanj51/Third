<%@page import="com.space.db.SpaceDBUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Office Page</title>
</head>
<body>
	<center>
		<h1>
			<u>ADD OFFICE</u>
		</h1>
	</center>
	<form action="addofficeservlet" method="post">
		<table align="center" border="4">
			
			<tr>
				<td>Office Name</td>
				<td><input type="text" name="officename" /></td>
			</tr>
			<tr>
			<td>Price</td>
			<td><input type="text" name="price"/></td>
			</tr>
			<tr>
			<td>Location Id</td>
			<td><input type="text" name="locationid"/></td>
			</tr>
			<tr>
			<td>Seats</td>
			<td><input type="text" name="seats"/></td>
			</tr>
			<td>AvailableSeats</td>
			<td><input type="text" name="availableseats"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="INSERT" /></td>
				<td><input type="reset" value="CANCEL" /></td>
			</tr>
		</table>
	</form>
	<div class="ListOfOffices">
		<%
			Connection con = SpaceDBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from office ");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
		%>
		<br>
		<br>
		<center><h1><u>List of Offices</u></h1></center>
		<table align="center" border="4">
			<tr>
				<th><%=rsmd.getColumnName(1)%></th>
				<th><%=rsmd.getColumnName(2)%></th>
				<th><%=rsmd.getColumnName(3)%></th>
				<th><%=rsmd.getColumnName(4)%></th>
				<th><%=rsmd.getColumnName(5)%></th>
				<th><%=rsmd.getColumnName(6)%></th>
				<th colspan="2">Action</th>
			</tr>
			<%
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getInt(3)%></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getString(5)%></td>
				<td><%=rs.getString(6)%></td>
				<td><a href="./updateoffice.jsp?officeid=<%=rs.getInt(1)%>">Update</a></td>
				<td><a href="./deleteoffice?officeid=<%=rs.getInt(1)%>">Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>