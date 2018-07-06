package com.grasp.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.grasp.game.Enum.ScreenStates;
import com.grasp.game.Global.GlobalsCommonCount;
import com.grasp.game.Timer.Timer;

import java.util.ArrayList;

/**
 * Created by HP on 22-01-2018.
 */

public class Chapter8 extends ChapterScreen implements Screen {

  private Timer time;

  // component of level_1
  private Image line,line2,line3;

  private Label value1,value1_1,value3_0,value3,value3_1,value5_0,value5,value5_1;

  private enum LableClick {VALUE1,VALUE1_1,VALUE3,VALUE3_1,VALUE5,VALUE5_1}

  private LableClick lableClick;

  // component of level_2

  // component of level_3

  private GlobalsCommonCount glv;

  //Array List for the drag listeners.
  ArrayList<DragListener> listeners;
  boolean moveTheBg = false;

  @Override
  public void show() {
  }
  Chapter8(){
    super();

    time = new Timer();

    glv = GlobalsCommonCount.getInstance();

    getLevelName();
    initialiseDragListeners(currentLevelNumber);
    initialiseLevelComponents(currentLevelNumber);

  }
  public void update(float dt){
    time.update(dt);
  }
  @Override
  public void render(float delta) {
    renderLists[currentLevelNumber].renderL(delta);
  }

  @Override
  public void resize(int width, int height) {}

  @Override
  public void pause() {}

  @Override
  public void resume() {}

  @Override
  public void hide() {}

  @Override
  public void dispose() {
    stage.dispose();
  }

  ClickListener TappValue = new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y) {

          lableClick = LableClick.VALUE1;

          switch (lableClick) {
            case VALUE1:
              if (getTapCount() == 2) {
                value1.setPosition(70, 190);
                line2.setVisible(true);
              }
              lableClick = LableClick.VALUE1_1;
              break;
            case VALUE1_1:
              if (getTapCount() == 2) {
                value1_1.setPosition(130, 190);
                line.setVisible(true);
              }
              lableClick = LableClick.VALUE3;
              break;
            case VALUE3:
              if (getTapCount() == 2) {
                value3.setPosition(240, 300);
                line3.setVisible(true);
              }
              lableClick = LableClick.VALUE3_1;
              break;
            case VALUE3_1:
              if (getTapCount() == 2) {
                value3_1.setPosition(70, 140);
                line2.setVisible(true);
              }
              lableClick = LableClick.VALUE5;
              break;
            case VALUE5:
              if (getTapCount() == 2) {
                value5.setPosition(240, 250);
                line3.setVisible(true);
              }
              lableClick = LableClick.VALUE5_1;
              break;
            case VALUE5_1:
              if (getTapCount() == 2) {
                value5_1.setPosition(130, 140);
                line.setVisible(true);
              }
              break;

            default:
              break;
          }

    }
  };

  void defineLevel1Components() {
    //check if the displayImages are present
    if(displayImages == null)
      return;

    //totalObjects
    int totalObjects = displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();

      if (str.contains("LineImage")) {
        line = updatable;
      }
      else if (str.contains("Line2Image")) {
        line2 = updatable;
      }
      if (str.contains("Line3Image")) {
        line3 = updatable;
      }
    }

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    totalObjects = updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("LabelValue1")) {
        value1 = updatable;
        value1.addListener(TappValue);
      }
      else if (str.contains("LabelValue1_1")) {
        value1_1 = updatable;
        value1_1.addListener(TappValue);
      }
      else if (str.contains("LabelValue3")) {
        value3 = updatable;
        value3.addListener(TappValue);
      }
      else if (str.contains("LabelValue3_1")) {
        value3_1 = updatable;
        value3_1.addListener(TappValue);
      }
      else if (str.contains("LabelValue5")) {
        value5 = updatable;
        value5.addListener(TappValue);
      }
      else if (str.contains("LabelValue5_1")) {
        value5_1 = updatable;
        value5_1.addListener(TappValue);
      }
    }
  }
  void defineLevel2Components() { }
  void defineLevel3Components() { }

  interface LevelDefinition {
    void initialise();
  }

  private LevelDefinition[] levelInitialisations = (LevelDefinition[]) new LevelDefinition[] {
          new LevelDefinition() {
            public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1Components(); } },

  };

  public void initialiseLevelComponents(int index) {
    levelInitialisations[index].initialise();
  }

  interface DragListnerList {
    void allotDragListener();
  }

  private DragListnerList[] dragListnerLists = (DragListnerList[]) new DragListnerList[] {
          new  DragListnerList() {
            public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } },
          new DragListnerList() { public void allotDragListener() { addLevel1DraggableListeners(); } }
  };

  public void initialiseDragListeners(int index) {
    dragListnerLists[index].allotDragListener();
  }

  private void addLevel1DraggableListeners(){
    //initialise the array of drag listeners
    int indexOfListener = 0;
    listeners = new ArrayList<DragListener>();
  }

  interface RenderLevel {
    void renderL(float delta);
  }

  private RenderLevel[] renderLists = (RenderLevel[]) new RenderLevel[] {
          new RenderLevel() {
            public void renderL(float delta) { renderLevel1(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel1(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel1(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel1(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel1(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel2(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel3(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel3(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel3(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel3(delta); } },
          new RenderLevel() { public void renderL(float delta) { renderLevel3(delta); } }
  };

  public void renderLevels(int index) {
//    renderLists[index].renderL( );
  }
  private void renderLevel1(float delta){
    update(delta);

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }

    stage.draw();

    time.stage.draw();
  }
  private void renderLevel2(float delta){
    update(delta);

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }

    stage.draw();

    if(moveTheBg) {
      bg.act(delta);
//      moveTheBg = false;
    }

    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    //Sets the color to be applied after clearing the screen (R,G,B,A)
    Gdx.gl.glClearColor(0,0,255,1);
    //Clears the screen
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    time.update(deltaTime);

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }

    stage.draw();
    time.stage.draw();

  }
}
