package com.bezos.witsiemon.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Layer {
	private int width, height;
	private Tile[][] map;

	public Layer(TiledMap tilemap, TiledMapTileLayer layer) {	
		
		int width = layer.getWidth();
		int height = layer.getHeight();
		
		this.width = width;
		this.height = height;
	
		map = new Tile[width][height];
		
		TextureRegion texture;
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				try {
					texture = layer.getCell(x, y).getTile().getTextureRegion();
					Boolean blocked = layer.getCell(x, y).getTile().getProperties().containsKey("blocked");
					if (blocked) {
						map[x][y] = new Tile(texture, PROPERTIES.BLOCKED);
					}
					else {
						map[x][y] = new Tile(texture, PROPERTIES.COLLIDABLE);
					}
				}
				catch (Exception e){
					texture = null;
				}			
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		return map[x][y];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
