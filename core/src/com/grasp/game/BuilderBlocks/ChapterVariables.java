package com.grasp.game.BuilderBlocks;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Use the following classes as structure.
 *
 */

public class ChapterVariables {

  private static ChapterVariables myObj;
  public static ChapterVariables getInstance(){
    if(myObj == null){
      myObj = new ChapterVariables();
    }
    return myObj;
  }

  public Chapter1Variables chapter1Variables = new Chapter1Variables();
  public Chapter2Variables chapter2Variables = new Chapter2Variables();
  public Chapter3Variables chapter3Variables = new Chapter3Variables();
  public Chapter4Variables chapter4Variables = new Chapter4Variables();
  public Chapter5Variables chapter5Variables = new Chapter5Variables();
  public Chapter6Variables chapter6Variables = new Chapter6Variables();
  public Chapter7Variables chapter7Variables = new Chapter7Variables();
  public Chapter8Variables chapter8Variables = new Chapter8Variables();

  ChapterVariables(){

    //
    //chapter1Variables = new Chapter1Variables();

  }

  public static class Chapter1Variables{

    //Chapter 1 Variables
    public int ValueOfB = 0;
    public int ValueOfScore = 0;
    public int ValueOfA = 0;
    public int ValueOfR = 0;
    public int ValueOfQ = 0;
    public int TargetScore = 0;
    public int ProgressBarValue = 1;

    //Current Remainder Ball Position
    public int RBallWidth;
    public int RBallHeight;
    public int RBallPosX;
    public int RBallPosY;
  }
  public class Chapter2Variables{

  }
  public class Chapter3Variables{
    //Chapter 3 Variables
    public int ValueOfB = 0;
    public int ValueOfScore = 0;
    public int TargetValue = 0;
    public int ValueOfA = 0;


  }
  public class Chapter4Variables{
    //Chapter 4 Variables
    public int ValueOfB = 0;
    public int ValueOfScore = 0;
    public int TargetValue = 0;
    public int ValueOfA = 0;

  }
  public class Chapter5Variables{
    //Chapter 5 Variables
    public int ValueOfB = 0;
    public int ValueOfScore = 0;
    public int TargetValue = 0;
    public int ValueOfA = 0;

  }
  public class Chapter6Variables{
    //Chapter 6 Variables
    public int ValueOfB = 0;
    public int ValueOfScore = 0;
    public int TargetValue = 0;
    public int ValueOfA = 0;

  }
  public class Chapter7Variables{
    //Chapter 7 Variables
    public int ValueOfB = 0;
    public int ValueOfScore = 0;
    public int TargetValue = 0;
    public int ValueOfA = 0;
  }
  public class Chapter8Variables{
    //Chapter 8 Variables
    public int ValueOfB = 0;
    public int ValueOfScore = 0;
    public int TargetValue = 0;
    public int ValueOfA = 0;
  }
}
