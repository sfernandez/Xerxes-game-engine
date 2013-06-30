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
package com.xerxes.engine.math;

import com.xerxes.engine.ui.Position;

public class LineSegment {

	private Position initialPosition;
	private Position finalPosition;
	private Pendent pendent;
	private static final double epsilon = 0.000001;
	public LineSegment(Position initialPosition, Position finalPosition) 
	{
		this.initialPosition = initialPosition;
		this.finalPosition = finalPosition;
		pendent = new Pendent();
	}
	public Position getInitialPosition()
	{
		return initialPosition;
	}
	public Position getFinalPosition()
	{
		return finalPosition;
	}
	public Position getPosition(double increment) 
	{
		if(increment<initialPosition.getX())increment=initialPosition.getX()+increment;
		double yIncognita;
		double xIncognita;
		double yKnow = finalPosition.getY();
		double m = pendent.getPendent();
		double horizontalCalc = m*(increment-finalPosition.getX());
		yIncognita = horizontalCalc+yKnow;
		xIncognita = increment;
		return new Position((int)xIncognita,(int)yIncognita,0);
	}
	public class Pendent
	{
		public double getPendent()
		{
			double calcY = finalPosition.getY()-initialPosition.getY();
			double calcX = finalPosition.getX()-initialPosition.getX();
			if(calcY<epsilon)calcY=epsilon;
			if(calcX<epsilon)calcX=epsilon;
			return calcY/calcX;
		}
	}
	public Pendent getPendent()
	{
		return pendent;
	}
	public double getLineEq() 
	{
		double pendent = getPendent().getPendent();
		double lineEq = initialPosition.getY() - (pendent*initialPosition.getX());
		return Math.abs(lineEq);
	}

}
