package com.consumerProducer.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ConsumerProducerImpl {

    public static void main(String args[]) {

        Queue queue = new Queue();
        ProducerThread producerThread = new ProducerThread(queue);
        ConsumerThread consumerThread = new ConsumerThread(queue);

        producerThread.start();
        consumerThread.start();
    }
}

class Queue {

    public int value;

    Semaphore semaphoreProd = new Semaphore(1);
    Semaphore semaphoreCons = new Semaphore(0);

    void get() {

        try {
            semaphoreCons.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int value = this.value;
        semaphoreProd.release();
        System.out.println("Got the value" + value);
    }

    void put(int value) {

        try {
            semaphoreProd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.value = value;
        System.out.println("Put the value" + value);
        semaphoreCons.release();
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

                Thread.sleep(1000);
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