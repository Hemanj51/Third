package com.space.controller.adminoffice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.space.bean.Office;

import com.space.daoimpl.AdminofficeDAOimpl;

/**
 * Servlet implementation class AddOfficeServlet
 */
public class Addoffice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addoffice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(Addoffice.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Office of = new Office();
		AdminofficeDAOimpl officeDAO = new AdminofficeDAOimpl();
		of.setOfficename(request.getParameter("officename"));
		of.setOfficeprice(Double.parseDouble(request.getParameter("officeprice")));
		of.setSeats(Integer.parseInt(request.getParameter("seats")));
		of.setBranchid(Integer.parseInt(request.getParameter("branchid")));
		int n=officeDAO.addOffice(of);
		if(n!=0){
			out.println("Successfully One Office Inserted.");
			logger.info("Successfully one office inserted.");
			RequestDispatcher rd = request.getRequestDispatcher("./adoffice.jsp");
			rd.include(request, response);
		}else{
			out.println("Record Insertion Failed.Please try again.");
			logger.info("Record Insertion failed.Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("./adoffice.jsp");
			rd.include(request, response);
		}
	}

}
