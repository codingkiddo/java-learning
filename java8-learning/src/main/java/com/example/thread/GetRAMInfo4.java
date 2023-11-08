package com.example.thread;

import java.util.List;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PhysicalMemory;
import oshi.util.FormatUtil;

public class GetRAMInfo4 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        GlobalMemory globalMemory = hardware.getMemory();

        List<PhysicalMemory> physicalMemories = globalMemory.getPhysicalMemory();
        for (PhysicalMemory physicalMemory : physicalMemories) {
            System.out.println("Manufacturer: " + physicalMemory.getManufacturer());
            System.out.println("Memory type: " + physicalMemory.getMemoryType());
            System.out.println("Bank/slot label: " + physicalMemory.getBankLabel());
            System.out.println("Capacity: " + FormatUtil.formatBytes(physicalMemory.getCapacity()));
            System.out.println("Clock speed: " + FormatUtil.formatHertz(physicalMemory.getClockSpeed()));
        }
    }
}
