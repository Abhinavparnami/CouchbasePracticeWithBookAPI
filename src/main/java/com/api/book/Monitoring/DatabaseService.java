package com.api.book.Monitoring;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.stereotype.Component;

import javax.management.monitor.MonitorNotification;
import java.util.Map;
@Component
public class DatabaseService implements HealthIndicator {

    private final String message_key = "Service A";

    @Override
    public Health health() {
        if (!isRunningServiceA()) {
            return Health.down().withDetail(message_key, "Not Available").build();
        }
        return Health.up().withDetail(message_key, "Available").build();
    }

    private Boolean isRunningServiceA() {
        Boolean isRunning = false;
        // Logic Skipped

        return isRunning;
    }
}

