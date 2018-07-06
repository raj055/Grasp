package com.grasp.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.grasp.game.MyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = MyGame.TITLE;
		config.width = MyGame.WIDTH;
		config.height = MyGame.HEIGHT;
		new LwjglApplication(new MyGame(), config);
	}
}
