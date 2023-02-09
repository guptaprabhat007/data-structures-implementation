package com.threadPool.service;

import com.threadPool.model.ThreadPool;

public class ThreadPoolImpl {

    public static void main(String[] args) throws Exception {

        ThreadPool threadPool = new ThreadPool(3, 10);

        for (int i = 0; i < 10; i++) {

            int taskNo = i;
            RunnableTask reportRunnable = new RunnableTask(taskNo);
            threadPool.execute(reportRunnable);

/*            threadPool.execute(() -> {
                String message =
                        Thread.currentThread().getName()
                                + ": Task " + taskNo;
                System.out.println(message);
            });
            */
        }

        //threadPool.waitUntilAllTasksFinished();
        //threadPool.stop();

    }


    static class RunnableTask implements Runnable {

        Integer taskNo;

        RunnableTask(Integer taskNo) {
            this.taskNo = taskNo;
        }

        public void run() {
            String message = Thread.currentThread().getName() + ": Task " + this.taskNo;
            System.out.println(message);
        }
    }
}

