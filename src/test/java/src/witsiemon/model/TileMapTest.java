package src.witsiemon.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.witsiemon.model.TileMap;

public class TileMapTest {
	 
	@Test
	public void getWidth_map_equal() {
		
		// set up
		int width = 5;
		int height = 5;
		TileMap tileMap = new TileMap(width, height);
		
		// act 
		int result = tileMap.getWidth();
		
		// verify
		assertEquals(result, width);
	}
		
	@Test
	public void getHeight_map_equal() {
			
		// set up
		int width = 5;
		int height = 5;
		TileMap tileMap = new TileMap(width, height);
			
		// act 
		int result = tileMap.getHeight();
		
		// verify
		assertEquals(result, height);
	}
}
