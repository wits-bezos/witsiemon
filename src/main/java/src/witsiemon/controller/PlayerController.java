package src.witsiemon.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

import src.witsiemon.Witsiemon;
import src.witsiemon.model.Actor;
import src.witsiemon.model.DIRECTION;
import src.witsiemon.model.Pokemon;
import src.witsiemon.screen.battleScreen;

public class PlayerController extends InputAdapter{
	
	private Actor player;
	private boolean up, down, left, right, newScreen;
	
	public PlayerController(Actor p) {
		this.player = p;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		if(keycode == Keys.A) {
			newScreen = true;
			return true;
		}
		if(keycode == Keys.UP) {
			up = true;
		}
		if(keycode == Keys.DOWN) {
			down = true;
		}
		if(keycode == Keys.LEFT) {
			left = true;
		}
		if(keycode == Keys.RIGHT) {
			right = true;
		}
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.A) {
			newScreen = false;
			return true;
		}
		if(keycode == Keys.UP) {
			up = false;
		}
		if(keycode == Keys.DOWN) {
			down = false;
		}
		if(keycode == Keys.LEFT) {
			left = false;
		}
		if(keycode == Keys.RIGHT) {
			right = false;
		}
		return false;
	}
	
	public boolean update(float delta) {

		if(newScreen) {
			return true;
		}
		if(up) {
			player.move(DIRECTION.NORTH);
			return false;
		}
		
		if(down) {
			player.move(DIRECTION.SOUTH);
			return false;
		}
		
		if(left) {
			player.move(DIRECTION.WEST);
			return false;
		}
		
		if(right) {
			player.move(DIRECTION.EAST);
			return false;
		}
		return false;
	}
}
