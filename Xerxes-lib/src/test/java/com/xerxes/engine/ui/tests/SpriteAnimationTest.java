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

import com.xerxes.engine.ui.animation.SpritePositionFrame;
import junit.framework.TestCase;

import org.easymock.EasyMock;
import com.xerxes.engine.ui.Position;
import com.xerxes.engine.ui.Size;
import com.xerxes.engine.ui.Spriteable;
import com.xerxes.engine.ui.animation.SpriteAnimation;
import com.google.gwt.junit.GWTMockUtilities;
/**
 * 
 * @author Sergi Fernández Cristià ||*||
 *
 */
public class SpriteAnimationTest extends TestCase
{
	private String animationName;
	private SpriteAnimation testAnimation;
	private Position testPosition;
	private Size testSize;
	
	@Override
	protected void setUp()throws Exception
	{
		super.setUp();
		GWTMockUtilities.disarm();
		EasyMock.createMock(Spriteable.class);
		testPosition = new Position(1,1,1);
		animationName="testAnimation";
		testAnimation = new SpriteAnimation(animationName);
	}
	@Override
	protected void tearDown()throws Exception
	{ 
		super.tearDown();
		testAnimation.clear();
		GWTMockUtilities.restore();
	}
	
	public void testCreateAnAnimationWithValidNameSetsTheNamePropertyToTheExected()
	{
		assertEquals("incorrect animation name",animationName,testAnimation.getName());
	}
	public void testAnAnimationByDefaultHas25fps(){
		assertEquals("incorrect fps",SpriteAnimation.getCurrentFps(),25);
	}
	public void testSetFpsSetTheFpsToTheExpected(){
		int newFps= 32;
		SpriteAnimation.setFps(32);
		int actualFps = SpriteAnimation.getCurrentFps();
		SpriteAnimation.setFps(25);
		assertEquals("incorrect fps",actualFps,newFps);
	}
	public void testAddFrameAddsAFrameToTheCollection()
	{
		testAnimation.addFrame(createFrame("frame1"));
		int expectedNumberOfFrames=1;
		assertEquals("incorrect number of frames",expectedNumberOfFrames,testAnimation.getNumberOfFrames());
	}
	public void testAddFrameInAConcretePositionFillsBlankPositions()
	{
		testAnimation.addFrame(createFrame("frame1"));
		testAnimation.addFrame(createFrame("frame5"),5);
		int expectedNumberOfFrames=7;
		assertEquals("incorrect number of frames",expectedNumberOfFrames,testAnimation.getNumberOfFrames());
	}
	public void testAddFrameInAConcretePositionFillsBlanksPositionsWithTheLastFrame()
	{
		SpritePositionFrame firstFrame = createFrame("frame1");
		SpritePositionFrame newFrame = createFrame("frame5");
		testAnimation.addFrame(firstFrame);
		testAnimation.addFrame(newFrame,4,10);
		SpritePositionFrame retrievedFrame = (SpritePositionFrame)testAnimation.getFrame(3);
		assertEquals("incorrect frame assigned",firstFrame,retrievedFrame);
	}
	public void testgetDurationWhenFpsIsSetTo25AndAnimationHas25FramesReturns1000(){
		SpritePositionFrame firstFrame = createFrame("frame1");
		SpritePositionFrame lastFrame = createFrame("frame25");
		testAnimation.addFrame(firstFrame);
		testAnimation.addFrame(lastFrame,25);
		int expectedDuration = 1080;
		int actualDuration = testAnimation.getDuration();
		assertEquals("incorrect duration",expectedDuration,actualDuration);
	}
	public void testgetDurationWhenFpsIsSetTo25AndAnimationHas12FramesReturns480(){
		SpritePositionFrame firstFrame = createFrame("frame1");
		SpritePositionFrame lastFrame = createFrame("frame12");
		testAnimation.addFrame(firstFrame);
		testAnimation.addFrame(lastFrame,12);
		int expectedDuration = 560;
		int actualDuration = testAnimation.getDuration();
		assertEquals("incorrect duration",expectedDuration,actualDuration);
	}
	
	
	private SpritePositionFrame createFrame(String frameName)
	{
		return new SpritePositionFrame(frameName,testPosition,testSize);
	}
}
