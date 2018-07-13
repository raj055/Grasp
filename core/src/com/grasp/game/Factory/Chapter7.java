package com.grasp.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.grasp.game.Enum.ScreenStates;
import com.grasp.game.Global.GlobalsCommonCount;
import com.grasp.game.Timer.Timer;

import java.util.ArrayList;

/**
 * Created by HP on 22-01-2018.
 */

public class Chapter7 extends ChapterScreen implements Screen {

  private Timer time;

  // component of level_1
  private Label synlabel,synlabel1,synlabel2,synlabel3;

  private Label value1,value3,value12,value14;

  // component of level_2

  private Label synlabelk1,synlabelk;

  private Label valuek2,valuek1,value1_1,value3_1,value12_1,value14_1,value22,value22_1,value24,value24_1;

  // component of level_3
  private Label synlabelx1,synlabelx11,synlabelx2,synlabelx22,synlabelx3,synlabelx33;
  private Label synlabely1,synlabely11,synlabely2,synlabely22,synlabely3,synlabely33;


  private GlobalsCommonCount glv;
  Number numLocal;

  //Array List for the drag listeners.
  ArrayList<DragListener> listeners;
  boolean moveTheBg = false;

  @Override
  public void show() {
  }
  Chapter7(){
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
  public void resize(int width, int height) {

  }

  @Override
  public void pause() {

  }

  @Override
  public void resume() {

  }

  @Override
  public void hide() {

  }

  @Override
  public void dispose() {
    stage.dispose();
  }

  DragListener drgListener = new DragListener(){
    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
      super.drag(event, x, y, pointer);
    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer) {
      super.dragStop(event, x, y, pointer);
    }
  };

  void defineLevel1To5Components() {
    //check if the updatables are present
    if (updatables == null)
        return;

    int totalObjects = updatables.size();
    for (Label updatable : updatables){
      String str = updatable.getName();

      if (str.contains("LabelValue1")){
        value1 = updatable;
      }
      else if (str.contains("LabelValue3")){
        value3 = updatable;
      }
      else if (str.contains("LabelValue12")){
        value12 = updatable;
      }
      else if (str.contains("LabelValue14")){
        value14 = updatable;
      }
      else if (str.contains("SyntaxLabel")){
        synlabel = updatable;
      }
      else if (str.contains("SyntaxLabel1")){
        synlabel1 = updatable;
      }
      else if (str.contains("SyntaxLabel2")){
        synlabel2 = updatable;
      }
      else if (str.contains("SyntaxLabel3")){
        synlabel3 = updatable;
      }
    }
  }
  void defineLevel6To10Components() {
    //check if the updatables are present
    if (updatables == null)
      return;

    int totalObjects = updatables.size();
    for (Label updatable : updatables){
      String str = updatable.getName();

      if (str.contains("LabelValue12")){
        value12 = updatable;
      }
      else if (str.contains("LabelValue14")){
        value14 = updatable;
      }
      else if (str.contains("LabelValuek1")){
        valuek1 = updatable;
      }
      else if (str.contains("LabelValuek2")){
        valuek2 = updatable;
      }
      else if (str.contains("SyntaxLabelk")){
        synlabelk = updatable;
      }
      else if (str.contains("SyntaxLabelx2")){
        synlabelx2 = updatable;
      }
      else if (str.contains("SyntaxLabelx1")){
        synlabelx1 = updatable;
      }
      else if (str.contains("SyntaxLabelk1")){
        synlabelk1 = updatable;
      }
    }
  }
  void defineLevel11To15Components() {
    //check if the updatables are present
    if (updatables == null)
      return;

    int totalObjects = updatables.size();
    for (Label updatable : updatables){
      String str = updatable.getName();

      if (str.contains("LabelValue1")){
        value1 = updatable;
      }
      else if (str.contains("LabelValue1_1")){
        value1_1 = updatable;
      }
      else if (str.contains("LabelValue3")){
        value3 = updatable;
      }
      else if (str.contains("LabelValue3_1")){
        value3_1 = updatable;
      }
      else if (str.contains("LabelValue12")){
        value12 = updatable;
      }
      else if (str.contains("LabelValue12_1")){
        value12_1 = updatable;
      }
      else if (str.contains("LabelValue14")){
        value14 = updatable;
      }
      else if (str.contains("LabelValue14_1")){
        value14_1 = updatable;
      }
      else if (str.contains("LabelValue22")){
        value22 = updatable;
      }
      else if (str.contains("LabelValue22_1")){
        value22_1 = updatable;
      }
      else if (str.contains("LabelValue24")){
        value24 = updatable;
      }
      else if (str.contains("LabelValue24_1")){
        value24_1 = updatable;
      }
      else if (str.contains("SyntaxLabelx1")){
        synlabelx1 = updatable;
      }
      else if (str.contains("SyntaxLabelx11")){
        synlabelx11 = updatable;
      }
      else if (str.contains("SyntaxLabelx2")){
        synlabelx2 = updatable;
      }
      else if (str.contains("SyntaxLabelx22")){
        synlabelx22 = updatable;
      }
      else if (str.contains("SyntaxLabelx3")){
        synlabelx3 = updatable;
      }
      else if (str.contains("SyntaxLabelx33")){
        synlabelx33 = updatable;
      }
      else if (str.contains("SyntaxLabely1")){
        synlabely1 = updatable;
      }
      else if (str.contains("SyntaxLabely11")){
        synlabely11 = updatable;
      }
      else if (str.contains("SyntaxLabely2")){
        synlabely2 = updatable;
      }
      else if (str.contains("SyntaxLabely22")){
        synlabely22 = updatable;
      }
      else if (str.contains("SyntaxLabely3")){
        synlabely3 = updatable;
      }
      else if (str.contains("SyntaxLabely33")){
        synlabely33 = updatable;
      }
    }
  }

  interface LevelDefinition {
    void initialise();
  }

  private LevelDefinition[] levelInitialisations = (LevelDefinition[]) new LevelDefinition[] {
          new LevelDefinition() {
            public void initialise() { defineLevel1To5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11To15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11To15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11To15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11To15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11To15Components(); } },

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
    listeners.add(indexOfListener++, drgListener);
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
