package com.bezos.witsiemon.actors;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Map {
	private int width, height;
	private Tile[][] map;

	public Map(String filename, String terrain) {
		TmxMapLoader loader = new TmxMapLoader();
		TiledMap tileMap = loader.load(filename);
		TiledMapTileLayer layer = (TiledMapTileLayer) tileMap.getLayers().get(terrain);
		
		int width = layer.getWidth();
		int height = layer.getHeight();
		
		this.width = width;
		this.height = height;
	
		map = new Tile[width][height];
		
		TextureRegion texture;
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				texture = layer.getCell(x, y).getTile().getTextureRegion();
				map[x][y] = new Tile(texture, PROPERTIES.COLLIDABLE);
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
