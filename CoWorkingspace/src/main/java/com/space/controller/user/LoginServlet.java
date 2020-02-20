package com.space.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.space.bean.Userdetails;
import com.space.daoimpl.UserDAOimpl;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(LoginServlet.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			Userdetails user = new Userdetails();
			UserDAOimpl userDAO = new UserDAOimpl();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			String type = userDAO.login(user.getUsername(), user.getPassword());
			HttpSession session = request.getSession();
			session.setAttribute("un", user.getUsername());
			session.setAttribute("pass", user.getPassword() );
			
			try {
				if(type.equalsIgnoreCase("User")){
					session.setAttribute("un", user.getUsername());
					session.setAttribute("pass", user.getPassword());
					//session.setMaxInactiveInterval(20);
					
					RequestDispatcher rd = request.getRequestDispatcher("./User.jsp");
					rd.forward(request, response);
				}
				
				else{
					out.println("Invalid UserName/ PassWord.Please try again....");
					logger.info("Invalid UserName/PassWord.Please try again.....");
					RequestDispatcher rd = request.getRequestDispatcher("./login.html");
					rd.include(request, response);
				}
			} catch (NullPointerException e) {
				out.println("Invalid UserName/ PassWord.Please try again....");
				RequestDispatcher rd = request.getRequestDispatcher("./login.html");
				rd.include(request, response);
			}
		
		
		}

}
