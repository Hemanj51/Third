package com.space.controller.adminbranch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.space.bean.Branch;
import com.space.daoimpl.AdminbranchDAOimpl;

/**
 * Servlet implementation class Addbranch
 */
public class Addbranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addbranch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(Addbranch.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Branch b=new Branch();
		AdminbranchDAOimpl branchDAO=new AdminbranchDAOimpl();
		b.setBranchname(request.getParameter("branchname"));
		b.setLocationid(Integer.parseInt(request.getParameter("locationid")));
		int n=branchDAO.addbranch(b);
		if(n!=0) {
			out.println("sucessfully one branch inserted");
			logger.info("Successfully one branch inserted");
			RequestDispatcher rd=request.getRequestDispatcher("./adbranch.jsp");
			rd.include(request, response);
		}else {
			out.println("Record insertion failed");
			logger.info("Record insertion failed");
			RequestDispatcher rd=request.getRequestDispatcher("./adbranch.jsp");
			rd.include(request, response);
		}
		
	}

}
