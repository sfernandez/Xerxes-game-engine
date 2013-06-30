package com.xerxes.engine.ui.animation;

public interface Animatable extends Playable{

	public abstract String getName();

	void clear();

	void addFrame(AbstractSpriteFrame frame);

	void addFrame(AbstractSpriteFrame frame, int startFrame, int frameNumber);

	void addFrame(AbstractSpriteFrame frame, int frameNumber);

}