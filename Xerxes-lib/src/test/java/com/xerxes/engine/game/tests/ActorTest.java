package com.xerxes.engine.game.tests;

import com.xerxes.engine.game.Actor;
import com.xerxes.engine.ui.Spriteable;
import com.xerxes.engine.ui.animation.Animatable;
import junit.framework.TestCase;

import static org.mockito.Mockito.*;

public class ActorTest extends TestCase {
    private static final String SECOND_ANIMATION_NAME = "second animation";
    private static final String FIRST_ANIMATION_NAME = "first animation";
    private Spriteable spriteDummy;
    private Animatable animationDummy;
    private Animatable anotherAnimationDummy;
    private Actor sut;

    @Override
    protected void setUp() throws Exception {
        spriteDummy = mock(Spriteable.class);
        animationDummy = mock(Animatable.class);
        anotherAnimationDummy = mock(Animatable.class);
        when(animationDummy.getName()).thenReturn(FIRST_ANIMATION_NAME);
        when(anotherAnimationDummy.getName()).thenReturn(SECOND_ANIMATION_NAME);
        sut = new Actor(spriteDummy, new Animatable[]{animationDummy, anotherAnimationDummy});
    }

    public void testRender_shouldCall_toSpriteRender() {
        sut.render();
        verify(spriteDummy, times(1)).render();
    }

    public void testRender_withAnImageName_shouldCall_toSpriteRender_withTheImageName() {
        String validImageName = "a valid image name";
        sut.render(validImageName);
        verify(spriteDummy, times(1)).render(validImageName);
    }

    public void testPlay_TheFirstAnimationShouldCallPlayTheFirstAnimation() {
        sut.play(FIRST_ANIMATION_NAME);
        verify(animationDummy, times(1)).play(spriteDummy);
    }

    public void testPlay_TheSecondAnimationShouldCallPlayTheSecondAnimation() {
        sut.play(SECOND_ANIMATION_NAME);
        verify(anotherAnimationDummy, times(1)).play(spriteDummy);
    }

    /*public void testExecuteAction_shouldExecuteANamedAction() {
        ActorAction actionDummy = mock(ActorAction.class);
        String actionName = "an action";
        sut.addAction(actionName, actionDummy);
        sut.executeAction(actionName);
        verify(actionDummy, times(1)).doAction(sut);
    }*/

}
