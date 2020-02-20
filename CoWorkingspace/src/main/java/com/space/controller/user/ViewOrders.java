package com.space.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.space.db.SpaceDBUtil;

/**
 * Servlet implementation class ViewOrders
 */
public class ViewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(ViewOrders.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			Connection con = SpaceDBUtil.getConnection();
			PreparedStatement pss = con.prepareStatement("select userid from userdetails where username=?");
			logger.info("Userdetails prepared statement called for userid");
			HttpSession session = request.getSession();
			pss.setString(1, (String) session.getAttribute("un"));
			ResultSet rss = pss.executeQuery();
			int userId =0;
			while(rss.next())
			{
				userId = rss.getInt(1);
			}
			PreparedStatement ps8 = con.prepareStatement("select * from reservations where userid=?");
			logger.info("Reservation prepared statement called");
			ps8.setInt(1, userId);
			ResultSet rs8 = ps8.executeQuery();
			ResultSetMetaData rsmd8 = rs8.getMetaData();

			out.println("<center>");
			out.println("<h1>List of Reservations</h1>");
			out.println("</center>");
			out.println("<table align=center border=1>");
			out.println("<tr>");
			out.println("<th>" + rsmd8.getColumnName(2) + "</th>");
			out.println("<th>" + rsmd8.getColumnName(3) + "</th>");
			out.println("<th>" + rsmd8.getColumnName(4) + "</th>");
			out.println("<th>" + rsmd8.getColumnName(5) + "</th>");
			out.println("<th>" + rsmd8.getColumnName(6) + "</th>");
			out.println("<th>" + rsmd8.getColumnName(7) + "</th>");
			out.println("<th>" + rsmd8.getColumnName(8) + "</th>");
			out.println("<th colspan=1>Action+</th>");
			out.println("</tr>");

			if (rs8 != null) {
				while (rs8.next()) {

					out.println("<tr>");
					out.println("<td>" + rs8.getInt(1) + "</td>");
					out.println("<td>" + rs8.getString(2) + "</td>");
					out.println("<td>" + rs8.getString(3) + "</td>");
					out.println("<td>" + rs8.getInt(4) + "</td>");
					out.println("<td>" + rs8.getInt(5) + "</td>");
					out.println("<td>" + rs8.getInt(6) + "</td>");
					out.println("<td>" + rs8.getDouble(7) + "</td>");
					out.println("<td>" + rs8.getInt(8) + "</td>");
					out.println(
							"<td><a href='./cancelation.jsp?reservationid=<%=rs8.getInt(1)%>&bsno=<%=rs8.getInt(8)%>&oid=<%=rs8.getInt(4)%>'>Canclation</a></td>");
					// <%-- <td><a
					// href="./deletebranch?branchid=<%=rs1.getInt(1)%>">Delete</a></td>
					// --%>
					out.println("</tr>");

				}
			} else {
				while (rs8.previous()) {

					out.println("<tr>");
					out.println("<td>" + rs8.getInt(1) + "</td>");
					out.println("<td>" + rs8.getString(2) + "</td>");
					out.println("<td>" + rs8.getString(3) + "</td>");
					out.println("<td>" + rs8.getInt(4) + "</td>");
					out.println("<td>" + rs8.getInt(5) + "</td>");
					out.println("<td>" + rs8.getInt(6) + "</td>");
					out.println("<td>" + rs8.getDouble(7) + "</td>");
					out.println("<td>" + rs8.getInt(8) + "</td>");
					out.println(
							"<td><a href='./cancelation.jsp?reservationid=<%=rs8.getInt(1)%>&bsno=<%=rs8.getInt(8)%>&oid=<%=rs8.getInt(4)%>'>Canclation</a></td>");
					out.println("</tr>");

				}
			}

			out.println("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
	}

}
