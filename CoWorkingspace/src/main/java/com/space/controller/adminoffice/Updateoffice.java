package com.space.controller.adminoffice;

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
 * Servlet implementation class UpdateOfficeServlet
 */
public class Updateoffice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateoffice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(Updateoffice.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			int id = Integer.parseInt(request.getParameter("officeid"));
			String name = request.getParameter("officename");
			double price = Double.parseDouble(request.getParameter("officeprice"));
			int seats=Integer.parseInt(request.getParameter("seats"));
			int branchid = Integer.parseInt(request.getParameter("branchid"));
			Connection con = SpaceDBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("update office set officename=?,officeprice=?,branchid=?,seats=? where officeid=?");
			logger.info("Update office method prepared statement called");
			ps.setString(1, name);
			ps.setDouble(2, price);
			ps.setInt(3, branchid);
			ps.setInt(4, seats);
			ps.setInt(5, id);
			int n = ps.executeUpdate();
			if(n!=0)
			{
				out.println("Successfully Record Updated....");
				logger.info("Successfully Record Updated....");
				RequestDispatcher rd = request.getRequestDispatcher("./adoffice.jsp");
				rd.include(request, response);
				
			}else{
				out.println("Not able to Updated. Please try again....");
				logger.info("Not able to Updated.Please try again.....");
				RequestDispatcher rd = request.getRequestDispatcher("./adoffice.jsp");
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
