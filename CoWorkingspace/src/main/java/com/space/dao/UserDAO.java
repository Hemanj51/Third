package com.space.dao;

import com.space.bean.Userdetails;
import com.space.bean.Reservations;
/** 
 *This is the User DAO interface.It is used to access the objects from database.
 */

public interface UserDAO {
	
	public String login(String username,String password);
	public int register(Userdetails user);
	public String forgot(String username,String emailid);
	public String search(String locationname);
	public int reservation(Reservations reservation);
	public int cancelation(Reservations reservation);

}
