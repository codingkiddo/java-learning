package com.example.thread;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.util.FormatUtil;

public class GetRAMInfo2 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        GlobalMemory globalMemory = hardware.getMemory();
        
        long usedMemory = globalMemory.getTotal() - globalMemory.getAvailable();

        System.out.println("Total memory: " + FormatUtil.formatBytes(globalMemory.getTotal()));
        System.out.println("Available memory: " + FormatUtil.formatBytes(globalMemory.getAvailable()));
        System.out.println("Used memory: " + FormatUtil.formatBytes(usedMemory));
    }
}
