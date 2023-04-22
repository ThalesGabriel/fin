package org.zhr.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.zhr"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}