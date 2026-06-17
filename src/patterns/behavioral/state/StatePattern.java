/**
 * 🔄 State Pattern
 * 
 * Story: A traffic light. It changes behavior based on its current state.
 * When GREEN → cars go. When YELLOW → slow down. When RED → stop.
 * The light itself doesn't change. Its BEHAVIOR changes with state.
 * 
 * What it does: Allows an object to alter its behavior when its internal state changes.
 * The object will appear to change its class.
 */

// 1. State Interface
interface TrafficLightState {
    void action();
    TrafficLightState next();
}

// 2. Concrete States
class GreenLight implements TrafficLightState {
    public void action() { System.out.println("   🟢 GREEN: GO! Cars are moving."); }
    public TrafficLightState next() { return new YellowLight(); }
}

class YellowLight implements TrafficLightState {
    public void action() { System.out.println("   🟡 YELLOW: SLOW DOWN! Prepare to stop."); }
    public TrafficLightState next() { return new RedLight(); }
}

class RedLight implements TrafficLightState {
    public void action() { System.out.println("   🔴 RED: STOP! Cars are waiting."); }
    public TrafficLightState next() { return new GreenLight(); }
}

// 3. Context
class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        state = new RedLight();  // Start with red
        System.out.println("   🚦 Traffic light initialized at RED");
    }

    public void change() {
        state.action();
        state = state.next();
    }
}

// 4. Demo
public class StatePattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   State Pattern Demo                     ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        TrafficLight light = new TrafficLight();
        
        System.out.println("\n🔄 Traffic light cycle (3 changes):");
        for (int i = 0; i < 6; i++) {
            System.out.print("   Cycle " + (i+1) + ": ");
            light.change();
        }
        
        System.out.println("\n💡 Same traffic light. Different behavior each state.");
    }
}