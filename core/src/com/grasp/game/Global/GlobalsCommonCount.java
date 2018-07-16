package com.grasp.game.Global;

/**
 * Created by HP on 12-01-2018.
 */

public class GlobalsCommonCount {

  //Declare the class singleton class
  private static GlobalsCommonCount myObj;
  public static GlobalsCommonCount getInstance(){
    if(myObj == null){
      myObj = new GlobalsCommonCount();
    }
    return myObj;
  }

  public int currentLevel;
  public int currentChapter;
  public int currentStepNumber;

  public static final String[] NumberLevel1 = {
          "Numbers/number0.png",
          "Numbers/number1.png",
          "Numbers/number2.png",
          "Numbers/number3.png",
          "Numbers/number4.png",
          "Numbers/number5.png",
          "Numbers/number6.png",
          "Numbers/number7.png",
          "Numbers/number8.png",
          "Numbers/number9.png"
  };

  public static final String[] NumberLevel3 ={
          "Numbers/number1.png",
          "Numbers/number3.png",
          "Numbers/number5.png",
          "Numbers/number8.png",
          "Numb/-2.png",
          "Numb/-3.png",
          "Numb/-6.png",
          "Numb/-7.png"
  };

  public static final String[] TextNumber2 ={
          "1",
          "3",
          "5",
          "8",
          "-2",
          "-3",
          "-6",
          "-7"
  };

  public static final String[] VariabalLevel3 ={
          "Values/1.png",
          "Values/2.png",
          "Values/3.png",
          "Values/4.png",
          "Values/5.png",
          "Values/x2.png",
          "Values/x3.png",
          "Values/xx.png"
  };

  public static final String[] TextLevel2 ={
          "1",
          "2",
          "3",
          "4",
          "5",
          "x2",
          "x3",
          "x"
  };

  public static final String[] TextLevel1 ={

          "Values/a.png",
          "Values/p.png",
          "Values/q.png",
          "Values/x.png",
          "Values/y.png",
          "Values/z.png",
  };

  public static final String[] TextLevel3 ={
          "a",
          "p",
          "q",
          "x",
          "y",
          "z",
  };

  public static final String[] NumberLevel11 ={
//          "Number/15.png",
          "Number/1.png",
          "Number/2.png",
//          "Number/25.png",
          "Number/3.png",
//          "Number/35.png",
          "Number/4.png",
//          "Number/45.png",
          "Number/6.png",
          "Number/8.png"
  };

  public static final String[] NumberLevel12 ={
//          "1.5",
          "1",
          "2",
//          "2.5",
          "3",
//          "3.5",
          "4",
//          "4.5",
          "6",
          "8"
  };

  public static final String[] StepName = {
          "Step1",
          "Step2",
          "Step3",
          "Step4",
          "Step5",
          "Step6"
  };

  public static final String[] LevelsName = {
          "Level1",
          "Level2",
          "Level3",
          "Level4",
          "Level5",
          "Level6",
          "Level7",
          "Level8",
          "Level9",
          "Level10",
          "Level11",
          "Level12",
          "Level13",
          "Level14",
          "Level15",
          "Level16"
  };

  public static final int[] ValueA = {
          12,  17,   20,
          10,  19,   12576, 422,
          225, 38220,  867
  };

  public static final String[] ChapterName = {
          "Chapter1",
          "Chapter2",
          "Chapter3",
          "Chapter4",
          "Chapter5",
          "Chapter6",
          "Chapter7",
          "Chapter8",
          "Chapter9",
          "Chapter10",
          "Chapter11",
          "Chapter12",
          "Chapter13",
          "Chapter14",
          "Chapter15"
  };

  public static final String[] CofigFile = {
    "skin/chapter1.json",
    "skin/chapter2.json",
    "skin/chapter3.json",
    "skin/chapter4.json",
    "skin/chapter5.json",
    "skin/chapter6.json",
    "skin/chapter7.json",
    "skin/chapter8.json"

  };

  public static final String[] DialogName = {
          "Pause",
          "congratulations",
          "Time's Up",
          "Wrong Ans",
          "Game Over",
          "Exit"
  };

  public static final int[] posYDiff ={
          1, 1, 1, 1, 1, 1, 1, 1, 1, 1
  };
  public static final int[] posYNum ={
          0, 150, 100, 200, 300, 250, 80, 180, 270, 130
  };
  public static final int[] posXBall ={
          0, 50, 100, 150, 200, 250, 300, 350, 400, 450
  };

  public static final int[] posYBall ={
          0, 50, 100, 150, 200, 250, 300, 350, 400, 450
  };

  public int lableUpdate;
  public boolean lableWrite = false;

  public int countClick;

  public int click1;
  public int click2;
  public int click3;
  public int click4;

  public void clear(){
    lableUpdate = 0;
    lableWrite = false;

    countClick = 0;

    click1 = 0;
    click2 = 0;
    click3 = 0;
    click4 = 0;
  }

}
