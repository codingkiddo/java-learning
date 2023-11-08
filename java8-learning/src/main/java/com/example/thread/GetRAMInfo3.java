package com.example.thread;

import java.util.List;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PhysicalMemory;

public class GetRAMInfo3 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        GlobalMemory globalMemory = hardware.getMemory();

        List<PhysicalMemory> physicalMemories = globalMemory.getPhysicalMemory();
        for (PhysicalMemory physicalMemory : physicalMemories) {
            System.out.println(physicalMemory.toString());
        }
    }
}
