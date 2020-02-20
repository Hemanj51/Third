package com.space.bean;

/**
 * This is the Userdetails bean class. A bean class Encapsulates many objects into one object to reusable the objects.
 * Here OOPS concept Encapsulation is used.
 *
 */

public class Userdetails {
	
	private int userid;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String emailid;
	private long mobile;
	private String type;
	private String status;
	public Userdetails(int userid, String firstname, String lastname, String username, String password, String emailid,
			long mobile, String type, String status) {
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.emailid = emailid;
		this.mobile = mobile;
		this.type = type;
		this.status = status;
	}
	public Userdetails() {
		// TODO Auto-generated constructor stub
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
