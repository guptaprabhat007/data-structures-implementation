package com.consumerProducer.priorityQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerProducerImpl {

    private BlockingQueue<Integer> queue;
    private int size;

    ConsumerProducerImpl(int size){
        this.size = size;
        this.queue  = new ArrayBlockingQueue<Integer>(size);
    }

    public static void main(String[] args) {

        ConsumerProducerImpl consumerProducer = new ConsumerProducerImpl(10);
        ProducerThread producerThread = new ProducerThread(consumerProducer.queue, consumerProducer.size);
        ConsumerThread consumerThread = new ConsumerThread(consumerProducer.queue, consumerProducer.size);

        producerThread.start();
        consumerThread.start();
    }

}

class ProducerThread extends Thread {

    private BlockingQueue<Integer> queue;
    private int size;

    ProducerThread(BlockingQueue<Integer> queue, int size){
        this.size = size;
        this.queue  = new ArrayBlockingQueue<Integer>(size);
    }

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
            Thread.sleep(1000);
            int produced = random.nextInt(100);
            this.queue.offer(produced);
            System.out.println("Produced : " + produced);
        }

    }
}

class ConsumerThread extends Thread {

    private BlockingQueue<Integer> queue;
    private int size;

    ConsumerThread(BlockingQueue<Integer> queue, int size){
        this.size = size;
        this.queue  = new ArrayBlockingQueue<Integer>(size);
    }

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
            Integer consumed = this.queue.take();
            System.out.println("Consumed : " + consumed);
        }

    }
}


