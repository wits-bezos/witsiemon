package com.bezos.witsiemon.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;


public class Map {
	private int width;
	private int height;
	private int size;
	private Layer[] map;
	private PROPERTIES[][] properties;
	
	public Map(String filename) {
		TmxMapLoader loader = new TmxMapLoader();
		TiledMap tilemap = loader.load(filename);
		
		TiledMapTileLayer layer;
		
		int n = tilemap.getLayers().getCount();
		
		this.size = n;
		
		this.map = new Layer[n];
		
		layer = (TiledMapTileLayer) tilemap.getLayers().get(0);
		this.map[0] = new Layer(tilemap, layer);
		
		for(int i = 1; i < n; i++) {
			layer = (TiledMapTileLayer) tilemap.getLayers().get(i);
			System.out.println(layer.getName());
			this.map[i] = new Layer(tilemap, layer);
		}
		
		this.width = layer.getWidth();
		this.height = layer.getHeight();
		
		properties = new PROPERTIES[width][height];
		for (int x = 0; x < width; x++){
			for (int y = 0; y < height; y++){
				properties[x][y] = PROPERTIES.COLLIDABLE;
				for (Layer l : map) {
					try{
						Boolean blocked = l.getTile(x, y).getProperty().equals(PROPERTIES.BLOCKED);
						if (blocked){
							properties[x][y] = PROPERTIES.BLOCKED;
						}
					}
					catch (Exception e) {
						
					}
				}
			}
		}
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Layer getLayer(int index) {
		return map[index];
	}
	
	public PROPERTIES getProperties(int x, int y) {
		return properties[x][y];
	}
}
