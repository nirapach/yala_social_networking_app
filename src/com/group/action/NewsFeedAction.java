package com.group.action;
import java.util.ArrayList;
import java.util.List;

import com.application.Dao.NewsfeedDAO;

import com.group.item.GroupNewsfeed;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class NewsFeedAction extends ActionSupport 
            implements ModelDriven<GroupNewsfeed>{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GroupNewsfeed groupnewsfeed  = new GroupNewsfeed();
	//Friendship friendship  = new Friendship();
	//Friends friends = new Friends();
   List<GroupNewsfeed> groupnewsfeeds = new ArrayList<GroupNewsfeed>();
  // List<Friendship> friendships = new ArrayList<Friendship>();
   NewsfeedDAO dao = new NewsfeedDAO();
   @Override
   public GroupNewsfeed getModel() {
      return groupnewsfeed;
   }
   /*public Friendship getModel1() {
	    return friendship;
	   }*/

   public String execute()
   {
      dao.addgroupNewsfeed(groupnewsfeed);
      return "success";
   }

   public String listgroupNewsfeeds()
   {
      groupnewsfeeds = dao.getNewsfeeds();
      return "success";
   }
   public String refreshgroupfeeds()
   {
      groupnewsfeeds = dao.getNewsfeeds();
      return "success";
   }

   public GroupNewsfeed getNewsfeed() {
      return groupnewsfeed;
   }

   public void setNewsfeed(GroupNewsfeed groupnewsfeed) {
      this.groupnewsfeed = groupnewsfeed;
   }

  public List<GroupNewsfeed> getNewsfeeds() {
      return groupnewsfeeds;
   }

   public void setNewsfeeds(List<GroupNewsfeed> groupnewsfeeds) {
      this.groupnewsfeeds = groupnewsfeeds;
   }
	
}
