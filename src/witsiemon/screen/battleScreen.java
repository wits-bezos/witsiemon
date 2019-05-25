package witsiemon.screen;

import java.awt.Font;
import witsiemon.Main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import witsiemon.Witsiemon;
import witsiemon.model.Pokemon;

public class battleScreen extends AbstractScreen{

	Pokemon enemy;
	Pokemon user;
	Batch batch;
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

    

   
    
	ShapeRenderer shapeRenderer1 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer2 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer3 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer4 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer5 =  new ShapeRenderer();

	BitmapFont font = new BitmapFont();
	BitmapFont font2 = new BitmapFont();

	

	private boolean user_turn = true;


	

	public battleScreen(Witsiemon app, Pokemon enemy, Pokemon user) {
		super(app);

		this.enemy = enemy;
		this.user = user;
		batch = new SpriteBatch();
		backgroundTexture = new Texture("res/background.png");
        backgroundSprite =new Sprite(backgroundTexture);
        
        attack = new Texture("res/attack.png");
        attackSprite = new Sprite(attack);
        
        heal =  new Texture("res/heal.png");
        healSprite = new Sprite(heal);
        
        battle = new Texture("res/battle.png");
        battleSprite = new Sprite(battle);
        
        victory = new Texture("res/victory.png");
        victorySprite = new Sprite(victory);

		// TODO Auto-generated constructor stub
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
		
		
		
		/// THIS IT IT
		/// THIS IS WHERE A NEW SCREEN MUST BE MADE
		/// DO NOT IGNORE THIS !
		
		///I"M TRYING TO MAKE IT STAND OUT
		
		
		
		
		
		
		
		
		
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
			
			//MAKE THE NEW SCREEN START RIGHT HERE
			
		

			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		else {	

			Gdx.input.setInputProcessor(new InputAdapter() {
	        @Override public boolean keyUp (int keycode) {
	        	
	        	//Attack
	            if (keycode == Input.Keys.A) { 
	                if(user_turn) {
	                	enemy.setDMG(user.getDMG());
	                	user_turn = false;
	    				return true;

	                }
	                else {
	                	user.setDMG(enemy.getDMG());
	                	user_turn = true;
	    				return true;

	                }

	            }
	            
	            //DEFEND
	            else if(keycode ==Input.Keys.D) {
	            	if(user_turn) {
						user.setHP(10);
						user_turn = false;
						return true;

					}
					else {
						enemy.setHP(10);
						user_turn = true;
						return true;

					}
				}
	            
	            //HEAL
	            else if(keycode == Input.Keys.B) {
	            	if(user_turn) {
						enemy.setDMG(user.getSP());
						user_turn = false;
						return true;

					}
					else {
						user.setDMG(enemy.getSP());
						user_turn = true;
						return true;

					}
					
				}
				return true;
					
	        }
	    });
			
			
		
			
			
			batch.begin();
			batch.draw(enemy.getSprite(),450,220,150,132);
			batch.draw(user.getSprite(), 0, 200, 200, 203);
			batch.end();
			
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
		
	}
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
