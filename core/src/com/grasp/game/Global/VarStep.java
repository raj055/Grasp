package com.grasp.game.Global;

/**
 * Class Created for the Created by HP on 11-05-2018.
 */

public class VarStep {
  /***
   * Chapter 1 Variables for each Level Execution
   */
  public int remaiderPositionX;
  public int score;
  public int remainderValue;

  private static VarStep myObj;
  public static VarStep getInstance(){
    if(myObj == null){
      myObj = new VarStep();
    }
    return myObj;
  }

  public void initialiseVariables(){

    //Initialise Chapter 1 variables
    remaiderPositionX = 0;
    score = 0;
    remainderValue = 0;

  }



}
