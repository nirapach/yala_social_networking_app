package com.registration;

public class ProfilePicAction {

	private String name,uploadFileFileName;
	User loggedUser;

	public User getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	public String execute()
	{
		boolean statusReceived =  RegisterDao.checkPicExists(name);
		if(!statusReceived)
			uploadFileFileName = "noImage";
		return "success";
	}
}
