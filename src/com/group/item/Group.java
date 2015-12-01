package com.group.item;

import java.util.ArrayList;

import com.application.common.OperationResult;
import com.application.constants.AppConstants;
import com.opensymphony.xwork2.ActionSupport;
import com.registration.User;

public class Group extends ActionSupport {

	private String groupId;
	private String groupName;
	private String groupPrivacy;
	private ArrayList<User> groupMembers;
	private String time;
	private String creator;
	private String profilePic;
	public OperationResult result;
	
	public Group() {
		result = new OperationResult();
		groupMembers = new ArrayList<User>();
	}
	
	public Group setSuccess() {
		result.setSuccess();
		return this;
	}
	
	public Group setError(String errorMessage) {
		result.setError(errorMessage);
		return this;
	}

	public String getProfilePic() {
		return (profilePic == null) ? AppConstants.DEFAULT_GROUP_PIC : profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getGroupPrivacy() {
		return groupPrivacy;
	}
	
	public void setGroupPrivacy(String groupPrivacy) {
		this.groupPrivacy = groupPrivacy;
	}
	
	public ArrayList<User> getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(ArrayList<User> groupMembers) {
		this.groupMembers = groupMembers;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public String getCreator() {
		return creator == null ? "diviswan" : creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
}
