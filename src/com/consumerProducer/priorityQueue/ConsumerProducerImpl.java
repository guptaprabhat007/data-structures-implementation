package com.consumerProducer.priorityQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerProducerImpl {

    public static BlockingQueue<Integer> queue;

    public static void main(String[] args) {

        queue = new ArrayBlockingQueue<Integer>(10);
        ProducerThread producerThread = new ProducerThread();
        ConsumerThread consumerThread = new ConsumerThread();

        producerThread.start();
        consumerThread.start();
    }

}

class ProducerThread extends Thread {

    @Override
    public void run() {
        try {
            producer();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public void producer() throws InterruptedException {

        Random random = new Random();
        while (true) {
            Thread.sleep(2000);
            int produced = random.nextInt(100);
            ConsumerProducerImpl.queue.add(produced);
            System.out.println("Produced : " + produced);
        }

    }
}

class ConsumerThread extends Thread {

    @Override
    public void run() {

        try {
            consumer();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public void consumer() throws InterruptedException {

        while (true) {

            Thread.sleep(2000);
            Integer consumed = ConsumerProducerImpl.queue.take();
            System.out.println("Consumed : " + consumed);
        }

    }
}


