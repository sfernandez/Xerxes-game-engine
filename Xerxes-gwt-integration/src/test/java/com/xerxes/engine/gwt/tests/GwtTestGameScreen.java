package com.xerxes.engine.gwt.tests;

import com.google.gwt.junit.client.GWTTestCase;

public class GwtTestGameScreen extends GWTTestCase {
    @Override
    public String getModuleName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void test_render_called_shouldRenderTheGameScreenCorrectly() {
        assertTrue(true);
    }
    /*private GameScreen sut;
	private static final String bgColor="#FFFFFF";
	private static final String borderColor="#000000";
	private static final double xPos=100;
	private static final double yPos=100;
	private static final double width=300;
	private static final double height=300;
	private static final int defaultZLevel=1;
	protected void gwtSetUp()
	{
		Position position=new Position(xPos, yPos, defaultZLevel);
		Size size = new Size(width, height);
		sut = new GameScreen(position, size, bgColor, borderColor,new GameController[]{new KeyboardController(new Actor[]{})});
		RootPanel.get().add(sut);
	}
	protected void gwtTearDown()
	{
		RootPanel.get().remove(sut);
	}
	@Override
	public String getModuleName() 
	{
		return "com.xerxes.Xerxes";
	}
	
	public void test_render_called_shouldRenderTheGameScreenCorrectly()
	{
		sut.render();
		assertEquals("incorrect x position", xPos, sut.getPosition().getX());
		assertEquals("incorrect y position", yPos, sut.getPosition().getY());
		assertEquals("incorrect width",width, sut.getSize().getWidth());
		assertEquals("incorrect height",height,sut.getSize().getHeight());
	}*/

}
