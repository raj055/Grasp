package com.grasp.game.BuilderBlocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.grasp.game.BuilderBlocks.Events;
import com.grasp.game.BuilderBlocks.OnClickCallBack;
import com.grasp.game.BuilderBlocks.OnDragCallBack;
import com.grasp.game.Factory.ChapterScreen;
import com.grasp.game.Global.GlobalsCommonCount;

import java.util.ArrayList;

public class ScrollingNumber implements Disposable {

    public ArrayList<Image> numbers = null;

    private GlobalsCommonCount gblVar;

    public ScrollingNumber(){

        gblVar = GlobalsCommonCount.getInstance();

        numbers = new ArrayList<Image>();

    }

    public void scrolling(ArrayList<Image> imagescrolling){

        int posX = 10;
        int posY;
        int totalNumbers = imagescrolling.size();
        for(int numCount = 0; numCount < totalNumbers; numCount++)
        {
            final Image img = (imagescrolling.get(numCount));

            final int count = numCount;

            posY = 700 + gblVar.posYNum[numCount];
            img.setPosition(posX,posY);
            posX += 40;

            img.addListener(new ClickListener(){
                @Override
                public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                    Gdx.app.log("click 1","First" + gblVar.countClick++);

                    gblVar.lableUpdate = count;
                    gblVar.lableWrite = true;
                }
            });

            numbers.add(img);
        }
    }

    public void update(float deltaTime){

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
