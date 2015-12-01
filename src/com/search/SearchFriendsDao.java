package com.search;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.application.connection.DBConnection;

public class SearchFriendsDao {
	   static List<String> searchednames= new ArrayList<String>();
	   static List<String> searchednamesreceiver= new ArrayList<String>();
	   static String username;
	   static String usernamereceiver;
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		static final String DB_URL = "jdbc:mysql://localhost:3306/se_p566";
		// Database credentials
		static final String USER = "root";
		static final String PASS = "mechanical";
	   
   public static boolean Search(SearchFriendsAction s){
			boolean status = true;
			try{
				Class.forName(JDBC_DRIVER);
				Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement ps=con.prepareStatement("select * from account_information  where Full_Name = ?");
				ps.setString(1,s.getName());
				//ps.setString(2,r.getPassword());
				
				ResultSet rs=ps.executeQuery();
				if("".equals(s.getName())){
					  System.out.println("Please Enter the Name");
					  return false;
				}
				int no = 0;
				searchednames.clear();
				while(rs.next()){
					no++;
					SearchFriendsAction searchfriendsaction=new SearchFriendsAction();
					searchfriendsaction.setName(rs.getString("Full_Name"));
					username=rs.getString("Full_Name");
					searchednames.add(username);
					
					System.out.println("username "+username);
						//listname=username;
					}
				//System.out.println("Names "+searchednames);
				if(no <= 0){
					 System.out.println("User Not in Database");
					  return false;
				}
				
				con.close();
			}catch(Exception e){e.printStackTrace();}
			return status;
		}
   public static int save(SearchFriendsAction s){
 		int status=0;
 		try{
 			Connection con = DBConnection.getConnection();
 			PreparedStatement ps = null;
 			String[] names = s.getName().split(", ");
 			for(String name: names ){
	 			ps=con.prepareStatement("insert into temporaryfriends values(?, 'manokris')");		
	 			ps.setString(1,name);
	 			status=ps.executeUpdate();
 			}
 			con.close();
 		
 		}catch(Exception e){e.printStackTrace();}
 		return status;
 	}	
   
   public static boolean checkfriends(SearchFriendsAction s){
		boolean status = true;
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from temporaryfriends where User_Name_Receiver = 'manokris'");
			//ps.setString(1,s.getName());
			//ps.setString(2,r.getPassword());
			
			ResultSet rs=ps.executeQuery();
			/*if("".equals(s.getName())){
				  System.out.println("Please Enter the Name");
				  return false;
			}*/
			int no = 0;
			searchednamesreceiver.clear();
			while(rs.next()){
				no++;
				SearchFriendsAction searchfriendsaction=new SearchFriendsAction();
				searchfriendsaction.setName(rs.getString("User_Name_Sender"));
				usernamereceiver=rs.getString("User_Name_Sender");
				searchednamesreceiver.add(usernamereceiver);
				
					//System.out.println("username "+username);
					//listname=username;
				}
			//System.out.println("Names "+searchednames);
			if(no <= 0){
				 System.out.println("User Not in Database");
				  return false;
			}
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		return status;
	}
   
   public static int approve(SearchFriendsAction s){
		int status=0;
		try{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = null;
			PreparedStatement ps1=null;
			String[] names = s.getName().split(", ");
			for(String name: names ){
				ps1=con.prepareStatement("delete from temporaryfriends where User_Name_Sender=? and User_Name_Receiver= 'manokris'");
	 			ps=con.prepareStatement("insert into friendship values(?, 'manokris')");	
	 			ps.setString(1,name);
	 			ps1.setString(1, name);
	 			
	 			
	 			//ps=con.prepareStatement("delete from temporaryfriends(?, 'manokris')");
	 			status=ps.executeUpdate();
	 			status= ps1.executeUpdate();
			}
			con.close();
		
		}catch(Exception e){e.printStackTrace();}
		return status;
	}
   
   public static int reject(SearchFriendsAction s){
		int status=0;
		try{
			Connection con = DBConnection.getConnection();
			//PreparedStatement ps = null;
			String[] names = s.getName().split(", ");
			for(String name: names ){
	 			//ps=con.prepareStatement("insert into friendship values(?, 'manokris')");	
				PreparedStatement ps=con.prepareStatement("delete from temporaryfriends where User_Name_Sender=? and User_Name_Receiver= 'manokris'");
	 			ps.setString(1,name);
	 			
	 			status=ps.executeUpdate();
			}
			con.close();
		
		}catch(Exception e){e.printStackTrace();}
		return status;
	}
   
   
   
}		
 		