package com.grasp.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.grasp.game.Enum.Chapters;
import com.grasp.game.Enum.Levels;
import com.grasp.game.Enum.ScreenStates;
import com.grasp.game.Enum.Steps;
import com.grasp.game.Factory.GameStates;
import com.grasp.game.Global.GlobalsCommonCount;
import com.grasp.game.MyGame;

/**
 * Created by HP on 12-01-2018.
 */

public class MainScreen implements Screen {

  private Stage stage;
  private BitmapFont font,font1;
  private GlobalsCommonCount glCmmCnt;

  private Image imgback;

  private ScreenStates screenState;

  public MainScreen(ScreenStates screenState){

    stage = new Stage();

    this.screenState = screenState;

  }

  @Override
  public void show() {

    //Set the input processor as the current stage
    Gdx.input.setInputProcessor(stage);

    //Set the background image.
    Image background = new Image(new Texture("data/bg_1.png"));
    background.setSize(MyGame.WIDTH, MyGame.HEIGHT);
    stage.addActor(background);

    glCmmCnt = GlobalsCommonCount.getInstance();

    font = new BitmapFont(Gdx.files.internal("fonts/foo.fnt"));
    font1 = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));

    Label.LabelStyle labelStyle = new Label.LabelStyle(font, Color.BLACK);
    Label.LabelStyle labelStyle1 = new Label.LabelStyle(font, Color.BLUE);

    Label titleLabel = new Label("Grasp", labelStyle);
    titleLabel.setFontScale(1.0f);
    titleLabel.setPosition(250, MyGame.HEIGHT - 50);
    stage.addActor(titleLabel);

    imgback = new Image(new Texture("data/back.png"));
    imgback.setSize(50,40);
    imgback.setPosition(MyGame.WIDTH - 50, 10);
    imgback.addListener(new ClickListener(){
      @Override
      public void clicked(InputEvent event, float x, float y) {
        GameStates.screenStates = ScreenStates.MENUSCREEN;
      }
    });
    stage.addActor(imgback);

    ClickListener clickedLevelBttn = new ClickListener(){
      @Override
      public void clicked(InputEvent event, float x, float y) {
        Label currState = (Label)event.getListenerActor();
        if(currState == null)
          return;
        java.lang.StringBuilder str = new java.lang.StringBuilder(currState.getText());
        String teststr = str.toString();

         if(screenState == ScreenStates.MENUSCREEN){
          int chapCount = 0;
          for(Chapters chapters: Chapters.values()) {
            if (teststr.contains(glCmmCnt.ChapterName[chapCount])) {
              if (chapters.ordinal() == chapCount)
                GameStates.chapterNumber = chapters;
            }
            chapCount++;
          }
          GameStates.screenStates = ScreenStates.LEVELSCREEN;
        }
        else if(screenState == ScreenStates.LEVELSCREEN) {
           int levelCount = 0;
           for(Levels lvl: Levels.values()) {
             if (teststr.contains(glCmmCnt.LevelsName[levelCount])) {
               if (lvl.ordinal() == levelCount)
                 GameStates.levelNumber = lvl;
             }
             levelCount++;
           }
           GameStates.screenStates = ScreenStates.STEPS;
         }
        else if(screenState == ScreenStates.STEPS) {
           int stepsCount = 0;
           for(Steps steps: Steps.values()) {
             if (teststr.contains(glCmmCnt.StepName[stepsCount])) {
               if (steps.ordinal() == stepsCount)
                 GameStates.steps = steps;
             }
             stepsCount++;
           }
           GameStates.screenStates = ScreenStates.PLAYSCREEN;
         }
      }
    };
    int countLevels = 0;
    int heightDiff = 50;
    int xPosition = 5;
    int maxCount = 15;
    if(screenState == ScreenStates.STEPS)
      maxCount = 6;

    for(int levelCount = 0; levelCount < maxCount; levelCount++) {
      Label level1Label;
      if(screenState == ScreenStates.LEVELSCREEN){
        level1Label = new Label(glCmmCnt.LevelsName[countLevels++], labelStyle1);
      }
      else if (screenState == ScreenStates.MENUSCREEN){
        level1Label = new Label(glCmmCnt.ChapterName[countLevels++], labelStyle1);
      }
       else
      {
        level1Label = new Label(glCmmCnt.StepName[countLevels++], labelStyle1);
      }

      level1Label.setPosition(xPosition, MyGame.HEIGHT - heightDiff);
      heightDiff += 90;
      level1Label.addListener(clickedLevelBttn);
      stage.addActor(level1Label);

      if(levelCount == 7)
      {
        xPosition = 180;
        heightDiff = 100;
      }
    }
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    stage.act(delta);
    stage.draw();
  }

  @Override
  public void resize(int width, int height) {

  }

  @Override
  public void pause() {

  }

  @Override
  public void resume() {

  }

  @Override
  public void hide() {

  }

  @Override
  public void dispose() {
    stage.dispose();
    font.dispose();
  }
}
