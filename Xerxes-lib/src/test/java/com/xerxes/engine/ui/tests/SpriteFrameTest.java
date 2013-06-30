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
package com.xerxes.engine.ui.tests;

import com.xerxes.engine.ui.Position;
import com.xerxes.engine.ui.Size;
import com.xerxes.engine.ui.Spriteable;
import com.xerxes.engine.ui.animation.SpriteImageFrame;
import com.xerxes.engine.ui.animation.SpritePositionFrame;
import junit.framework.TestCase;
import org.easymock.EasyMock;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

public class SpriteFrameTest extends TestCase 
{

	private static final String VALID_IMAGE_NAME="ImageName";
	private Position testPosition;
	private Spriteable spriteMock;
	private Size testSize;
	
	@Override
	protected void setUp()throws Exception
	{
		super.setUp();
		spriteMock = EasyMock.createNiceMock(Spriteable.class);
		testPosition = new Position(1,1,1);
		testSize = new Size(10,10);
	}
	@Override
	protected void tearDown()throws Exception
	{
		super.tearDown();
	}
	
	public void testConstructSetsTheImageNameToTheSpecified()
	{
		SpritePositionFrame frame = createTestPositionFrame();
		assertEquals("incorrect image name",VALID_IMAGE_NAME,frame.getCurrentImageName());
	}
	public void testConstructSetsThePositionToTheSpecified()
	{
		SpritePositionFrame frame = createTestPositionFrame();
		assertEquals("incorrect position",testPosition,frame.getCurrentPosition());
	}
	public void testConstructSetsTheSizeToTheExpected()
	{
		SpritePositionFrame frame = createTestPositionFrame();
		assertEquals("incorrect size",testSize,frame.getCurrentSize());
	}
	public void testplayCallsToRenderWithTheCurrentImageName()
	{
        SpriteImageFrame frame = createTestImageFrame();
		spriteMock.render(VALID_IMAGE_NAME);
		replay(spriteMock);
		frame.play(spriteMock);
		verify(spriteMock);
	}
	public void testPlayCallsToChangeLocationWithTheCurrentXAndYInformation()
	{
		SpritePositionFrame frame = createTestPositionFrame();
		spriteMock.changeLocation(testPosition.getX(), testPosition.getY());
		replay(spriteMock);
		frame.play(spriteMock);
		verify(spriteMock);
	}
	public void testPlayCallsToChangeDepthWithTheCurrentZInformation()
	{
		SpritePositionFrame frame = createTestPositionFrame();
		spriteMock.changeDepth(testPosition.getZ());
		replay(spriteMock);
		frame.play(spriteMock);
		verify(spriteMock);
	}
	public void testPlayCallsToResizeWithTheCurrentWidthAndHeight()
	{
		SpriteImageFrame frame = createTestImageFrame();
		spriteMock.resize(testSize.getWidth(), testSize.getHeight());
		replay(spriteMock);
		frame.play(spriteMock);
		verify(spriteMock);
	}
	private SpritePositionFrame createTestPositionFrame()
	{
		return new SpritePositionFrame(VALID_IMAGE_NAME,testPosition,testSize);
	}

    private SpriteImageFrame createTestImageFrame(){
        return new SpriteImageFrame(VALID_IMAGE_NAME,testPosition,testSize);
    }
	
}
