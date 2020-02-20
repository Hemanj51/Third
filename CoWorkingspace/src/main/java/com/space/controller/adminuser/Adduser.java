package com.space.controller.adminuser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.space.bean.Userdetails;
import com.space.daoimpl.AdminuserdetailsDAOimpl;


/**
 * Servlet implementation class Adduser
 */
public class Adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adduser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(Adduser.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Userdetails u=new Userdetails();
		AdminuserdetailsDAOimpl userDAO=new AdminuserdetailsDAOimpl();
		u.setFirstname(request.getParameter("firstname"));
		u.setLastname(request.getParameter("lastname"));
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setEmailid(request.getParameter("emailid"));
		u.setMobile(Long.parseLong(request.getParameter("mobile")));
		int n=userDAO.addUserdetails(u);
		if(n!=0) {
			out.println("sucessfully one userdetails inserted");
			logger.info("Successfully one userdetails inserted");
			  RequestDispatcher rd=request.getRequestDispatcher("./aduser.jsp");
			  rd.include(request, response);
			 
		}else {
			out.println("Record insertion failed");
			logger.info("Record insertion failed");
			RequestDispatcher rd=request.getRequestDispatcher("./aduser.jsp");
			rd.include(request, response);
		}
		
	}

}
