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

import com.google.gwt.animation.client.Animation;
import com.xerxes.engine.math.LineSegment;
import com.xerxes.engine.ui.Position;
import com.xerxes.engine.ui.Spriteable;

import java.util.ArrayList;
import java.util.List;

/**
 * represents an animation of an sprite object
 *
 * @author Sergi Fernández Cristià ||*||
 */
public class SpriteAnimation extends Animation implements Animatable {
    private static int fps = 25;
    private String name;
    private List<AbstractSpriteFrame> frames;
    private Spriteable currentSprite;
    private boolean shouldRepeat;

    public SpriteAnimation(String animationName) {
        this(animationName, false);
    }

    public SpriteAnimation(String animationName, boolean shouldRepeat) {
        this.shouldRepeat = shouldRepeat;
        initFramesCollection();
        name = animationName;
    }

    protected void onUpdate(double progress) {
        double actualFrames = (double) this.getNumberOfFrames();
        double actualFrame = progress * actualFrames;
        int frameNumber = (int) actualFrame;
        if (frameNumber <= frames.size() - 1) frames.get(frameNumber).play(currentSprite);
    }

    private void initFramesCollection() {
        frames = new ArrayList<AbstractSpriteFrame>();
    }

    /* (non-Javadoc)
     * @see com.xerxes.client.ui.animation.Animatable#getName()
     */
    public String getName() {
        return name;
    }

    /* (non-Javadoc)
     * @see com.xerxes.client.ui.animation.Animatable#clear()
     */
    public void clear() {
        initFramesCollection();
    }

    /* (non-Javadoc)
     * @see com.xerxes.client.ui.animation.Animatable#addFrame(com.xerxes.client.ui.animation.SpriteFrame)
     */
    public void addFrame(AbstractSpriteFrame frame) {
        frames.add(frame);
    }

    /* (non-Javadoc)
     * @see com.xerxes.client.ui.animation.Animatable#addFrame(com.xerxes.client.ui.animation.SpriteFrame, int, int)
     */
    public void addFrame(AbstractSpriteFrame frame, int startFrame, int frameNumber) {
        int currentNumberOfFrames = this.getNumberOfFrames();
        if (startFrame > currentNumberOfFrames) iterateAndInterpolateFrames(frame, currentNumberOfFrames, startFrame);
        this.addFrame(frame);
        int endFrameNumber = this.getNumberOfFrames() + frameNumber;
        for (int counter = startFrame; counter < endFrameNumber - 1; counter++) {
            addNewFrameBasedOnPreviousOne(counter, frame.getCurrentPosition());
        }
    }

    private void iterateAndInterpolateFrames(AbstractSpriteFrame frame, int startFrame, int endFrame) {
        int lastFrameNumber = startFrame - 1;
        AbstractSpriteFrame initFrame = frames.get(lastFrameNumber);
        Position startPosition = initFrame.getCurrentPosition();
        Position endPosition = frame.getCurrentPosition();
        LineSegment segment = new LineSegment(startPosition, endPosition);
        double interpolationPosition = 0;
        double numberOfFrames = (double) Math.abs(startFrame - endFrame);
        double incrementPosition = Math.abs(endPosition.getX() - startPosition.getX()) / numberOfFrames;
        if (endPosition.getX() < startPosition.getX()) incrementPosition = incrementPosition * -1;
        for (int counter = lastFrameNumber; counter < endFrame - 1; counter++) {
            Position interpolatedPosition = segment.getPosition(interpolationPosition);
            addNewFrameBasedOnPreviousOne(counter, interpolatedPosition);
            interpolationPosition += incrementPosition;
        }
    }

    private void addNewFrameBasedOnPreviousOne(int counter, Position interpolatedPosition) {
        AbstractSpriteFrame current = frames.get(counter);
        AbstractSpriteFrame newFrame = constructNewFrame(current, interpolatedPosition);
        this.addFrame(newFrame);
    }

    private AbstractSpriteFrame constructNewFrame(AbstractSpriteFrame current, Position interpolatedPosition) {
        if (current instanceof SpriteImageFrame)
            return new SpriteImageFrame(current.getCurrentImageName(), interpolatedPosition, current.getCurrentSize());
        return new SpritePositionFrame(current.getCurrentImageName(), interpolatedPosition, current.getCurrentSize());
    }

    /* (non-Javadoc)
     * @see com.xerxes.client.ui.animation.Animatable#addFrame(com.xerxes.client.ui.animation.SpriteFrame, int)
     */
    public void addFrame(AbstractSpriteFrame frame, int frameNumber) {
        addFrame(frame, this.getNumberOfFrames(), frameNumber);
    }

    public int getNumberOfFrames() {
        return frames.size();
    }

    public AbstractSpriteFrame getFrame(int numberOfFrame) {
        return frames.get(numberOfFrame);
    }

    public static int getCurrentFps() {
        return fps;
    }

    public static void setFps(int newFps) {
        fps = newFps;
    }

    /* (non-Javadoc)
     * @see com.xerxes.client.ui.animation.Animatable#play(com.xerxes.client.ui.Spriteable)
     */
    public void play(Spriteable sprite) {
        currentSprite = sprite;
        run(getDuration());
    }


    protected void onComplete() {
        super.onComplete();
        frames.get(0).play(currentSprite);
        if (shouldRepeat) {
            play(currentSprite);
        }
    }

    public int getDuration() {
        double numberOfFrames = getNumberOfFrames();
        double numberOfFramesPerSecond = fps;
        double result = numberOfFrames / numberOfFramesPerSecond;
        result *= 1000;
        return (int) result;
    }

}
