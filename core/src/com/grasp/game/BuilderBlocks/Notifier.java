package com.grasp.game.BuilderBlocks;

import java.util.ArrayList;

/**
 *
 *
 */

public class Notifier {

  //Array List of subscribers.
  ArrayList<SubscribersList> subscribersList = new ArrayList<SubscribersList>();

  //Declare the class singleton class
  private static Notifier myObj;

  //Return the single instance of the
  public static Notifier getInstance(){
    if(myObj == null){
      myObj = new Notifier();
    }
    return myObj;
  }

  public void RegisterSubscriber(Subscriber subscriber, Events events){

    //Assign the event value to the subscribed class.
    if((subscriber != null) &&
      (events != null))
    {
      //Define Subscribers List.
      SubscribersList subcriberElement = new SubscribersList();
      subcriberElement.setSubscriber(subscriber);
      subcriberElement.setEvent(events);

      //Add the subscribers to the list.
      subscribersList.add(subcriberElement);
    }
  }

  public void PostEvents(Events events){
    //Confirm the subscribers list if non-null.
    if(subscribersList != null){
      //Check if the list of subscribers is empty.
      if(subscribersList.size() > 0){
        //Find all the subscribers who have subscribed to the posted event.
        for(SubscribersList sb : subscribersList){
          if(sb.getEvent().equals(events)){
            //Execute the callback function on receiving the event.
            sb.getSubscriber().UpdateAllElements(events);
          }
        }
      }
    }
  }
}
