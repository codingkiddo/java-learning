package com.example.thread;

import java.util.List;

import oshi.SystemInfo;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class FileSystemExample2 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        FileSystem fileSystem = operatingSystem.getFileSystem();
        List<OSFileStore> osFileStores = fileSystem.getFileStores();

        for(OSFileStore fileStore : osFileStores) {
            System.out.println("Description: " + fileStore.getDescription());
            System.out.println("Label: " + fileStore.getLabel());
            System.out.println("Logical Volume: " + fileStore.getLogicalVolume());
            System.out.println("Mount: " + fileStore.getMount());
            System.out.println("Name: " + fileStore.getName());
            System.out.println("Options: " + fileStore.getOptions());
            System.out.println("Type: " + fileStore.getType());
            System.out.println("UUID: " + fileStore.getUUID());
            System.out.println("Volume: " + fileStore.getVolume());
            System.out.println("Free Space: " + FormatUtil.formatBytes(fileStore.getFreeSpace()));
            System.out.println("Total Space: " + FormatUtil.formatBytes(fileStore.getTotalSpace()));
            System.out.println("Usable Space: " + FormatUtil.formatBytes(fileStore.getUsableSpace()));
            System.out.println();
        }
    }
}
