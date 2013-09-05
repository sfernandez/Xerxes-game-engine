package com.xerxes.engine.game;

import com.xerxes.engine.ui.GameScreen;

import java.util.ArrayList;
import java.util.List;

public class CollisionRegister {

    private static CollisionRegister instance;
    private List<ICollision> collisions;

    private CollisionRegister() {
        collisions = new ArrayList<ICollision>();
    }

    public void check() {
        for (ICollision collision : collisions) {
            collision.check();
        }
    }

    public void registerCollision(Actor firstActor, Actor secondActor, CollisionAction action) {
        collisions.add(new Collision(firstActor, secondActor, action));
    }

    public void registerCollisionWithGameScreen(Actor actor, GameScreen screen, GameScreenCollisionAction action)
    {
        collisions.add(new GameScreenCollision(actor, screen, action));
    }

    public static CollisionRegister getInstance() {
        if (instance == null) instance = new CollisionRegister();
        return instance;
    }
}
