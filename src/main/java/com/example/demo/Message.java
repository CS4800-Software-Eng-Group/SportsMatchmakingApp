package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Message {
	
	@Id @GeneratedValue
	private int friendshipId;
	
	private String sender;
	
	private String recipient;
	
	private String text;
	
	private String timestamp;
	
	public Message() { }
	
	public Message(String sender, String recipient, String text, String timestamp)
	{
		this.recipient = recipient;
		this.sender = sender;
		this.text = text;
		this.timestamp = timestamp;
	}
	
	public void setSender(String sender)
	{
		this.sender = sender;
	}
	
	public String getSender()
	{
		return sender;
	}
	
	public void setText(String text)
	{
		this.text = text;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void setRecipient(String recipient)
	{
		this.recipient = recipient;
	}
	
	public String getRecipient()
	{
		return recipient;
	}
	
	public void setTimestamp(String timestamp)
	{
		this.timestamp = timestamp;
	}
	
	public String getTimestamp()
	{
		return timestamp;
	}
}
