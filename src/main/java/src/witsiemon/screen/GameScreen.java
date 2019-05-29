package src.witsiemon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;

import src.witsiemon.Settings;
import src.witsiemon.Witsiemon;
import src.witsiemon.controller.PlayerController;
import src.witsiemon.model.Actor;
import src.witsiemon.model.TERRAIN;
import src.witsiemon.model.TileMap;
import src.witsiemon.util.AnimationSet;
import src.witsiemon.model.Camera;
import src.witsiemon.model.Pokemon;

public class GameScreen extends AbstractScreen {
	
	private PlayerController controller;
	private Camera camera;
	private Actor player;
	private SpriteBatch batch;
	private Texture standingSouth;
	private Texture grass;
	private Texture grass2;
	private TileMap map;
	private Witsiemon appp;
	private Pokemon user;
	private Pokemon enemy;

	public GameScreen(Witsiemon app) {
		super(app);
		this.appp = app;
		standingSouth = new Texture("res/player1_front.png");
		grass = new Texture("res/grass.png");
		grass2 = new Texture("res/grass2.png");
		batch = new SpriteBatch();
		
		TextureAtlas atlas = app.getAssetManager().get("res/packed/textures.atlas", TextureAtlas.class);
		
		AnimationSet animations = new AnimationSet(
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_north"), PlayMode.LOOP_PINGPONG),
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_south"), PlayMode.LOOP_PINGPONG),
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_east"), PlayMode.LOOP_PINGPONG),
			new Animation(0.3f/2f, atlas.findRegions("player1_walk_west"), PlayMode.LOOP_PINGPONG),
			atlas.findRegion("player1_stand_north"),
			atlas.findRegion("player1_stand_south"),
			atlas.findRegion("player1_stand_east"),
			atlas.findRegion("player1_stand_west")
		);
		
		map = new TileMap(10, 10);
		player = new Actor(map, 0, 0, animations);
		camera = new Camera();
		controller = new PlayerController(player);
		
		user = new Pokemon("charizard",100,20,30,6);
		enemy = new Pokemon("ekans",100,15,2,1);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	
	public void newScreen() {
		int delay = 1000; // number of milliseconds to sleep

        long start = System.currentTimeMillis();
        while(start >= System.currentTimeMillis() - delay);
		appp.battle = true;
		battleScreen battleScreen = new battleScreen(appp, enemy, user);
		appp.setScreen(battleScreen);
        
	}

	@Override
	public void render(float delta) {


  

		if(controller.update(delta)) {
			newScreen();
		}
		controller.update(delta);
		player.update(delta);
		camera.update(player.getWorldX()+0.5f, player.getWorldY()+0.5f);
		
		batch.begin();
		
		float worldStarX = Gdx.graphics.getWidth()/2 - camera.getCameraX()*Settings.SCALED_TILE_SIZE;
		float worldStarY = Gdx.graphics.getHeight()/2 - camera.getCameraY()*Settings.SCALED_TILE_SIZE;
		for(int x = 0; x < map.getWidth();x++) {
			for(int y = 0; y < map.getHeight(); y++) {
				Texture render;
				if(map.getTile(x, y).getTerrain() == TERRAIN.GRASS) {
					render = grass;
				}else {
					render = grass2;
				}
				batch.draw(render,worldStarX+x*Settings.SCALED_TILE_SIZE, worldStarY+y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
			}
		}
		
		batch.draw(player.getSprite(), 
				worldStarX+player.getWorldX()*Settings.SCALED_TILE_SIZE, 
				worldStarY+player.getWorldY()*Settings.SCALED_TILE_SIZE, 
				Settings.SCALED_TILE_SIZE, 
				Settings.SCALED_TILE_SIZE*1.5f);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(controller);
		
	}

}
