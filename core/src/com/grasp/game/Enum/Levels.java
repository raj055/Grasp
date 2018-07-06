package com.grasp.game.Enum;


public enum Levels {
  LEVEL1 (0),
  LEVEL2 (1),
  LEVEL3 (2),
  LEVEL4 (3),
  LEVEL5 (4),
  LEVEL6 (5),
  LEVEL7 (6),
  LEVEL8 (7),
  LEVEL9 (8),
  LEVEL10 (9),
  LEVEL11 (10),
  LEVEL12 (11),
  LEVEL13 (12),
  LEVEL14 (13),
  LEVEL15 (14),
  LEVEL16 (15);

  public int currentVal = 0;

  Levels(int i) {
      this.currentVal = i;
  }

  public int getCurrentVal() {
    return this.currentVal;
  }

}
