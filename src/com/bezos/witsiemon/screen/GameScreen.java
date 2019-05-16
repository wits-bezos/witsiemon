/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezos.witsiemon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.bezos.witsiemon.Pokemon;
import com.bezos.witsiemon.Settings;
import com.bezos.witsiemon.controller.PlayerController;
import com.bezos.witsiemon.model.Actor;
//import com.bezos.witsiemon.model.TileMap;

/**
 *
 * @author vasty
 */
public class GameScreen extends AbstractScreen{

	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	
	private Actor player;
	private PlayerController controller;
	
	//Textures
	private Texture avatar;
	private Texture grass;
	
	private SpriteBatch batch;
	
	public GameScreen(Pokemon app) {
		super(app);
		
		/*avatar = new Texture("res/sprites/bob_back_walk.001.png");
		batch = new SpriteBatch();
		*/
		
		TmxMapLoader loader = new TmxMapLoader();
		map = loader.load("res/maps/matrix_west.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		camera = new OrthographicCamera();
		
		//player = new Actor(map, 0, 0);
		controller = new PlayerController(player);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
	}

	@Override
	public void render(float delta) {
		renderer.setView(camera);
		renderer.render();
		
		
		/*batch.begin();
		
		for (int x = 0; x < map.getWidth(); x++) {
			for (int y = 0; x < map.getHeight(); y++) {
				batch.draw(grass,
						x*Settings.SCALED_TILE_SIZE,
						y*Settings.SCALED_TILE_SIZE,
						Settings.SCALED_TILE_SIZE,
						Settings.SCALED_TILE_SIZE * 2f);
			}
		}
		
		batch.draw(avatar, 
				player.getX()*Settings.SCALED_TILE_SIZE, 
				player.getY()*Settings.SCALED_TILE_SIZE, 
				Settings.SCALED_TILE_SIZE, 
				Settings.SCALED_TILE_SIZE * 2f);
		
		batch.end();
		*/
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.update();
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
		map.dispose();
		renderer.dispose();
	}
	
}
