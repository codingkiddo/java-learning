package com.codingkiddo.immutablesdemo.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.time.Instant;
import java.util.Optional;

@Value.Immutable
@Value.Style(jdkOnly = true) // use java.util collections, no Guava types in API
@JsonSerialize(as = ImmutableDevice.class)
@JsonDeserialize(as = ImmutableDevice.class)
public interface Device {
    String id();
    String mac();
    String model();
    Optional<String> vendor();

    @Value.Default
    default Instant createdAt() { return Instant.now(); }

    @Value.Derived
    default String macCompact() { return mac().replace(":", "").toUpperCase(); }

    @Value.Check
    default void validate() {
        if (id().isBlank()) throw new IllegalStateException("id must not be blank");
        if (!mac().matches("(?i)^[0-9a-f]{2}(:[0-9a-f]{2}){5}$"))
            throw new IllegalStateException("mac must be like AA:BB:CC:DD:EE:FF");
    }
}
