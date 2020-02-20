<%@page import="com.space.db.SpaceDBUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*,com.space.query.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancelation</title>
</head>
<body>
	<center>
		<h1>Canclation</h1>
	</center>
	<%
		Connection con = SpaceDBUtil.getConnection();
		int rid = Integer.parseInt(request.getParameter("reservationid"));
		int bseats = Integer.parseInt(request.getParameter("bsno"));
		int oid = Integer.parseInt(request.getParameter("oid"));
		PreparedStatement ps1 = con.prepareStatement("select seats from office where officeid=?");
		ps1.setInt(1, oid);
		ResultSet rs1 = ps1.executeQuery();
		rs1.next();
		int existingSeats = rs1.getInt(1);
		if (bseats != 0) {
			PreparedStatement ps2 = con.prepareStatement("update office set seats=? where officeid=?");
			ps2.setInt(1, (existingSeats + bseats));
			ps2.setInt(2, oid);
			int n1 = ps2.executeUpdate();
			if (n1 != 0) {
				PreparedStatement ps = con.prepareStatement("delete from reservations where reservationid=?");
				ps.setInt(1, rid);//change here userid
				int n = ps.executeUpdate();
				if (n != 0) {
					out.println("Successfully Reservation Canceled");
					RequestDispatcher rd = request.getRequestDispatcher("./adreservation.jsp");
					rd.include(request, response);
				} else {
					out.println(" Reservation Failed to Cancele");
					RequestDispatcher rd = request.getRequestDispatcher("./adreservation.jsp");
					rd.include(request, response);
				}
			} else {
				out.println(" Reservation Failed to Cancele");
				RequestDispatcher rd = request.getRequestDispatcher("./adreservation.jsp");
				rd.include(request, response);
			}
		} else {
			out.println("Please Reserved after try cancelation");
			RequestDispatcher rd = request.getRequestDispatcher("./adreservation.jsp");
			rd.include(request, response);
		}
	%>
</body>
</html>