package witsiemon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import witsiemon.Settings;
import witsiemon.Witsiemon;
import witsiemon.controller.PlayerController;
import witsiemon.model.Actor;
import witsiemon.model.TERRAIN;
import witsiemon.model.TileMap;

public class GameScreen extends AbstractScreen {
	
	private PlayerController controller;
	private Actor player;
	private SpriteBatch batch;
	private Texture standingSouth;
	private Texture grass;
	private Texture grass2;
	private TileMap map;
	

	public GameScreen(Witsiemon app) {
		super(app);
		
		standingSouth = new Texture("res/player1_front.png");
		grass = new Texture("res/grass.png");
		grass2 = new Texture("res/grass2.png");
		batch = new SpriteBatch();
		map = new TileMap(10, 10);
		player = new Actor(map,0, 0);
		controller = new PlayerController(player);
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

	@Override
	public void render(float delta) {
		batch.begin();
		
		for(int x = 0; x < map.getWidth();x++) {
			for(int y = 0; y < map.getHeight(); y++) {
				Texture render;
				if(map.getTile(x, y).getTerrain() == TERRAIN.GRASS) {
					render = grass;
				}else {
					render = grass2;
				}
				batch.draw(render,x*Settings.SCALED_TILE_SIZE, y*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
			}
		}
		
		batch.draw(standingSouth, player.getX()*Settings.SCALED_TILE_SIZE, player.getY()*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE*1.5f);
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
