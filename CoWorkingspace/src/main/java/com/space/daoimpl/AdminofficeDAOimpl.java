package com.space.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.space.bean.Office;
import com.space.dao.AdminofficeDAO;
import com.space.db.SpaceDBUtil;

/**
 * 
 *This is the Admin OfficeDAO Implementation class.
 * Here implementation is provided for the unimplemented methods provided by AdminofficeDAO interface
 *
 */

public class AdminofficeDAOimpl implements AdminofficeDAO {
	 Connection con = SpaceDBUtil.getConnection();
	    PreparedStatement ps = null;
	    /**
		 * This is the addOffice method.Here we add the data to the fields provided by the bean class.
	     * Exceptions are used for the normal flow of execution.
		 */
		
	    final static Logger logger=Logger.getLogger(AdminofficeDAOimpl.class);
	
	public int addOffice(Office office) {
		int n=0;
		try {
			logger.info("Add office method called");
			ps=con.prepareStatement("insert into office(officename,officeprice,branchid,seats) values(?,?,?,?)");
			logger.info("Add office method prepared statement called");
			ps.setString(1, office.getOfficename());
			ps.setDouble(2, office.getOfficeprice());
			ps.setInt(3, office.getBranchid());
			ps.setInt(4, office.getSeats());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
		
	}
	/**
	 * This is the viewOffices method.It displays the particular office information based on officeid.
	 */

	public Office viewOffices(int officeid) {
	       Office o =new Office();
	       try {
	    	   logger.info("View office method called");
			ps=con.prepareStatement("select * form office where officeid=?");
			logger.info("View office method prepared statement called");  
			   ps.setInt(1, officeid);
			   ResultSet rs =ps.executeQuery();
			   while(rs.next()) {
				   o.setOfficeid(rs.getInt(1));
				   o.setOfficename(rs.getString(2));
				   o.setOfficeprice(rs.getDouble(3));
				   o.setBranchid(rs.getInt(4));
				   o.setSeats(rs.getInt(5));
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
	       
		return o;
	}
	/**
	 * This is the viewAllOffices method.It is used to display the list of office information.
	 */
	public List<Office> viewAllOffices() {
		List<Office> office =new ArrayList<Office>();
		Office o= new Office();
		try {
			logger.info("View all offices method called");
			ps=con.prepareStatement("select * form office");
			logger.info("View all offices prepared statement called");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				   o.setOfficeid(rs.getInt(1));
				   o.setOfficename(rs.getString(2));
				   o.setOfficeprice(rs.getDouble(3));
				   o.setBranchid(rs.getInt(4));
				   o.setSeats(rs.getInt(5));
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return office;
	}
	/**
	 * This is the updateOffice method.It updates the office information based on officeid.
	 */
	public int updateOffice(int officeid, Office office) {
		int n=0;
		try {
			logger.info("Update office method called");
			ps=con.prepareStatement("update office set officename=?,officeprice=?,branchid=?,seats=? where officeid=?");
			logger.info("Update office prepared statement called");
			ps.setString(1, office.getOfficename());
			ps.setDouble(2, office.getOfficeprice());
			ps.setInt(3, office.getBranchid());
			ps.setInt(4, office.getSeats());
			ps.setInt(5, officeid);
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
		
		
	}
	/**
	 * This is the deleteOffice method.It deletes the particular office data based on officeid.
	 * It doesn't deletes the data from the database.It shows the status Inactive
	 */

	public int deleteOffice(int officeid) {
	      int n=0;
	      try {
	    	  logger.info("Delete office method called");
			ps=con.prepareStatement("detele form office where officeid=?");
			logger.info("Delete office prepared statement called");
			  ps.setInt(1, officeid);
			  n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
	      return n;
	      
		
	}
	

}