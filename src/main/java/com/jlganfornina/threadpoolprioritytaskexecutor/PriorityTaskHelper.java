package com.jlganfornina.threadpoolprioritytaskexecutor;

import com.jlganfornina.threadpoolprioritytaskexecutor.executors.PriorityTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class PriorityTaskHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(PriorityTaskHelper.class);
    private final TaskExecutor taskExecutor;

    public PriorityTaskHelper(@Qualifier("TaskExecutor") TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void addPriorityTask(final Integer id, final Integer priority) {
        this.taskExecutor.execute(new Task(id, priority));
    }

    private class Task extends PriorityTask {
        private final Integer id;

        Task(final Integer id, final Integer priority) {
            super(priority);
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 1000000; i++) ;

            System.out.println("id: " + id + ", priority: " + getPriority());
            ;
        }
    }
}