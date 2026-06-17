/**
 * 🎯 Strategy Pattern
 * 
 * Story: Google Maps — choosing your route. "Fastest" "Scenic" "Avoid tolls".
 * Each is a different algorithm. You pick one at runtime. The map doesn't change,
 * just the way it calculates the route.
 * 
 * What it does: Defines a family of algorithms, puts each in a separate class,
 * and makes them interchangeable at runtime.
 */

// 1. Strategy Interface
interface NavigationStrategy {
    void navigate(String destination);
}

// 2. Concrete Strategies
class FastestRoute implements NavigationStrategy {
    public void navigate(String dest) {
        System.out.println("   🏎️ Taking the fastest route to " + dest + " (15 min)");
    }
}

class ScenicRoute implements NavigationStrategy {
    public void navigate(String dest) {
        System.out.println("   🌅 Taking the scenic route to " + dest + " (45 min but beautiful)");
    }
}

class WalkingRoute implements NavigationStrategy {
    public void navigate(String dest) {
        System.out.println("   🚶 Walking to " + dest + " (great exercise!)");
    }
}

class BikeRoute implements NavigationStrategy {
    public void navigate(String dest) {
        System.out.println("   🚲 Biking to " + dest + " (eco-friendly!)");
    }
}

// 3. Context
class GPS {
    private NavigationStrategy strategy;

    public void setStrategy(NavigationStrategy strategy) {
        this.strategy = strategy;
        System.out.println("   🗺️ GPS: Strategy changed to " + strategy.getClass().getSimpleName());
    }

    public void goTo(String destination) {
        if (strategy == null) {
            System.out.println("   ❌ GPS: No strategy selected!");
            return;
        }
        strategy.navigate(destination);
    }
}

// 4. Demo
public class StrategyPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Strategy Pattern Demo                  ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        GPS gps = new GPS();
        
        System.out.println("📍 Going to the airport:");
        gps.setStrategy(new FastestRoute());
        gps.goTo("Airport");
        
        System.out.println("\n📍 Going to the beach (Sunday):");
        gps.setStrategy(new ScenicRoute());
        gps.goTo("Beach");
        
        System.out.println("\n📍 Going to the corner store:");
        gps.setStrategy(new WalkingRoute());
        gps.goTo("Corner Store");
        
        System.out.println("\n📍 Going to the park:");
        gps.setStrategy(new BikeRoute());
        gps.goTo("Park");

        System.out.println("\n💡 Same GPS. Different strategies for different needs!");
    }
}