package com.jlganfornina.threadpoolprioritytaskexecutor.executors;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class ThreadPoolPriorityTaskExecutor extends ThreadPoolTaskExecutor {

    @Override
    protected BlockingQueue<Runnable> createQueue(int queueCapacity) {
        return new PriorityBlockingQueue<Runnable>(queueCapacity, new ComparePriority());
    }

    private static class ComparePriority<T extends PriorityTask> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o1.getPriority().compareTo(o2.getPriority());
        }
    }
}