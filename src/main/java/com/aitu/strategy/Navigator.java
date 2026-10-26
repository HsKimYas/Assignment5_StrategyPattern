package com.aitu.strategy;

import java.util.Objects;

/**
 * Context in the Strategy pattern. It is independent of concrete strategies.
 */
public final class Navigator {
    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy must not be null");
    }

    /**
     * Replaces the current route-planning algorithm at runtime.
     */
    public void setStrategy(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy must not be null");
    }

    /**
     * Delegates route planning to the currently selected strategy.
     */
    public Route plan(RouteRequest request) {
        return strategy.planRoute(request);
    }

    public String getCurrentStrategyName() {
        return strategy.name();
    }
}
