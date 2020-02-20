package com.space.dao;

import java.util.List;

import com.space.bean.Branch;
import com.space.bean.Location;
/**
 * This is the Admin LocationDAO interface.It is used to access the objects from database.
 *
 */

public interface AdminlocationDAO {
	
	//Location DAO interface
	public int addlocation(Location location);
	public Location viewLocation(int locationid);
	public List<Location> viewAlllocations();
	public int updateLocation(int locationid,Location location);
	public int deleteLocation(int locationid);
   

}



















