package com.grasp.game.Factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.StringBuilder;
import com.grasp.game.BuilderBlocks.ChapterVariables;
import com.grasp.game.BuilderBlocks.Events;
import com.grasp.game.BuilderBlocks.ProgressData;
import com.grasp.game.Component.BallDisplay;
import com.grasp.game.Component.Number;
import com.grasp.game.Enum.ScreenStates;
import com.grasp.game.Global.GlobalsCommonCount;
import com.grasp.game.MyGame;
import com.grasp.game.RealNumbers.BallDragListener;
import com.grasp.game.RealNumbers.DragBallIndicators;
import com.grasp.game.RealNumbers.RemainderDragListener;
import com.grasp.game.RealNumbers.VisibleComponents;
import com.grasp.game.Timer.Timer;

import java.util.ArrayList;

import static com.grasp.game.Global.GlobalsCommonCount.ValueA;


/**
 * Created by HP on 12-01-2018.
 */

public class Chapter1 extends ChapterScreen implements Screen {

  //Level 1 variables
  private int b = 0;
  private int r = 0;
  private Timer time;
  private int score = 0;
  private int remPosX= 20;
  private GlobalsCommonCount glv;
  private Dialog dialog;

  //Get the components of level 1
  private Image progbar1;



  private Label label_b   = null;
  private Label label_r   = null;
  private Label label_score = null;
  private Label submitButton = null;
  int scoreValue = 0;
  int bValue = 0;
  float aValue = 1;
  ArrayList<Image> displayBalls = null;
  ArrayList<Image> remainderBall = null;

  //Get the components of level 3
  Label labelX;
  Number numLocal;
  BallDisplay ballDisplay;
  int stepNumber = 0;

  //Array List for the drag listeners.
  ArrayList<DragListener> listeners;
  boolean moveTheBg = false;

  //Ball Drag Listener
  BallDragListener ballDragListener;
  RemainderDragListener remBallDragListener;

  //Indicators
  DragBallIndicators dragBallIndicators;

  //Dependant Components
  VisibleComponents visibleComponents;

  Chapter1(){
    super();

    time = new Timer();

    glv = GlobalsCommonCount.getInstance();

    //Define all Listeners and Updation Objects
    ballDragListener = new BallDragListener(Events.BALL_DRAG_EVENT);
    remBallDragListener = new RemainderDragListener(Events.REMAINDER_BALL_DRAG);

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

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer) {
//      Image dregball = (Image)event.getListenerActor();
//
//      Image dispBallImg = displayBallList.get(b++);
//      dispBallImg.setVisible(true);
//      int xPos = 150;
//      int totalBalls = 0;
//      for(Image disBall : displayBalls) {
//        score++;
//        disBall.setPosition(xPos, MyGame.HEIGHT - 100);
//        xPos += 50;
//      }
//      float progBarSize = score * (300/aValue);
//
//      progbar1.setSize(30, progBarSize);
//      progbar1.setVisible(true);
//      label_b.setText(b + " ");
//
//      label_score.setText(score + "");
    }
  };

  // Drag Remainder Ball
  DragListener remainderDragListener = new DragListener(){

    @Override
    public void drag(InputEvent event, float x, float y, int pointer) {
      Image dragball = (Image)event.getListenerActor();
      dragball.moveBy(x, y);
    }

    @Override
    public void dragStop(InputEvent event, float x, float y, int pointer) {
//      Image draggedBall = (Image)event.getListenerActor();
//      r++;
//      score++;
//      if (draggedBall != null) {
//        draggedBall.setSize(40,40);
//        draggedBall.setPosition(remPosX,170);
//        remPosX += 40;
//        float progBarSize = score * (300/aValue);
//        progbar1.setSize(30, progBarSize);
//
//        progbar1.setVisible(true);
//        label_r.setText(r +" ");
//        label_score.setText(score + " ");
//      }
    }
  };

  // Submit Button ClickListener
  ClickListener submitBttnClickListener = new ClickListener(){
    @Override
    public void clicked(InputEvent event, float x, float y) {

      GameStates.screenStates = ScreenStates.LEVELSCREEN;
      time.dispose();

      /**********************
       stageTranslate += 400;
       stepNumber++;
       if(stageTranslate >= 1200) {
       stageTranslate = 0;
       stepNumber = 0;
       }
       defineLevel1Components();
       stage.getCamera().translate(stageTranslate,0,0);
       stage.getCamera().update();
       ************************/
    }
  };

  void defineLevel1Components() {

    //check if the updatables are present
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


  void defineLevel6Components() {
    int totalObjects = displayImages.size();
    for (Image updatable : displayImages)
    {
      String str = updatable.getName();
      if (str.contains("PragBar1")) {
        progbar1 = updatable;
      }
    }
  }
  void defineLevel7Components() {
    int totalObjects = displayImages.size();
    for (Image updatable : displayImages)
    {
      String str = updatable.getName();
      if (str.contains("PragBar1")) {
        progbar1 = updatable;
      }
    }
  }
  void defineLevel8Components() {
    int totalObjects = displayImages.size();
    for (Image updatable : displayImages)
    {
      String str = updatable.getName();
      if (str.contains("PragBar1")) {
        progbar1 = updatable;
      }
    }
  }
  void defineLevel9Components() {
    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    int totalObjects = updatables.size();
    for (Label updatable : updatables)
    {
      String str = updatable.getName();
      if (str.contains("Score2")) {
        label_b = updatable;
      }
      else if (str.contains("ScoreValue")) {
        label_score = updatable;
      }
      else if (str.contains("Score4")) {
        label_r = updatable;
      }
      else if (str.contains("LabelA")){
        StringBuilder strA = updatable.getText();

        aValue = ValueA[currentLevelNumber];
      }
      else if (str.contains("SubmitButtn")) {
        submitButton = updatable;
        submitButton.addListener(submitBttnClickListener);
      }
    }

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
//        displayball = updatable;
        displayBallList.add(updatable);
      }
    }

    totalObjects = displayImages.size();
    for (Image updatable : displayImages)
    {
      String str = updatable.getName();
      if (str.contains("PragBar1")) {
        progbar1 = updatable;
      }
    }

    totalObjects = draggable.size();
    for (Image updatable : draggable) {
      String str = updatable.getName();
      if (str.contains("DragBall")) {
        displayBalls.add(updatable);
      }
      else if (str.contains("RemBall"))
        remainderBall.add(updatable);
    }
    attachDraggables();
  }
  void defineLevel10Components() {
    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    int totalObjects = updatables.size();
    for (Label updatable : updatables)
    {
      String str = updatable.getName();
      if (str.contains("Score2")) {
        label_b = updatable;
      }
      else if (str.contains("ScoreValue")) {
        label_score = updatable;
      }
      else if (str.contains("Score4")) {
        label_r = updatable;
      }
      else if (str.contains("LabelA")){
        StringBuilder strA = updatable.getText();

        aValue = ValueA[currentLevelNumber];
      }
      else if (str.contains("SubmitButtn")) {
        submitButton = updatable;
        submitButton.addListener(submitBttnClickListener);
      }
    }

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
//        displayball = updatable;
        displayBallList.add(updatable);
      }
    }
    totalObjects = draggable.size();
    for (Image updatable : draggable) {
      String str = updatable.getName();
      if (str.contains("DragBall")) {
        displayBalls.add(updatable);
      }
      else if (str.contains("RemBall"))
        remainderBall.add(updatable);
    }
    attachDraggables();
  }
  void defineLevel11Components() {
    ballDisplay = new BallDisplay();
    numLocal = new Number();

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    int totalObjects = updatables.size();
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

    for(Image numberI : numLocal.numbers)
    {
      stage.addActor(numberI);
    }
  }
  void defineLevel12Components() {
    ballDisplay = new BallDisplay();
    numLocal = new Number();

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    int totalObjects = updatables.size();
    for (Label updatable : updatables)
    {
      String str = updatable.getName();

      if (str.contains("LabelB"))
        labelX = updatable;
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
  void defineLevel13Components() {
    ballDisplay = new BallDisplay();
    numLocal = new Number();

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    int totalObjects = updatables.size();
    for (Label updatable : updatables)
    {
      String str = updatable.getName();

      if (str.contains("LabelB"))
        labelX = updatable;
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
  void defineLevel14Components() {
    ballDisplay = new BallDisplay();
    numLocal = new Number();

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    int totalObjects = updatables.size();
    for (Label updatable : updatables)
    {
      String str = updatable.getName();

      if (str.contains("LabelB"))
        labelX = updatable;
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
  void defineLevel15Components() {
    ballDisplay = new BallDisplay();
    numLocal = new Number();

    //check if the updatables are present
    if(updatables == null)
      return;

    //totalObjects
    int totalObjects = updatables.size();
    for (Label updatable : updatables)
    {
      String str = updatable.getName();

      if (str.contains("LabelB"))
        labelX = updatable;
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

  void getUpdatableImagePtr(){}

  ArrayList<Label> getUpdatableUpdatableLabelPtr(){
    ArrayList<Label> arryLb;
    switch (stepNumber){
      case 0:
        arryLb = updatables;
        break;
      case 1:
        arryLb = updatablesNext;
        break;
      case 2:
        arryLb = updatablesLast;
        break;
      default:
        arryLb = updatables;
        break;
    }
    return
            arryLb;
  }
  ArrayList<Image>  getUpdatableDisplayImagePtr(){
    ArrayList<Image> arryLb;
    switch (stepNumber){
      case 0:
        arryLb = displayImages;
        break;
      case 1:
        arryLb = displayImagesNext;
        break;
      case 2:
        arryLb = displayImagesLast;
        break;
      default:
        arryLb = displayImages;
        break;
    }
    return
            arryLb;
  }
  ArrayList<Image>  getUpdatableDraggableImagePtr(){
    ArrayList<Image> arryLb;
    switch (stepNumber){
      case 0:
        arryLb = draggable;
        break;
      case 1:
        arryLb = draggableNext;
        break;
      case 2:
        arryLb = draggableLast;
        break;
      default:
        arryLb = draggable;
        break;
    }
    return
            arryLb;
  }

  interface LevelDefinition {
    void initialise();
  }

  private LevelDefinition[] levelInitialisations = new LevelDefinition[] {
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
          new LevelDefinition() { public void initialise() { defineLevel11Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11Components(); } },
          new LevelDefinition() { public void initialise() { defineLevel11Components(); } },

  };

  public void initialiseLevelComponents(int index) {
    levelInitialisations[index].initialise();
  }

  interface DragListnerList {
    void allotDragListener();
  }

  private DragListnerList[] dragListnerLists = new DragListnerList[] {
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

  private void addLevel1DraggableListeners(){
    //initialise the array of drag listeners
    int indexOfListener = 0;
    listeners = new ArrayList<DragListener>();
    listeners.add(indexOfListener++, drgListener);
    listeners.add(indexOfListener++, remainderDragListener);
  }
  private void addLevel2DraggableListeners(){

  }
  private void addLevel3DraggableListeners(){

  }
  private void addLevel4DraggableListeners(){

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
