package com.space.dao;

import com.space.bean.Reservations;
/**
 * This is the Admin DAO interface.It is used to access the objects from database.
 *
 */
public interface AdminDAO {
	 
	//admin reservation and cancellation
	public int reservation(Reservations reservation);
	public int cancelation(Reservations reservation);
	public String login(String userName, String passWord);
	

}
