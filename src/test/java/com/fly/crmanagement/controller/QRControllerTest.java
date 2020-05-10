package com.fly.crmanagement.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class QRControllerTest {
    @Test
    void test() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int number = random.nextInt(10);
            sb.append(number);
        }
        System.out.println(sb.toString());
    }
}