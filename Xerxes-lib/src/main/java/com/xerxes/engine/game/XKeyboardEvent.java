package com.xerxes.engine.game;

public class XKeyboardEvent extends GameEvent
{
	private int keyCode;

    private String type;
	
	public XKeyboardEvent(int keyCode, String type)
	{
		this.keyCode=keyCode;
        this.type=type;
	}
	
	public int getKeyCode()
	{
		return keyCode;
	}

    public String getType(){
        return type;
    }
}
