package witsiemon.model;

import java.util.HashMap;
import java.util.Map;

import battle.moves.Move;
import battle.STAT;

public class Pokemon {

	
	private String name="";
	private int level = 0;
	private boolean consciousness = true;
	
	Map<STAT,Integer> stats;
	int currHP=100;
	
	Move[] moves = new Move[4];
	
	public Pokemon(String name, int level) {
		this.name = name;
		this.level = level;
		
		stats= new HashMap<STAT, Integer>();
		
		//Sets all stats to 15
		
		for (STAT stat : STAT.values()) {
			stats.put(stat, 15);
		}
		
		//Sets HP to full(100)
		stats.put(STAT.HITPOINTS, 100);
		
	}
	
	public int getLevel() {
		return this.level;
	}
	public String getName() {
		return this.name;
	}
	
	void setHP(int HP) {
		this.currHP = HP;
	}
	
	int getHP() {
		return this.currHP;
	}
	
	public boolean canFight() {
		return consciousness;
	}
	
	//Assume pos is valid ( < 4 )
	
	void newMove(Move move, int pos) {
		moves[pos] = move;
	}
	
	//Assume pos is valid ( < 4 )
	Move getMove(int pos) {
		return moves[pos];
	}
	
	int statValue(STAT s) {
		return stats.get(s);
	}

	public int getStat(STAT speedValue) {
		// TODO Auto-generated method stub
		return stats.get(speedValue);
	}

	public int getCurrentHitpoints() {
		// TODO Auto-generated method stub
		return this.currHP;
	}
	
}
