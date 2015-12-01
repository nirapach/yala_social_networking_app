package com.registration;

import java.text.SimpleDateFormat;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.Map;

public class RegisterAction extends ActionSupport implements SessionAware{
private String name,password,email,full_name,uploadFileFileName;
Date dob;
User loggedUser;
private static final long serialVersionUID = 1L;
private Map<String, Object> session;

public User getLoggedUser() {
	return loggedUser;
}
public void setLoggedUser(User loggedUser) {
	this.loggedUser = loggedUser;
}
public String getUploadFileFileName() {
	return uploadFileFileName;
}
public void setUploadFileFileName(String uploadFileFileName) {
	this.uploadFileFileName = uploadFileFileName;
}

public Date getDob() {
	return (dob);
}
public void setDob(String dob) {
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
 if(dob != null)
 {
	 try {
		 
			this.dob = formatter.parse(dob);
			System.out.println(formatter.format(this.dob));
	 
		} catch (Exception e) {
			e.printStackTrace();
		} 
 }
	
}
public String getPassword() {
	return password;
}
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String executeRegister()
{
	System.out.println("in register");
	if(RegisterDao.checkLoginExists(this))
	{
		int i=RegisterDao.save(this);
		if(i>0)
		{
			if(executeLogin() == "success")
				return "success";
		}
		
	}
	return "error";
	
}

public String executeLogin(){
	loggedUser = RegisterDao.Login(this);
	if(loggedUser.userName != null && loggedUser.userName != "")
	{
	uploadFileFileName = name;	
	return "success";
	}
	return "error";
}

public static boolean SavePic(String name){
	boolean j=RegisterDao.savePicture(name);
	if(j){
	return true;
	}
	return false;
}

public String getFull_name() {
	return full_name;
}

public void setFull_name(String full_name) {
	this.full_name = full_name;
	
}
public String home() {
    return "success";
}
public String logOut() {
    session.remove("loginId");
    //addActionMessage("You have been Successfully Logged Out");
    return "success";
}
public String newsfeedpage() {
return "success";
}
public String newsgroupsfeedpage() {
return "success";
}
public String chatpage() {
return "success";
}
public Map<String, Object> getSession() {
    return session;
}	
public void setSession(Map<String, Object> map) {
    this.session = map;
}
//public boolean ValidationEvent(RegisterAction r) {
//	// Storing Field Values In Variables
//	String name = r.name;
//	String email = r.email; 
//	String pwd1 = r.password;
//	String f_name = r.full_name;
//	Date date = r.dob;
//	
//	if(name != "" && )
//	return false;
//	
//}
}
