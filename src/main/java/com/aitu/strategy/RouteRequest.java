package com.aitu.strategy;

/**
 * Immutable input data used by route-planning strategies.
 */
public record RouteRequest(String origin, String destination, double distanceKm) {
    public RouteRequest {
        if (origin == null || origin.isBlank()) {
            throw new IllegalArgumentException("Origin must not be blank");
        }
        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Destination must not be blank");
        }
        if (distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }
    }
}
