package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Friendship
{
	@Id @GeneratedValue
	private int friendshipId;
	
	private int userId1;
	
	private int userId2;
	
	public Friendship(int userId1, int userId2)
	{
		this.userId1 = userId1;
		this.userId2 = userId2;
	}
	
	public Friendship()
	{
		
	}
	
	public void setUserId1(int id)
	{
		this.userId1 = id;
	}
	
	public int getUserId1()
	{
		return userId1;
	}
	
	public void setUserId2(int id)
	{
		this.userId2 = id;
	}
	
	public int getUserId2()
	{
		return userId2;
	}
}