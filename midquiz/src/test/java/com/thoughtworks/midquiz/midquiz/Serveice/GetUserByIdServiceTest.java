package com.thoughtworks.midquiz.midquiz.Serveice;

import com.thoughtworks.midquiz.midquiz.Model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class GetUserByIdServiceTest {

  @Mock
  private GetUserByIdService getUserByIdService;

  @Test
  void test() {
    when(getUserByIdService.getAllUsers()).thenReturn(Collections.singletonList(User.builder()
            .id(1L).build()));
    final List<User> allUsers = getUserByIdService.getAllUsers();
    System.out.println(allUsers);
  }

  @Test
   void test3() throws Exception{
    System.out.println("main函数开始执行");

    longtime();

    System.out.println("main函数执行结束");

  }

  @Async
  public void longtime(){
    System.out.println("我在执行一项耗时任务");

    try {
      Thread.sleep(5000);

    } catch (InterruptedException e){
      e.printStackTrace();

    }

    System.out.println("完成");

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