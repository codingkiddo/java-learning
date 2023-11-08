package com.example.thread;

import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

public class GetOsInfoExample2 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();

        System.out.println("Family: " + operatingSystem.getFamily());
        System.out.println("Manufacturer: " + operatingSystem.getManufacturer());
        System.out.println("Number of bits supported by the OS (32 or 64): " + operatingSystem.getBitness());
    }
}
