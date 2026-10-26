package com.aitu.strategy;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        RouteRequest trip = new RouteRequest(
                "Astana IT University",
                "Baiterek Tower",
                6.0);

        Navigator navigator = new Navigator(new CarStrategy());
        printRoute("Initial strategy", navigator.plan(trip));

        navigator.setStrategy(new WalkStrategy());
        printRoute("After runtime switch", navigator.plan(trip));

        navigator.setStrategy(new CycleStrategy());
        printRoute("After second runtime switch", navigator.plan(trip));
    }

    private static void printRoute(String title, Route route) {
        System.out.printf(
                "%s: %s | %.1f km | %d min | %s%n",
                title,
                route.transportMode(),
                route.distanceKm(),
                route.estimatedMinutes(),
                route.description());
    }
}
