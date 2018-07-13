package com.grasp.game.Factory;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.grasp.game.Component.NumberCh3;
import com.grasp.game.Component.TextveriabalCh3;
import com.grasp.game.Enum.ScreenStates;
import com.grasp.game.Global.GlobalsCommonCount;
import com.grasp.game.Timer.Timer;

import java.util.ArrayList;

/**
 * Created by HP on 16-01-2018.
 */

public class Chapter3 extends ChapterScreen implements Screen {

  private Timer time;

  // component of level_1
  private Label labelP,labelE;

//  Label value1,value3,value11,value13;

  private Label value1,value3,value11,value13;

  private Label value2,value12;

  private float elapsed;

  // component of level_2
  private Image imgsqureL,imgsqureL2,imgsquer,imground,imground1,imground2,imgShap1,imgShap2;
  private Image img_y1,img_y2;
  private Label y1,y2,label_x,num,eqval,min,label_2y,AnsValue;

  // component of level_3
  private Image imga1,imga2,imgb1,imgb2,imgc1,imgc2,img1b1,img1b2;

  private Label valueA,valueB,valueC,valueA1,valueB1,valueC1,valueB11,valueB12;

  private Label a,a2,b,b2,c,c2,b11,b12,AnsLabel;


  private GlobalsCommonCount glv;

  TextveriabalCh3 textveriabalch3;

  NumberCh3 numLocalch3;

  //Array List for the drag listeners.
  ArrayList<DragListener> listeners;
  boolean moveTheBg = false;

  @Override
  public void show() {
  }


  Chapter3(){
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

  // Click Y1 image
  ClickListener ClickY1 = new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y) {
      if( getTapCount() == 2) {

        imgsqureL.setVisible(false);
        y1.setVisible(false);

        /*imgsquer.setPosition(15, MyGame.HEIGHT - 400);
        imgsqureL2.setPosition(120, MyGame.HEIGHT - 395);
        imground.setPosition(MyGame.WIDTH - 130, MyGame.HEIGHT - 300);
        imground1.setPosition(MyGame.WIDTH - 130, MyGame.HEIGHT - 360);
        imground2.setPosition(MyGame.WIDTH - 130, MyGame.HEIGHT - 420);

        label_x.setPosition(70, MyGame.HEIGHT - 360);
        y2.setPosition(100, MyGame.HEIGHT - 310);
        num.setPosition(MyGame.WIDTH - 115, MyGame.HEIGHT - 370);
        eqval.setPosition(MyGame.WIDTH - 185, MyGame.HEIGHT - 360);*/

        min.setVisible(true);
        imgShap1.setVisible(true);

        img_y2.setTouchable(Touchable.enabled);
      }
    }
  };

  // Click Y2 image
  ClickListener ClickY2 = new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y) {
      if( getTapCount() == 2) {

        imgsqureL2.setVisible(false);
        y2.setVisible(false);

        /*imgsquer.setPosition(15,MyGame.HEIGHT - 400);
        imground.setPosition(MyGame.WIDTH - 180,MyGame.HEIGHT - 300);
        imground1.setPosition(MyGame.WIDTH - 180,MyGame.HEIGHT - 360);
        imground2.setPosition(MyGame.WIDTH - 180,MyGame.HEIGHT - 420);

        label_x.setPosition(70,MyGame.HEIGHT - 360);
        num.setPosition(MyGame.WIDTH - 165,MyGame.HEIGHT - 370);
        eqval.setPosition(160,MyGame.HEIGHT - 360);

        min.setPosition(MyGame.WIDTH - 125,MyGame.HEIGHT - 360);

        imgShap1.setSize(80,150);
        imgShap1.setPosition(MyGame.WIDTH - 100, MyGame.HEIGHT - 400);

        imgShap2.setVisible(true);

        imgShap2.setSize(80,150);
        imgShap2.setPosition(MyGame.WIDTH - 100, MyGame.HEIGHT - 355);*/

        label_2y.setVisible(true);

        AnsValue.setVisible(true);

      }
    }
  };

  void defineLevel1To5Components() {
    numLocalch3 = new NumberCh3();
    textveriabalch3 = new TextveriabalCh3();

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    int totalObjects = updatables.size();
    for (Label updatable : updatables)
    {
      String str = updatable.getName();

      if (str.contains("LabelB")) {
        labelP = updatable;
      }
      else if (str.contains("LabelB")) {
        labelE = updatable;
      }
    }

    for(Image numberI : textveriabalch3.texts)
    {
      stage.addActor(numberI);
    }

  }
  void defineLevel6To10Components() {

    if(displayImages == null)
      return;
    int totalObjects = displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();

      //check if the displayImages are present
      if (str.contains("y1Image")) {
        img_y1 = updatable;
        img_y1.addListener(ClickY1);
      }
      else if (str.contains("y2Image")) {
        img_y2 = updatable;
        img_y2.addListener(ClickY1);
      }
      else if (str.contains("SqurelImage")) {
        imgsqureL = updatable;
      }
      else if (str.contains("SquerImage")) {
        imgsquer = updatable;
      }
      else if (str.contains("Squrel2Image")) {
        imgsqureL2 = updatable;
      }
      else if (str.contains("RoundImage")) {
        imground = updatable;
      }
      else if (str.contains("Round1Image")) {
        imground1 = updatable;
      }
      else if (str.contains("Round2Image")) {
        imground2 = updatable;
      }
      else if (str.contains("Shap1")) {
        imgShap1 = updatable;
      }
      else if (str.contains("Shap2")) {
        imgShap2 = updatable;
      }
    }

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    totalObjects = updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("Valuey1")) {
        y1 = updatable;
      }
      else if (str.contains("Valuey2")) {
        y2 = updatable;
      }
      else if (str.contains("Label2y")) {
        label_2y = updatable;
      }
      else if (str.contains("Labelx")) {
        label_x = updatable;
      }
      else if (str.contains("Number")) {
        num = updatable;
      }
      else if (str.contains("Equal")) {
        eqval = updatable;
      }
      else if (str.contains("Minimum")) {
        min = updatable;
      }
      else if (str.contains("Ansvalue")) {
        AnsValue = updatable;
      }
    }
  }
  void defineLevel11To15Components() {
    if(displayImages == null)
      return;
    int totalObjects = displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();

      //check if the displayImages are present
      if (str.contains("b1Image")) {
        imgb1 = updatable;
      }
      else if (str.contains("C2Image")) {
        imgc2 = updatable;
      }
      else if (str.contains("b2Image")) {
        imgb2 = updatable;
      }
      else if (str.contains("C1Image")) {
        imgc1 = updatable;
      }
      else if (str.contains("a1Image")) {
        imga1 = updatable;
      }
      else if (str.contains("b2Image1")) {
        img1b2 = updatable;
      }
      else if (str.contains("a2Image")) {
        imga2 = updatable;
      }
      else if (str.contains("b1Image1")) {
        img1b1 = updatable;
      }

    }

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    totalObjects = updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("ValueA")) {
        valueA = updatable;
      }
      else if (str.contains("ValueB")) {
        valueB = updatable;
      }
      else if (str.contains("ValueB11")) {
        valueB11 = updatable;
      }
      else if (str.contains("ValueC")) {
        valueC = updatable;
      }
      else if (str.contains("ValueA1")) {
        valueA1 = updatable;
      }
      else if (str.contains("ValueB1")) {
        valueB1 = updatable;
      }
      else if (str.contains("ValueB12")) {
        valueB12 = updatable;
      }
      else if (str.contains("ValueC1")) {
        valueC1 = updatable;
      }
      else if (str.contains("Labelb")) {
        b = updatable;
      }
      else if (str.contains("Labelc2")) {
        c2 = updatable;
      }
      else if (str.contains("Labelb2")) {
        b2 = updatable;
      }
      else if (str.contains("Labelc1")) {
        c = updatable;
      }
      else if (str.contains("LabelA1")) {
        a = updatable;
      }
      else if (str.contains("Labelb12")) {
        b12 = updatable;
      }
      else if (str.contains("LabelA2")) {
        a2 = updatable;
      }
      else if (str.contains("Labelb11")) {
        b11 = updatable;
      }
      else if (str.contains("LabelAns")) {
        AnsLabel = updatable;
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
  private void renderLevel1(float deltaTime){
    update(deltaTime);

    textveriabalch3.update(deltaTime);

    if (glv.lableWrite) {

      switch (glv.countClick){
        case 1:
          labelP.setText(textveriabalch3.string_labal + " ");
          break;

        case 2:
          labelE.setText(textveriabalch3.string_labal + " ");

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
  private void renderLevel2(float delta){
    update(delta);

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }

    stage.draw();


    time.stage.draw();
  }
  private void renderLevel3(float deltaTime){

    time.update(deltaTime);

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }

    stage.draw();
    time.stage.draw();

  }
}
