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
package com.xerxes.engine.ui;


/**
 * represents the size of an object in the xerxes framework
 * @author Sergi Fernández Cristià ||*||
 *
 */
public class Size 
{
	private double width;
	private double height;
	private Resizeable notifier;
	
	/**
	 * constructor
	 * @param registeredObject object to whom report size changes
	 * @param w the width of the object
	 * @param h the height of the object
	 */
	public Size(Resizeable registeredObject,double w,double h)
	{
		this(w,h);
		notifier=registeredObject;
		notifier.notifyResize(w, h);
	}
	public Size(double w,double h)
	{
		width=w;
		height=h;
	}
	/**
	 * 
	 * @return the width of the object
	 */
	public double getWidth()
	{
		return width;
	}
	
	public void setWidth(double width)
	{
		this.width=width;
	}
	
	/**
	 * 
	 * @return the height of the object
	 */
	public double getHeight()
	{
		return height;
	}
	
	public void setHeight(double height)
	{
		this.height=height;
	}
	
	/**
	 * new size of the object
	 * @param newW new Width
	 * @param newH new Height
	 */
	public void resize(double newW, double newH) 
	{
		width=newW;
		height=newH;
		if(notifier!=null)notifier.notifyResize(newW, newH);
	}
}
