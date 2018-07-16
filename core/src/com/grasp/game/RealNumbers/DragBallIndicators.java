package com.grasp.game.RealNumbers;

import com.grasp.game.BuilderBlocks.ChapterVariables;
import com.grasp.game.BuilderBlocks.Events;
import com.grasp.game.BuilderBlocks.Notifier;
import com.grasp.game.BuilderBlocks.ProgressData;
import com.grasp.game.BuilderBlocks.Subscriber;
import com.grasp.game.BuilderBlocks.SumIndicator;

import java.util.ArrayList;

import static com.grasp.game.BuilderBlocks.Events.BALL_DRAG_EVENT;
import static com.grasp.game.BuilderBlocks.Events.REMAINDER_BALL_DRAG;

/**
 *
 *
 */

public class DragBallIndicators extends SumIndicator implements Subscriber {

  enum DragBallLabels {
    Score2,
    Score4,
    TargetScore,
    ScoreValue
  }
  //Get the Chapter1 Variables.
  ChapterVariables chapterVariables = ChapterVariables.getInstance();

  public DragBallIndicators(ArrayList<ProgressData> members){
    super(members);

   //Subscribe to the relevant events
    Notifier notifier = Notifier.getInstance();
    notifier.RegisterSubscriber(this, BALL_DRAG_EVENT);
    notifier.RegisterSubscriber(this, REMAINDER_BALL_DRAG);
  }
  @Override
  public void UpdateAllElements(Events evt) {

    if(evt.equals(BALL_DRAG_EVENT)){

      updateElement(DragBallLabels.Score2, chapterVariables.chapter1Variables.ValueOfB);

      int VALUE_B = chapterVariables.chapter1Variables.ValueOfB;
      int valueA = chapterVariables.chapter1Variables.ValueOfA;
      int QValue = chapterVariables.chapter1Variables.ValueOfQ;
      int SCOREVAL = getValue(DragBallLabels.Score2) * QValue + getValue(DragBallLabels.Score4);

      chapterVariables.chapter1Variables.ValueOfScore = SCOREVAL;
      updateElement(DragBallLabels.ScoreValue, SCOREVAL);
      updateChapter1Variables();
    }
    else if (evt.equals(REMAINDER_BALL_DRAG)){

      updateElement(DragBallLabels.Score4, chapterVariables.chapter1Variables.ValueOfR);
      updateElement(DragBallLabels.ScoreValue,
        chapterVariables.chapter1Variables.ValueOfScore);
    }
  }

  public void updateElement(DragBallLabels dragBallLabels, int value){
    for (ProgressData pData : currentProgress){
      if(pData.getLabel().getName().matches(dragBallLabels.toString())){
        pData.getLabel().setText(Integer.toString(value));
        pData.setValue(value);
      }
    }
  }

  public int getValue(DragBallLabels dragBallLabels){
    int value = 0;
    for (ProgressData pData : currentProgress){
      if(pData.getLabel().getName().matches(dragBallLabels.toString())){
        value = pData.valueVar;
        break;
      }
    }
    return value;
  }

  public int getProgressDataIndex(DragBallLabels dragBallLabels){
    int currentProgressDataIndex = 0;
    for (ProgressData pData : currentProgress) {
      if (pData.getLabel().getName().matches(dragBallLabels.toString())) {
        currentProgressDataIndex = currentProgress.indexOf(pData);
      }
    }
    return currentProgressDataIndex;
  }

  void updateChapter1Variables(){
    // Fill value of all the relevant global Variables.

    String ValueOfA = currentProgress.get(getProgressDataIndex(DragBallLabels.TargetScore)).getLabel().getText().toString();
    chapterVariables.chapter1Variables.ValueOfA = Integer.valueOf(ValueOfA);

    //Score Value
    String ValueOfScore = currentProgress.get(getProgressDataIndex(DragBallLabels.ScoreValue)).getLabel().getText().toString();
    chapterVariables.chapter1Variables.ValueOfScore = Integer.valueOf(ValueOfScore);

    //Value of B
    String ValueOfB = currentProgress.get(getProgressDataIndex(DragBallLabels.Score2)).getLabel().getText().toString();
    chapterVariables.chapter1Variables.ValueOfB = Integer.valueOf(ValueOfB);;

    //Value of R
    String ValueOfR = currentProgress.get(getProgressDataIndex(DragBallLabels.Score4)).getLabel().getText().toString();
    chapterVariables.chapter1Variables.ValueOfR = Integer.valueOf(ValueOfR);;
  }
}
