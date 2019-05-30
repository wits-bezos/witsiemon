package src.witsiemon.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.badlogic.gdx.Input.Keys;

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
		
		boolean result = pc.keyUp(Keys.A);
		
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
	@Test
	public void keyDown_left_true() {
		src.witsiemon.model.Actor p = null;
		PlayerController pc = new PlayerController(p);
		pc.keyUp(37);
		assertEquals(pc.left,true);
	}
	
	@Test
	public void keyDown_right_true() {
		src.witsiemon.model.Actor p = null;
		PlayerController pc = new PlayerController(p);
		pc.keyUp(39);
		assertEquals(pc.right,true);
	}
	
	@Test
	public void keyUp_left_true() {
		src.witsiemon.model.Actor p = null;
		PlayerController pc = new PlayerController(p);
		pc.keyUp(37);
		assertEquals(pc.left,true);
	}
	@Test
	public void keyUp_right_true() {
		src.witsiemon.model.Actor p = null;
		PlayerController pc = new PlayerController(p);
		pc.keyUp(39);
		assertEquals(pc.right,true);
	}
	@Test
	public void keyUp_up_true() {
		src.witsiemon.model.Actor p = null;
		PlayerController pc = new PlayerController(p);
		pc.keyUp(38);
		assertEquals(pc.up,true);
	}
	@Test
	public void keyUp_down_true() {
		src.witsiemon.model.Actor p = null;
		PlayerController pc = new PlayerController(p);
		boolean result  = pc.keyUp(40);
		assertEquals(result,true);
	}
	
	
	
}
