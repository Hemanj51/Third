package com.space.bean;

import java.sql.Date;

/**
 * This is the Reservations bean class. A bean class Encapsulates many objects into one object to reusable the objects.
 * Here OOPS concept Encapsulation is used.
 *
 */
public class Reservations {
	
	private int reservationid;
	private String startdate;
	private String enddate;
	private int officeid;
	private int branchid;
	private int userid;
	private double totalprice;
	private String[] amenityid;
	private int bookedseats;
	public Reservations(int reservationid, String startdate, String enddate, int officeid, int branchid, int userid,
			double totalprice, String[] amenityid,int bookedseats) {
		
		this.reservationid = reservationid;
		this.startdate = startdate;
		this.enddate = enddate;
		this.officeid = officeid;
		this.branchid = branchid;
		this.userid = userid;
		this.totalprice = totalprice;
		this.amenityid = amenityid;
		this.bookedseats=bookedseats;
	}
	public Reservations() {
		// TODO Auto-generated constructor stub
	}
	public int getReservationid() {
		return reservationid;
	}
	public void setReservationid(int reservationid) {
		this.reservationid = reservationid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public int getOfficeid() {
		return officeid;
	}
	public void setOfficeid(int officeid) {
		this.officeid = officeid;
	}
	
	public int getBranchid() {
		return branchid;
	}
	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public String[] getAmenityid() {
		return amenityid;
	}
	public void setAmenityid(String[] amenityid) {
		this.amenityid = amenityid;
	}
	
	public void setBookedseats(int bookedseats) {
		this.bookedseats = bookedseats;
	}
	public int getBookedseats() {
		// TODO Auto-generated method stub
		return bookedseats;
	}
	
	
	

}
