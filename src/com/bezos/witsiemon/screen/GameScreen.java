/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezos.witsiemon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.bezos.witsiemon.Pokemon;
import com.bezos.witsiemon.Settings;
import com.bezos.witsiemon.actors.Actor;
import com.bezos.witsiemon.actors.Map;
import com.bezos.witsiemon.actors.Player;
import com.bezos.witsiemon.controller.PlayerController;

/**
 *
 * @author vasty
 */
public class GameScreen extends AbstractScreen{

	private Map map;
	
	private Actor player;
	private PlayerController controller;
	
	//Textures
	private Texture avatar;
	
	private SpriteBatch batch;
	
	public GameScreen(Pokemon app) {
		super(app);
		batch = new SpriteBatch();
		
		System.out.println("Test...");
		map = new Map("res/maps/map.tmx", "terrain");
		
		avatar = new Texture("res/sprites/bob_back_walk.001.png");
		player = new Actor(map, 0, 0);
		
		controller = new PlayerController(player);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render(float delta) {
		batch.begin();
			for (int x = 0; x < map.getWidth(); x++) {
				for (int y = 0; y < map.getHeight(); y++) {
					TextureRegion texture = map.getTile(x, y).getTexture();
					
					batch.draw(texture,
							x*Settings.SCALED_TILE_SIZE,
							y*Settings.SCALED_TILE_SIZE,
							Settings.SCALED_TILE_SIZE,
							Settings.SCALED_TILE_SIZE  );
				}
			}
			
			batch.draw(avatar,
					player.getX()*Settings.SCALED_TILE_SIZE,
					player.getY()*Settings.SCALED_TILE_SIZE,
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
