package com.grasp.game.BuilderBlocks;

/**
 *
 */

public class SubscribersList {
  Subscriber subscriber;
  Events event;

  void setSubscriber(Subscriber sb){
    if(sb != null)
      subscriber = sb;
  }

  void setEvent(Events evt){
    if(evt != null)
      event = evt;
  }

  Subscriber getSubscriber(){
    return subscriber;
  }

  Events getEvent(){
    return event;
  }
}
