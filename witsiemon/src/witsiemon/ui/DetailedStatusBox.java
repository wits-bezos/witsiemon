package witsiemon.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class DetailedStatusBox extends StatusBox {
	
	private Label hpText;

	public DetailedStatusBox(Skin skin) {
		super(skin);
		
		hpText = new Label("NaN/NaN", skin, "smallLabel");
		uiContainer.row();
		uiContainer.add(hpText).expand().right();
	}
	
	public void setHPText(int hpLeft, int hpTotal) {
		hpText.setText(hpLeft+"/"+hpTotal);
	}

}
