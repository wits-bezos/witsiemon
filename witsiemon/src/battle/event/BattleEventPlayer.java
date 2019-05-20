package battle.event;

import com.badlogic.gdx.graphics.Texture;
import battle.BATTLE_PARTY;
import battle.animation.BattleAnimation;
import ui.DialogueBox;
import ui.StatusBox;

import aurelienribon.tweenengine.TweenManager;


public interface BattleEventPlayer {
	
	public void playBattleAnimation(BattleAnimation animation, BATTLE_PARTY party);
	
	public void setPokemonSprite(Texture region, BATTLE_PARTY party);
	
	public DialogueBox getDialogueBox();
	
	public StatusBox getStatusBox(BATTLE_PARTY party);
	
	public BattleAnimation getBattleAnimation();
	
	public TweenManager getTweenManager();
	
	public void queueEvent(BattleEvent event);
}
