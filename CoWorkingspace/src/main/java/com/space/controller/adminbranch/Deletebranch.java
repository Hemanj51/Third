package com.space.controller.adminbranch;

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
 * Servlet implementation class Deletebranch
 */
public class Deletebranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletebranch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(Deletebranch.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			int id = Integer.parseInt(request.getParameter("branchid"));
			Connection con = SpaceDBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from branch where branchid=?");
			logger.info("Delete branch prepared statement called");
			ps.setInt(1, id);
			int n = ps.executeUpdate();
			if(n!=0)
			{
				out.println("Successfully One Record Deleted...");
				logger.info("Successfully One record deleted");
				RequestDispatcher rd = request.getRequestDispatcher("./adbranch.jsp");
				rd.include(request, response);
			}else{
				out.println("Record Notable to deleted.Please try again");
				logger.info("Record not able to deleted.Please try again");
				RequestDispatcher rd = request.getRequestDispatcher("./adbranch.jsp");
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
