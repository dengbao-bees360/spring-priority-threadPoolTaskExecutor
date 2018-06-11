package com.jlganfornina.threadpoolprioritytaskexecutor.executors;

public abstract class PriorityTask implements Runnable {

    private Integer priority;

    public PriorityTask(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}