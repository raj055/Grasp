package com.grasp.game.BuilderBlocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class OnClickCallBack extends ClickListener {

    Events notifyEvent;
    Notifier notifier;

    public OnClickCallBack(Events triggerEvent) {

        //Execute the super class's constructor
        super();

        //Get the single instance of Notifier.
        notifier = Notifier.getInstance();

        //Assign the notifier event.
        notifyEvent = triggerEvent;
    }

    protected void postEvent() {

        //Notify the post events.
        notifier.PostEvents(notifyEvent);

        //Log the event
        Gdx.app.log("POST EVETN",notifyEvent.toString());
    }
}
