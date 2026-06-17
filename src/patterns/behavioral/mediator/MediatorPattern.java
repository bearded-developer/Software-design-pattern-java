/**
 * 🏛️ Mediator Pattern
 * 
 * Story: An air traffic controller. Planes don't talk to each other directly —
 * they talk to the controller. The controller coordinates everything.
 * 
 * What it does: Defines an object that encapsulates how a set of objects interact.
 * Promotes loose coupling by keeping objects from referring to each other explicitly.
 */

import java.util.ArrayList;
import java.util.List;

// 1. Mediator Interface
interface AirTrafficControl {
    void requestLanding(Airplane plane);
    void notify(String message, Airplane sender);
}

// 2. Mediator
class ControlTower implements AirTrafficControl {
    private List<Airplane> planes = new ArrayList<>();
    
    public void register(Airplane plane) { planes.add(plane); }
    
    public void requestLanding(Airplane plane) {
        System.out.println("   🏛️ Tower: " + plane.getName() + " requests landing.");
        notify("Landing requested. Please wait.", plane);
    }
    
    public void notify(String message, Airplane sender) {
        for (Airplane plane : planes) {
            if (plane != sender) {
                plane.receive(message);
            }
        }
    }
}

// 3. Colleague
class Airplane {
    private String name;
    private AirTrafficControl tower;
    
    public Airplane(String name, AirTrafficControl tower) {
        this.name = name;
        this.tower = tower;
    }
    
    public String getName() { return name; }
    
    public void approach() {
        System.out.println("\n   ✈️ " + name + ": Approaching airport...");
        tower.requestLanding(this);
    }
    
    public void receive(String message) {
        System.out.println("   ✈️ " + name + " received: " + message);
    }
}

// 4. Demo
public class MediatorPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Mediator Pattern Demo                  ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        ControlTower tower = new ControlTower();
        Airplane flight101 = new Airplane("Flight 101", tower);
        Airplane flight202 = new Airplane("Flight 202", tower);
        Airplane flight303 = new Airplane("Flight 303", tower);
        
        tower.register(flight101);
        tower.register(flight202);
        tower.register(flight303);
        
        flight101.approach();
        flight202.approach();
        
        System.out.println("\n💡 Planes never talked to each other directly!");
        System.out.println("   The tower coordinated everything.");
    }
}