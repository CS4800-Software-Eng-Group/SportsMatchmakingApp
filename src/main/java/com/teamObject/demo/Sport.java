package com.teamObject.demo;

public class Sport {
	
	/*
	 *  A specific sport
	 */
	private String sport;
	/*
	 * The sport's description
	 */
	private String description;
	
	public Sport() {
		
	}
	
	/*
	 * Constructor for specific sports
	 */
	public Sport(String sport, String description) {
		this.sport = sport;
		this.description = description;
	}
	
	/**
	 * @return sport name
	 */
	public String getSport() {
		return sport;
	}
	
	
	/**
	 * @param the name of the sport
	 */
	public void setSport(String sport) {
		this.sport = sport;
	}
	
	/**
	 * @return sport description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param the description of the sport
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Sport [Sport=" + sport + ", Description=" + description + "]";
	}

	@Override
	public boolean equals(Object obj) {
		//check if same reference
		if (this == obj)
			return true;
		//check if object is null
		if (obj == null)
			return false;
		//check if object is from difference class
		if (getClass() != obj.getClass())
			return false;
		//check if name is different
		Sport other = (Sport) obj;
		if (sport != other.sport)
			return false;
		return true;
	}
	
}
