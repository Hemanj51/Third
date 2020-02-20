package com.space.controller.adminaminities;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.space.db.SpaceDBUtil;

/**
 * Servlet implementation class Updateamenities
 */
public class Updateamenities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateamenities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(Updateamenities.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			int amenityid = Integer.parseInt(request.getParameter("amenityid"));
			String amenitytype = request.getParameter("amenitytype");
			double amenityprice = Double.parseDouble(request.getParameter("amenityprice"));
			int officeid = Integer.parseInt(request.getParameter("officeid"));
			Connection con = SpaceDBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("update amenities set amenitytype=?,amenityprice=?,officeid=? where amenityid=?");
			logger.info("Amenities method prepared statement called");
			ps.setString(1, amenitytype);
			ps.setDouble(2, amenityprice);
			ps.setInt(3, officeid);
			ps.setInt(4, amenityid);
			int n = ps.executeUpdate();
			if(n!=0)
			{
				out.println("Successfully Record Updated....");
				logger.info("Successfully Record Updated....");
				RequestDispatcher rd = request.getRequestDispatcher("./adamenities.jsp");
				rd.include(request, response);
				
			}else{
				out.println("Not able to Updated. Please try again....");
				logger.info("Not able to Updated. Please try again....");
				RequestDispatcher rd = request.getRequestDispatcher("./adamenities.jsp");
				rd.include(request, response);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
	

	}

}
