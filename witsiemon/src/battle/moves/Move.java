package battle.moves;

import battle.BATTLE_PARTY;

import battle.BattleMechanics;
import battle.animation.BattleAnimation;
import battle.event.BattleEventQueuer;
import witsiemon.model.Pokemon;


public abstract class Move {
	
	protected MoveSpecification spec;
	protected Class<? extends BattleAnimation> animationClass;
	
	public Move(MoveSpecification spec, Class<? extends BattleAnimation> animationClass) {
		this.spec = spec;
		this.animationClass = animationClass;
	}
	
	public int useMove(BattleMechanics mechanics, Pokemon user, Pokemon target, BATTLE_PARTY party, BattleEventQueuer broadcaster) {
		int damage = mechanics.calculateDamage(this, user, target);
		target.applyDamage(damage);
		return damage;
	}
	
	public abstract BattleAnimation animation();
	
	public abstract String message();
	
	/**
	 * @return If this move deals damage
	 */
	public abstract boolean isDamaging();
	
	public String getName() {
		return spec.getName();
	}
	
	public MOVE_TYPE getType(){
		return spec.getType();
	}
	
	public MOVE_CATEGORY getCategory() {
		return spec.getCategory();
	}
	
	public int getPower() {
		return spec.getPower();
	}
	
	public float getAccuracy() {
		return spec.getAccuracy();
	}
	
	public MoveSpecification getMoveSpecification() {
		return spec;
	}
	
	/**
	 * @return A copy of this instance.
	 */
	public abstract Move clone();
}
