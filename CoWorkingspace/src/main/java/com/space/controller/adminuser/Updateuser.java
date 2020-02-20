package com.space.controller.adminuser;

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
 * Servlet implementation class Updateuser
 */
public class Updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(Updateuser.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			int userid=Integer.parseInt(request.getParameter("userid"));
			String firstname=request.getParameter("firstname");
			String lastname=request.getParameter("lastname");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String emailid=request.getParameter("emailid");
			long mobile=Long.parseLong(request.getParameter("mobile"));
			String type=request.getParameter("type");
			String status=request.getParameter("status");
			Connection con=SpaceDBUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("update userdetails set firstname=?,lastname=?,username=?,password=?,emailid=?,mobile=?,type=?,status=? where userid=?");
			logger.info("Update userdetails prepared statement called");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, emailid);
			ps.setLong(6, mobile);
			ps.setString(7, type);
			ps.setString(8, status);
			ps.setInt(9, userid );
			int n=ps.executeUpdate();
			if(n!=0) {
				out.println("Successfully user Record updated");
				logger.info("Successfully user Record updated");
				RequestDispatcher rd=request.getRequestDispatcher("./aduser.jsp");
				rd.include(request, response);
			}else {
				out.println("Record not inserted sucessfully");
				logger.info("Record not inserted suuccessfully");
				RequestDispatcher rd=request.getRequestDispatcher("./aduser.jsp");
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
