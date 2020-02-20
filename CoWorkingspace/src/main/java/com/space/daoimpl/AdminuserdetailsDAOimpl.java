package com.space.daoimpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.space.bean.Userdetails;
import com.space.dao.AdminuserdetailsDAO;
import com.space.db.SpaceDBUtil;
/**
 * This is the AdminUserdetails Implementation class.
 *Here implementation is provided for the unimplemented methods  provided by AdminUserdetailsDAO interface
 *
 */

public class AdminuserdetailsDAOimpl implements AdminuserdetailsDAO {
	  Connection con = SpaceDBUtil.getConnection();
	    PreparedStatement ps = null;
	    /**
	     * This is the addUserdetails method.
	     * Admin will add the user details.
	     * Exceptions are used for the normal flow of execution.
	     */
	    final static Logger logger=Logger.getLogger(AdminuserdetailsDAOimpl.class);
	public int addUserdetails(Userdetails user) {
		int n =0;
		
		try {
			logger.info("Add Userdetails method callled");
			ps=con.prepareStatement("insert into userdetails(firstname,lastname,username,password,emailid,mobile,type,status) values(?,?,?,?,?,?,?,?)");
			logger.info("Add userdetails prepared statement called");
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4,user.getPassword());
			ps.setString(5, user.getEmailid());
			ps.setLong(6, user.getMobile());
			ps.setString(7, "User");
			ps.setString(8, "Active");
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
		
	
		
	}
	/**
	 * This is the viewUserdetails method.It displays the particular data of Userdetails based on userid.
	 */

	public Userdetails viewUserdetails(int userid) {
		Userdetails user = new Userdetails();
		try {
			logger.info("View Userdetails method called");
			ps=con.prepareStatement("select * form userdetails where userid=? and status=?");
			logger.info("View UserDetails prepared statement called");
			ps.setInt(1, userid);
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setUserid(rs.getInt(1));
				user.setFirstname(rs.getString(2));
				user.setLastname(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setEmailid(rs.getString(6));
				user.setMobile(rs.getLong(7));
				user.setType("type");
				user.setStatus("status");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		
		
		return user;
	}
	/**
	 * This is the viewAllUserdetails method.It displays the list of Userdetails.
	 */

	public List<Userdetails> viewAllUserdetails() {
		List<Userdetails> useres =new ArrayList<Userdetails>();
		Userdetails u =new Userdetails();
		try {
			logger.info("View All UserDetails method called");
			ps=con.prepareStatement("select *from userdetails where status=?");
			logger.info("View all userdetails prepared statement called");
			ps.setString(1, "Active");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				u.setUserid(rs.getInt(1));
				u.setFirstname(rs.getString(2));
				u.setLastname(rs.getString(3));
				u.setUsername(rs.getString(4));
				u.setPassword(rs.getString(5));
				u.setEmailid(rs.getString(6));
				u.setMobile(rs.getLong(7));
				u.setType("type");
				u.setStatus("status");
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return useres;
	}

	/**
	 * This is the updateUserdetails method.It updates the userdetails based on userid
	 */

	public int updateUserdetails(int userid, Userdetails user) {
		int n=0;
		try {
			logger.info("Update userdetails method called");
			ps=con.prepareStatement("update userdetails set firstname=?,lastname=?,username=?,password=?,emailid=?,mobile=?,type=?,status=? where userid=?");
			logger.info("Update userdetails prepared statement called");
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getUsername());
			ps.setString(4,user.getPassword());
			ps.setString(4, user.getEmailid());
			ps.setLong(6, user.getMobile());
			ps.setString(7, "User");
			ps.setString(8, "Active");
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
	
		
	}
	
	/**
	 * This is the deleteUserdetails method.It deletes the userdetails based on userid.
	 * It doesn't deletes the data from database.It shows the status Inactive.
	 */

	public int deleteUserdetails(int userid) {
		int n=0;
		try {
			logger.info("Delete UserDetails method called");
			ps=con.prepareStatement("update bus set status='Inactive' where userid=? ");
			logger.info("Delete UserDetails prepared statement called");
			ps.setInt(1, userid);
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
		// TODO Auto-generated method stub
		
	}

	

}
