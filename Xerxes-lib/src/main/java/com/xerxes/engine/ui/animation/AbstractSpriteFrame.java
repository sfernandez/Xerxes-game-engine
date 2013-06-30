package com.xerxes.engine.ui.animation;


import com.xerxes.engine.ui.Position;
import com.xerxes.engine.ui.Size;

public abstract class AbstractSpriteFrame implements Playable {

    protected String currentImageName;
    protected Size currentSize;
    protected Position currentPosition;

    protected AbstractSpriteFrame(String imageName, Position position,Size size)
    {
        currentImageName= imageName;
        currentPosition = position;
        currentSize = size;
    }

    public String getCurrentImageName()
    {
        return currentImageName;
    }

    public Size getCurrentSize()
    {
        return currentSize;
    }

    public Position getCurrentPosition()
    {
        return currentPosition;
    }

    @Override
    public boolean equals(Object frame)
    {
        if(!(frame instanceof AbstractSpriteFrame))return false;
        AbstractSpriteFrame frameToCompare=(AbstractSpriteFrame)frame;
        if(currentImageName!=frameToCompare.currentImageName)return false;
        return true;
    }
    @Override
    public int hashCode()
    {
        return currentImageName.hashCode();
    }
}
