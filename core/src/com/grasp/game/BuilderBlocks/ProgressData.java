package com.grasp.game.BuilderBlocks;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 *
 *
 */

public class ProgressData {
  public Label  visibleEntity;
  public Integer valueVar;
  public Float  valueFlt;

  public Label getLabel(){
    return  visibleEntity;
  }
  public void setValue(int value) {
    valueVar = value;
  }
  public void setValue(float value) {
    valueFlt = value;
  }
}
