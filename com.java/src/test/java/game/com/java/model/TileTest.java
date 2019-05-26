package game.com.java.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TileTest {
	
	// test case to validate correct terrain structure 
	@Test
	public void getTerrain_anystate_grass() {
		
		// set up
		TERRAIN terrain = TERRAIN.GRASS;
		Tile tile = new Tile(terrain);
			
		// act 
		TERRAIN result = tile.getTerrain();
		
		// verify
		assertEquals(result, terrain);
	}
	
	// test case to validate correct terrain structure  
	@Test
	public void getActor_anystate_actor() {
		
		// set up
		TERRAIN terrain = TERRAIN.GRASS;
		Tile tile = new Tile(terrain);
		TileMap tileMap = new TileMap(5, 5);
		Actor actor =  new Actor(tileMap, 0, 0, null);
		tile.setActor(actor);
			
		// act 
		Actor result = tile.getActor();
		
		// verify
		assertEquals(result, actor);
	}
}
