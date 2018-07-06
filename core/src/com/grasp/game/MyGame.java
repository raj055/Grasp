package com.grasp.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.grasp.game.Factory.GameStates;

public class MyGame extends Game {

	public static final String TITLE = "Grasp";
	public static final int WIDTH = 400;
	public static final int HEIGHT = 700;

//	private SpriteBatch batch;

	private GameStates gameStates;

	@Override
	public void create () {
		gameStates = new GameStates(this);
	}

	@Override
	public void render () {
		super.render();
		gameStates.render();
	}

	@Override
	public void dispose () {
	}
}
