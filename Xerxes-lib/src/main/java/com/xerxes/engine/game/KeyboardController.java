package com.xerxes.engine.game;

import java.util.ArrayList;
import java.util.HashMap;

public class KeyboardController extends GameController 
{
	private HashMap<Integer, String> keyMap;

    public KeyboardController(){
        this(new ArrayList<Actor>());
    }
	
	public KeyboardController(ArrayList<Actor> actors)
	{
		this(actors,new HashMap<Integer, String>());
	}
	
	public void addOrModifyKeyEvent(int keyCode, String actionName)
	{
		keyMap.put(keyCode, actionName);
	}
	
	public KeyboardController(ArrayList<Actor> actors, HashMap<Integer, String> keyMap)
	{
		super(actors);
		this.keyMap=keyMap;
	}
	@Override
	protected String getActionFromEvent(GameEvent event)
	{
		XKeyboardEvent keyboardEvent = (XKeyboardEvent)event;
		return keyMap.get(keyboardEvent.getKeyCode());
	}
}
