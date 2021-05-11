package com.delayQueue.model;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayMessage implements Delayed {

    private String item;
    private Long expireTime;

    public DelayMessage(String item, Long delay) {

        this.item = item;
        this.expireTime = System.currentTimeMillis() + delay;
    }

    @Override
    public long getDelay(TimeUnit unit) {

        long diff = this.expireTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {

        if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
            return -1;
        else if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {

        return this.item + " " + this.expireTime;
    }
}
