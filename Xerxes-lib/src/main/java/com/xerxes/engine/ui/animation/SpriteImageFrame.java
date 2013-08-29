package com.xerxes.engine.ui.animation;

import com.xerxes.engine.ui.Position;
import com.xerxes.engine.ui.Size;
import com.xerxes.engine.ui.Spriteable;


public class SpriteImageFrame extends AbstractSpriteFrame {

    public SpriteImageFrame(String imageName) {
        this(imageName, null, null);
    }

    public SpriteImageFrame(String imageName, Position position, Size size) {
        super(imageName, position, size);
    }


    @Override
    public void play(Spriteable sprite) {
        sprite.render(currentImageName);
        if (currentSize != null) sprite.resize(currentSize.getWidth(), currentSize.getHeight());
    }

}
