package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LargeNumberOfFilesProcessing {


    ExecutorService executors = Executors.newFixedThreadPool(100);

    Callable<String> callableTask = () -> {
        TimeUnit.MILLISECONDS.sleep(300);
        return "Task's execution";
    };

    List<Callable<String>> callableTasks = new ArrayList<>();


}
