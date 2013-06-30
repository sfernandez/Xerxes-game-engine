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
package com.xerxes.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.xerxes.client.ui.tests.utilites.ImageBundleExample;
import com.xerxes.client.ui.tests.utilites.TestSpriteAnimation;
import com.xerxes.engine.game.GameController;
import com.xerxes.engine.game.KeyboardController;
import com.xerxes.engine.ui.GameScreen;
import com.xerxes.engine.ui.Position;
import com.xerxes.engine.ui.Size;
import com.xerxes.engine.ui.Sprite;
import com.xerxes.engine.ui.animation.Animatable;
import com.xerxes.engine.ui.animation.SpriteAnimation;
import com.xerxes.engine.ui.animation.SpritePositionFrame;

public class Xerxes implements EntryPoint 
{

	public void onModuleLoad() 
	{
		Button createSprite = new Button();
		Button createAnimation = new Button();
		Button createInterpolationAnimation = new Button();
		Button createReverseInterpolationAnimation=new Button();
		Button createGameScreen = new Button();
		createSprite.setText("Create Basic Sprite");
		createAnimation.setText("Create Basic Sprite Animation");
		createInterpolationAnimation.setText("Create Interpolation Animation");
		createReverseInterpolationAnimation.setText("Create Reverse Interpolation Animation");

		createAnimation.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) {
				createAndPlaySimpleAnimation();
				
			}

			
		});
		createSprite.addClickHandler(new ClickHandler(){
			public void onClick(ClickEvent event) 
			{
				createAndRenderSimpleSprite();
			}
		});
		createInterpolationAnimation.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) 
			{
				createAndRenderInterpolationAnimation();		
			}
		});
		createReverseInterpolationAnimation.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				createAnRenderReverseInterpolationAnimation();
				
			}
		});
		
		
		RootPanel.get().add(createSprite);
		RootPanel.get().add(createAnimation);
		RootPanel.get().add(createInterpolationAnimation);
		RootPanel.get().add(createReverseInterpolationAnimation);
		RootPanel.get().add(createGameScreen);
	}
	private void createAndRenderInterpolationAnimation()
	{
		Sprite testSprite = createTestSprite();
		Animatable testAnim = new SpriteAnimation("testAnim");
		testAnim.addFrame(new SpritePositionFrame("compass", new Position(50,50,50), testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("compass", new Position(100, 100, 10), testSprite.getSize()), 12, 24);
		testAnim.play(testSprite);
	}
	private void createAnRenderReverseInterpolationAnimation()
	{
		Sprite testSprite = createTestSprite();
		Animatable testAnim = new SpriteAnimation("testAnim");
		testAnim.addFrame(new SpritePositionFrame("compass", new Position(100, 100, 10), testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("compass", new Position(50, 50, 50), testSprite.getSize()), 12, 24);
		testAnim.play(testSprite);
	}
	private void createAndRenderSimpleSprite()
	{
		Sprite testSprite = createTestSprite();
		testSprite.render("compass");
	}
	private Sprite createTestSprite()
	{
		Sprite testSprite = new Sprite("test");
        createAndAddSprite(testSprite);
		ImageBundleExample testBundle = GWT.create(ImageBundleExample.class);
		testSprite.addImage("compass",testBundle.CompassIcon());
		return testSprite;
	}
	private void createAndPlaySimpleAnimation() {
		SpriteAnimation.setFps(12);
		Sprite testSprite = new Sprite("AnimationTest");
		TestSpriteAnimation animBundle = GWT.create(TestSpriteAnimation.class);
		testSprite.addImage("NW1",animBundle.NW1());
		testSprite.addImage("NW2",animBundle.NW2());
		testSprite.addImage("NW3",animBundle.NW3());
		testSprite.addImage("NW4",animBundle.NW4());
		testSprite.addImage("NW5",animBundle.NW5());
		testSprite.addImage("NW6",animBundle.NW6());
		testSprite.addImage("NW7",animBundle.NW7());
		testSprite.addImage("NW8",animBundle.NW8());
		testSprite.addImage("NW9",animBundle.NW9());
		testSprite.addImage("NW10",animBundle.NW10());
		testSprite.addImage("NW11",animBundle.NW11());
		testSprite.addImage("NW12",animBundle.NW12());
		testSprite.addImage("NW13",animBundle.NW13());
        createAndAddSprite(testSprite);
		Animatable testAnim = new SpriteAnimation("testAnim");
		testAnim.addFrame(new SpritePositionFrame("NW1",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW2",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW3",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW4",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW5",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW6",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW7",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW8",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW9",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW10",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW11",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW12",testSprite.getPosition(),testSprite.getSize()));
		testAnim.addFrame(new SpritePositionFrame("NW13",testSprite.getPosition(),testSprite.getSize()));
		testAnim.play(testSprite);
	}
	private GameScreen createAGameScreen()
	{
		GameScreen gs = new GameScreen(new Position(100,100,1),new Size(300,300),new GameController[]{new KeyboardController()});
		gs.render();
		RootPanel.get().add(gs);
        return gs;
	}

    private void createAndAddSprite(Sprite sprite){
        GameScreen gs=createAGameScreen();
        gs.addSprite(sprite);
    }


}
