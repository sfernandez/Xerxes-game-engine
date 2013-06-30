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

import java.util.HashMap;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
/**
 * represents a sprite object inside the xerxes framework
 * a sprite is an image object that can change it's position depth size and appearance in runtime
 * a sprite can contain n number of images representing an sprite animation
 * @author Sergi Fernández Cristià ||*||
 *
 */
public class Sprite implements Spriteable
{
	private DivElement imageContainer;
	private Image image;
	private HashMap<String, ImageResource> imageTemplates;
	private Position position;
	private Size size;
	private static final double defaultX=0;
	private static final double defaultY=0;
	private static final int defaultZ=0;
	private static final int defaultWidth=100;
	private static final int defaultHeight=100;
	/**
	 * 
	 * @param spriteId id of the sprite
	 */
	public Sprite(String spriteId)
	{
		this(spriteId,defaultX,defaultY);
	}

	/**
	 * 
	 * @param spriteId id of the sprite
	 * @param posX horizontal position in pixels
	 * @param posY vertical position in pixels
	 */
	public Sprite(String spriteId,double posX,double posY)
	{
		this(spriteId,posX,posY,defaultZ);
	}
	/**
	 * 
	 * @param spriteId id of the sprite
	 * @param posX horizontal position in pixels
	 * @param posY vertical position in pixels
	 * @param posZ depth level
	 */
	public Sprite(String spriteId,double posX,double posY,int posZ)
	{
		imageTemplates = new HashMap<String, ImageResource>();
		imageContainer = Document.get().createDivElement();
		imageContainer.setId(spriteId);
		imageContainer.getStyle().setProperty("position", "absolute");
		image = new Image();
		imageContainer.appendChild(image.getElement());
		position = new Position(this,posX,posY,posZ);
		size = new Size(this,defaultWidth,defaultHeight);
	}
	/**
	 * returns the position object
	 * @return position
	 */
	public Position getPosition()
	{
		return position;
	}
	/**
	 * Adds an image resource to the sprite
	 * @param imageName alias of the image
	 * @param imagePrototype prototype representing the graphic
	 */
	public void addImage(String imageName,ImageResource imagePrototype) 
	{
		imageTemplates.put(imageName, imagePrototype);
	}
	/**
	 * @return the number of images registered in the sprite
	 */
	public int imageCount() 
	{
		return imageTemplates.size();
	}
	/**
	 * draws the default image
	 */
	public void render() 
	{
		String firstImage = imageTemplates.keySet().iterator().next();
		render(firstImage);
	}
	
	public void render(String imageName) 
	{
		//if(!this.isVisible())this.setVisible(true);
		image.setResource(imageTemplates.get(imageName));
	}
	public void notifyMove(double posX, double posY, int posZ) 
	{
		imageContainer.getStyle().setProperty("top", posY+"px");
		imageContainer.getStyle().setProperty("left", posX+"px");
		imageContainer.getStyle().setProperty("zIndex", posZ+"");
	}
	/**
	 * changes the location of the sprite object
	 * @param newX new horizontal position 
	 * @param newY new vertical position
	 */
	public void changeLocation(double newX, double newY) 
	{
		position.ChangeLocation(newX,newY);
	}
	/**
	 * changes the depth of the sprite object
	 * @param newZ new depth level
	 */
	public void changeDepth(int newZ) 
	{
		position.ChangeDepth(newZ);
	}
	public void notifyResize(double width, double height) 
	{
		imageContainer.getStyle().setProperty("width", width+"px");
		imageContainer.getStyle().setProperty("height", height+"px");
	}
	/**
	 * @return the size object
	 */
	public Size getSize() 
	{
		return size;
	}
	/**
	 * resizes the sprite
	 * @param newW new width (in pixels)
	 * @param newH new height (in pixels)
	 */
	public void resize(double newW, double newH) 
	{
		size.resize(newW,newH);	
	}

    @Override
    public DivElement getContainer() {
        return imageContainer;
    }

}
