package com.example.thread;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.VirtualMemory;
import oshi.util.FormatUtil;

public class GetVirtualMemory2 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        GlobalMemory globalMemory = hardware.getMemory();
        VirtualMemory virtualMemory = globalMemory.getVirtualMemory();

        System.out.println("Max virtual memory: " + FormatUtil.formatBytes(virtualMemory.getVirtualMax()));
        System.out.println("Virtual memory used: " + FormatUtil.formatBytes(virtualMemory.getVirtualInUse()));

        System.out.println("Total swap: " + FormatUtil.formatBytes(virtualMemory.getSwapTotal()));
        System.out.println("Swap used: " +FormatUtil.formatBytes(virtualMemory.getSwapUsed()));

        System.out.println("Pages swapped in: " + virtualMemory.getSwapPagesIn());
        System.out.println("Pages swapped out: " + virtualMemory.getSwapPagesOut());
    }
}
