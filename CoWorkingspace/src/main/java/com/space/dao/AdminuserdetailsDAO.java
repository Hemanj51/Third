package com.space.dao;

import java.util.List;

import com.space.bean.Userdetails;

/**
 * This is the Admin UserdetailsDAO interface.It is used to access the objects from database.
 */



public interface AdminuserdetailsDAO {

	//userdetils dao interface
		public int addUserdetails(Userdetails user);
		public Userdetails viewUserdetails(int userid);
		public List<Userdetails> viewAllUserdetails();
		public int updateUserdetails(int userid,Userdetails user);
		public int deleteUserdetails(int userid);
}
