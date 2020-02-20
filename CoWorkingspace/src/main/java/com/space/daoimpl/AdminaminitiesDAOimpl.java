package com.space.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.space.bean.Amenities;
import com.space.dao.AdminaminitiesDAO;
import com.space.db.SpaceDBUtil;
/**
 * @author-j51
 * This is the Admin AminitiesDAO Implementataion class.
 * Here implementation is provided for the unimpelemented methods  provided by AdminaminitiesDAO interface
 *
 */
public class AdminaminitiesDAOimpl implements AdminaminitiesDAO {
	Connection con=SpaceDBUtil.getConnection();
	PreparedStatement ps=null;
	final static Logger logger=Logger.getLogger(AdminaminitiesDAOimpl.class);
	/**
	 *  @author-j51
	 * This is the addAmenities method.Here we add the data to the fields provided by the bean class.
	 * Exceptions are used for the normal flow of execution.
	 * @param input amenity id
	 */

	public int addAmenities(Amenities amenities) {
		int n=0;
		try {
			logger.info("Add Amenities method called");
			ps=con.prepareStatement("insert into amenities(amenitytype,amenityprice,officeid) values(?,?,?)");
			logger.info("Add Amenities method prepared statement called");
			ps.setString(1, amenities.getAmenitytype());
			ps.setDouble(2, amenities.getAmenityprice());
			ps.setInt(3, amenities.getOfficeid());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
	}
	/**
	 * @author j51
	 * This is the viewAmenities method.It displays the particular amenity information based on amenityid.
	 *@param input aminity id
	 */

	public Amenities viewAmenities(int amenityid) {
		Amenities a= new Amenities();
		try {
			logger.info("View Amenities method called");
			ps=con.prepareStatement("select * form amenities where amenityid=?");
			logger.info("View Amenities method prepared statement called");
			ps.setInt(1, amenityid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				a.setAmenityid(rs.getInt(1));
				a.setAmenitytype(rs.getString(2));
				a.setAmenityprice(rs.getDouble(3));
				a.setOfficeid(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return a;
	}
	/**
	 * This is the viewAllAmenities method.It is used to display the list of Amenities information.
	 */

	public List<Amenities> viewAllAmenities() {
		List<Amenities> amenities=new ArrayList<Amenities>();
		try {
			logger.info("View All Amenities method called");
			ps=con.prepareStatement("select * from amenities");
			logger.info("View All Amenities prepared statement called");
			ResultSet rs=ps.executeQuery();
			Amenities amenity=null;
			while(rs.next()) {
				amenity=new Amenities();
				amenity.setAmenityid(rs.getInt(1));
				amenity.setAmenitytype(rs.getString(2));
				amenity.setAmenityprice(rs.getDouble(3));
				amenity.setOfficeid(rs.getInt(4));
				amenities.add(amenity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		
		return amenities;
	}
	/**
	 * This is the updateAmenities method.It updates the amenity information based on amenityid.
	 */
	public int updateAmenities(int amenityhid, Amenities amenities) {
		int n=0;
		try {
			logger.info("Update Amenities method called");
			ps=con.prepareStatement("update amenities set amenitytype=?,amenityprice=? where amenityid=?");
			logger.info("Update Amenities method prepared statement called");
			ps.setString(1, amenities.getAmenitytype());
			ps.setDouble(2, amenities.getAmenityprice());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
	}
	/**
	 * This is the deleteAmenities method.It deletes the particular amenity data based on amenity id.
	 * It doesn't deletes the data from the database.It shows the status Inactive.
	 */

	public int deleteAmenities(int amenityid) {
		int n=0;
		try {
			logger.info("Delete Amenities method called");
			ps=con.prepareStatement("delete from aminities where aminityid=?");
			logger.info("Delete Amenities prepared statement called");
			ps.setInt(1, amenityid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
	}
	
	
	

}
