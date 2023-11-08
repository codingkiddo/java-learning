package com.example.thread;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class ProcessorInfoExample3 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        CentralProcessor processor = hardware.getProcessor();

        System.out.println("Number of physical packages: " + processor.getPhysicalPackageCount());
        System.out.println("Number of physical CPUs: " + processor.getPhysicalProcessorCount());
        System.out.println("Number of logical CPUs: " + processor.getLogicalProcessorCount());
    }
}
