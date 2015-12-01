package com.application.BO;

import java.util.ArrayList;
import java.util.Random;
import com.application.Dao.GroupDao;
import com.application.constants.AppConstants;
import com.application.utils.StringUtils;
import com.group.item.Group;
import com.registration.User;

public class GroupBO {

	public static Group	CreateGroup(Group group) {
		
		String groupId = GroupDao.GetGroupId(group);
		
		if(!StringUtils.IsNullOrEmpty(groupId)) {
			group.setGroupId(groupId);
			return group.setSuccess(); //group.setError(AppConstants.ERROR_GROUP_EXISTS);
		}
		
		group.setGroupId(Integer.toString(new Random().nextInt(10000000)));
		
		User usr = new User();
		usr.setUserName(group.getCreator());
		group.getGroupMembers().add(usr);
		
		group = GroupDao.CreateGroup(group);
		
		if(group != null) {
			GroupDao.AddMembers(group);
		}
		
		return group == null ? new Group().setError("Error") : group.setSuccess();
	}
	
	public static Group GetGroupMembers(Group group) {
		ArrayList<User> members = GroupDao.GetGroupMembers(group);
		group.setGroupMembers(members);
		return members.size() > 0 ? group.setSuccess() : group.setError(AppConstants.ERROR_MEMBER_RETRIEVAL);
	}
	
	public static Group GetGroupDetails(Group group) {
		group = GroupDao.GetGroup(group);
		if(group != null) {
			group.setGroupMembers(GroupDao.GetGroupMembers(group));
		}
		return group == null ? new Group().setError(AppConstants.ERROR_GROUP_NOT_EXISTS) : group.setSuccess();
	}
	
	public static boolean DeleteGroup(Group group) {
		
		return GroupDao.DeleteGroup(group);
	}
}
