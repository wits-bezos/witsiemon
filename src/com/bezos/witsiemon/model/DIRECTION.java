package com.bezos.witsiemon.model;

public enum DIRECTION {
	NORTH(0, 1),
	SOUTH(0, -1),
	EAST(1, 0),
	WEST(-1, 0);
	
	private int dx, dy;
	
	private DIRECTION(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}
	
}
