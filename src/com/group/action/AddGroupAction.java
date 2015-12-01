package com.group.action;

import java.util.ArrayList;
import java.util.List;

import com.application.BO.GroupBO;
import com.application.constants.AppConstants;
import com.controls.radiobutton.RadioButtonItem;
import com.group.item.Group;
import com.opensymphony.xwork2.ActionSupport;

public class AddGroupAction extends ActionSupport {
	
	private List<RadioButtonItem> privacy;
	private Group group;
	
	public AddGroupAction() {
		
		privacy = new ArrayList<RadioButtonItem>();
		privacy.add(new RadioButtonItem(AppConstants.RADIO_KEY_OPEN,   AppConstants.RADIO_VAL_OPEN));
		privacy.add(new RadioButtonItem(AppConstants.RADIO_KEY_CLOSED, AppConstants.RADIO_VAL_CLOSED));
		privacy.add(new RadioButtonItem(AppConstants.RADIO_KEY_SECRET, AppConstants.RADIO_VAL_SECRET));
	}
	
	public List<RadioButtonItem> getPrivacy() {
		return privacy;
	}

	public void setPrivacy(List<RadioButtonItem> privacy) {
		this.privacy = privacy;
	}

	public String getDefaultPrivacySetting() {
		return AppConstants.RADIO_KEY_OPEN;
	}
	
	public String execute() {
		return AppConstants.SUCCESS;
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public String CreateGroup() {
		
		group = GroupBO.CreateGroup(group);
		
		if(group == null) 
			return AppConstants.ERROR;
		
		return group.result.getStatus();
	}
}
