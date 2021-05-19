package com.thoughtworks.midquiz.midquiz;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class MidquizApplication {

    public static void main(String[] args) {
        SpringApplication.run(MidquizApplication.class, args);
    }

}
