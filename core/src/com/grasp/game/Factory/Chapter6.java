package com.grasp.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.grasp.game.Component.Numberch6;
import com.grasp.game.Enum.ScreenStates;
import com.grasp.game.Global.GlobalsCommonCount;
import com.grasp.game.Timer.Timer;

import java.util.ArrayList;

/**
 * Created by HP on 22-01-2018.
 */

public class Chapter6 extends ChapterScreen implements Screen {

  private Timer time;

  // component of level_1
  Image square;
  Image square1;
  Image sercal;
  Image sercal1;
  Image triangle_p;

  // component of level_2
  private Label value,value1,value2,value3,value4,value5;

  private Label anser;

  // component of level_3
  private Image imgVlu1,imgVlu5,imgVlu7,imgVlu4,imgVlu8,imgVlu2,imgVlu,imgVlu6,imgVlu9_2,imgVlu9,imgVlu3;

  private GlobalsCommonCount glv;

  Numberch6 number;

  //Array List for the drag listeners.
  ArrayList<DragListener> listeners;
  boolean moveTheBg = false;

  @Override
  public void show() {
  }
  Chapter6(){
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

  void defineLevel1Components() {
    if(displayImages == null)
      return;
    int totalObjects = displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();
      if (str.contains("squareImage")) {
        square = updatable;
      } else if (str.contains("square1Image")) {
        square1 = updatable;
      } else if (str.contains("sercalImage")) {
        sercal = updatable;
      } else if (str.contains("sercal1Image")) {
        sercal1 = updatable;
      } else if (str.contains("triangle_p")) {
        triangle_p = updatable;
      }
    }
  }
  void defineLevel2Components() {

    number = new Numberch6();

    for(Image numberI : number.numbers)
    {
      stage.addActor(numberI);
    }

    //check if the updatables are present
    if(updatables == null)
      return;

    int totalObjects = updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("value4")) {
        value4 = updatable;
      } else if (str.contains("value")) {
        value = updatable;
      } else if (str.contains("value1")) {
        value1 = updatable;
      } else if (str.contains("value2")) {
        value2 = updatable;
      } else if (str.contains("value3")) {
        value3 = updatable;
      }else if (str.contains("value4")) {
        value4 = updatable;
      } else if (str.contains("value5")) {
        value5 = updatable;
      } else if (str.contains("Labelanser")) {
        anser = updatable;
      }
    }
  }
  void defineLevel3Components() {
    if(displayImages == null)
      return;
    int totalObjects = displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();
      if (str.contains("ImageVlu1")) {
        imgVlu1 = updatable;
      }
      else if (str.contains("imgValue5")) {
        imgVlu5 = updatable;
      }
      else if (str.contains("ImageVlu7")) {
        imgVlu7 = updatable;
      }
      else if (str.contains("imgVlu4")) {
        imgVlu4 = updatable;
      }
      else if (str.contains("imgVlu8")) {
        imgVlu8 = updatable;
      }
      else if (str.contains("imgVlu2")) {
        imgVlu2 = updatable;
      }
      else if (str.contains("imgVlu")) {
        imgVlu = updatable;
      }
      else if (str.contains("imgVlu3")) {
        imgVlu3 = updatable;
      }
      else if (str.contains("ImageVlu5")) {
        imgVlu5 = updatable;
      }
      else if (str.contains("imgVlu6")) {
        imgVlu6 = updatable;
      }
      else if (str.contains("imgVlu8")) {
        imgVlu8 = updatable;
      }
      else if (str.contains("imgVlu9_2")) {
        imgVlu9_2 = updatable;
      }
      else if (str.contains("imgVlu9")) {
        imgVlu9 = updatable;
      }
    }
}
  void defineLevel4Components() { }
  void defineLevel11Components() { }
  void defineLevel12Components() { }
  void defineLevel13Components() { }
  void defineLevel14Components() { }
  void defineLevel15Components() { }

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
          new LevelDefinition() { public void initialise() { defineLevel11Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel12Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel13Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel14Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel15Components(); } },

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

    number.update(delta);

    if (glv.lableWrite){

      switch (glv.countClick){
        case 1:
          value.setText(number.string_labal + " ");
          break;

        case 2:
          value1.setText(number.string_labal + " ");
          break;

        case 3:
          value3.setText(number.string_labal + " ");
          break;

        default:
          break;
      }

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

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }

    stage.draw();
    time.stage.draw();

  }
}
