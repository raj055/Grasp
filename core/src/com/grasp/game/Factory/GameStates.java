package com.grasp.game.Factory;

import com.badlogic.gdx.Screen;
import com.grasp.game.Enum.Chapters;
import com.grasp.game.Enum.Dialog;
import com.grasp.game.Enum.Levels;
import com.grasp.game.Enum.ScreenStates;
import com.grasp.game.Enum.Steps;
import com.grasp.game.MyGame;
import com.grasp.game.Screens.GameOverScreen;
import com.grasp.game.Screens.MainScreen;

/**
 * Created by HP on 12-01-2018.
 */

public class GameStates {

  private final MyGame game;

  //initialise the parameters.
  public static Chapters chapterNumber = null;
  public static Levels levelNumber = null;
  public static ScreenStates screenStates = null;
  public static Steps steps = null;

  static ScreenStates previousStates = null;

  private int currentState;

  //current screen to be shown
  Screen currentScreen;

  public GameStates(MyGame game){

    //The first chapter number is
    screenStates = ScreenStates.MENUSCREEN;
    GetScreen getScreenParameters;

    //assign the game for screen updation
    this.game = game;

    //Initialise the current states
    chapterNumber = Chapters.CHAPTER_1;
    levelNumber = Levels.LEVEL1;
    steps = Steps.STEP_1;

    //get the current screen
    implementCurrentState();

  }

  private void implementCurrentState() {

    if(previousStates == screenStates)
      return;
    //implement Current screen state
    switch (screenStates)
    {
      case MENUSCREEN:
        currentScreen = new MainScreen(ScreenStates.MENUSCREEN);
        break;
      case LEVELSCREEN:
        currentScreen = new MainScreen(ScreenStates.LEVELSCREEN);
        break;
      //Addition case for testing purpose
      case STEPS:
        currentScreen = new MainScreen(ScreenStates.STEPS);
        break;
      case GAMEOVER:
        currentScreen = new GameOverScreen(ScreenStates.GAMEOVER);
        break;
      case PLAYSCREEN:
        currentScreen = GetScreen.getCurrentScreen();
        break;
      default:
        screenStates = ScreenStates.MENUSCREEN;
        break;
    }

    this.game.setScreen(currentScreen);
    previousStates = screenStates;
  }

  public void render(){
    implementCurrentState();
  }

}
