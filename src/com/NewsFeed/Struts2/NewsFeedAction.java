package com.NewsFeed.Struts2;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.NewsFeed.Hibernate.*;

public class NewsFeedAction extends ActionSupport 
            implements ModelDriven<Newsfeed>{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Newsfeed newsfeed  = new Newsfeed();
	//Friendship friendship  = new Friendship();
	//Friends friends = new Friends();
   List<Newsfeed> newsfeeds = new ArrayList<Newsfeed>();
   //List<Friendship> friendships = new ArrayList<Friendship>();
   NewsfeedDAO dao = new NewsfeedDAO();
   @Override
   public Newsfeed getModel() {
      return newsfeed;
   }
   //public Friendship getModel1() {
	//    return friendship;
	 //  }

   public String execute()
   {
      dao.addNewsfeed(newsfeed);
      return "success";
   }

   public String listNewsfeeds()
   {
      newsfeeds = dao.getNewsfeeds();
      return "success";
   }
   public String refreshfeeds()
   {
      newsfeeds = dao.getNewsfeeds();
      return "success";
   }

   public Newsfeed getNewsfeed() {
      return newsfeed;
   }

   public void setNewsfeed(Newsfeed newsfeed) {
      this.newsfeed = newsfeed;
   }

  public List<Newsfeed> getNewsfeeds() {
      return newsfeeds;
   }

   public void setNewsfeeds(List<Newsfeed> newsfeeds) {
      this.newsfeeds = newsfeeds;
   }
	
}
