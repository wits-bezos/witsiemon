/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bezos.witsiemon.screen;

import com.badlogic.gdx.Screen;
import com.bezos.witsiemon.Witsiemon;

public abstract class AbstractScreen implements Screen {

	private Witsiemon app;
	
	public AbstractScreen(Witsiemon app){
		this.app = app;
	}
	
	public abstract void update(float delta);
	
	@Override
	public abstract void show();

	@Override
	public abstract void render(float delta);

	@Override
	public abstract void resize(int width, int height);

	@Override
	public abstract void pause();

	@Override
	public abstract void resume();

	@Override
	public abstract void hide();

	@Override
	public abstract void dispose();

}
