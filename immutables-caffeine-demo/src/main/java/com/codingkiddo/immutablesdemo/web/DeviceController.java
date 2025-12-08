package com.codingkiddo.immutablesdemo.web;

import com.codingkiddo.immutablesdemo.domain.Device;
import com.codingkiddo.immutablesdemo.service.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService service;

    public DeviceController(DeviceService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> get(@PathVariable String id,
                                      @RequestParam(defaultValue = "false") boolean includeMetrics) {
        return ResponseEntity.ok(service.getById(id, includeMetrics));
    }
}
