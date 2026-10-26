package com.aitu.strategy;

/**
 * Route algorithm optimized for travelling by bicycle.
 */
public final class CycleStrategy implements RouteStrategy {
    private static final double AVERAGE_SPEED_KMH = 18.0;

    @Override
    public Route planRoute(RouteRequest request) {
        int minutes = estimateMinutes(request.distanceKm(), AVERAGE_SPEED_KMH);
        return new Route(
                request.origin(),
                request.destination(),
                request.distanceKm(),
                minutes,
                "Cycling",
                "Prefers bike-friendly roads and cycle paths.");
    }

    @Override
    public String name() {
        return "Cycling";
    }

    private int estimateMinutes(double distanceKm, double speedKmh) {
        return (int) Math.ceil(distanceKm / speedKmh * 60);
    }
}
