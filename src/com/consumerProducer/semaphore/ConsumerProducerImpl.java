package com.consumerProducer.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class ConsumerProducerImpl {

    public static void main(String args[]) {

        Queue queue = new Queue(5);
        ProducerThread producerThread = new ProducerThread(queue);
        ConsumerThread consumerThread = new ConsumerThread(queue);

        producerThread.start();
        consumerThread.start();
    }
}

class Queue {

    private List<Integer> queue;
    private int size;

    public Queue(int size) {
        this.size = size;
        this.queue = new ArrayList<>(size);
    }

    Semaphore semaphoreProd = new Semaphore(1);
    Semaphore semaphoreCons = new Semaphore(0);

    void get() {

        try {
            semaphoreCons.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (queue.size() > 0) {
            Integer value = queue.remove(0);
            System.out.println("Got the value " + value);
            semaphoreProd.release();
            semaphoreCons.release();
        }else {
            throw new RuntimeException("QUEUE IS EMPTY");
        }
    }

    void put(int value) {

        try {
            semaphoreProd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (queue.size() < size) {
            queue.add(value);
            System.out.println("Put the value " + value);
            semaphoreProd.release();
            semaphoreCons.release();
        }else {
            throw new RuntimeException("QUEUE IS FULL");
        }

    }
}


class ProducerThread extends Thread {

    Queue queue;

    ProducerThread(Queue q) {
        queue = q;
    }

    @Override
    public void run() {

        try {
            while (true) {

                Thread.sleep(500);
                Random random = new Random();
                int value = random.nextInt(100);
                queue.put(value);
            }


        } catch (InterruptedException exception) {

            exception.printStackTrace();
        }
    }
}

class ConsumerThread extends Thread {

    Queue queue;

    ConsumerThread(Queue q) {
        queue = q;
    }

    @Override
    public void run() {

        try {

            while (true) {
                Thread.sleep(1000);
                queue.get();
            }
        } catch (InterruptedException exception) {

            exception.printStackTrace();
        }
    }
}