package com.teamObject.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SportTest {
	
	private Sport s = new Sport();
	@BeforeEach
	public void testSport(){
		
		s = new Sport("Basketball", "A game of up to 10 players");
	}
	
	@Test
	public void testToString() {
		String res = s.toString();
		Assertions.assertEquals("Sport [Sport=" + "Basketball" + ", Description=" +  "A game of up to 10 players" + "]", res);
	}
}
