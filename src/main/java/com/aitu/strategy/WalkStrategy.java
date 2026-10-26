package com.aitu.strategy;

/**
 * Route algorithm optimized for travelling on foot.
 */
public final class WalkStrategy implements RouteStrategy {
    private static final double AVERAGE_SPEED_KMH = 5.0;

    @Override
    public Route planRoute(RouteRequest request) {
        int minutes = estimateMinutes(request.distanceKm(), AVERAGE_SPEED_KMH);
        return new Route(
                request.origin(),
                request.destination(),
                request.distanceKm(),
                minutes,
                "Walking",
                "Uses pedestrian-friendly paths and crossings.");
    }

    @Override
    public String name() {
        return "Walking";
    }

    private int estimateMinutes(double distanceKm, double speedKmh) {
        return (int) Math.ceil(distanceKm / speedKmh * 60);
    }
}
