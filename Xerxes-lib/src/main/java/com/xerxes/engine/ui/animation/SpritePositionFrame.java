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
package com.xerxes.engine.ui.animation;

import com.xerxes.engine.ui.Position;
import com.xerxes.engine.ui.Size;
import com.xerxes.engine.ui.Spriteable;

/**
 * represents a single frame inside the spriteAnimation
 * @author Sergi Fernández Cristià ||*||
 *
 */
public class SpritePositionFrame extends AbstractSpriteFrame
{
    public SpritePositionFrame(String imageName, Position position, Size size) {
        super(imageName, position, size);
    }

    public void play(Spriteable sprite)
	{
		sprite.changeLocation(currentPosition.getX(), currentPosition.getY());
		sprite.changeDepth(currentPosition.getZ());
	}
}
