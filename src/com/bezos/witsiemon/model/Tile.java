package com.bezos.witsiemon.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Tile {
	private TextureRegion texture;
	private PROPERTIES property;
	private Actor actor;
	
	public Tile(TextureRegion texture, PROPERTIES property) {
		this.texture = texture;
		this.property = property;
	}
	
	public TextureRegion getTexture() {
		return texture;
	}

	public void setTexture(TextureRegion terrain) {
		this.texture = texture;
	}

	public PROPERTIES getProperty() {
		return property;
	}

	public void setProperty(PROPERTIES property) {
		this.property = property;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	} 
}
