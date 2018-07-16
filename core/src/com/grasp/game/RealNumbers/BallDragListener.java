package com.grasp.game.RealNumbers;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.grasp.game.BuilderBlocks.ChapterVariables;
import com.grasp.game.BuilderBlocks.Events;
import com.grasp.game.BuilderBlocks.OnDragCallBack;
import com.grasp.game.BuilderBlocks.SumIndicator;
import com.grasp.game.MyGame;

import java.util.ArrayList;

public class BallDragListener extends OnDragCallBack {

  ArrayList<Image> displayBalls = new ArrayList<Image>();
  ArrayList<Image> showBalls = new ArrayList<Image>();

  //Get the Chapter1 Variables.
  ChapterVariables chapterVariables = ChapterVariables.getInstance();

  SumIndicator sumIndicator;

  public BallDragListener(Events triggerEvent) {
    super(triggerEvent);
  }

  @Override
  public void drag(InputEvent event, float x, float y, int pointer) {

    //Get the ball to be dragged
    Image dragball = (Image)event.getListenerActor();

    //Drag all the balls
    if(!(displayBalls.isEmpty())) {
      for (Image disBall : displayBalls) {
        disBall.moveBy(x, y);
      }
    }
  }

  @Override
  public void dragStop(InputEvent event, float x, float y, int pointer) {

    //Get the Dragged Ball Actor
    Image dragball = (Image)event.getListenerActor();

    //Update the relevant variables
    updateGlobalVariables();

    //Update the relevant labels
    postEvent();

  }

  public void setDisplayBalls(ArrayList<Image> dispBalls){
    if(dispBalls != null) {
      displayBalls.addAll(dispBalls);
    }
  }

  void setShowBalls(ArrayList<Image> showBalls){
    if(showBalls != null) {
      showBalls.addAll(showBalls);
    }
  }

  ArrayList<Image> getDisplayBalls(){
    return displayBalls;
  }

  void updateGlobalVariables(){

    int xPos = 150;
//    int totalBalls = 0;
    for(Image disBall : displayBalls) {
      chapterVariables.chapter1Variables.ValueOfScore++;
      disBall.setPosition(xPos, MyGame.HEIGHT - 100);
      xPos += 50;
    }
    chapterVariables.chapter1Variables.ValueOfQ++;
  }
}
