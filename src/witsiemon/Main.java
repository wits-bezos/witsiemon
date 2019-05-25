package witsiemon;

import java.util.Scanner;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	 public static void main(String[] args) {
		 LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		 config.title = "Witsiemon";
		 config.height = 400;
		 config.width = 600;
		 boolean battle = false;
		 int i=1;
		 //Scanner in =  new Scanner(System.in);
		 //i = in.nextInt();
		 if(i == 1) {
			 battle = true;
		 }
		 new LwjglApplication(new Witsiemon(true), config);
	 }
}
