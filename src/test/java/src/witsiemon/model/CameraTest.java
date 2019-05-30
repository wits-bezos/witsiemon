package src.witsiemon.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.witsiemon.model.Camera;

public class CameraTest {
	
	
	@Test
	public void getCameraX_scale_zero() {
	
		// set up
		Camera camera = new Camera();
		float cameraX = 0f;
		float cameraY = 0f;
		camera.update(cameraX, cameraY);
		
		// act 
		float result = camera.getCameraX();
		
		// verify
		assertTrue(cameraX == result);
	}
	
	
	@Test
	public void getCameraY_scale_zero() {
	
		// set up
		Camera camera = new Camera();
		float cameraX = 0f;
		float cameraY = 0f;
		camera.update(cameraX, cameraY);
		
		// act 
		float result = camera.getCameraY();
		
		// verify
		assertTrue(cameraY == result);
	}
}
