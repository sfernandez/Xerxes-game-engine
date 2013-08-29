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

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.resources.client.ImageResource;

public interface Spriteable extends Movable, Resizeable {
    public Position getPosition();

    public void addImage(String imageName, ImageResource imagePrototype);

    public void render(String imageName);

    public void render();

    public void changeLocation(double newX, double newY);

    public void changeDepth(int newZ);

    public Size getSize();

    public void resize(double d, double e);

    public DivElement getContainer();
}
