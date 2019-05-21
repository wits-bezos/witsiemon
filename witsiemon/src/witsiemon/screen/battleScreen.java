package witsiemon.screen;

import java.awt.Font;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import witsiemon.Witsiemon;
import witsiemon.model.Pokemon;

public class battleScreen extends AbstractScreen{

	Pokemon enemy;
	Pokemon user;
	Batch batch;
	ShapeRenderer shapeRenderer1 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer2 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer3 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer4 =  new ShapeRenderer();
	ShapeRenderer shapeRenderer5 =  new ShapeRenderer();
	int userTurn = 0;

	BitmapFont font = new BitmapFont();
	
	private boolean attack;
	private boolean sp_attack;
	private boolean defend;

	
	

	public battleScreen(Witsiemon app, Pokemon enemy, Pokemon user) {
		super(app);

		this.enemy = enemy;
		this.user = user;
		batch = new SpriteBatch();

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

	public void userTurn() {

		if(attack) {
			enemy.setDMG(user.getDMG());
		}
		if(sp_attack) {
			enemy.setDMG(user.getSP());
		}
		if(defend) {
			user.setHP(10);
		}
	}
	
	public void enemyTurn() {

		if(attack) {
			user.setDMG(enemy.getDMG());
		}
		if(sp_attack) {
			user.setDMG(enemy.getSP());
		}
		if(defend) {
			user.setHP(10);
		}
	}
	@Override
	public void render(float delta) {
		
		
			attack = false;
			defend = false;
			sp_attack = false;
			Gdx.input.setInputProcessor(new InputAdapter() {
	        @Override public boolean keyUp (int keycode) {
	            if (keycode == Input.Keys.A) { 
	                attack = true;

	            }
	            else if(keycode ==Input.Keys.D) {
					defend = true;
				}
	            else if(keycode == Input.Keys.B) {
					sp_attack = true;
				}
				return true;
					
	        }
	    });
			if(userTurn == 1) {
				userTurn = 0;
				userTurn();
			}
			else {
				userTurn = 1;
				enemyTurn();
			}
			
		
			batch.begin();
			batch.draw(enemy.getSprite(),450,250,150,132);
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
			font.draw(batch, "D) DEFEND", 190, 130);
			batch.end();
			
					
			
			
			shapeRenderer2.begin(ShapeType.Filled);
			shapeRenderer2.setColor(Color.GREEN);
			shapeRenderer2.rect(20, 180, (float) (user.getHP()*1.5), 20);
			shapeRenderer2.end();
			
			shapeRenderer1.begin(ShapeType.Filled);
			shapeRenderer1.setColor(Color.RED);
			shapeRenderer1.rect(20, 180, 150, 20);
			shapeRenderer1.end();
			
			
			
			shapeRenderer3.begin(ShapeType.Filled);
			shapeRenderer3.setColor(Color.RED);
			shapeRenderer3.rect(425, 180, 150, 20);
			shapeRenderer3.end();
			
			shapeRenderer4.begin(ShapeType.Filled);
			shapeRenderer4.setColor(Color.GREEN);
			shapeRenderer4.rect(425, 180, (float) (enemy.getHP()*1.5), 20);
			shapeRenderer4.end();
		
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
