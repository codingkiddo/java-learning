package com.example.thread;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class ProcessorInfoExample2 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        CentralProcessor processor = hardware.getProcessor();

        CentralProcessor.ProcessorIdentifier processorIdentifier = processor.getProcessorIdentifier();

        System.out.println("Processor Vendor: " + processorIdentifier.getVendor());
        System.out.println("Processor Name: " + processorIdentifier.getName());
        System.out.println("Processor ID: " + processorIdentifier.getProcessorID());
        System.out.println("Identifier: " + processorIdentifier.getIdentifier());
        System.out.println("Microarchitecture: " + processorIdentifier.getMicroarchitecture());
        System.out.println("Frequency (Hz): " + processorIdentifier.getVendorFreq());
        System.out.println("Frequency (GHz): " + processorIdentifier.getVendorFreq() / 1000000000.0);
    }
}
