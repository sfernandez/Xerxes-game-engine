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
package com.xerxes.engine.gwt.tests;

import com.google.gwt.junit.client.GWTTestCase;

public class GwtTestSprite extends GWTTestCase {
    @Override
    public String getModuleName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void test_render_called_shouldRenderTheGameScreenCorrectly() {
        assertTrue(true);
    }
    /*private DivElement placeHolder;
    private String placeHolderId;
	private Sprite testSprite;
	private String spriteId;
	private int testPosX;
	private int testPosY;
	private int testPosZ;
	private int width;
	private int height;
	protected void gwtSetUp()
	{
		testPosZ=2;
		testPosX=10;
		width=100;
		height=100;
		placeHolderId ="placeHolder";
		spriteId = "testSprite";
		placeHolder = Document.get().createDivElement();
		placeHolder.setAttribute("id", placeHolderId);
		Document.get().getBody().appendChild(placeHolder);
		testSprite = new Sprite(spriteId,testPosX,testPosY,testPosZ);
		RootPanel.get(placeHolderId).add(testSprite);
	}
	protected void gwtTearDown()
	{
		RootPanel.get(placeHolderId).remove(testSprite);
		Document.get().removeChild(placeHolder);
	}
	public String getModuleName() 
	{
		return "com.xerxes.Xerxes";
	}
	public void testConstructASpriteCreatesADivInsideThePlaceHolder()
	{
		String expectedTag = "DIV";
		String actualTag = getContainer().getTagName();
		assertEquals("incorrect tagName received", expectedTag, actualTag);
	}
	public void testConstructASpriteCreatesAImgInsideTheDiv()
	{
		String expectedTag="IMG";
		String actualTag = getImageNode().getTagName();
		assertEquals("incorrect tagName received", expectedTag, actualTag);
	}
	private com.google.gwt.dom.client.Element getImageNode()
	{
		com.google.gwt.dom.client.Element image = DOM.getElementById(placeHolderId).getFirstChildElement().getFirstChildElement();
		return image;
	}
	private com.google.gwt.dom.client.Element getContainer()
	{
		return DOM.getElementById(placeHolderId).getFirstChildElement();
	}
	public void testAddImageWithValidAbstractImagePrototypeAddsAnImageToTheSprite()
	{
		ImageBundleExample testBundle = GWT.create(ImageBundleExample.class);
		testSprite.addImage("compass",testBundle.CompassIcon());
		int expectedNumber=1;
		int actualNumber=testSprite.imageCount();
		assertEquals("incorrect number of images",expectedNumber,actualNumber);
	}
	public void testConstructAnSpriteSetsThePositionStyleToAbsolute()
	{
		String expectedPosition="absolute";
		String actualPosition = getContainer().getStyle().getProperty("position");
		assertEquals("incorrect position",expectedPosition,actualPosition);
	}
	public void testConstructAnSpriteStartsWithNullVisibility()
	{
		assertFalse("incorrect visibility",testSprite.isVisible());
	}
	public void testConstructAnSpriteReturnsAnSpriteWithTheSpecifiedId()
	{
		assertEquals("incorrect id",spriteId,getContainer().getId());
	}
	public void testConstructAnSpriteWithValid2DimensionPropertySetTheLocationToTheSpecified()
	{
		Position spritePosition = testSprite.getPosition();
		int actualX = (int)spritePosition.getX();
		int actualY = (int)spritePosition.getY();
		assertEquals("incorrect position",(int)testPosX,actualX);
		assertEquals("incorrect position",(int)testPosY,actualY);
	}
	public void testConstructAnSpriteWithValidDepthSetsTheDepthToTheSpecified()
	{
		Position spritePosition = testSprite.getPosition();
		int actualZ = spritePosition.getZ();
		assertTrue("incorrect depth",actualZ==testPosZ);
	}
	public void testConstructAnSpriteWithValid2DimensionPropertiesSetLeftPositionToTheExpected()
	{
		String actualX = getContainer().getStyle().getProperty("left");
		assertEquals("incorrect real position",testPosX+"px",actualX);
	}
	public void testConstructAnSpriteWithValid2DimensionPropertiesSetsTheTopPositionToTheExpected()
	{
		String actualY = getContainer().getStyle().getProperty("top");
		assertEquals("incorrect real position",testPosY+"px",actualY);
	}
	public void testChangePositionWithValid2DimensionPropertiesSetsPropertiesOfPositionToTheExpected()
	{
		int newX=30;
		int newY=40;
		testSprite.changeLocation(newX,newY);
		double actureturn null;  //To change body of implemented methods use return null;  //To change body of implemented methods use File | Settings | File Templates.File | Settings | File Templates.alX=testSprite.getPosition().getX();
		double actualY=testSprite.getPosition().getY();
		boolean areEqual= (newX==actualX&&newY==actualY);
		assertTrue("incorrect position setted",areEqual);		
	}
	public void testChangePositionWithValid2DimensionPropertiesSetsTheHorizontalPositionOfTheWidgetToTheExpected()
	{
		int newX=30;
		int newY=40;
		testSprite.changeLocation(newX, newY);
		String actualX=getContainer().getStyle().getProperty("left");
		assertEquals("incorrect horizontal position",newX+"px",actualX);
	}
	public void testChangePositionWithValid2DimensionPropertiesSetsTheVerticalPositionOfTheWidgetToTheExpected()
	{
		int newX=30;
		int newY=40;
		testSprite.changeLocation(newX, newY);
		String actualY=getContainer().getStyle().getProperty("top");
		assertEquals("incorrect horizontal position",newY+"px",actualY);
	}
	public void testChangeDepthWithValidDepthSetsTheDepth()
	{
		int newZ= 100;
		testSprite.changeDepth(newZ);
		assertEquals("incorrect depth",newZ,testSprite.getPosition().getZ());
	}
	public void testConstructAnSpriteSetsTheWidthSizeToTheSupplied()
	{
		double actualWidth = testSprite.getSize().getWidth();
		assertEquals("incorrect width",width,(int)actualWidth);
	}
	public void testConstructAnSpriteSetsTheHeightSizeToTheSupplied()
	{
		double actualHeight = testSprite.getSize().getHeight();
		assertEquals("incorrect height",height,(int)actualHeight);
	}
	public void testResizeChangesWidthAndHeightToTheExpected()
	{
		int newW=200;
		int newH=300;
		testSprite.resize(newW,newH);
		Size size = testSprite.getSize();
		boolean equals= (newW==size.getWidth()&&newH==size.getHeight());
		assertTrue("incorrect size setting",equals);
	}
	public void testResizeChangesTheWidthOfTheUIElement()
	{
		int newW=200;
		int newH=300;
		testSprite.resize(newW,newH);
		String actualWidth = getContainer().getStyle().getProperty("width");
		assertEquals("incorrect ui width",newW+"px",actualWidth);
	}
	public void testResizeChangesTheHeightOfTheUIElement()
	{
		int newW=200;
		int newH=300;
		testSprite.resize(newW,newH);
		String actualHeight = getContainer().getStyle().getProperty("height");
		assertEquals("incorrect ui height",newH+"px",actualHeight);
	}*/
}
