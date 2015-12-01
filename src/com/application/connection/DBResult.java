package com.application.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.group.item.Group;
import com.registration.User;

public class DBResult {

	public static boolean runQuery(String sql, String[] params) {
		
		boolean status = false;
		Connection con = null;
		PreparedStatement ps;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			
			for(int i = 0; i < params.length; i++)
				ps.setString(i+1, params[i]);
			
			status = !ps.execute();
			
		} catch(Exception e) {
			status = false;
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return status;
	}
	
public static boolean runQuery(String sql, String[][] params) {
		
		boolean status = false;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			
			for(int i = 0; i < params.length; i++) {
				for(int j = 0; j < params[i].length; j++) {
					ps.setString(j+1, params[i][j]);
				}
				status = !ps.execute();
			}
			
		} catch(Exception e) {
			status = false;
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return status;
	}
	
	public static Group runQueryReturnGroup(String sql, String[] params) {
		
		Group result = null;
		Connection con = null;
		PreparedStatement ps;
		ResultSet resultSet = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			
			for(int i = 0; i < params.length; i++)
				ps.setString(i+1, params[i]);
			
			resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				result = new Group();
				result.setGroupId(resultSet.getString("Group_ID"));
				result.setGroupName(resultSet.getString("Group_Name"));
				result.setGroupPrivacy(resultSet.getString("Group_Privacy"));
				result.setCreator(resultSet.getString("Group_Creator"));
				result.setProfilePic(resultSet.getString("Group_Profile_PIC"));
			}
			
		} catch(Exception e) {
			result = null;
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
public static ArrayList<User> runQueryReturnUsers(String sql, String[] params) {
		
		ArrayList<User> result = null;
		User user;
		Connection con = null;
		PreparedStatement ps;
		ResultSet resultSet = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			
			for(int i = 0; i < params.length; i++)
				ps.setString(i+1, params[i]);
			
			resultSet = ps.executeQuery();
			
			result = new ArrayList<User>();
			
			while(resultSet.next()) {
				user = new User();
				user.setUserName(resultSet.getString("User_Name"));
				user.setE_mail_ID(resultSet.getString("E_mail_ID"));
				user.setFull_Name(resultSet.getString("Full_Name"));
				result.add(user);
			}
			
		} catch(Exception e) {
			result = null;
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
	
	public static String runQueryReturnString(String sql, String[] params) {
		
		String result = null;
		Connection con = null;
		PreparedStatement ps;
		ResultSet resultSet = null;
		
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(sql);
			
			for(int i = 0; i < params.length; i++)
				ps.setString(i+1, params[i]);
			
			resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				result = resultSet.getString(1);
			}
			
		} catch(Exception e) {
			result = null;
			e.printStackTrace();
		} finally {
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
}
