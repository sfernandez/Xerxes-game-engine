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
 * represents a position inside the xerxes framework
 *
 * @author Sergi Fernández Cristià ||*||
 */
public class Position {
    private double xPos;
    private double yPos;
    private int zPos;
    private Movable notifier;
    private static final double epsilon = 0.000001;

    /**
     * @param registeredObject object to notify change of position and depth
     * @param posX             horizontal position in pixels
     * @param posY             vertical position in pixels
     * @param posZ             depth level
     */
    public Position(Movable registeredObject, double posX, double posY, int posZ) {
        this(posX, posY, posZ);
        notifier = registeredObject;
        notifier.notifyMove(posX, posY, posZ);
    }

    public Position(double posX, double posY, int posZ) {
        if (posX < epsilon) posX = epsilon;
        if (posY < epsilon) posY = epsilon;
        xPos = posX;
        yPos = posY;
        zPos = posZ;
    }

    /**
     * @return the horizontal position in pixels
     */
    public double getX() {
        return xPos;
    }

    /**
     * @return the vertical position in pixels
     */
    public double getY() {
        return yPos;
    }

    /**
     * @return the depth level
     */
    public int getZ() {
        return zPos;
    }

    /**
     * Changes the location of the position
     *
     * @param newX horizontal position
     * @param newY vertical position
     */
    public void ChangeLocation(double newX, double newY) {
        xPos = newX;
        yPos = newY;
        if (notifier != null) notifier.notifyMove(xPos, yPos, zPos);
    }

    /**
     * Changes the depth of the sprite object
     *
     * @param newZ the depth level
     */
    public void ChangeDepth(int newZ) {
        zPos = newZ;
        if (notifier != null) notifier.notifyMove(xPos, yPos, zPos);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position)) return false;
        Position object = (Position) o;
        if (object.getX() != this.getX()) return false;
        if (object.getY() != this.getY()) return false;
        if (object.getZ() != this.getZ()) return false;
        return true;
    }
}
