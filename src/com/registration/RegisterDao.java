package com.registration;
import java.sql.*;

public class RegisterDao {

	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost:3306/se_p566";
	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "mechanical";
	   static String PRIVATE = "private";
	public static int save(RegisterAction r){
		int status=0;
		try{
			
			
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement ps=con.prepareStatement("insert into user_details values(?,?,?,?)");
			ps.setString(1,r.getName());
			ps.setString(4,r.getPassword());
			ps.setString(2,r.getEmail());
			ps.setString(3,r.getFull_name());
			
			status=ps.executeUpdate();
			
			if(status == 1)
			{
				try
				{
					PreparedStatement psAccount=con.prepareStatement("insert into account_information values(?,?,?,?,?,?,?)");
					psAccount.setString(1,r.getName());
					psAccount.setDate(4,new java.sql.Date (r.getDob().getTime()));
					psAccount.setString(2,r.getEmail());
					psAccount.setString(3,r.getFull_name());
					psAccount.setString(5,null);
					psAccount.setString(6,null);
					psAccount.setString(7,PRIVATE);
					
					status=psAccount.executeUpdate();
				}catch(Exception e){e.printStackTrace();}
			}
				
			con.close();
		
		}catch(Exception e){e.printStackTrace();}
		return status;
	}
	
	public static User Login(RegisterAction r){
		boolean status = false;
		User user;
		try{
			
			
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement ps=con.prepareStatement("SELECT ai.User_Name AS User_Name, " + 
															 "ai.E_mail_ID AS E_Mail_ID, " + 
															 "ai.Profile_Pic AS Profile_Pic, " +
															 "ai.Full_Name AS Full_Name, " +
															 "ai.Privacy_Setting AS Privacy_Setting " +
													    "FROM account_information ai " + 
													         "JOIN user_details ud " + 
													           "ON ai.User_Name = ud.User_Name " + 
													    "WHERE ai.User_Name = ? " + 
													      "AND ud.Password = ?");
			ps.setString(1,r.getName());
			ps.setString(2,r.getPassword());
			
			ResultSet rs = ps.executeQuery();
			user = new User();
			while(rs.next())
			{
				user.userName = rs.getString("User_Name");
				user.e_mail = rs.getString("E_mail_ID");
				user.img = rs.getString("Profile_Pic");
				user.Full_Name = rs.getString("Full_Name");
				user.privacySetting = rs.getString("Privacy_Setting");
				
			}
			
			con.close();
			return user;
		}catch(Exception e){e.printStackTrace();}
		return null;
	}
	public static boolean checkLoginExists(RegisterAction r){
		boolean status = false;
		try{
			
			
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement ps=con.prepareStatement("select * from user_details  where User_Name = ? OR E_mail_ID = ?");
			ps.setString(1,r.getName());
			ps.setString(2,r.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				System.out.println(rs.getString("User_Name"));
				status = false;
			}
				
			else
				status = true;
			con.close();
		
		}catch(Exception e){e.printStackTrace();}
		return status;
	}
	
	public static boolean savePicture(String user_name){
		boolean status = false;
		try{
			
			
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement ps=con.prepareStatement("update account_information set Profile_Pic = ?  where User_Name = ?");
			ps.setString(1,user_name);
			ps.setString(2,user_name);
			System.out.println(ps.toString());
			ps.execute();
			status = true;
			con.close();
		
		}catch(Exception e){e.printStackTrace();}
		return status;
	}
	
	public static boolean checkPicExists(String userName)
	{
		boolean status = false;
		try{
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			PreparedStatement ps=con.prepareStatement("select Profile_Pic from account_information where User_Name = ?");
			ps.setString(1,userName);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String profile_path =  rs.getString("Profile_Pic");
				if(profile_path != null && profile_path != "null")
				status = true;
				
			}
			con.close();
		
		}catch(Exception e){e.printStackTrace();}
		return status;
	}
}
