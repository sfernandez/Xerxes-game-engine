package com.xerxes.engine.game;

import com.google.gwt.user.client.Timer;

import java.util.ArrayList;
import java.util.List;

public class GameTimer {

    private static final int DEFAULT_PERIOD_LIMIT = 100;

    private Timer timer;

    private static GameTimer instance;

    private int periodLimit;

    private List<TimerActorEvent> repeatingActorEvents;

    private List<TimerActorEvent> oneTimeActorEvents;

    private GameTimer() {
        repeatingActorEvents = new ArrayList<TimerActorEvent>();
        oneTimeActorEvents = new ArrayList<TimerActorEvent>();
        periodLimit = DEFAULT_PERIOD_LIMIT;
        timer = new Timer() {
            @Override
            public void run() {
                CollisionRegister.getInstance().check();
                for (TimerActorEvent actorEvent : repeatingActorEvents) {
                    actorEvent.doAction();
                }
                for (TimerActorEvent actorEvent : oneTimeActorEvents){
                    actorEvent.doAction();
                    oneTimeActorEvents.remove(actorEvent);
                }
            }
        };
    }

    public void addOneTimeActorEvent(TimerActorEvent event){
        oneTimeActorEvents.add(event);
    }

    public void addRepeatingActorEvent(TimerActorEvent event) {
        repeatingActorEvents.add(event);
    }

    public void setPeriodLimit(int periodLimit) {
        this.periodLimit = periodLimit;
    }

    public void start() {
        timer.scheduleRepeating(periodLimit);
    }

    public void stop() {
        timer.cancel();
    }

    public static GameTimer getInstance() {
        if (instance == null) instance = new GameTimer();
        return instance;
    }
}
