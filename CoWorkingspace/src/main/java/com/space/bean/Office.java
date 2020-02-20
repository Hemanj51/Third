package com.space.bean;

/**
 * This is the Office bean class. A bean class Encapsulates many objects into one object to reusable the objects.
 * Here OOPS concept Encapsulation is used.
 *
 */

public class Office {
	
	private int officeid;
	private String officename;
	private double officeprice;
	private int branchid;
	private int seats;
	
	public void Customer() {}

	public Office(int officeid, String officename, double officeprice, int branchid, int seats) {
		this.officeid = officeid;
		this.officename = officename;
		this.officeprice = officeprice;
		this.branchid = branchid;
		this.seats = seats;
	}

	public Office() {
		// TODO Auto-generated constructor stub
	}

	public int getOfficeid() {
		return officeid;
	}

	public void setOfficeid(int officeid) {
		this.officeid = officeid;
	}

	public String getOfficename() {
		return officename;
	}

	public void setOfficename(String officename) {
		this.officename = officename;
	}

	public double getOfficeprice() {
		return officeprice;
	}

	public void setOfficeprice(double officeprice) {
		this.officeprice = officeprice;
	}

	public int getBranchid() {
		return branchid;
	}

	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	

}
