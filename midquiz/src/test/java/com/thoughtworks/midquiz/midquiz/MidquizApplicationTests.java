package com.thoughtworks.midquiz.midquiz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MidquizApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test0() throws Exception {
        System.out.println("main函数开始执行");

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run(){
                System.out.println("===task start===");

                try {
                    Thread.sleep(50);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

                System.out.println("===task finish===");

            }

        });

        thread.start();

        System.out.println("main函数执行结束");

    }

}
