package com.example.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestQuartz{
    @Test
    public void testQuartzJob(){
        ApplicationContext ct  = new ClassPathXmlApplicationContext("job.xml");
        int cnt = 5;
        while(--cnt != 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}


