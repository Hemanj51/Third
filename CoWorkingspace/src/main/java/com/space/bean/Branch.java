package com.space.bean;


/**
 * This is the Branch bean class. A bean class Encapsulates many objects into one object to reusable the objects.
 *  Here OOPS concept Encapsulation is used.
 *
 */
public class Branch {
	private int branchid;
	private String branchname;
	private int locationid;
	public Branch(int branchid, String branchname,int locationid) {
		this.branchid = branchid;
		this.branchname = branchname;
		this.locationid = locationid;
	}
	public Branch() {
		// TODO Auto-generated constructor stub
	}
	public int getBranchid() {
		return branchid;
	}
	public void setBranchid(int branchid) {
		this.branchid = branchid;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public int getLocationid() {
		return locationid;
	}
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	
	
	

}
