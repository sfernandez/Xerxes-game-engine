package com.xerxes.engine.game;

import java.util.ArrayList;

public abstract class  GameController
{
	private ArrayList<Actor> actors;

    public GameController(){
        this(new ArrayList<Actor>());
    }
	
	public GameController(ArrayList<Actor> actors)
	{
		this.actors=actors;
	}

    public void addActor(Actor actor){
        this.actors.add(actor);
    }
	
	public final void receiveEvent(GameEvent event)
	{
		for(Actor actor:actors)
		{
			actor.executeAction(getActionFromEvent(event));
		}
	}
	protected abstract String getActionFromEvent(GameEvent event);
}
