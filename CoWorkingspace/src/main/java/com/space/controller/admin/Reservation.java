package com.space.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.space.bean.Reservations;
import com.space.daoimpl.AdminDAOimpl;
import com.space.daoimpl.UserDAOimpl;

/**
 * Servlet implementation class Reservation
 */
public class Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(Reservation.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Reservations r=new Reservations();
		AdminDAOimpl adminDAO=new AdminDAOimpl();
		
		r.setStartdate(request.getParameter("startdate"));
		r.setEnddate(request.getParameter("enddate"));
		r.setOfficeid(Integer.parseInt(request.getParameter("officeid")));
		r.setBranchid(Integer.parseInt(request.getParameter("branchid")));
		r.setUserid(Integer.parseInt(request.getParameter("userid")));
		String[] amenities = request.getParameterValues("amenityid");
		r.setAmenityid(amenities);
		//r.setTotalprice(Double.parseDouble(request.getParameter("totalprice")));
		r.setBookedseats(Integer.parseInt(request.getParameter("bookedseats")));
		int n=adminDAO.reservation(r);
		if(n!=0){
			out.println("record insertion sucessfully");
			logger.info("record insertion sucessfully");
			RequestDispatcher rd=request.getRequestDispatcher("./adreservation.jsp");
			rd.include(request, response);
			
		}else{
			out.println("record insertion failed...please try again");
			logger.info("record insertion failed...please try again");
			RequestDispatcher rd=request.getRequestDispatcher("./adreservation.jsp");
			rd.include(request, response);
			
		}
	}

}
