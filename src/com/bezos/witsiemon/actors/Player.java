package com.bezos.witsiemon.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite{
	
	/*
	private Vector2 velocity = new Vector2();
	
	private float speed = 60*2; ///gravity = 60 * 1.8f;
	
	private TiledMapTileLayer tile;
	
	public Player(Sprite sprite, TiledMapTileLayer tile) {
		super(sprite);
		this.tile = tile;
	}
	
	public boolean move(float delta, int dx, int dy) {
		if (tile.getCell((int) getX() + dx, (int) getY() + dy).getTile()) {
			return false;
		}
		//velocity.y -= 0 * delta;
		
		/*if (velocity.y > speed) {
			velocity.y = speed;
		}
		else if (velocity.y < speed) {
			velocity.y = -speed;
		}
		
		setX(getX() + velocity.x*delta);
		setY(getY() + velocity.y*delta); 
		
		return true;
	}

	@Override
	public void draw(Batch batch) {
		move(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}
	*/
	
	
}
