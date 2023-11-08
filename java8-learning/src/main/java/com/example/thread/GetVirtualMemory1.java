package com.example.thread;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.VirtualMemory;

public class GetVirtualMemory1 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        GlobalMemory globalMemory = hardware.getMemory();
        VirtualMemory virtualMemory = globalMemory.getVirtualMemory();

        System.out.println(virtualMemory.toString());
    }
}
