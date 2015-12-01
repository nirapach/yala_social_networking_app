package com.application.Dao;

import java.util.ArrayList;
import java.util.Arrays;

import com.application.connection.DBResult;
import com.application.utils.StringUtils;
import com.group.item.Group;
import com.registration.User;

public class GroupDao {
	
	public static Group CreateGroup(Group group) {
		
		String sql = "INSERT INTO Groups(Group_ID, Group_Name, Group_Privacy, Time, " + 
										"Group_Profile_PIC, Group_Creator) " +
								 "VALUES(?, ?, ?, ?, ?, ?)";
		
		String[] params = { group.getGroupId(), group.getGroupName(), group.getGroupPrivacy(), 
							null, group.getProfilePic(), group.getCreator() };
		
		return DBResult.runQuery(sql, params) ? group.setSuccess() : null;
	}
	
	public static boolean DeleteGroup(Group group) {
		
		boolean result = false;
		String sql = "DELETE FROM Users_Groups WHERE Group_ID = ?";
		String[] params = { group.getGroupId() };
		
		result = DBResult.runQuery(sql, params);
		
		if(!result)
			return result;
		
		sql = "DELETE FROM Groups WHERE Group_ID = ?";
		
		return DBResult.runQuery(sql, params);
	}
	
	public static boolean AddMembers(Group group) {
		
		String sql = "INSERT INTO Users_Groups(User_Name, Group_ID) " +
						  "VALUES (?, ?) ";
		
		ArrayList<User> members = group.getGroupMembers();
		
		String params[][] = new String[members.size()][];
		
		for(int i = 0; i < members.size(); i++) {
			String param[] = new String[2];
			param[0] = members.get(i).getUserName();
			param[1] = group.getGroupId();
			params[i] = param;
		}
		
		return DBResult.runQuery(sql, params);
	}
	
	public static boolean UpdateGroup(Group group) {
		
		String sql = "UPDATE Groups " +
						"SET Group_Privacy = ?, " +
					  "WHERE Group_ID = ?";
		
		String[] params = { group.getGroupPrivacy(), group.getGroupId() };
		
		return DBResult.runQuery(sql, params);
	}
	
	public static Group GetGroup(Group group) {
		
		String sql = "SELECT Group_ID, Group_Name, Group_Privacy, Group_Creator, Group_Profile_PIC " + 
					   "FROM Groups " + 
					  "WHERE Group_ID = ?";
		String[] params = { group.getGroupId() };
		
		return DBResult.runQueryReturnGroup(sql, params);
	}
	
	public static boolean GroupExists(Group group) {
		
		String sql = "SELECT Group_ID " + 
					   "FROM Groups " + 
					  "WHERE Group_Name = ? " + 
					    "AND Creator = ?";
		
		String[] params = { group.getGroupName(), group.getCreator() };
		
		return DBResult.runQuery(sql, params);
	}
	
	public static String GetGroupId(Group group) {
		
		String sql = "SELECT Group_ID " + 
					   "FROM Groups " + 
					  "WHERE Group_Name = ? " + 
					    "AND Group_Creator = ?";
		
		String[] params = { group.getGroupName(), group.getCreator() };
		
		return DBResult.runQueryReturnString(sql, params);
	}
	
	public static ArrayList<User> GetGroupMembers(Group group) {
		
		String sql = "SELECT ai.User_Name, ai.E_mail_ID, ai.Full_Name  " +
					   "FROM account_information ai " +
					         "JOIN Users_Groups ug " + 
					            "ON ai.User_Name = ug.User_Name " +
					  "WHERE ug.Group_ID = ?";
		
		String[] params = { group.getGroupId() };
		
		return DBResult.runQueryReturnUsers(sql, params);
	}
}
