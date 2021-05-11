package com.consumerProducer.service;

import com.consumerProducer.model.ConsumerThread;
import com.consumerProducer.model.ProducerThread;

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
