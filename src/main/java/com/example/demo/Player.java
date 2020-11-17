package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Player {
	
	@Id
	/**
	 * Player's unique ID	
	 */
	private int pID;

	/**
	 * Player's first name
	 */
	private String firstName;
	
	/**
	 * The user's last name
	 */
	private String lastName;
	
	/**
	 * The user's profile bio
	 */
	private String bio;
	
	/**
	 * Player's password
	 */
	private String username;
	
	@Transient
	/**
	 * Player's password
	 */
	private String password;
	
	/**
	 * Player's password
	 */
	private String login;
	
	
	/**
	 * Sport that the Player wants to play
	 */
	private String sport; //Will be changed to a Sport Object

	/**
	 * Player's years of age
	 */
	//private int age;

	
	/**
	 * ZIP code where the Player is located
	 */
	private String zipCode;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the login
	 */
	public Player(int pID, String fName, String lName, String bio, String sport, String zip) {
		super();
		this.pID = pID;
		this.firstName = fName;
		this.lastName = lName;
		this.bio = bio;
		this.sport = sport;
		this.zipCode = zip;
	}

	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin() {
		this.login = this.username+this.password;
	}

	/**
	 * @return the Player's unique ID
	 */
	public int getpID() {
		return this.pID;
	}

	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * @param pID the Player's unique ID to be set
	 */
	public void setpID(int pID) {
		this.pID=pID;
	}

	/**
	 * @return the Player's first name
	 */
	public String getfName() {
		return firstName;
	}

	/**
	 * @param fName the Player's first name to be set
	 */
	public void setfName(String fName) {
		this.firstName = fName;
	}
	
	@Transient
	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.getPassword()+this.getUsername();
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * @return the Player's sport
	 */
	public String getSport() {
		return sport;
	}

	
	/**
	 * @param sport the Player's sport to be set
	 */
	public void setSport(String sport) {
		this.sport = sport;
	}

	/**
	 * @return the Player's age
	 */
	/*public int getAge() {
		return age;
	}*/

	/**
	 * @param age the Player's age to be set
	 */
	/*public void setAge(int age) {
		this.age = age;
	}*/

	
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * @param zipCode the Player's zipCode to be set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Player [pID=" + pID + ", fName=" + firstName + ", username=" + username + ", sport=" + sport + ", zipCode="
				+ zipCode + "]";
	}



}