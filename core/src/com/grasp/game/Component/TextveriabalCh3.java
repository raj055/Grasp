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
 * Created by HP on 12-12-2017.
 */

public class TextveriabalCh3 implements Disposable {


  public static final int TextCOUNT = 6;

  public Array<Image> texts;

  private GlobalsCommonCount gblVar;

  public String string_labal;

  public TextveriabalCh3(){

    gblVar = GlobalsCommonCount.getInstance();

    texts = new Array<Image>();

    int posX = 10;
    int posY;

    for(int numCount = 0 ; numCount < TextCOUNT; numCount++)
    {
      final Image img = new Image(new Texture(gblVar.TextLevel1[numCount]));

       gblVar.TextLevel1[numCount] = gblVar.TextLevel3[numCount];

      final  int count = numCount;

      posY = 50 + gblVar.posYNum[numCount];
      img.setSize(30,40);
      img.setPosition(posX,posY);
      posX += 40;

      img.addListener(new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y) {

          Gdx.app.log("TextVariable","click_" + gblVar.countClick++);

          string_labal = gblVar.TextLevel1[count];

          gblVar.lableUpdate = count;
          gblVar.lableWrite = true;

        }
      });

      texts.add(img);
    }

  }

  public void update(float deltaTime) {
    int yCount = 0;

    for (Image img : texts) {
      float y = img.getY();
      y -= gblVar.posYDiff[0];
      img.setPosition(img.getX(), y);
      if (y <= 0) {
        y = 400;
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
