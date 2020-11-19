package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "FRIENDSHIP")
public class Friendship
{
	@Id @GeneratedValue
	private int friendshipId;
	
	private String userId1;
	
	private String userId2;
	
	public Friendship(String userId1, String userId2)
	{
		this.userId1 = userId1;
		this.userId2 = userId2;
	}
	
	public Friendship()
	{
		
	}
	
	public void setUserId1(String id)
	{
		this.userId1 = id;
	}
	
	public String getUserId1()
	{
		return userId1;
	}
	
	public void setUserId2(String id)
	{
		this.userId2 = id;
	}
	
	public String getUserId2()
	{
		return userId2;
	}
	
	public void setFriendshipId(int id)
	{
		friendshipId = id;
	}
	
	public int getFriendshipId()
	{
		return friendshipId;
	}
}