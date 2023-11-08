package com.example.thread;

import java.util.List;

import oshi.SystemInfo;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

public class FileSystemExample1 {
    public static void main(String... args) {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        FileSystem fileSystem = operatingSystem.getFileSystem();
        List<OSFileStore> osFileStores = fileSystem.getFileStores();

        for(OSFileStore fileStore : osFileStores) {
            System.out.println(fileStore.toString());
        }
    }
}
