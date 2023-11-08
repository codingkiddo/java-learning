package com.example.thread;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class GetOsInfoExample1 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();

        System.out.println("Operating System: " + operatingSystem.toString());
    }
}
