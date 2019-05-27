package com.bezos.witsiemon.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Map_backup {
	private int width, height;
	private Tile[][] map;

	public Map_backup(String filename, String layername) {	
		TmxMapLoader loader = new TmxMapLoader();
		TiledMap tilemap = loader.load(filename);
		
		TiledMapTileLayer layer = (TiledMapTileLayer) tilemap.getLayers().get(layername);
		
		int width = layer.getWidth();
		int height = layer.getHeight();
		
		this.width = width;
		System.out.println("width: " + width);
		this.height = height;
		System.out.println("width: " + width);
	
		map = new Tile[width][height];
		
		TextureRegion texture;
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				try {
					texture = layer.getCell(x, y).getTile().getTextureRegion();
					map[x][y] = new Tile(texture, PROPERTIES.COLLIDABLE);
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
