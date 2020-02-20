package com.space.controller.adminaminities;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.space.bean.Amenities;
import com.space.daoimpl.AdminaminitiesDAOimpl;

/**
 * Servlet implementation class Addamenities
 */
public class Addamenities extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addamenities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(Addamenities.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Amenities a = new Amenities();
		AdminaminitiesDAOimpl amenitiesDAO = new AdminaminitiesDAOimpl();
		a.setAmenitytype(request.getParameter("amenitytype"));
		a.setAmenityprice(Double.parseDouble(request.getParameter("amenityprice")));
		a.setOfficeid(Integer.parseInt(request.getParameter("officeid")));
		int n=amenitiesDAO.addAmenities(a);
		if(n!=0){
			out.println("Successfully One Amenity Inserted.");
			logger.info("successfully one amenity added");
			RequestDispatcher rd = request.getRequestDispatcher("./adamenities.jsp");
			rd.include(request, response);
		}else{
			out.println("Record Insertion Failed.Please try again.");
			logger.info("Record Insertion Failed.Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("./adamenities.jsp");
			rd.include(request, response);
		}
	}

}
