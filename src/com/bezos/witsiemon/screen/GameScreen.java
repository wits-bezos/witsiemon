/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezos.witsiemon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bezos.witsiemon.Pokemon;
import com.bezos.witsiemon.Settings;
import com.bezos.witsiemon.controller.PlayerController;
import com.bezos.witsiemon.model.Player;

/**
 *
 * @author vasty
 */
public class GameScreen extends AbstractScreen{

	private Player player;
	private PlayerController controller;
	private Texture avatar;
	private SpriteBatch batch;
	
	public GameScreen(Pokemon app) {
		super(app);
		
		avatar = new Texture("res/sprites/bob_back_walk.001.png");
		batch = new SpriteBatch();
		player = new Player(0, 0);
		controller = new PlayerController(player);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render(float delta) {
		batch.begin();
		
		batch.draw(avatar, 
				player.getX()*Settings.SCALED_TILE_SIZE, 
				player.getY()*Settings.SCALED_TILE_SIZE, 
				Settings.SCALED_TILE_SIZE, 
				Settings.SCALED_TILE_SIZE * 2f);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}
	
}
