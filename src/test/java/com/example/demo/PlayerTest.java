package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
	
	private Player p; 
	
	@BeforeEach
	public void setup() {
		System.out.println("before testing ...");
		p = new Player(100, "William", "Soccer");;
	}
	
	@Test
	public void testToString() {
		String result = p.toString();
		Assertions.assertEquals("Player [pID=" + 100 + ", fName=" + "William" + ", sport=" + "Soccer" + "]", result);
	}
}
