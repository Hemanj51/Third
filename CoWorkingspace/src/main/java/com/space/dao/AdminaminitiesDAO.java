package com.space.dao;

import java.util.List;

import com.space.bean.Amenities;
/**
 * This is the Admin Amenities DAO interface.It is used to access the objects from database.
 * 
 */
public interface AdminaminitiesDAO {
	
	//Amenities DAO interface
		public int addAmenities(Amenities amenities);
		public Amenities viewAmenities(int amenityid);
		public List<Amenities> viewAllAmenities();
		public int updateAmenities(int amenityhid,Amenities amenities);
		public int deleteAmenities(int amenityid);

}
