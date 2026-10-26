package com.aitu.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NavigatorTest {
    private final RouteRequest request = new RouteRequest("A", "B", 10.0);

    @Test
    void delegatesToCarStrategy() {
        Navigator navigator = new Navigator(new CarStrategy());

        Route route = navigator.plan(request);

        assertEquals("Car", route.transportMode());
        assertEquals(12, route.estimatedMinutes());
    }

    @Test
    void switchesStrategyAtRuntime() {
        Navigator navigator = new Navigator(new CarStrategy());

        navigator.setStrategy(new WalkStrategy());
        assertEquals("Walking", navigator.plan(request).transportMode());

        navigator.setStrategy(new CycleStrategy());
        assertEquals("Cycling", navigator.plan(request).transportMode());
    }

    @Test
    void rejectsNullStrategy() {
        assertThrows(NullPointerException.class, () -> new Navigator(null));
    }

    @Test
    void rejectsInvalidDistance() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RouteRequest("A", "B", 0));
    }
}
