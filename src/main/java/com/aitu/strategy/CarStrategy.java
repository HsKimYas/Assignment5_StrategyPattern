package com.aitu.strategy;

/**
 * Route algorithm optimized for travelling by car.
 */
public final class CarStrategy implements RouteStrategy {
    private static final double AVERAGE_SPEED_KMH = 50.0;

    @Override
    public Route planRoute(RouteRequest request) {
        int minutes = estimateMinutes(request.distanceKm(), AVERAGE_SPEED_KMH);
        return new Route(
                request.origin(),
                request.destination(),
                request.distanceKm(),
                minutes,
                "Car",
                "Uses the fastest practical road route for a car.");
    }

    @Override
    public String name() {
        return "Car";
    }

    private int estimateMinutes(double distanceKm, double speedKmh) {
        return (int) Math.ceil(distanceKm / speedKmh * 60);
    }
}
