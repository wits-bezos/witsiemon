package src.witsiemon.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.witsiemon.controller.PlayerController;

public class PlayerControllerTest {
	
	// test case to validate correct change in direction 
	@Test
	
	public void keyDown_newScreenFalse_newScreenTrue() {
		src.witsiemon.model.Actor p = null;
		PlayerController pc = new PlayerController(p);
		int keycode = 65;
		
		boolean result = pc.keyDown(keycode);
		
		assertEquals(result,true);
	}
	
	@Test
	public void keyUp() {
		src.witsiemon.model.Actor p = null;
		PlayerController pc = new PlayerController(p);
		int keycode = 65;
		
		boolean result = pc.keyUp(keycode);
		
		assertEquals(result,true);
	}
	@Test
	public void keyDown_get_false() {
		
		// set up
		src.witsiemon.model.Actor p = null;
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
		src.witsiemon.model.Actor p = null;
		PlayerController pc = new PlayerController(p);
		int keycode = 19;
		
		// act 
		boolean result = pc.keyDown(keycode);
		
		// verify
		assertEquals(result, false);
	}
}
