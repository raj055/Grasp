package com.grasp.game.BuilderBlocks;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;

/**
 *
 *
 */

public abstract class ShowEntity implements Subscriber {

  //Update all the images to be displayed or to be visible.
  public Image progressBar;
  public ArrayList<Image> EntitiesToDisplay = new ArrayList<Image>();

  //Show Entity
  protected ShowEntity(Image progressBar, ArrayList<Image> arrImages){

    //Progress Bar
    this.progressBar = progressBar;

  }

  //Update Progress Bar
  void updateProgressBar(int value) {
    if(progressBar != null){

    }
  }

}
