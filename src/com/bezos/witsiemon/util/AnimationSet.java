package com.bezos.witsiemon.util;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.bezos.witsiemon.model.DIRECTION;

public class AnimationSet {

	private Map<DIRECTION, Animation> walking;
	private Map<DIRECTION, TextureRegion> standing;  
	
	public AnimationSet(Animation walk_north,
						Animation walk_south,
						Animation walk_east,
						Animation walk_west,
						TextureRegion stand_north,
						TextureRegion stand_south,
						TextureRegion stand_east,
						TextureRegion stand_west) {
		walking = new HashMap<DIRECTION, Animation>();
		walking.put(DIRECTION.NORTH, walk_north);
		walking.put(DIRECTION.SOUTH, walk_south);
		walking.put(DIRECTION.EAST, walk_east);
		walking.put(DIRECTION.WEST, walk_west);
		
		standing = new HashMap<DIRECTION, TextureRegion>();
		standing.put(DIRECTION.NORTH, stand_north);
		standing.put(DIRECTION.SOUTH, stand_south);
		standing.put(DIRECTION.EAST, stand_east);
		standing.put(DIRECTION.WEST, stand_west);
	}
	
	public Animation getWalking(DIRECTION dir) {
		return walking.get(dir);
	}
	
	public TextureRegion getStanding(DIRECTION dir) {
		return standing.get(dir);
		
	}
	
}
