package com.codingkiddo.time;

import java.time.Clock;
import java.time.Instant;

public class Time1 {

    public static void main(String[] args) {

        System.out.println(Clock.systemDefaultZone());
        
        String ts = "2026-01-23T12:00:00.000Z";
        long epochMillis = Instant.parse(ts).toEpochMilli();
        System.out.println(epochMillis);
    }
}
