package com.example.syncasync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncTask {

    @GetMapping("/async-task")
    public void asyncTask() {
        System.out.println("Start");
        new Thread(() -> {
            slowTask();
            System.out.println("Async task done");
        }).start();
        System.out.println("End");
    }

    void slowTask() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
