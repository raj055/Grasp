package com.grasp.game.BuilderBlocks;

import java.util.ArrayList;

/**
 * ClassName : SumIndicator
 *             This class contains the array list of data of progress
 */

public class SumIndicator {

  //Array List for Progress Data.
  public ArrayList<ProgressData>  currentProgress = new ArrayList<ProgressData>();
  ArrayList<Integer> extraVariables;

  //Constructor
  public SumIndicator(ArrayList<ProgressData> members){
    currentProgress.addAll(members);
  }
}
