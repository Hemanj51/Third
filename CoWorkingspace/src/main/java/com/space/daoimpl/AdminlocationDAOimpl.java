package com.space.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.space.bean.Branch;
import com.space.bean.Location;
import com.space.dao.AdminlocationDAO;
import com.space.db.SpaceDBUtil;

/**
 * 
 * This is the Admin LocationDAO Implementation class.
 * Here implementation is provided for the unimplemented methods provided by AdminlocationDAO interface
 */
public class AdminlocationDAOimpl implements AdminlocationDAO{

	final static Logger logger=Logger.getLogger(AdminlocationDAOimpl.class);
	Connection con=SpaceDBUtil.getConnection();
	PreparedStatement ps=null;
	/**
	 * This is the addLocation method.Here we add the data to the fields provided by the bean class.
     * Exceptions are used for the normal flow of execution.
	 */
	public int addlocation(Location location) {
		int n=0;
		try {
			logger.info("Add Location method called");
			ps=con.prepareStatement("insert into location(locationname) values(?)");
			logger.info("Add location prepared statement called");
			ps.setString(1, location.getLocationname());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
		
	}
	/**
	 * This is the viewLocation method.It displays the particular branch information based on locationid.
	 */

	public Location viewLocation(int locationid) {
		Location l= new Location();
		try {
			logger.info("View Location method called");
			ps=con.prepareStatement("select * form location where locationid=?");
			logger.info("View Location Prepared statement called");
			ps.setInt(1, locationid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				l.setLocationid(rs.getInt(1));
				l.setLocationname(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return l;
	}

	/**
	 * This is the viewAllLocation method.It is used to display the list of Location information.
	 */

	public List<Location> viewAlllocations() {
		List<Location> locations=new ArrayList<Location>();
		try {
			logger.info("View All locations method called");
			ps=con.prepareStatement("select * from location");
			logger.info("View All locations prepared statement called");
			ResultSet rs=ps.executeQuery();
			Location location=null;
			while(rs.next()) {
				location=new Location();
				location.setLocationid(rs.getInt(1));
				location.setLocationname(rs.getString(2));
				locations.add(location);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		
		return locations;
	}
	/**
	 * This is the updateLocation method.It updates the location information based on locationid.
	 */

	public int updateLocation(int locationid, Location location) {
		int n=0;
		try {
			logger.info("Update location method called");
			ps=con.prepareStatement("update location set locationname=? where locationid=?");
			logger.info("Update location prepared statement called");
			ps.setString(1, location.getLocationname());
			ps.setInt(2,locationid);
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
	}
	/**
	 * This is the deleteLocation method.It deletes the particular location data based on locationid.
	 * It doesn't deletes the data from the database.It shows the status Inactive.
	 */

	public int deleteLocation(int locationid) {
		int n=0;
		try {
			logger.info("Delete location method called");
			ps=con.prepareStatement("delete from location where locationid=?");
			logger.info("Delete location prepared statement called");
			ps.setInt(1, locationid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
	}

	
}
