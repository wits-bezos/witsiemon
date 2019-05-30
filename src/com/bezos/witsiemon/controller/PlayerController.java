package com.bezos.witsiemon.controller;

import com.badlogic.gdx.Input.Keys;
import com.bezos.witsiemon.model.Actor;
import com.bezos.witsiemon.model.DIRECTION;
import com.badlogic.gdx.InputAdapter;

public class PlayerController extends InputAdapter {
	
	private Actor player;
	
	private boolean up, down, left, right;
	private boolean battle = false;
	
	public PlayerController(Actor player) {
		this.player = player;
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.UP) {
			up = true;
		}
		if (keycode == Keys.DOWN) {
			down = true;	
		}
		if (keycode == Keys.LEFT) {
			left = true;
		}
		if (keycode == Keys.RIGHT) {
			right = true;
		}
		if (keycode == Keys.B) {
			battle = true;
		}
		
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.UP) {
			up = false;
		}
		if (keycode == Keys.DOWN) {
			down = false;	
		}
		if (keycode == Keys.LEFT) {
			left = false;
		}
		if (keycode == Keys.RIGHT) {
			right = false;
		}
		
		return false;
	}
	
	public void update(float delta) {
		if(up) {
			player.move(DIRECTION.NORTH);
		}
		else if(down) {
			player.move(DIRECTION.SOUTH);
		}
		else if(left) {
			player.move(DIRECTION.WEST);
		}
		else if(right) {
			player.move(DIRECTION.EAST);
		}
	}
	
	public Boolean getBattle() {
		if (battle) {
			return true;
		}
		return false;
	}
}
