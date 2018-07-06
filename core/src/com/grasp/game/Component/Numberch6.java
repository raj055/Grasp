package com.grasp.game.Component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.grasp.game.Global.GlobalsCommonCount;

/**
 * Created by HP on 25-11-2017.
 */

public class Numberch6 implements Disposable {

  public static final int NUMBERCOUNT = 6;

  public Array<Image> numbers;

  private GlobalsCommonCount gblVar;

  public String string_labal;

  public Numberch6(){

    gblVar = GlobalsCommonCount.getInstance();

    numbers = new Array<Image>();

    int posX = 6;
    int posY = 700;
    for(int numCount = 0; numCount < NUMBERCOUNT; numCount++)
    {
        final Image img = new Image(new Texture(gblVar.NumberLevel11[numCount]));

      gblVar.NumberLevel11[numCount] = gblVar.NumberLevel12[numCount];

        final  int count = numCount;

        posY = 700 + gblVar.posYNum[numCount];
        img.setSize(30,40);
        img.setPosition(posX,posY);
        posX += 40;

        img.addListener(new ClickListener(){
          @Override
          public void clicked(InputEvent event, float x, float y) {

            Gdx.app.log("TextVariable","click_" + gblVar.countClick++);

            string_labal = gblVar.NumberLevel11[count];

            gblVar.lableUpdate = count;
            gblVar.lableWrite = true;

          }
        });

        numbers.add(img);
    }

  }

  public void update(float deltaTime){
    int yCount = 0;

    for(Image img : numbers)
    {
      float y = img.getY();
      y -= gblVar.posYDiff[0];
      img.setPosition(img.getX(),y);
      if (y <= 0) {
        y = 700;
        float x;
        x = MathUtils.random(50, 360);
        img.setPosition(x, y);
      }

      }

  }

  @Override
  public void dispose() {
    gblVar.clear();
  }

}
