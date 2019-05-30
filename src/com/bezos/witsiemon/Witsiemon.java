/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezos.witsiemon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.bezos.witsiemon.screen.BattleScreen;
import com.bezos.witsiemon.screen.GameScreen;


public class Witsiemon extends Game{
	
	private GameScreen screen;
	private BattleScreen battleScreen;
	public boolean battle;
	
	private AssetManager assetmanager;
	
	@Override
	public void create() {
		assetmanager = new AssetManager();
		assetmanager.load("res/packed/textures.atlas", TextureAtlas.class);
		assetmanager.finishLoading();
		
		screen = new GameScreen(this);
		battleScreen = new BattleScreen(this);
		this.setScreen(screen);
	}
	
	@Override
	public void render(){
		Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		super.render();
	}

	public AssetManager getAssetmanager() {
		return assetmanager;
	}
	
}
