package com.xerxes.engine.game;

public class TimerActorEvent {
    private TimerActorEventAction action;
    private Actor[] actors;

    public TimerActorEvent(Actor[] actors, TimerActorEventAction action)
    {
        this.actors = actors;
        this.action = action;
    }

    public void doAction(){
        action.doEventAction(actors);
    }
}
