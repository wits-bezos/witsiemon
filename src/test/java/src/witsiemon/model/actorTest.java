package game.com.java.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;

import game.com.java.Witsiemon;
import game.com.java.util.AnimationSet;

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
	public void getSprite_return_texture() {
		
		// set up
		TileMap map = new TileMap(10, 10);
		
		Witsiemon app = new Witsiemon();
		app.create();
		TextureAtlas atlas = app.getAssetManager().get("res/packed/textures.atlas", TextureAtlas.class);
		
		AnimationSet animations = new AnimationSet(
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_north"), PlayMode.LOOP_PINGPONG),
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_south"), PlayMode.LOOP_PINGPONG),
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_east"), PlayMode.LOOP_PINGPONG),
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_west"), PlayMode.LOOP_PINGPONG),
			atlas.findRegion("player1_stand_north"),
			atlas.findRegion("player1_stand_south"),
			atlas.findRegion("player1_stand_east"),
			atlas.findRegion("player1_stand_west")
		);
		
		Actor actor = new Actor(map, 5, 5, animations);
		
		// act 
		TextureRegion result = actor.getSprite();
		
		// verify
		assert(result == animations.getStanding(DIRECTION.SOUTH));
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
