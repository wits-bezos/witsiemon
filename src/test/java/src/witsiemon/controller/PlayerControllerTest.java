package src.witsiemon.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.badlogic.gdx.Input.Keys;

import src.witsiemon.controller.PlayerController;

public class PlayerControllerTest {
	
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
