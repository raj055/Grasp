package com.grasp.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.StringBuilder;
import com.grasp.game.BuilderBlocks.ChapterVariables;
import com.grasp.game.BuilderBlocks.Events;
import com.grasp.game.BuilderBlocks.ProgressData;
import com.grasp.game.Enum.ScreenStates;
import com.grasp.game.Global.GlobalsCommonCount;
import com.grasp.game.RealNumbers.BallDisplay;
import com.grasp.game.RealNumbers.BallDragListener;
import com.grasp.game.RealNumbers.DragBallIndicators;
import com.grasp.game.RealNumbers.RemainderDragListener;
import com.grasp.game.BuilderBlocks.ScrollingNumber;
import com.grasp.game.RealNumbers.VisibleComponents;
import com.grasp.game.Timer.Timer;

import java.util.ArrayList;

import static com.grasp.game.Global.GlobalsCommonCount.ValueA;

/**
 * Created by HP on 12-01-2018.
 */

public class Chapter1 extends ChapterScreen implements Screen {

  //Level 1 variables
  private Timer time;
  private GlobalsCommonCount glv;

  //Get the components of level 1
  private Image progbar1;
  private Label submitButton = null;
  ArrayList<Image> displayBalls = null;
  ArrayList<Image> remainderBall = null;

  ArrayList<Image> scrollingImages = null;

  //Get the components of level 3
  Label labelX;
  BallDisplay ballDisplay;

  //Array List for the drag listeners.
  ArrayList<DragListener> listeners;
  boolean moveTheBg = false;

  //Ball Drag Listener
  BallDragListener ballDragListener;
  RemainderDragListener remBallDragListener;

  //Scrolling Number
  ScrollingNumber numLocal;

  //Indicators
  DragBallIndicators dragBallIndicators;

  //Dependant Components
  VisibleComponents visibleComponents;

  Chapter1(){
    super();

    time = new Timer();

    glv = GlobalsCommonCount.getInstance();

    ballDisplay = new BallDisplay();

    //Define all Listeners and Updation Objects
    ballDragListener = new BallDragListener(Events.BALL_DRAG_EVENT);
    remBallDragListener = new RemainderDragListener(Events.REMAINDER_BALL_DRAG);
//    numLocal = new ScrollingNumber(Events.SCROLL_NUMBER_SELECT);

    getLevelName();
    initialiseDragListeners(currentLevelNumber);
    initialiseLevelComponents(currentLevelNumber);
  }

  //update the time
  public void update(float dt){
    time.update(dt);
  }
  @Override
  public void show() {}

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

  // Drag Remainder Ball
  private void attachDraggables(){
    if(draggable == null) {
      return;
    }
    try {
      int totalObjects = draggable.size();
      int currentIndex = 0;

      for (Image draggables : draggable) {
        if (draggables.getName().contains("RemBall")) {
          draggables.addListener(remBallDragListener);
        } else
          draggables.addListener(ballDragListener);
      }
    }catch (Exception e){
    }
  }

  // Drag and Drop Main Ball
   DragListener drgListener = new DragListener(){
    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
      Image dragball = (Image)event.getListenerActor();
      //Drag all the balls
      for(Image disBall : displayBalls) {
        disBall.moveBy(x, y);
      }
    }

  };

  // Drag Remainder Ball
   DragListener remainderDragListener = new DragListener(){

    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
      Image dragball = (Image)event.getListenerActor();
      dragball.moveBy(x, y);
    }

  };

  // Submit Button ClickListener
   ClickListener submitBttnClickListener = new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y) {
      GameStates.screenStates = ScreenStates.LEVELSCREEN;
      time.dispose();
    }
  };

  private void defineLevel1To10Components() {

    //check if the updatable are present
    if(updatables == null)
      return;

    ChapterVariables chapterVariables = ChapterVariables.getInstance();
    //totalObjects
    int totalObjects = updatables.size();
    ArrayList<ProgressData>  updateLabelsList = new ArrayList<ProgressData>();
    for (Label updatable : updatables)
    {
      //Array List of Labels
      ProgressData prgDataLabel = new ProgressData();
      String txt = updatable.getText().toString();

      //Progress Data Label
      prgDataLabel.visibleEntity = updatable;
      prgDataLabel.valueVar = Integer.valueOf(txt);
      updateLabelsList.add(prgDataLabel);

      //Update Value of A
      chapterVariables.chapter1Variables.ValueOfA = ValueA[currentLevelNumber];
      Gdx.app.debug("Current Level Number", String.valueOf(currentLevelNumber));
      Gdx.app.debug("Value of A", String.valueOf(chapterVariables.chapter1Variables.ValueOfA));
    }
    //Put components
    dragBallIndicators = new DragBallIndicators(updateLabelsList);

    if(displayImages == null)
      return;

    displayBalls = new ArrayList<Image>();
    displayBallList = new ArrayList<Image>();
    remainderBall = new ArrayList<Image>();
    totalObjects = displayImages.size();
    for (Image updatable : displayImages)
    {
      String str = updatable.getName();
      if (str.contains("progBar1"))
        progbar1 = updatable;
      else if (str.contains("displayBall")) {

        displayBallList.add(updatable);
      }
    }

    //Components to be updated on receiving an event
    visibleComponents = new VisibleComponents(progbar1, displayBallList);

    totalObjects = draggable.size();
    for (Image updatable : draggable) {
      String str = updatable.getName();
      if (str.contains("DragBall")) {
        chapterVariables.chapter1Variables.ValueOfB++;
        displayBalls.add(updatable);
      }
      else if (str.contains("RemBall"))
        remainderBall.add(updatable);
    }
    ballDragListener.setDisplayBalls(displayBalls);

    attachDraggables();
  }

  private void defineLevel11to15Components() {

    //check if the updatables are present
    if(scrollingPara == null)
      return;

    numLocal = new ScrollingNumber();

    scrollingImages = new ArrayList<Image>();

    //totalObjects
    int totalObjects = scrollingPara.size();

    for(Image img : scrollingPara)
    {
      scrollingImages.add(img);

      numLocal.scrolling(scrollingImages);
    }

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    totalObjects = updatables.size();
    for (Label updatable : updatables)
    {
      String str = updatable.getName();

      if (str.contains("LabelB")) {
        labelX = updatable;
      }
      else if (str.contains("Checkmark")) {
        Gdx.app.log("ch_11","click");
        submitButton = updatable;
        submitButton.addListener(submitBttnClickListener);
      }
    }

    for (int i = 0; i < BallDisplay.columns; i++){

      for (int j = 0; j < BallDisplay.rows; j++) {

        stage.addActor(ballDisplay.balls[i][j]);

        ballDisplay.balls[i][j].setVisible(false);

      }
    }

    for(Image numberI : scrollingPara)
    {
      stage.addActor(numberI);
    }


  }

  interface LevelDefinition {
    void initialise();
  }

  private LevelDefinition[] levelInitialisations = new LevelDefinition[] {
          new LevelDefinition() {
            public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel1To10Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11to15Components(); } },

  };

  private void initialiseLevelComponents(int index) {
    levelInitialisations[index].initialise();
  }

  interface DragListnerList {
    void allotDragListener();
  }

  public DragListnerList[] dragListnerLists = new DragListnerList[] {
          new DragListnerList() {
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

  public void addLevel1DraggableListeners(){
    //initialise the array of drag listeners
    int indexOfListener = 0;
    listeners = new ArrayList<DragListener>();
    listeners.add(indexOfListener++, drgListener);
    listeners.add(indexOfListener++, remainderDragListener);
  }

  interface RenderLevel {
    void renderL(float delta);
  }

  private RenderLevel[] renderLists = new RenderLevel[] {
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

    numLocal.update(deltaTime);

    ballDisplay.update(deltaTime);

    if (glv.lableWrite){

      glv.lableWrite = false;

      StringBuilder  str = new StringBuilder(labelX.getText());
      str.append(glv.lableUpdate);
      str.append("*");
      labelX.setText(str);

      switch (glv.countClick) {
        case 1:
          glv.click1 = glv.lableUpdate;
          break;

        case 2:
          glv.click2 = glv.lableUpdate;
          break;

        default:
          break;
      }

      for (int i = 0; i < glv.click1; i++){
        ballDisplay.balls[i][0].setVisible(true);
        for (int j = 0; j < glv.click2; j++) {
          ballDisplay.balls[i][j].setVisible(true);
        }
      }
    }

    if (time.isTimeUp()){
      GameStates.screenStates = ScreenStates.GAMEOVER;
    }
    stage.draw();
    time.stage.draw();
  }

}
