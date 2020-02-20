
package com.space.db;
/**
 * This is the SpaceDBUtil class.It is used to access the database properties for connection.
 *
 */
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class SpaceDBUtil {
		public static Connection con=null;
		
		public static Connection getConnection(){
		try {
			File f=new File("C:\\Users\\heman\\Downloads\\CoWorkSpace8\\CoWorkingspace\\src\\main\\resources\\db.properties");
			FileInputStream fis=new FileInputStream(f);
			Properties p=new Properties();
			p.load(fis);
			Class.forName(p.getProperty("driver"));
			con=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("pass"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		}

	}

