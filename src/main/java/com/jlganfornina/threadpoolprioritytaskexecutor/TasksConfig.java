package com.jlganfornina.threadpoolprioritytaskexecutor;

import com.jlganfornina.threadpoolprioritytaskexecutor.executors.ThreadPoolPriorityTaskExecutor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TasksConfig {
    private ThreadPoolPriorityTaskExecutor getThreadPoolPriorityTaskExecutor(Integer corePoolSize, Integer maxPoolSize, Integer queueCapacity) {
        ThreadPoolPriorityTaskExecutor threadPoolPriorityTaskExecutor = new ThreadPoolPriorityTaskExecutor();
        threadPoolPriorityTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolPriorityTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolPriorityTaskExecutor.setQueueCapacity(queueCapacity);

        return threadPoolPriorityTaskExecutor;
    }

    @Bean
    @Qualifier("TaskExecutor")
    public ThreadPoolTaskExecutor getTaskExecutor(
            @Value("${app.spring.corePoolSize}") Integer corePoolSize,
            @Value("${app.spring.maxPoolSize}") Integer maxPoolSize,
            @Value("${app.spring.queueCapacity}") Integer queueCapacity) {
        return getThreadPoolPriorityTaskExecutor(corePoolSize, maxPoolSize, queueCapacity);
    }
}
