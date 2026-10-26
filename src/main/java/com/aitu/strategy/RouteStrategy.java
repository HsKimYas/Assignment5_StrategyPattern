package com.aitu.strategy;

/**
 * Common interface for all route-planning algorithms.
 */
public interface RouteStrategy {
    Route planRoute(RouteRequest request);

    String name();
}
