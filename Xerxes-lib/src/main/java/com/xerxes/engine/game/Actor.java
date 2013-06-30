/* This file is part of Xerxes game engine.

    Xerxes game engine is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Xerxes game engine is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Xerxes game engine.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.xerxes.engine.game;

import com.xerxes.engine.ui.Spriteable;
import com.xerxes.engine.ui.animation.Animatable;

import java.util.HashMap;
import java.util.List;

public class Actor 
{

	private Spriteable sprite;
	private HashMap<String,Animatable> animations;
	private HashMap<String,ActorAction> actions;
    private List<String> disabledActions;

    public Actor(Spriteable sprite){
        initActor(sprite);
    }

    private void initActor(Spriteable sprite){
        this.sprite=sprite;
        this.actions=new HashMap<String, ActorAction>();
        this.animations = new HashMap<String, Animatable>();
    }
	
	public Actor(Spriteable sprite,Animatable[] animations)
	{
        initActor(sprite);
		for(Animatable animation:animations)
		{
			this.animations.put(animation.getName(), animation);
		}
	}

    public void addAnimation(Animatable animation){
        this.animations.put(animation.getName(), animation);
    }
	
	public void addAction(String actionName, ActorAction action)
	{
		actions.put(actionName, action);
	}
	
	public void executeAction(String actionName)
	{
		actions.get(actionName).doAction(this);
	}
	
	public void render() 
	{
		sprite.render();
	}
	
	public void render(String imageName)
	{
		sprite.render(imageName);
	}

	public void play(String animationName) 
	{
		animations.get(animationName).play(sprite);
	}

    public Spriteable getSprite(){
        return this.sprite;
    }
	
}
