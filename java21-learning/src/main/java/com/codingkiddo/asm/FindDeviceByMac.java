package com.codingkiddo.asm;

import java.util.List;
import java.util.Optional;

public class FindDeviceByMac {

    public static void main(String[] args) {
        List<Device> devices = List.of(
                new Device("Device-1", List.of("AA:BB:CC:11:22:33", "AA:BB:CC:11:22:44")),
                new Device("Device-2", List.of("DD:EE:FF:55:66:77")),
                new Device("Device-3", List.of("11:22:33:44:55:66"))
        );

        String inputMac = "dd:ee:ff:55:66:77";

        Optional<Device> device = findDeviceByMac(devices, inputMac);

        device.ifPresentOrElse(
                d -> System.out.println("Matched device: " + d),
                () -> System.out.println("No device found")
        );
    }

    public static Optional<Device> findDeviceByMac(List<Device> devices, String macAddress) {
        String normalizedMac = normalizeMac(macAddress);

        return devices.stream()
                .filter(device -> device.getMacAddresses().stream()
                        .map(FindDeviceByMac::normalizeMac)
                        .anyMatch(mac -> mac.equals(normalizedMac)))
                .findFirst();
    }

    private static String normalizeMac(String mac) {
        return mac == null ? "" : mac.replace("-", "")
                                     .replace(":", "")
                                     .toLowerCase();
    }
}

class Device {
    private final String name;
    private final List<String> macAddresses;

    public Device(String name, List<String> macAddresses) {
        this.name = name;
        this.macAddresses = macAddresses;
    }

    public String getName() {
        return name;
    }

    public List<String> getMacAddresses() {
        return macAddresses;
    }

    @Override
    public String toString() {
        return "Device{name='" + name + "', macAddresses=" + macAddresses + "}";
    }
}