package game.com.java.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlayerControllerTest {
	
	// test case to validate correct change in direction 
	@Test
	public void keyDown_get_false() {
		
		// set up
		game.com.java.model.Actor p = null;
		PlayerController pc = new PlayerController(p);
		int keycode = 20;
		
		// act 
		boolean result = pc.keyDown(keycode);
		
		// verify
		assertEquals(result, false);
	}
	
	// test case to validate correct change in direction
	@Test
	public void keyUp_get_false() {
		
		// set up
		game.com.java.model.Actor p = null;
		PlayerController pc = new PlayerController(p);
		int keycode = 19;
		
		// act 
		boolean result = pc.keyDown(keycode);
		
		// verify
		assertEquals(result, false);
	}
}
