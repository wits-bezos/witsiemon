/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezos.witsiemon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.bezos.witsiemon.Pokemon;
import com.bezos.witsiemon.Settings;
import com.bezos.witsiemon.actors.Actor;
import com.bezos.witsiemon.actors.Camera;
import com.bezos.witsiemon.actors.Map;
import com.bezos.witsiemon.controller.PlayerController;

/**
 *
 * @author vasty
 */
public class GameScreen extends AbstractScreen{

	private Map map;
	
	private Camera camera;
	private Actor player;
	private PlayerController controller;
	
	//Textures
	private Texture avatar;
	
	private SpriteBatch batch;
	
	public GameScreen(Pokemon app) {
		super(app);
		batch = new SpriteBatch();
		
		map = new Map("res/maps/matrix_west.tmx");
		
		avatar = new Texture("res/sprites/girl1_back_walk.000.png");
		player = new Actor(map.getLayer(0), 12, 0);
		camera = new Camera();
		
		controller = new PlayerController(player);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render(float delta) {
		player.update(delta);
		camera.update(player.getWorld_x() + 0.5f, player.getWorld_y() + 0.5f);
		
		batch.begin();
			float start_x = Gdx.graphics.getWidth()/2 - camera.getX()*Settings.SCALED_TILE_SIZE;
			float start_y = Gdx.graphics.getHeight()/2 - camera.getY()*Settings.SCALED_TILE_SIZE;
			
			int n = map.getSize();
			for (int i = 0; i < n; i++) {
				for (int x = 0; x < map.getWidth(); x++) {
					for (int y = 0; y < map.getHeight(); y++) {
						try {
							TextureRegion texture = map.getLayer(i).getTile(x, y).getTexture();
							
							batch.draw(texture,
									start_x + x*Settings.SCALED_TILE_SIZE,
									start_y + y*Settings.SCALED_TILE_SIZE,
									Settings.SCALED_TILE_SIZE,
									Settings.SCALED_TILE_SIZE);
						}
						catch (Exception e) {
							
						}
					}
				}
			}
			batch.draw(avatar,
					start_x + player.getWorld_x()*Settings.SCALED_TILE_SIZE,
					start_y + player.getWorld_y()*Settings.SCALED_TILE_SIZE,
					Settings.SCALED_TILE_SIZE,
					Settings.SCALED_TILE_SIZE*2f); 
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
