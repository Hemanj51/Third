<%@page import="com.space.db.SpaceDBUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*,com.space.query.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation</title>

</head>
<body>
	<div class="banner">
		<div id="logo">
			<img src="./img/workspaceLogo.PNG">
		</div>
	</div>
	<center>
		<h1>
			<u>Reservation</u>
		</h1>
	</center>
	<%
		Connection con = SpaceDBUtil.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from office");
		PreparedStatement ps1 = con.prepareStatement("select * from branch");
		PreparedStatement ps2 = con.prepareStatement("select * from userdetails");
		PreparedStatement ps3 = con.prepareStatement("select * from amenities");
		
		ResultSet rs = ps.executeQuery();
		ResultSet rs1 = ps1.executeQuery();
		ResultSet rs2 = ps2.executeQuery();
		ResultSet rs3 = ps3.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		ResultSetMetaData rsmd1 = rs1.getMetaData();
		ResultSetMetaData rsmd2 = rs2.getMetaData();
		ResultSetMetaData rsmd3 = rs3.getMetaData();
	%>
	<form action="reservation" method="post">
		<table align="center" border="1" bgcolor="lightblue">

			<tr>
				<td>Start Date</td>
				<td><input type="date" name="startdate" /></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><input type="date" name="enddate" /></td>
			</tr>
			<tr>
				<td>Select Office</td>
				<td><select name="officeid">
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
				<td>Select Branch</td>
				<td><select name="branchid">
						<%
							while (rs1.next()) {
						%>
						<option value=<%=rs1.getInt(1)%>><%=rs1.getString(2)%></option>
						<%
							}
						%>
				</select></td>
			</tr>
			<tr>
				<td>User</td>
				<td><select name="userid"> 
				<%
				while (rs2.next()) {  %>
						<option	value="1"><%=(String) session.getAttribute("un")%></option>
				
				
				<%-- <option
							value=<%=Integer.parseInt((String) session.getAttribute("uid"))%>><%=(String) session.getAttribute("uname")%></option>
				
				 --%>
				<%} %>
				</select></td>
			</tr>
			<tr>
				<td>Amenities</td>
				<td>
					<%
						while (rs3.next()) {
					%> <input type="checkbox" name="amenityid"
					value=<%=rs3.getInt(1)%>><%=rs3.getString(2)%></input> <%
 	}
 %>
				</td>
			</tr>
			<tr>
				<td>Booking Seats</td>
				<td><input type="text" name="bookedseats" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Cancel" /></td>
			</tr>
			<tr>
			<td><a href="./cancelation.jsp">cancellation</a></td>
			</tr>
		</table>
	</form>
<div class="listofreservations">
		<%
			PreparedStatement ps8 = con.prepareStatement("select * from reservations");
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
				<%-- <td><a href="./deletebranch?branchid=<%=rs1.getInt(1)%>">Delete</a></td> --%>
			</tr>
			<%
				}
			%>
		</table>
	</div>

</body>
</html>