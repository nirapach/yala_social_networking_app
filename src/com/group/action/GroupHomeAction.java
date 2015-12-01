package com.group.action;

import com.application.BO.GroupBO;
import com.application.Dao.GroupDao;
import com.application.constants.AppConstants;
import com.application.utils.StringUtils;
import com.group.item.Group;
import com.opensymphony.xwork2.ActionSupport;

public class GroupHomeAction extends ActionSupport{

	private Group group;
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String execute() {
		return AppConstants.SUCCESS;
	}
	
	public String GetGroupMembers() {
		return GroupBO.GetGroupMembers(group).result.getStatus();
	}
	
	public String GetGroupDetails() {
		return GroupBO.GetGroupDetails(group).result.getStatus();
	}
	
	public String DeleteGroup() {
		return GroupBO.DeleteGroup(group) ? AppConstants.SUCCESS : AppConstants.ERROR;
	}
}
