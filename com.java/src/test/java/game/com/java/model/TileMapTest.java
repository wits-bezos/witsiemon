package game.com.java.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TileMapTest {
	
	/**
	// test case to validate correct size map 
	@Test
	public void getTile_map_equal() {
		
		// set up
		int width = 5;
		int height = 5;
		TileMap tileMap = new TileMap(width, height);
		
		// act 
		Tile result = tileMap.getTile(0, 0);
		
		// verify
		Tile[][] tiles = new Tile[width][height];
		for(int x = 0;x < width;x++) {
			for(int y = 0;y < height; y++) {
				if(Math.random() > 0.5d) {
					tiles[x][y] = new Tile(TERRAIN.GRASS);
				}
				else {
					tiles[x][y] = new Tile(TERRAIN.GRASS2);
				}
			}
		}
		
		assertEquals(result, tiles[0][0]);
	}
	
	**/
	
	// test case to validate correct width 
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
		
	// test case to validate correct size map 
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
