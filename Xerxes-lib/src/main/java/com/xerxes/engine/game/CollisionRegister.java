package com.xerxes.engine.game;

import java.util.ArrayList;
import java.util.List;
import com.google.gwt.user.client.Timer;

public class CollisionRegister
{
    private static int DEFAULT_CHECK_COLLISION_TIME = 100;
    private static CollisionRegister instance;
    private List<Collision> collisions;
    private int checkCollisionTime;
    private Timer timer;

    private CollisionRegister()
    {
        collisions = new ArrayList<Collision>();
        checkCollisionTime = DEFAULT_CHECK_COLLISION_TIME;
        timer = new Timer(){
            @Override
            public void run()
            {
                for(Collision collision : collisions){
                    collision.isCollisionOccurred();
                }
            }
        };
    }

    public void start()
    {
        timer.scheduleRepeating(checkCollisionTime);
    }

    public void stop()
    {
        timer.cancel();
    }

    public void registerCollision(Actor firstActor, Actor secondActor)
    {
        collisions.add(new Collision(firstActor, secondActor));
    }

    public static CollisionRegister getInstance()
    {
        if(instance == null) instance = new CollisionRegister();
        return instance;
    }
}