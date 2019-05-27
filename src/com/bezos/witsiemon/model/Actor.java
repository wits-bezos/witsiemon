package com.bezos.witsiemon.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.bezos.witsiemon.util.AnimationSet;

public class Actor {
	
	private Map map;
	private int x, y;
	private DIRECTION facing;
	
	private float world_x, world_y;
	private int src_x, src_y, dest_x, dest_y;
	private float anim_timer, ANIM_TIME = 0.3f; 
	
	private float walk_timer;
	private boolean move_request;
	
	private ACTOR_STATE state;
	
	private AnimationSet animations;
	
	public Actor(Map map, int x, int y, AnimationSet animations) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.world_x = x;
		this.world_y = y;
		this.animations = animations;
		map.getLayer(0).getTile(x, y).setActor(this);
		this.state = ACTOR_STATE.STANDING;
		this.facing = DIRECTION.NORTH;
	}
	
	public enum ACTOR_STATE {
		WALKING,
		STANDING; 
	}
	
	public void update(float delta) {
		if (state == ACTOR_STATE.WALKING) {
			anim_timer += delta;
			walk_timer += delta;
			world_x = Interpolation.linear.apply(src_x, dest_x, anim_timer/ANIM_TIME);
			world_y = Interpolation.linear.apply(src_y, dest_y, anim_timer/ANIM_TIME);
			if (anim_timer > ANIM_TIME) {
				float difference = anim_timer - ANIM_TIME;
				walk_timer -= difference; 
				
				finishMove();
				if (move_request) {
					if (move(facing)) {
						anim_timer += difference;
						world_x = Interpolation.linear.apply(src_x, dest_x, anim_timer/ANIM_TIME);
						world_y = Interpolation.linear.apply(src_y, dest_y, anim_timer/ANIM_TIME);
					}
				}
				else {
					walk_timer = 0f;
				}
			}
		
		}
		this.move_request = false;
	}
	
	public boolean move(DIRECTION dir) {
		if (state == ACTOR_STATE.WALKING) {
			if (facing == dir) {
				this.move_request = true;
			}
			return false;
		}
		if (x+dir.getDx() >= map.getWidth() || x+dir.getDx() < 0 || y+dir.getDy() >= map.getHeight() || y+dir.getDy() < 0) {
			return false;
		}
		
		if (map.getLayer(0).getTile(x+dir.getDx(), y+dir.getDy()).getActor() != null) {
			return false;
		}
		
		initMove(dir);
		
		map.getLayer(0).getTile(x, y).setActor(null);
		x += dir.getDx();
		y += dir.getDy();
		map.getLayer(0).getTile(x, y).setActor(this);
		return true;
	}
	
	private void initMove(DIRECTION dir) {
		this.facing = dir;
		this.src_x = x;
		this.src_y = y;
		this.dest_x = x + dir.getDx();
		this.dest_y = y + dir.getDy();
		this.world_x = x;
		this.world_y = y;
		this.anim_timer = 0f;
		this.state = ACTOR_STATE.WALKING;
	}
	
	private void finishMove() {
		this.state = ACTOR_STATE.STANDING;
		this.world_x = dest_x;
		this.world_y = dest_y;
		this.src_x = 0;
		this.src_y = 0;
		this.dest_x = 0;
		this.dest_y = 0;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getWorld_x() {
		return world_x;
	}

	public float getWorld_y() {
		return world_y;
	}
	
	public TextureRegion getSprite() {
		if (state == ACTOR_STATE.WALKING) {
			try{
				//System.out.println(walk_timer);
				return animations.getWalking(facing).getKeyFrame(walk_timer);
			}
			catch (Exception e){
				return animations.getStanding(facing);
			}
		}
		else if (state == ACTOR_STATE.STANDING) {
			return animations.getStanding(facing);
		}
		return animations.getStanding(DIRECTION.SOUTH);
	}
}
