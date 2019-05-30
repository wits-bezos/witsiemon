package com.bezos.witsiemon.screen;

import java.awt.Font;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.bezos.witsiemon.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.audio.Mp3.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.bezos.witsiemon.Witsiemon;
import com.bezos.witsiemon.model.Pokemon;

public class BattleScreen extends AbstractScreen{

	private GameScreen screen;
	private AssetManager assetManager;
	private Pokemon user;
	private Pokemon enemy;
	private Batch batch;
	
	public static Texture backgroundTexture;
    public static Sprite backgroundSprite;
    public static Texture attack;
    public static Sprite attackSprite;
    public static Texture heal;
    public static Sprite healSprite;
    public static Texture battle;
    public static Sprite battleSprite;
    public static Texture victory;
    public static Sprite victorySprite;
    int game = 0;
    Witsiemon appp;
    private float elapsed;
    

   
    
	ShapeRenderer shapeRenderer1 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer2 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer3 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer4 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer5 =  new ShapeRenderer();

	BitmapFont font = new BitmapFont();
	BitmapFont font2 = new BitmapFont();

	private com.badlogic.gdx.audio.Music music_level1;
	

	private boolean user_turn = true;


	

	public BattleScreen(Witsiemon app) {
		super(app);
		this.appp = app;
		
		assetManager = new AssetManager();
		assetManager.load("res/battle/packed/textures.atlas", TextureAtlas.class);
		assetManager.finishLoading();
		
		user = new Pokemon("res/battle/charizard.png",100,20,30,6);
		enemy = new Pokemon("res/battle/ekans.png",100,15,2,1);
		
		batch = new SpriteBatch();
		backgroundTexture = new Texture("res/battle/background.png");
        backgroundSprite =new Sprite(backgroundTexture);
        
        attack = new Texture("res/battle/attack.png");
        attackSprite = new Sprite(attack);
        
        heal =  new Texture("res/battle/heal.png");
        healSprite = new Sprite(heal);
        
        battle = new Texture("res/battle/battle.png");
        battleSprite = new Sprite(battle);
        
        victory = new Texture("res/battle/victory.png");
        victorySprite = new Sprite(victory);

		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(float delta) {
		
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


	public void renderBackground() {
        backgroundSprite.draw(batch);
	}
	
	private void renderAttack() {
		batch.draw(attack,  200,180,180,180);

	}
	
	private void renderHeal() {
		batch.draw(heal,  200,180,180,180);

	}
	
	private void renderBattle() {
		batch.draw(battle,  200,180,180,180);

	}
	
	private void renderVictory() {
		batch.draw(victory,  200,180,180,180);
	}
	
	
	@Override

	public void render(float delta) {
		
		batch.begin();
		renderBackground();
		batch.end();		
			
			
			batch.begin();
			batch.draw(enemy.getSprite(),450,220,150,132);
			batch.draw(user.getSprite(), 0, 200, 200, 203);
			batch.end();
			if(game == 0) {	

			shapeRenderer5.begin(ShapeType.Filled);
			shapeRenderer5.setColor(Color.WHITE);
			shapeRenderer5.rect(180, 40, 250, 100);
			shapeRenderer5.end();

			batch.begin();
			font.setColor(Color.BLUE);
			font.draw(batch, "A) ATTACK", 190, 70);
			font.draw(batch, "B) SPECIAL ATTACK", 190, 100);
			font.draw(batch, "D) HEAL", 190, 130);
			batch.end();	
			
			Gdx.input.setInputProcessor(new InputAdapter() {
		        @Override public boolean keyUp (int keycode) {
	            	font.setColor(Color.RED);

		        	//Attack
		            if (keycode == Input.Keys.A) { 
			        	batch.begin();
		            	font.draw(batch, "A) ATTACK", 190, 70);
		            	batch.end();
		                if(user_turn) {
		                	enemy.setDMG(user.getDMG());
		                	user_turn = false;
		    				return true;

		                }
		                else {
		                	batch.begin();
			            	font.draw(batch, "A) ATTACK", 190, 70);
		                	batch.end();
			            	user.setDMG(enemy.getDMG());
		                	user_turn = true;
		    				return true;

		                }

		            }
		            
		            //DEFEND
		            else if(keycode ==Input.Keys.D) {
		            	if(user_turn) {
							user.setHP(10);
							batch.begin();
							font.draw(batch, "D) HEAL", 190, 130);
							batch.end();
							user_turn = false;
							return true;

						}
						else {
							enemy.setHP(10);
							batch.begin();
							font.draw(batch, "D) HEAL", 190, 130);
							batch.end();
							user_turn = true;
							return true;

						}
					}
		            
		            //HEAL
		            else if(keycode == Input.Keys.B) {
		            	if(user_turn) {
		            		batch.begin();
		        			font.draw(batch, "B) SPECIAL ATTACK", 190, 100);
		        			batch.end();
							enemy.setDMG(user.getSP());
							user_turn = false;
							return true;

						}
						else {
							batch.begin();
							font.draw(batch, "B) SPECIAL ATTACK", 190, 100);
							batch.end();
							user.setDMG(enemy.getSP());
							user_turn = true;
							return true;

						}
						
					}
					return true;
		        }
		    });

			}
			
			shapeRenderer1.begin(ShapeType.Filled);
			shapeRenderer1.setColor(Color.RED);
			shapeRenderer1.rect(20, 180, 150, 20);
			shapeRenderer1.end();
			
			shapeRenderer2.begin(ShapeType.Filled);
			shapeRenderer2.setColor(Color.GREEN);
			shapeRenderer2.rect(20, 180, (float) (user.getHP()*1.5), 20);
			shapeRenderer2.end();
			
			shapeRenderer3.begin(ShapeType.Filled);
			shapeRenderer3.setColor(Color.RED);
			shapeRenderer3.rect(450, 180, 150, 20);
			shapeRenderer3.end();
			
			shapeRenderer4.begin(ShapeType.Filled);
			shapeRenderer4.setColor(Color.GREEN);
			shapeRenderer4.rect(450, 180, (float) (enemy.getHP()*1.5), 20);
			shapeRenderer4.end();
			
			
			if(!enemy.isAwake() || !user.isAwake()) {
				
				shapeRenderer1.begin(ShapeType.Filled);
				shapeRenderer1.setColor(Color.GRAY);
				shapeRenderer1.rect(180, 180, 250, 150);
				shapeRenderer1.end();
				
				batch.begin();
				font2.setColor(Color.RED);
				font2.draw(batch, "GAME OVER", 260, 290);
				if(enemy.isAwake()) {
					font2.draw(batch, "ENEMY HAS WON THE MATCH !!!", 190, 250);
				}
				else {
					font2.draw(batch," USER HAS WON THE MATCH !!!",190 , 250);
				}
				batch.end();

				
				
				game = 1;
				//MAKE THE NEW SCREEN START RIGHT HERE
				elapsed += delta;
				if(elapsed > 1.0) {
				newScreen();
				}


					
			

				
			}
		
	}
	

	public void newScreen() {
		int delay = 1000; // number of milliseconds to sleep

        long start = System.currentTimeMillis();
        while(start >= System.currentTimeMillis() - delay);
		appp.battle = false;
		GameScreen screen = new GameScreen(appp);
		appp.setScreen(screen);
        
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
		// TODO Auto-generated method stub
		
	}
	

}
