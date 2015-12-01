package com.application.Dao;

import java.util.ArrayList;
import java.util.List;
import com.group.action.GroupHomeAction;
import com.group.item.GroupNewsfeed;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.group.item.Group;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.group.item.Group;
public class NewsfeedDAO {
	
   @SessionTarget
   Session session;

   @TransactionTarget
   Transaction transaction;

   @SuppressWarnings("unchecked")
   
   public List<GroupNewsfeed> getNewsfeeds()
   {
     // Friends Friends = new Friends();
	   //List<Friendship> friendships = new ArrayList<Friendship>();
	   //List<Newsfeed> newsfeedswhole = new ArrayList<Newsfeed>();
	   List<GroupNewsfeed> groupnewsfeeds = new ArrayList<GroupNewsfeed>();
      try
      {
    	  //Object friendsname=null;
    	 // String querystring="from Newsfeed newsfeed"+"where newsfeed.username =?";
    	//  newsfeeds=session.createQuery(querystring).setString(0,"nirapach").list();
         
    	  //newsfeeds = query.list();
    	 // String groupIdvalue = group.getGroupId();
    	  groupnewsfeeds = session.createQuery("from GroupNewsfeed").list();
		 //newsfeeds = session.createQuery("from Newsfeed where username in (" + "select Friends_User_Name from Friends where Primary_User_Name='nirapach')").list();
    	  //newsfeedswhole = session.createQuery("from Newsfeed").list();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      return groupnewsfeeds;
   }

   public void addgroupNewsfeed(GroupNewsfeed newsfeed)
   {
      session.save(newsfeed);
   }
}
