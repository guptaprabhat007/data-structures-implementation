package com.consumerProducer.model;

import com.consumerProducer.service.ConsumerProducerImpl;

public class ConsumerThread extends Thread {

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
