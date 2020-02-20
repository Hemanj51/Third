package com.space.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.space.bean.Userdetails;
import com.space.daoimpl.UserDAOimpl;
/**
 * Servlet implementation class ForgotServlet
 */
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    final static Logger logger=Logger.getLogger(ForgotServlet.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Userdetails user = new Userdetails();
		UserDAOimpl userDAO = new UserDAOimpl();
		user.setUsername(request.getParameter("username"));
		user.setEmailid(request.getParameter("emailid"));
		String passWord = userDAO.forgot(user.getUsername(), user.getEmailid());
		if(passWord!=null)
		{
			//===========================
			//mail functionality start
			//==========================
			// Recipient's email ID needs to be mentioned.
	        String to = user.getEmailid();

	        // Sender's email ID needs to be mentioned
	        String from = "rajeshwaribabbadhi@gmail.com";

	        // Assuming you are sending email from through gmails smtp
	        String host = "smtp.gmail.com";

	        // Get system properties
	        Properties properties = System.getProperties();

	        // Setup mail server
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");

	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

	            protected PasswordAuthentication getPasswordAuthentication() {

	                return new PasswordAuthentication("chandra.javafullstack@gmail.com", "Charan123$");

	            }

	        });

	        // Used to debug SMTP issues
	        session.setDebug(true);

	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: header field
	            message.setSubject("Regarding Your Forgot PassWord");

	            // Now set the actual message
	            message.setText("Hello This is your forgot PassWord  "  +passWord+"");

	            System.out.println("sending...");
	            // Send message
	            Transport.send(message);
	            System.out.println("Sent message successfully....");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
			//==========================
			//ending mail functionality 
			//=========================
			out.println("Your PassWord is sent to registered mail  ");
			logger.info("Your Password is sent to registered mail   ");
			RequestDispatcher rd = request.getRequestDispatcher("./login.html");
			rd.include(request, response);
		}else{
			out.println("User Not Found.Please register and continue....");
			logger.info("User not Found . Please register and continue...");
			RequestDispatcher rd = request.getRequestDispatcher("./login.html");
			rd.include(request, response);
		}
	}

}

	