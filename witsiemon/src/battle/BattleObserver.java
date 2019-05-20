package battle;

import battle.event.BattleEvent;


public interface BattleObserver {
	

	public void queueEvent(BattleEvent event);
}
