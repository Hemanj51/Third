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

/**
 * Servlet implementation class Cancelation
 */
public class Cancelation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cancelation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	 final static Logger logger=Logger.getLogger(Cancelation.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Reservations r = new Reservations();
		AdminDAOimpl adminDAO = new AdminDAOimpl();
	    r.setReservationid(Integer.parseInt(request.getParameter("reservationid")));
		r.setStartdate(request.getParameter("startdate"));
		r.setEnddate(request.getParameter("enddate"));
		r.setBranchid(Integer.parseInt(request.getParameter("branchid")));
		r.setOfficeid(Integer.parseInt(request.getParameter("officeid")));
		r.setUserid(Integer.parseInt(request.getParameter("userid")));
		r.setBookedseats(Integer.parseInt(request.getParameter("bookedseats")));
		int n = adminDAO.cancelation(r);
		if (n != 0) {
			out.println("cancellation done successfully");
			logger.info("cancellation done successfully");
			RequestDispatcher rd = request.getRequestDispatcher("./adreservation.jsp");
			rd.include(request, response);

		} else {
			out.println("cancellation failed...please try again");
			logger.info("cancellation failed...please try again");
			RequestDispatcher rd = request.getRequestDispatcher("./adcancelation.jsp");
			rd.include(request, response);

		}

	}
}
