package com.codingkiddo.immutablesdemo.service;

import com.codingkiddo.immutablesdemo.domain.Device;
import com.codingkiddo.immutablesdemo.domain.ImmutableDeviceQuery;
import com.codingkiddo.immutablesdemo.repo.DeviceRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DeviceService {

    private final DeviceRepository repo;

    public DeviceService(DeviceRepository repo) {
        this.repo = repo;
    }

    @Cacheable(cacheNames = "devices", key = "#query") // Immutables gives stable equals/hashCode
    public Device getBy(ImmutableDeviceQuery query) {
        return repo.findById(query.id()).orElseThrow(
            () -> new NoSuchElementException("Device not found: " + query.id()));
    }

    public Device getById(String id, boolean includeMetrics) {
        return getBy(ImmutableDeviceQuery.builder().id(id).includeMetrics(includeMetrics).build());
    }
}
