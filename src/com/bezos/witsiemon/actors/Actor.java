package com.bezos.witsiemon.actors;

import com.badlogic.gdx.math.Interpolation;

public class Actor {
	
	private Layer map;
	private int x, y;
	
	private float world_x, world_y;
	private int src_x, src_y, dest_x, dest_y;
	private float anim_timer, ANIM_TIME = 0.5f; 
	
	private ACTOR_STATE state;
	
	public Actor(Layer map, int x, int y) {
		this.map = map;
		this.x = x;
		this.y = y;
		this.world_x = x;
		this.world_y = y;
		map.getTile(x, y).setActor(this);
		this.state = ACTOR_STATE.STANDING;
	}
	
	public enum ACTOR_STATE {
		WALKING,
		STANDING; 
	}
	
	public void update(float delta) {
		if (state == ACTOR_STATE.WALKING) {
			this.anim_timer += delta;
			this.world_x = Interpolation.linear.apply(src_x, dest_x, anim_timer/ANIM_TIME);
			this.world_y = Interpolation.linear.apply(src_y, dest_y, anim_timer/ANIM_TIME);
			if (anim_timer > ANIM_TIME) {
				finishMove();
			}
		}
	}
	
	public boolean move(int dx, int dy) {
		if (state != ACTOR_STATE.STANDING) {
			return false;
		}
		if (x+dx >= map.getWidth() || x+dx < 0 || y+dy >= map.getHeight() || y+dy < 0) {
			return false;
		}
		
		if (map.getTile(x+dx, y+dy).getActor() != null) {
			return false;
		}
		
		initMove(x, y, dx, dy);
		
		map.getTile(x, y).setActor(null);
		x += dx;
		y += dy;
		map.getTile(x, y).setActor(this);
		return true;
	}
	
	private void initMove(int old_x, int old_y, int dx, int dy) {
		this.src_x = old_x;
		this.src_y = old_y;
		this.dest_x = old_x + dx;
		this.dest_y = old_y + dy;
		this.world_x = old_x;
		this.world_y = old_y;
		this.anim_timer = 0f;
		this.state = ACTOR_STATE.WALKING;
	}
	
	private void finishMove() {
		this.state = ACTOR_STATE.STANDING;
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
	
}
