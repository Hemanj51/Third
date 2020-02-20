package com.space.controller.adminlocation;

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
 * Servlet implementation class Updatelocation
 */
public class Updatelocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatelocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(Updatelocation.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			int lid = Integer.parseInt(request.getParameter("locationid"));
			String name = request.getParameter("locationname");
			Connection con = SpaceDBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("update location set locationname=? where locationid=?");
			logger.info("Update location prepared statement called");
			ps.setString(1, name);
			ps.setInt(2, lid);
			int n = ps.executeUpdate();
			if(n!=0)
			{
				out.println("Successfully Record Updated....");
				logger.info("Successfully Record Updated....");
				RequestDispatcher rd = request.getRequestDispatcher("./adlocation.jsp");
				rd.include(request, response);
				
			}else{
				out.println("Not able to Updated. Please try again....");
				logger.info("Not able to Updated. Please try again....");
				RequestDispatcher rd = request.getRequestDispatcher("./adlocation.jsp");
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
