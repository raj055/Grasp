package com.grasp.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.grasp.game.Enum.ClickPluse;
import com.grasp.game.Enum.ScreenStates;
import com.grasp.game.Global.GlobalsCommonCount;
import com.grasp.game.BuilderBlocks.ScrollingNumber;
import com.grasp.game.Timer.Timer;

import java.util.ArrayList;

/**
 * Created by HP on 22-01-2018.
 */

public class Chapter5 extends ChapterScreen implements Screen {

  private Timer time;

  // component of level_1
  private Label valueF,valueS,valueT,valueF1,valueS2,valueT2,valueF12;

  private Label value1,value2,value11,value12,value13,value14,value15,anser;

  private Label pluse,pluse1,pluse2,pluse3;

  private Image imgadd;

  private ClickPluse clickPluse;

  // component of level_2
  private Label cong;

  private Label valueA,valueN,valueD;

  private Label val4;

  // component of level_3

    private Label valL,valueL1,val1;


  private GlobalsCommonCount glv;

  ScrollingNumber numLocal;

  //Array List for the drag listeners.
  ArrayList<DragListener> listeners;
  boolean moveTheBg = false;

  @Override
  public void show() {
  }
  Chapter5(){
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
    //check if the displayImages are present
    if(displayImages == null)
      return;

    //totalObjects
    int totalObjects = displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();

      if (str.contains("PluseBttn")) {
        imgadd = updatable;
      }
    }

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    totalObjects = updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("Firstterm")) {
        valueF = updatable;
      }
      else if (str.contains("Secondterm")) {
        valueS = updatable;
      }
      else if (str.contains("Thirdterm")) {
        valueT = updatable;
      }
      else if (str.contains("Fourthterm")) {
        valueF1 = updatable;
      }
      else if (str.contains("Value1")) {
        value1 = updatable;
      }
      else if (str.contains("Value2")) {
        value2 = updatable;
      }
      else if (str.contains("Value11")) {
        value11 = updatable;
      }
      else if (str.contains("Pluse")) {
        pluse = updatable;
      }
      else if (str.contains("Pluse1")) {
        pluse1 = updatable;
      }
      else if (str.contains("Pluse2")) {
        pluse2 = updatable;
      }
      else if (str.contains("Pluse3")) {
        pluse3 = updatable;
      }
      else if (str.contains("Value12")) {
        value12 = updatable;
      }
      else if (str.contains("Value13")) {
        value13 = updatable;
      }
      else if (str.contains("Value14")) {
        value14 = updatable;
      }
      else if (str.contains("ValueS2")) {
        valueS2 = updatable;
      }
      else if (str.contains("ValueT2")) {
        valueT2 = updatable;
      }
      else if (str.contains("ValueF12")) {
        valueF12 = updatable;
      }
    }
  }
  void defineLevel6To10Components() {
//    numLocal = new ScrollingNumber(Events.SCROLL_NUMBER_SELECT);

    for(Image numberI : numLocal.numbers)
    {
      stage.addActor(numberI);
    }

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    int totalObjects = updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("Value4")) {
        val4 = updatable;
      }
      else  if (str.contains("Congratulations")) {
        cong = updatable;
      }
    }

  }
  void defineLevel11To15Components() {
//    numLocal = new ScrollingNumber(Events.SCROLL_NUMBER_SELECT);

    for(Image numberI : numLocal.numbers)
    {
      stage.addActor(numberI);
    }

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    int totalObjects = updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("Value4")) {
        val4 = updatable;
      }
      else  if (str.contains("Value1")) {
        value1 = updatable;
      }
      else  if (str.contains("Labelval1")) {
        val1 = updatable;
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

    numLocal.update(delta);

    if (glv.lableWrite){
      valueD.setText(glv.lableUpdate + " ");
      val4.setText("47");
      cong.setVisible(true);
    }


    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }

    stage.draw();

    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){
    //Sets the color to be applied after clearing the screen (R,G,B,A)
    Gdx.gl.glClearColor(0,0,255,1);
    //Clears the screen
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    time.update(deltaTime);

    numLocal.update(deltaTime);

    if (glv.lableWrite){

      val4.setText(glv.lableUpdate + " ");

    }

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }

    stage.draw();
    time.stage.draw();

  }
}
