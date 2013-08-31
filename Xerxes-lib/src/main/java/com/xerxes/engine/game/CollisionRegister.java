package com.xerxes.engine.game;

import java.util.ArrayList;
import java.util.List;

public class CollisionRegister {

    private static CollisionRegister instance;
    private List<Collision> collisions;

    private CollisionRegister() {
        collisions = new ArrayList<Collision>();
    }

    public void check() {
        for (Collision collision : collisions) {
            collision.check();
        }
    }

    public void registerCollision(Actor firstActor, Actor secondActor, CollisionAction action) {
        collisions.add(new Collision(firstActor, secondActor, action));
    }

    public static CollisionRegister getInstance() {
        if (instance == null) instance = new CollisionRegister();
        return instance;
    }
}
