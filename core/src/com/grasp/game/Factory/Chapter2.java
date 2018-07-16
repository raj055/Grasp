package com.grasp.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.grasp.game.Component.Nagetiv_Num;
import com.grasp.game.Component.TextVeriabal;
import com.grasp.game.Enum.ScreenStates;
import com.grasp.game.Global.GlobalsCommonCount;
import com.grasp.game.Global.Objects;
import com.grasp.game.RealNumbers.BallDisplay;
import com.grasp.game.BuilderBlocks.ScrollingNumber;
import com.grasp.game.Timer.Timer;

import java.util.ArrayList;

/**
 * Created by HP on 12-01-2018.
 */

public class Chapter2 extends ChapterScreen implements Screen {

  private Timer time;

  // component of level_1
  Image graph = null;
  Image line_x = null;
  Image line_y = null;
  Image circle = null;
  Image circle1 = null;
  Image line1 = null;
  Image line2 = null;
  Image line3 = null;
  Label score = null;

  private int r = 0;

  private int stageTranslate = 0;

  int stepNo = 0;

  private Image submit = null;

  // component of level_2
  //level_2 step1
  Label Labal_f1 = null;
  Label Labal_f2 = null;
  Label Labal_f3 = null;
  Label Labal_f4 = null;

  //level_2 step2
  Label value_f1,value_f2,value_f3;
  Label num_1,num_2;

  //level_2 step3
  Image imgspread,imgspread1;
  Label cellLabel1,cellLabel2,cellLabel3,cellLabel4,cellLabel5,cellLabel6,cellLabel7;
  Label cellLabel11,cellLabel12,cellLabel13,cellLabel14,cellLabel15,cellLabel16,cellLabel17,cellLabel18;
  Label deviLabel1,deviLabel2,deviLabel3;
  Label deviLabel11,deviLabel12,deviLabel13;

  // component of level_3
  Image syntex1 = null;
  Image syntex2 = null;
  Image imggreen = null;
  Image imgsyntax = null;
  Image imgsyntex1 = null;
  Image imgsyntex2 = null;
  Image imgsyntex3 = null;

  Label quotient;

  // Component of Scrolling and Ball

  private GlobalsCommonCount glv;

  private Objects object;

  TextVeriabal textVeriabal;

  ScrollingNumber numLocal;

  BallDisplay ballDisplay;

  Nagetiv_Num nagetivNum;

  //Array List for the drag listeners.
  ArrayList<DragListener> listeners;

  ArrayList<Image> scrollingImages = null;

  boolean moveTheBg = false;

  @Override
  public void show() {}

  Chapter2(){
    super();

    time = new Timer();

    glv = GlobalsCommonCount.getInstance();

    object = Objects.getInstance();

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

  //Drag circle TouchListener
  DragListener dragcircle = new DragListener(){
    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {

     switch (GameStates.steps){
        case STEP_1:
          circle.moveBy(x, y);
          Gdx.app.log("step1","circle");
          break;
        case STEP_2:
          circle1.moveBy(x, y);
          Gdx.app.log("step2","circle");
          break;

        default:
          break;
     }
    }
    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer) {

      switch (GameStates.steps){
        case STEP_1:
          line1.setVisible(false);
          line2.setVisible(true);
          break;
        case STEP_2:
          line2.setVisible(false);
          line3.setVisible(true);
          break;
        default:
          break;
      }

    }
  };

  // Submit Button ClickListener
  ClickListener submitClickListener = new ClickListener() {
    @Override
    public void clicked(InputEvent event, float x, float y) {

      time.dispose();

      stageTranslate = 400;
      stepNo++;

      defineLevel1to5Components();
      stage.getCamera().translate(stageTranslate,0,0);
      stage.getCamera().update();

    }
  };

  //Level's

  // Level's Component
  void defineLevel1to5Components() {

    ArrayList<Label> updatableImage;
    ArrayList<Image> displayImage;
    ArrayList<Image> draggableImage;

    //assign the variables
    updatableImage =  getUpdatableUpdatableLabelPtr();
    displayImage   =  getUpdatableDisplayImagePtr();
    draggableImage =  getUpdatableDraggableImagePtr();
/*

    int count = 0;

    for(Image updatable : displayImage){
      String str = updatable.getName();
//      if (str.contains(object.Ch1L1[count])) {
//        line1 = updatable;
//      }
      count++;
    }
*/

    if(displayImage == null)
      return;

   //totalObjects
      int totalObjects = displayImage.size();
      for (Image updatable : displayImage) {
        String str = updatable.getName();

        if (str.contains("line1")) {
          line1 = updatable;
        } else if (str.contains("line2")) {
          line2 = updatable;
        } else if (str.contains("line3")) {
          line3 = updatable;
        } else if (str.contains("ClickImage")) {
          submit = updatable;
          submit.addListener(submitClickListener);
        }
      }

    if(draggableImage == null)
      return;

      //totalObjects
      totalObjects = draggableImage.size();
      for (Image updatable : draggableImage) {
        String str = updatable.getName();
        if (str.contains("DragCircle")) {
          circle = updatable;
          circle.addListener(dragcircle);
        }else  if (str.contains("DragCircle1")) {
          circle1 = updatable;
          circle1.addListener(dragcircle);
        }
      }
  }
  void defineLevel6to10Components() {

//    numLocal = new ScrollingNumber(Events.SCROLL_NUMBER_SELECT);

    ballDisplay = new BallDisplay();

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    int totalObjects = updatables.size();
    for (Label updatable : updatables) {
      String str = updatable.getName();

      if (str.contains("labelF1")) {
        Labal_f1 = updatable;
      }
      else if (str.contains("labelF2")) {
        Labal_f2 = updatable;
      }
      else if (str.contains("labelF3")) {
        Labal_f3 = updatable;
      }
      else if (str.contains("labelF4")) {
        Labal_f4 = updatable;
      }
      else if (str.contains("number1")) {
        num_1 = updatable;
      }
      else if (str.contains("number2")) {
        num_2 = updatable;
      }
    }

    //check if the updatables are present
    if(scrollingPara == null)
      return;

    numLocal = new ScrollingNumber();

    scrollingImages = new ArrayList<Image>();

    //totalObjects
    totalObjects = scrollingPara.size();

    for(Image img : scrollingPara)
    {
      scrollingImages.add(img);

      numLocal.scrolling(scrollingImages);
    }

    for (int i = 0; i < BallDisplay.columns; i++){

      for (int j = 0; j < BallDisplay.rows; j++) {

        stage.addActor(ballDisplay.balls[i][j]);

        ballDisplay.balls[i][j].setVisible(false);

      }
    }

    for(Image numberI : numLocal.numbers)
    {
      stage.addActor(numberI);
    }
  }
  void defineLevel11to15Components() {
    textVeriabal = new TextVeriabal();

    for(Image numberI : textVeriabal.numbers)
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

      if (str.contains("quotient")) {
        quotient = updatable;
      }
    }

    if(displayImages == null)
      return;
    totalObjects = displayImages.size();
    for (Image updatable : displayImages) {
      String str = updatable.getName();
      if (str.contains("Imggreen")) {
        imggreen = updatable;
        imggreen.addListener(submitClickListener);

      }
      else if (str.contains("Syntex1")) {
        syntex1 = updatable;
      }
      else if (str.contains("Imgsyntex1")) {
        imgsyntex1 = updatable;
      }
    }

    //check if the updatables are present
    if(scrollingPara == null)
      return;

    numLocal = new ScrollingNumber();

    scrollingImages = new ArrayList<Image>();

    //totalObjects
     totalObjects = scrollingPara.size();

    for(Image img : scrollingPara)
    {
      scrollingImages.add(img);

      numLocal.scrolling(scrollingImages);
    }

    nagetivNum = new Nagetiv_Num();

    for(Image numberI : nagetivNum.numbers)
    {
      stage.addActor(numberI);
    }
  }

  ArrayList<Label> getUpdatableUpdatableLabelPtr(){
    ArrayList<Label> arryLb;
//    arryLb = updateList.get(stepNo);
    return
            null;
//            arryLb;
  }
  ArrayList<Image>  getUpdatableDisplayImagePtr(){
    ArrayList<Image> arryLb;

//    arryLb = displayList.get(stepNo);
    return
            null;
//            arryLb;
  }
  ArrayList<Image>  getUpdatableDraggableImagePtr(){
    ArrayList<Image> arryLb;
//    arryLb = dragList.get(stepNo);

    return
            null;
//            arryLb;
  }



  interface LevelDefinition {
    void initialise();
  }

  private LevelDefinition[] levelInitialisations = (LevelDefinition[]) new LevelDefinition[] {
          new LevelDefinition() {
            public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1to5Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel6to10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },

  };

  public void initialiseLevelComponents(int index) {
    levelInitialisations[index].initialise();
  }

  //Drag's
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
//    listeners.add(indexOfListener++, drgListener);
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

    if(moveTheBg) {
      bg.act(delta);
//      moveTheBg = false;
    }

    time.stage.draw();


  }
  private void renderLevel2(float deltaTime){
    //Sets the color to be applied after clearing the screen (R,G,B,A)
    Gdx.gl.glClearColor(0,0,255,1);
    //Clears the screen
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    time.update(deltaTime);

    numLocal.update(deltaTime);
    ballDisplay.update(deltaTime);

    int ballclick = 0;

    switch (GameStates.steps) {
      case STEP_1:
        if (glv.lableWrite) {

          switch (glv.countClick) {
            case 1:
              Labal_f1.setText(glv.lableUpdate + " ");
              ballclick = glv.click1 = glv.lableUpdate;
              break;
            case 2:
              Labal_f2.setText(glv.lableUpdate + " ");
              ballclick = glv.click2 = glv.lableUpdate;
              break;
            case 3:
              Labal_f3.setText(glv.lableUpdate + " ");
              ballclick = glv.click3 = glv.lableUpdate;
              break;
            case 4:
              Labal_f4.setText(glv.lableUpdate + " ");
              ballclick = glv.click4 = glv.lableUpdate;

              break;

            default:
              break;
          }

          for (int i = 0; i < ballclick; i++) {

            ballDisplay.balls[i][r].setVisible(true);

          }
        }
        break;

      case STEP_2:
        if (glv.lableWrite) {

          switch (glv.countClick) {
            case 1:
              num_1.setText(glv.lableUpdate + " ");
              break;
            case 2:
              num_2.setText(glv.lableUpdate + " ");

              break;

            default:
              break;
          }
        }
        break;

      default:
        break;
    }

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }

    stage.draw();

    if(moveTheBg) {
      bg.act(deltaTime);
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

    textVeriabal.update(deltaTime);

    if (glv.lableWrite){

      quotient.setText(textVeriabal.string_labal + " ");

      imggreen.setVisible(true);
      syntex1.setVisible(true);
      imgsyntex1.setVisible(true);
    }

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }

    stage.draw();

    if(moveTheBg) {
      bg.act(deltaTime);
//      moveTheBg = false;
    }

    time.stage.draw();

  }

  // Step's Render
  interface RenderStep {
    void renderS(float delta);
  }

  private RenderStep[] renderSteps = (RenderStep[]) new RenderStep[]{
          new RenderStep() {
            @Override
            public void renderS(float delta) { renderSteps1(delta);} },
          new RenderStep() { public void renderS(float delta) { renderSteps2(delta); } },
          new RenderStep() { public void renderS(float delta) { renderSteps3(delta); } },
  };

  private void renderSteps1(float delta){
    update(delta);

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }

    stage.draw();

    time.stage.draw();
  }
  private void renderSteps2(float delta){
    update(delta);

    stage.draw();
  }
  private void renderSteps3(float delta){
    stage.draw();
  }
}
