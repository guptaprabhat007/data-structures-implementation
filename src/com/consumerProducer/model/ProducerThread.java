package com.consumerProducer.model;

import com.consumerProducer.service.ConsumerProducerImpl;

import java.util.Random;

public class ProducerThread extends Thread {

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
