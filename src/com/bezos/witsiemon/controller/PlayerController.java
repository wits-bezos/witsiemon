package com.bezos.witsiemon.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.bezos.witsiemon.model.Player;

public class PlayerController extends InputAdapter {
	
	private Player player;
	
	public PlayerController(Player player) {
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
