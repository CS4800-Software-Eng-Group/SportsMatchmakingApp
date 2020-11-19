package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Player {
	
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
	@Id
	private String username;
	
	/**
	 * Player's password
	 */
	private String password;
	
	/**
	 * Sport that the Player wants to play
	 */
	private String sport; //Will be changed to a Sport Object

	private String address;
	
	private String city;
	
	private String state;
	
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
	public Player(String username, String fName, String lName, String bio, String sport, String password, String address, String city, String state, String zip) {
		super();
		this.username = username;
		this.firstName = fName;
		this.lastName = lName;
		this.password = password;
		this.bio = bio;
		this.sport = sport;
		this.zipCode = zip;
		this.address = address;
		this.city = city;
		this.state = state;
	}
	
	public Player()
	{
		
	}

	/**
	 * @return the Player's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param fName the Player's first name to be set
	 */
	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lName)
	{
		this.lastName = lName;
	}

	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getAddress()	
	{
		return address;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}
	
	public String getState()
	{
		return state;
	}
	
	public void setBio(String bio)
	{
		this.bio = bio;
	}
	
	public String getBio()
	{
		return bio;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
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
		return "Player [fName=" + firstName + ", username=" + username + ", sport=" + sport + ", zipCode="
				+ zipCode + "]";
	}
}