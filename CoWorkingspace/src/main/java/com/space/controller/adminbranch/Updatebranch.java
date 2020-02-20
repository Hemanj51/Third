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
 * Servlet implementation class Updatebranch
 */
public class Updatebranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updatebranch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(Updatebranch.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			int branchid = Integer.parseInt(request.getParameter("branchid"));
			String name = request.getParameter("branchname");
			int locationid = Integer.parseInt(request.getParameter("locationid"));
			Connection con = SpaceDBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement("update branch set branchname=?,locationid=? where branchid=?");
			logger.info("Update branch method prepared statement called");
			ps.setString(1, name);
			ps.setInt(2, locationid);
			ps.setInt(3, branchid);
			int n = ps.executeUpdate();
			if(n!=0)
			{
				out.println("Successfully Record Updated....");
				logger.info("Successfully record updated....");
				RequestDispatcher rd = request.getRequestDispatcher("./adbranch.jsp");
				rd.include(request, response);
				
			}else{
				out.println("Not able to Updated. Please try again....");
				logger.info("Not able to Updated.Please try again");
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
