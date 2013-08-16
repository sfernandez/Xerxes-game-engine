package com.xerxes.engine.game;

public class Collision
{
    private Actor firstActor;
    private Actor secondActor;

    public Collision(Actor firstActor, Actor secondActor)
    {
        this.firstActor = firstActor;
        this.secondActor = secondActor;
    }

    public boolean isCollisionOccurred()
    {
        return firstActor.getCollisionModel().collidesWith(secondActor.getCollisionModel());
    }
}