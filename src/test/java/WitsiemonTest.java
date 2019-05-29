

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import src.witsiemon.Witsiemon;

public class WitsiemonTest {
	// test case to validate correct change in direction 
	@Test
	public void getAssetManager_check_assetmanager() {
		
		// set up
		Witsiemon app = new Witsiemon(true);
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		 config.title = "Witsiemon";
		 config.height = 400;
		 config.width = 600;
		 config.vSyncEnabled = true;
		 new LwjglApplication(app, config);
		 
		
		
		// act 
		AssetManager result = app.getAssetManager();
		
		// verify
		assertNull(result);
	}
}
