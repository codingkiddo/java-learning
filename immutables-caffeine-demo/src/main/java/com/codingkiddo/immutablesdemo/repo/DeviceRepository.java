package com.codingkiddo.immutablesdemo.repo;

import com.codingkiddo.immutablesdemo.domain.Device;
import com.codingkiddo.immutablesdemo.domain.ImmutableDevice;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DeviceRepository {

    private final Map<String, Device> devices = new ConcurrentHashMap<>();

    @PostConstruct
    void seed() {
        put(ImmutableDevice.builder()
                .id("d-1")
                .mac("AA:BB:CC:DD:EE:01")
                .model("Airties Nova 4960")
                .vendor("Airties")
                .build());
        put(ImmutableDevice.builder()
                .id("d-2")
                .mac("AA:BB:CC:DD:EE:02")
                .model("Airties Nova 4980")
                .vendor("Airties")
                .build());
    }

    public Optional<Device> findById(String id) {
        return Optional.ofNullable(devices.get(id));
    }

    public Device save(Device d) {
        devices.put(d.id(), d);
        return d;
    }

    private void put(Device d) { devices.put(d.id(), d); }
}
