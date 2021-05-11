package com.delayQueue;

import com.delayQueue.model.DelayMessage;
import com.delayQueue.service.DelayQueueServiceImpl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class Main {

    public static void main(String[] args) {

        Long delay = 5000L; // milliseconds
        BlockingQueue<DelayMessage> delayQueue = new DelayQueue<>();

        DelayQueueServiceImpl delayQueueService = new DelayQueueServiceImpl();
        delayQueueService.startDemo(delayQueue, delay);

    }
}
