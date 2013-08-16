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
package com.xerxes.engine.physics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.xerxes.engine.ui.Position;

public class CollisionModel 
{
	private double minX;
	private double maxX;
	private double minY;
	private double maxY;
	
	public CollisionModel(Position[] points)
	{
		List<Double> horizontalPosList = new ArrayList<Double>();
		List<Double> verticalPosList = new ArrayList<Double>();
		for(Position pos:points)
		{
			horizontalPosList.add(pos.getX());
			verticalPosList.add(pos.getY());
		}
		Collections.sort(horizontalPosList);
		Collections.sort(verticalPosList);
		minX=horizontalPosList.get(0);
		maxX=horizontalPosList.get(horizontalPosList.size()-1);
		minY=verticalPosList.get(0);
		maxY=verticalPosList.get(verticalPosList.size()-1);
	}

    public boolean collidesWith(CollisionModel collisionModel)
    {
        boolean minXCollision = collidesWithHorizontalAxis(collisionModel.minX);
        boolean maxXCollision = collidesWithHorizontalAxis(collisionModel.maxX);
        boolean minYCollision = collidesWithVerticalAxis(collisionModel.minY);
        boolean maxYCollision = collidesWithVerticalAxis(collisionModel.maxY);
        if((minXCollision || maxXCollision) && (minYCollision || maxYCollision)) return true;
        return false;
    }

    private boolean collidesWithHorizontalAxis(double horizontalPosition)
    {
        return collidesWithPoint(horizontalPosition, minX, maxX);
    }

    private boolean collidesWithVerticalAxis(double verticalPosition)
    {
        return collidesWithPoint(verticalPosition, minY, maxY);
    }

    private boolean collidesWithPoint(double outerPos, double minPos, double maxPos)
    {
        if(outerPos >= minPos && outerPos <= maxPos) return true;
        return false;
    }
}
