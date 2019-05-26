package game.com.java.screen;
import com.badlogic.gdx.Screen;
import game.com.java.Witsiemon;

public abstract class AbstractScreen implements Screen {

	private Witsiemon app;
	
	public AbstractScreen(Witsiemon app) {
		this.app = app;
	}
	
	@Override
	public abstract void dispose();

	@Override
	public abstract void hide();

	@Override
	public abstract void pause();

	@Override
	public abstract void render(float delta);

	@Override
	public abstract void resize(int width, int height);

	@Override
	public abstract void resume();

	@Override
	public abstract void show();

}
