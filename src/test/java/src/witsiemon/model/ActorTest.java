package src.witsiemon.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import src.witsiemon.util.AnimationSet;

import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;


public class ActorTest {
	
	// test case to validate correct change in direction 
	@Test
	public void getX_return_five() {
		
		// set up
		TileMap map = new TileMap(10, 10);
		AnimationSet animations = null;
		Actor actor = new Actor(map, 5, 5, animations);
		
		// act 
		int result = actor.getX();
		
		// verify
		assertEquals(result, 5);
	}
	
	// test case to validate correct change in direction 
	@Test
	public void getY_return_five() {
		
		// set up
		TileMap map = new TileMap(10, 10);
		AnimationSet animations = null;
		Actor actor = new Actor(map, 5, 5, animations);
		
		// act 
		int result = actor.getY();
		
		// verify
		assertEquals(result, 5);
	}
	
	// test case to validate correct change in direction 
	@Test
	public void getWorldY_return_float() {
		
		// set up
		TileMap map = new TileMap(10, 10);
		AnimationSet animations = null;
		Actor actor = new Actor(map, 5, 5, animations);
		
		// act 
		float result = actor.getWorldY();
		
		// verify
		assert(result == 5);
	}
	
	// test case to validate correct change in direction 
	@Test
	public void getWorldX_return_float() {
		
		// set up
		TileMap map = new TileMap(10, 10);
		AnimationSet animations = null;
		Actor actor = new Actor(map, 5, 5, animations);
		
		// act 
		float result = actor.getWorldX();
		
		// verify
		assert(result == 5);
	}
	
	// test case to validate correct change in direction 
	@Test
	public void move_return_float() {
		
		// set up
		TileMap map = new TileMap(10, 10);
		AnimationSet animations = null;
		Actor actor = new Actor(map, 5, 5, animations);
		DIRECTION dir = DIRECTION.SOUTH;
		// act 
		boolean result = actor.move(dir);
		
		// verify
		assertEquals(result, true);
	}
}
