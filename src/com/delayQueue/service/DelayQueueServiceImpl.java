package com.delayQueue.service;

import com.delayQueue.model.DelayMessage;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class DelayQueueServiceImpl {

    public void startDemo(BlockingQueue<DelayMessage> delayQueue, Long delay) {

        // producer thread
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    Random random = new Random();
                    int i = random.nextInt(1000);
                    // push elements in the delay queue
                    try {

                        DelayMessage delayMessage = new DelayMessage("item" + i, delay);
                        System.out.println(System.currentTimeMillis() + " Producer produced - " + delayMessage);
                        delayQueue.put(delayMessage);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Error while pushing message in the Queue " + e.getMessage());
                    }
                }
            }
        }.start();

        // consumer thread
        new Thread() {

            @Override
            public void run() {

                while (true) {

                    // retrieving elements from delay queue
                    try {
                        DelayMessage delayMessage = delayQueue.take();
                        System.out.println(System.currentTimeMillis() + " Consumer consumed - " + delayMessage);
                        //Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("Error while retrieving message from the Queue " + e.getMessage());
                    }
                }
            }
        }.start();
    }
}
