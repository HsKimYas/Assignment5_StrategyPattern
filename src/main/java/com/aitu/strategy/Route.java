package com.aitu.strategy;

/**
 * Result produced by a route-planning strategy.
 */
public record Route(
        String origin,
        String destination,
        double distanceKm,
        int estimatedMinutes,
        String transportMode,
        String description) {
}
