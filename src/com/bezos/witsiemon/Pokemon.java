/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezos.witsiemon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.bezos.witsiemon.screen.GameScreen;

/**
 *
 * @author vasty
 */

public class Pokemon extends Game{
	
	private GameScreen screen;
	
	@Override
	public void create() {
		screen = new GameScreen(this);
		this.setScreen(screen);
	}
	
	@Override
	public void render(){
		Gdx.gl.glClearColor(0f, 0f, 0f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		super.render();
	}
	
}
