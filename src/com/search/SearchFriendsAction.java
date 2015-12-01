package com.search;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.application.constants.AppConstants;
import com.opensymphony.xwork2.ActionSupport;
import com.search.SearchFriendsDao;;

public class SearchFriendsAction {
	 // public final String names;
	public  Collection<String> searchednames= new ArrayList<String>();
	public  Collection<String> searchednamesreceiver= new ArrayList<String>();
	public String username;
	public String usernamereceiver;
	  
	private String name;
	private boolean checkMe;
	public String names;
	 
	public boolean isCheckMe() {
		return checkMe;
	}
 
	public void setCheckMe(boolean checkMe) {
		this.checkMe = checkMe;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String executeSearch(){
		boolean j = SearchFriendsDao.Search(this);
		searchednames.addAll(SearchFriendsDao.searchednames);
		return j ? AppConstants.SUCCESS : AppConstants.ERROR;
	}
	
	public String executeSave(){
		//System.out.println(name);
		int i=SearchFriendsDao.save(this);
		String[] names= name.split(",");
		//System.out.println("i "+i);
		if(i>0){
		return "success";
		}
		return "error";
	}
	
	public String executeCheckFriends(){
		boolean j= SearchFriendsDao.checkfriends(this);
		searchednamesreceiver.addAll(SearchFriendsDao.searchednamesreceiver);
		System.out.println(SearchFriendsDao.searchednamesreceiver);
		if(j){
		return "success";
		}
		return "error";
	}
	
	public String executeAccept(){
		//System.out.println(name);
		int i=SearchFriendsDao.approve(this);
		String[] names= name.split(",");
		//System.out.println("i "+i);
		if(i>0){
		return "success";
		}
		return "error";
	}
	
	public String executeReject(){
		//System.out.println(name);
		int i=SearchFriendsDao.reject(this);
		String[] names= name.split(",");
		//System.out.println("i "+i);
		/*if(i>0){
		return "success";
		}*/
		return "clear";
	}
	
}
