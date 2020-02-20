package com.space.bean;

/**
 * This is the Location bean class. A bean class Encapsulates many objects into one object to reusable the objects.
 *  Here OOPS concept Encapsulation is used.
 * 
 */

public class Location {

	private int locationid;
	private String locationname;
	public Location(int locationid, String locationname) {
		this.locationid = locationid;
		this.locationname = locationname;
	}
	public Location() {
		// TODO Auto-generated constructor stub
	}
	public int getLocationid() {
		return locationid;
	}
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	public String getLocationname() {
		return locationname;
	}
	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}
	
	
	
	
}
