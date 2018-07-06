package com.grasp.game.Global;

/**
 * Created by HP on 20-02-2018.
 */

public class Objects {

  //Declare the class singleton class
  private static Objects myObject;
  public static Objects getInstance(){
    if(myObject == null){
      myObject = new Objects();
    }
    return myObject;
  }

  public static final String[] Ch1L1 ={
          "line1",
          "line2",
          "line3",
          "ClickImage",
          "DragCircle",
          "DragCircle1"
  };

  public static final String[] Ch1L2 ={
          "labelF1",
          "labelF2",
          "labelF3",
          "labelF4",
          "number1",
          "number2"
  };

  public static final String[] Ch1L3 ={
          "quotient",
          "Imggreen",
          "Syntex1",
          "Imgsyntex1"
  };
}
