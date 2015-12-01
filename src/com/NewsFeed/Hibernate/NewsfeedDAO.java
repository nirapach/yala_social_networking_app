package com.NewsFeed.Hibernate;

import java.util.ArrayList;
import java.util.List;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class NewsfeedDAO {
	
   @SessionTarget
   Session session;

   @TransactionTarget
   Transaction transaction;

   @SuppressWarnings("unchecked")
   
   public List<Newsfeed> getNewsfeeds()
   {
     // Friends Friends = new Friends();
	   //List<Friendship> friendships = new ArrayList<Friendship>();
	   //List<Newsfeed> newsfeedswhole = new ArrayList<Newsfeed>();
	   List<Newsfeed> newsfeeds = new ArrayList<Newsfeed>();
      try
      {
    	  //Object friendsname=null;
    	 // String querystring="from Newsfeed newsfeed"+"where newsfeed.username =?";
    	//  newsfeeds=session.createQuery(querystring).setString(0,"nirapach").list();
         
    	  //newsfeeds = query.list();
    	  newsfeeds = session.createQuery("from Newsfeed").list();
		 //newsfeeds = session.createQuery("from Newsfeed where username in (" + "select Friends_User_Name from Friends where Primary_User_Name='nirapach')").list();
    	  //newsfeedswhole = session.createQuery("from Newsfeed").list();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      return newsfeeds;
   }

   public void addNewsfeed(Newsfeed newsfeed)
   {
      session.save(newsfeed);
   }
}
