package com.wjy.task.sync;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class SyncTask {

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 60 * 1000)
    public void getCurrentTime() {

        System.out.println("时间：" + dateFormat.format(new Date()));

    }

}
