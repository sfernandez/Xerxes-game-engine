package com.xerxes.engine.game;

import com.google.gwt.user.client.Timer;

public class GameTimer {

    private static final int DEFAULT_PERIOD_LIMIT = 100;

    private Timer timer;

    private static GameTimer instance;

    private int periodLimit;

    private GameTimer() {
        periodLimit = DEFAULT_PERIOD_LIMIT;
        timer = new Timer() {
            @Override
            public void run() {
                CollisionRegister.getInstance().check();
            }
        };
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
