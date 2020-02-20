package com.space.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.space.bean.Reservations;
import com.space.dao.AdminDAO;
import com.space.db.SpaceDBUtil;

public class AdminDAOimpl implements AdminDAO {
	final static Logger logger=Logger.getLogger(AdminDAOimpl.class);
	Connection con = SpaceDBUtil.getConnection();
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	/**
	 * This is the reservation method.Admin will do reservation according to the user requirements.
	 * Based on office price and amenity price the totalprice will be calculated.
	 */

	public int reservation(Reservations reservation) {
		int n=0;
		try {
			logger.info("Reservation Method called");
			double oprice = 0,aprice =0; 
			int officeSeats=0;
			PreparedStatement ps1 = con.prepareStatement("select officeprice,seats from office where officeid=?");
			logger.info("office method Prepared statement called");
			ps1.setInt(1, reservation.getOfficeid());
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()){
				oprice = rs1.getDouble(1);
				officeSeats=rs1.getInt(2);
			}
			PreparedStatement ps2 = con.prepareStatement("select amenityprice from amenities where amenityid=?");
			logger.info("Amenity method called for amenity price");
			String[] amenities = reservation.getAmenityid();
			int size = amenities.length;
			for(int i=0;i<size;++i) {
			ps2.setInt(1,Integer.parseInt(amenities[i]));
			ResultSet rs2 = ps2.executeQuery();
			while(rs2.next()){
				aprice =aprice+ rs2.getDouble(1);
			}
			}
			ps = con.prepareStatement("insert into reservations(startdate,enddate,officeid, branchid, userid,totalprice,bookedseats) values(?,?,?,?,?,?,?)");
			logger.info("Reservation method Prepared statement method called");
			String sd = reservation.getStartdate();
			//Date d1 = new Date(Long.parseLong(sd));
			/*
			 * ps.setDate(1,new java.sql.Date(d1.getTime())); String ed =
			 * reservation.getEnddate(); Date d2 = new Date(Long.parseLong(ed));
			 * ps.setDate(2,new java.sql.Date(d2.getTime()));
			 */
			ps.setString(1, reservation.getStartdate());
			ps.setString(2, reservation.getEnddate());
			ps.setInt(3, reservation.getOfficeid());
			ps.setInt(4, reservation.getBranchid());
			ps.setInt(5, reservation.getUserid()); 
			ps.setDouble(6, reservation.getTotalprice());
			ps.setInt(7, reservation.getBookedseats());
			double amenityprice =0;
			double totalAmentiesPrice = 0;
			String[] amenties = reservation.getAmenityid();
			ResultSet rs3 = null;
			for(String a:amenties){
				PreparedStatement ps3 = con.prepareStatement("select amenityprice from amenities where amenityid=?");
				logger.info("Amenity method called for getting amenityprice");
				ps3.setInt(1, Integer.parseInt(a));
				rs3=ps3.executeQuery();
				rs3.next();
				amenityprice=rs3.getInt(1);
				totalAmentiesPrice+=amenityprice;
			}
			int sn = reservation.getBookedseats();
			System.out.println("sn"+sn);
			System.out.println("oprice"+oprice);
			//System.out.println("aprice"+aprice);
			System.out.println(totalAmentiesPrice);
			double totalprice = reservation.getBookedseats()*(oprice)+(totalAmentiesPrice);
			ps.setDouble(6, totalprice);
			
			n = ps.executeUpdate();
			if(n!=0){
				int updateSeats =officeSeats-reservation.getBookedseats();
				PreparedStatement ps3 = con.prepareStatement("update office set seats=? where officeid=?");
				logger.info("update office seats prepared statement called");
				ps3.setInt(1, updateSeats);
				ps3.setInt(2, reservation.getOfficeid());
				int result = ps3.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.info(e);
			e.printStackTrace();
		}
		return n;
		
	}
	/**
	 * This the admin cancelation method.Admin can cancel the reservation based on reservationid.
	 * After the cancelation of seats the seats are updated(added).
	 */

	public int cancelation(Reservations reservation) {
		int n=0;
		int seats=0;
		
		try {
			logger.info("Canceletaion method called");
			int officeseats=0;
			PreparedStatement ps6 = con.prepareStatement("select seats from office where officeid=?");
			logger.info("Office method prepared statement called for selecting seats");
			ps6.setInt(1, reservation.getOfficeid());
			ResultSet rss = ps6.executeQuery();
			rss.next();
			seats = rss.getInt(1);
			PreparedStatement ps4 = con.prepareStatement("update office set seats=? where officeid=?");
			logger.info("Update Office seats prepared statement called");
			ps4.setInt(1, seats);
			ps4.setInt(2, reservation.getOfficeid());
			int result = ps4.executeUpdate();
			if(result!=0){
				PreparedStatement ps5 = con.prepareStatement("delete from reservations where reservationid=?");
				logger.info("Delete reservation method called");
				ps5.setInt(1, reservation.getReservationid());
				int n1 = ps5.executeUpdate();
				if(n1!=0){
					System.out.println("Successfully Reservation canceled");
				}else{
					System.out.println("Updation Failed");
				}
			}else {
				System.out.println("cant delete");
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			e.printStackTrace();
		}
		return n;
	}
		
	/**
	 * This is the admin login method.For Admin authentication is must.
	 * Admin should login with username and password.
	 */
		public String login(String userName, String passWord) {
			String type=null;
			  try {
				  logger.info("Login method called");
				ps = con.prepareStatement("select type from userdetails where username=? and password=?");
				logger.info("Login method prepared statement called");
				ps.setString(1, userName);
				ps.setString(2, passWord);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					 type=rs.getString(1);
					
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error(e);
				e.printStackTrace();
			}
			return type;
		}
		
	}


	
