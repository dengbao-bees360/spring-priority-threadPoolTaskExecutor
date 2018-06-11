package com.jlganfornina.threadpoolprioritytaskexecutor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {SpringConfig.class, TasksConfig.class})
public class ThreadPoolPriorityTaskExecutorApplicationTests {

    @Autowired
    PriorityTaskHelper priorityTaskHelper;

    @Test
    public void contextLoads() {
        IntStream.range(1, 1000).forEach(id -> {
            Integer priority = new Random().ints(1, 0, 2000).findFirst().getAsInt();

            priorityTaskHelper.addPriorityTask(id, priority);
        });

        for (int i = 0; i <= 2147000000; i++) ;
    }
}
