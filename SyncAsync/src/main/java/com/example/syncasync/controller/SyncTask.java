package com.example.syncasync.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SyncTask {

    @GetMapping("/sync-task")
    public void syncTask() {
        System.out.println("Start");
        slowTask();
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
