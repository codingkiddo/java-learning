package com.codingkiddo.immutablesdemo.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@Value.Style(jdkOnly = true)
@JsonSerialize(as = ImmutableDeviceQuery.class)
@JsonDeserialize(as = ImmutableDeviceQuery.class)
public interface DeviceQuery {
    String id();
    @Value.Default
    default boolean includeMetrics() { return false; }
}
