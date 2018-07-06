package com.grasp.game.Enum;

/**
 * Created by HP on 06-01-2018.
 */

public enum Steps {
  STEP_1 (0),
  STEP_2 (1),
  STEP_3 (2),
  STEP_4 (3),
  STEP_5 (4),
  STEP_6 (5);

  public int currentVal = 0;

  Steps(int i) {
    this.currentVal = i;
  }

  public int getCurrentVal() {
    return this.currentVal;
  }
}
