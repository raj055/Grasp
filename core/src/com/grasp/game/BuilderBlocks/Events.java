package com.grasp.game.BuilderBlocks;

/**
 *
 *
 */

public enum Events {
  BALL_DRAG_EVENT,
  REMAINDER_BALL_DRAG,
  SCROLL_NUMBER_SELECT,
  DEFAULT_EVENT;

  private final String[] strlist = {
    "",
    "",
  };

  public int getEventSequence (Events events){
    return events.ordinal();
  }
}
