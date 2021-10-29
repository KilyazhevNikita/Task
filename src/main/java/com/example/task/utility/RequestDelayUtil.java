package com.example.task.utility;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class RequestDelayUtil {

    @SneakyThrows
    public static void sendRequestDelay() {
        TimeUnit.SECONDS.sleep(5);
    }
}
