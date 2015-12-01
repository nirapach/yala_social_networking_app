package com.group.item;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import java.sql.Date;

import org.hibernate.annotations.Cascade;
@Entity
@Table(name="groupnewsfeed")
public class GroupNewsfeed {
	
	@Id
	 @GeneratedValue
	   private int id;
	//@Column(name="groupId")
	//public static String groupId;
	@Column(name="groupName")
	private String groupName;
   @Column(name="username")
   private String username;
   @Column(name="status")
   private String status;
   //@Column(name="status")
   //private int marks;
   @Column(name="created")
   private Date created;
  /* @ManyToMany(mappedBy = "newsfeed",cascade = CascadeType.ALL)
   @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
   private Friends friends;*/
   
   public int getId() {
    return id;
   }
   public void setId(int id) {
    this.id = id;
   }
  /* public Friends getFriends() {
       return friends;
   }

   public void setFriends(Friends friends) {
       this.friends = friends;
   }*/
   public String getGroupName() {
	      return groupName;
	   }
	   public void setGroupName(String groupName) {
	      this.groupName = groupName;
	   }
	   /*public String getGroupId() {
		      return groupId;
		   }
		   public void setGroupId(String groupId) {
		      this.groupId = groupId;
		   }*/
   public String getUsername() {
      return username;
   }
   public void setUsername(String username) {
      this.username = username;
   }
   public String getStatus() {
      return status;
   }
   public void setStatus(String status) {
      this.status = status;
   }
   
   public Date getCreated() {
      return created;
   }
   public void setCreated(Date created) {
      this.created = created;
   }
}
