package com.grasp.game.Factory;

import com.badlogic.gdx.Screen;
import com.grasp.game.Enum.Chapters;

/**
 * Created by HP on 12-01-2018.
 */

public class GetScreen {
  //current Instance of Screen
  private static Screen currentScreen;

  public static Screen getCurrentScreen(){

    //Get the string of chapter name
    String chapterName = new String();

    //Check the chapter number
    if(GameStates.chapterNumber == Chapters.CHAPTER_1){
      chapterName = "Chapter1";
      currentScreen = new Chapter1();
    }
    else if(GameStates.chapterNumber == Chapters.CHAPTER_2){
      chapterName = "Chapter2";
      currentScreen = new Chapter2();
    }
    else if(GameStates.chapterNumber == Chapters.CHAPTER_3){
      chapterName = "Chapter3";
      currentScreen = new Chapter3();
    }
    else if(GameStates.chapterNumber == Chapters.CHAPTER_4){
      chapterName = "Chapter4";
      currentScreen = new Chapter4();
    }
    else if(GameStates.chapterNumber == Chapters.CHAPTER_5){
      chapterName = "Chapter5";
      currentScreen = new Chapter5();
    }
    else if(GameStates.chapterNumber == Chapters.CHAPTER_6){
      chapterName = "Chapter6";
      currentScreen = new Chapter6();
    }
    else if(GameStates.chapterNumber == Chapters.CHAPTER_7){
      chapterName = "Chapter7";
      currentScreen = new Chapter7();
    }
    else if(GameStates.chapterNumber == Chapters.CHAPTER_8){
      chapterName = "Chapter8";
      currentScreen = new Chapter8();
    }

    //return the current chapter
    return currentScreen;
  }
}
