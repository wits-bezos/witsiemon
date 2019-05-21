package com.bezos.witsiemon.actors;

public class Camera {
	private float x = 0f;
	private float y = 0f;
	
	public void update(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	

}
