package com.registration;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.io.FileUtils;
import com.opensymphony.xwork2.ActionSupport;
 


public class FileUploadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private User loggedUser;
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;	

	public User getLoggedUser() {
		return loggedUser;
	}
	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String execute()
	{
		try{
//		String filePath = "/profile/";  // Path where uploaded file will be stored
//       System.out.println("Server path:" + filePath); // check your path in console
//       File fileToCreate = new File(filePath, uploadFileFileName);// Create file name  same as original
//       //FileUtils.copyFile(uploadFile, fileToCreate); // Just copy temp file content tos this file
//       FileUtils.copyFile(uploadFile, new File(filePath + uploadFileFileName ));
		boolean linkStored = RegisterAction.SavePic(this.loggedUser.userName);
		if(linkStored)
		{
			File saveFilePath = new File("/home/dileep/Dileep/web_workspace/Yala/images/profile/" + loggedUser.userName+".jpg");
	          if (saveFilePath.exists())
	          {
	        	  saveFilePath.delete();
	          }
	          FileUtils.copyFile(uploadFile, saveFilePath);
	          Thread.sleep(10000);
	          uploadFileFileName = loggedUser.userName;
			return SUCCESS;
		}
		
		}catch(Exception e)
		{
			e.printStackTrace();
           addActionError(e.getMessage());

		}
		return INPUT;
	}
	

     
	}
