package src.witsiemon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import src.witsiemon.model.Pokemon;
import src.witsiemon.screen.GameScreen;
import src.witsiemon.screen.battleScreen;

public class Witsiemon extends Game {
	
	private GameScreen screen;
	private AssetManager assetManager;
	private battleScreen battleScreen;
	private Pokemon user;
	private Pokemon enemy;
	public boolean battle;
	
	public Witsiemon(boolean battle){
		this.battle = battle;
	}
	@Override
	public void create() {
		assetManager = new AssetManager();
		assetManager.load("res/packed/textures.atlas", TextureAtlas.class);
		assetManager.finishLoading();
		
		user = new Pokemon("charizard",100,20,30,6);
		enemy = new Pokemon("ekans",100,15,2,1);
		battleScreen = new battleScreen(this, enemy, user);
		screen = new GameScreen(this);
		if(battle) {
			this.setScreen(battleScreen);
	
		}
		else {
			this.setScreen(screen);
		}
	}
	
	@Override
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		super.render();
	}
	
	public AssetManager getAssetManager() {
		return assetManager;
	}

}