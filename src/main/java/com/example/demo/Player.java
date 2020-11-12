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
	private String fName;
	
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

	@Transient
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
	//private int zipCode;
	
	
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
		return fName;
	}

	/**
	 * @param fName the Player's first name to be set
	 */
	public void setfName(String fName) {
		this.fName = fName;
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

	@Transient
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
	/*public int getZipCode() {
		return zipCode;
	}*/

	/**
	 * @param zipCode the Player's zipCode to be set
	 */
	/*public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}*/

	@Override
	public String toString() {
		return "Player [pID=" + pID + ", fName=" + fName + ", sport=" + sport + "]";
	}

}