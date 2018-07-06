package com.grasp.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.grasp.game.Enum.ScreenStates;
import com.grasp.game.Factory.GameStates;
import com.grasp.game.MyGame;

/**
 * Created by HP on 12-01-2018.
 */

public class GameOverScreen implements Screen {
  // reference to the game
  MyGame game;

  Stage stage;

  private Dialog dialog;


  public GameOverScreen (final ScreenStates game) {
    stage = new Stage();

		/* load the background image */
    Image bg = new Image(new Texture("data/blur.jpg"));
    bg.setSize(MyGame.WIDTH, MyGame.HEIGHT);
    stage.addActor(bg);

  }

  @Override
  public void resize (int width, int height) {
  }

  @Override
  public void show () {
    Gdx.input.setInputProcessor(stage);

    Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
    dialog = new Dialog("Time's Up...", skin);
    dialog.setSize(250, 250);
    dialog.setPosition(Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 100);

    Image level = new Image(new Texture("data/levelsel.png"));
    level.setSize(20, 20);
    level.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        GameStates.screenStates = ScreenStates.LEVELSCREEN;
      }
    });


    dialog.getContentTable().defaults().pad(10);
    dialog.getContentTable().add(level);

    stage.addActor(dialog);

  }

  @Override
  public void hide () {
    dispose();
  }

  @Override
  public void pause () {
  }

  @Override
  public void resume () {
  }

  @Override
  public void render (float delta) {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    stage.draw();
  }

  @Override
  public void dispose () {
    stage.clear();
    stage.dispose();
  }
}
