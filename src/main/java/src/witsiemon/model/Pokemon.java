package src.witsiemon.model;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.graphics.Texture;


public class Pokemon {
	
	private String name;
	
	private int level, HP, ATT, SP_ATT, SPEED;
	Texture appearance;
	
	public Pokemon(String name, int HP, int ATT, int SP_ATT, int SPEED){
		this.name = name;
		this.HP = HP;
		this.ATT = ATT;
		this.SP_ATT = SP_ATT;
		this.SPEED = SPEED;
		this.appearance = new Texture("res/" + name + ".png");
	}
	
	public boolean isAwake() {
		if(this.HP > 0) {
			return true;
		}
		return false;
	}
	public Texture getSprite() {
		return appearance;
	}
	public void setDMG(int dmg) {
		this.HP = HP - dmg;
	}
	public void setHP(int add) {
		HP += add;
		if(HP > 100) {
			HP = 100;
		}
	}
	public int getHP() {
		if(this.HP <0) {
			this.HP = 0;
		}
		return this.HP;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDMG() {
		return ATT;
	}
	public int getSP() {
		return SP_ATT;
	}
	public int getSpeed() {
		return SPEED;
	}
	
	
	
}