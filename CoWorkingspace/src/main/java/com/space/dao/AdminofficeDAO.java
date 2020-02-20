package com.space.dao;

import java.util.List;

import com.space.bean.Office;

/** 
 *This is the Admin OfficeDAO interface.It is used to access the objects from database.
 */

public interface AdminofficeDAO {
	
	//office dao interface
	public int addOffice(Office office);
	public Office viewOffices(int officeid);
	public List<Office> viewAllOffices();
	public int updateOffice(int officeid,Office office);
	public int deleteOffice(int officeid);

}
