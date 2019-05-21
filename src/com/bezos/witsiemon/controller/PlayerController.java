package com.bezos.witsiemon.controller;

import com.badlogic.gdx.Input.Keys;
import com.bezos.witsiemon.actors.Actor;
import com.badlogic.gdx.InputAdapter;

public class PlayerController extends InputAdapter {
	
	private Actor player;
	
	public PlayerController(Actor player) {
		this.player = player;
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.UP) {
			player.move(0, 1);
		}
		if (keycode == Keys.DOWN) {
			player.move(0, -1);	
		}
		if (keycode == Keys.LEFT) {
			player.move(-1, 0);
		}
		if (keycode == Keys.RIGHT) {
			player.move(1, 0);
		}
		
		return false;
	}
}
