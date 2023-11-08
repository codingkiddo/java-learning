package com.example.thread;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class GetOsInfoExample3 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        OperatingSystem.OSVersionInfo versionInfo = operatingSystem.getVersionInfo();

        System.out.println("Version: " + versionInfo.getVersion());
        System.out.println("CodeName: " + versionInfo.getCodeName());
        System.out.println("Build Number: " + versionInfo.getBuildNumber());
    }
}