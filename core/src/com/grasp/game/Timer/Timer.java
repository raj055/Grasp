package com.grasp.game.Timer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by HP on 12-01-2018.
 */

public class Timer implements Disposable {

  public Stage stage;

  private Integer worldTimer;
  private boolean timeUp;
  private float timeCount;

  //Scene2D widgets
  private Label countdownLabel;

  private Label timeLabel;

  public Timer(){

    worldTimer = 30;
    timeCount = 0;

    stage = new Stage();

    //define a table used to organize our hud's labels
    Table table = new Table();
    //Top-Align table
    table.top();
    //make the table fill the entire stage
    table.setFillParent(true);

    //define our labels using the String, and a Label style consisting of a font and color
    countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.RED));
    timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));


    //add our labels to our table, padding the top, and giving them all equal width with expandX
    table.add(timeLabel).expandX().padTop(10).padLeft(220);
    //add a second row to our table
    table.row();
    table.add(countdownLabel).expandX().padLeft(220);

    //add our table to the stage
    stage.addActor(table);

  }

  public void update(float dt){
    timeCount += dt;
    if(timeCount >= 1){
      if (worldTimer > 0) {
        worldTimer--;
      } else {
        timeUp = true;
      }
      countdownLabel.setText(String.format("%03d", worldTimer));
      timeCount = 0;
    }
  }


  @Override
  public void dispose() { stage.dispose(); }

  public boolean isTimeUp() { return timeUp; }
}
