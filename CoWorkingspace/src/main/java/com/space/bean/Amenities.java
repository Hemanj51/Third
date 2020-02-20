package com.space.bean;

/**
 * This is the Amenities bean class. A bean class Encapsulates many objects into one object to reusable the objects.
 * Here OOPS concept Encapsulation is used.
 *
 */
public class Amenities {
	private int amenityid;
	private String amenitytype;
	private double amenityprice;
	private int officeid;
	public Amenities(int amenityid, String amenitytype, double amenityprice, int officeid) {
		this.amenityid = amenityid;
		this.amenitytype = amenitytype;
		this.amenityprice = amenityprice;
		this.officeid = officeid;
	}
	public Amenities() {
		// TODO Auto-generated constructor stub
	}
	public int getAmenityid() {
		return amenityid;
	}
	public void setAmenityid(int amenityid) {
		this.amenityid = amenityid;
	}
	public String getAmenitytype() {
		return amenitytype;
	}
	public void setAmenitytype(String amenitytype) {
		this.amenitytype = amenitytype;
	}
	public double getAmenityprice() {
		return amenityprice;
	}
	public void setAmenityprice(double amenityprice) {
		this.amenityprice = amenityprice;
	}
	public int getOfficeid() {
		return officeid;
	}
	public void setOfficeid(int officeid) {
		this.officeid = officeid;
	}
	
	
	

}
