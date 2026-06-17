/**
 * 📋 Command Pattern
 * 
 * Story: A waiter taking your order on a pad. The order is a "command" 
 * that can be written down, queued, and executed later.
 * 
 * What it does: Turns a request into a standalone object that contains 
 * everything about the request. Can queue, log, undo commands.
 */

import java.util.ArrayList;
import java.util.List;

// 1. Command Interface
interface Order {
    void execute();
}

// 2. Receiver
class Chef {
    public void cookPasta() { System.out.println("   👨‍🍳 Chef: Cooking pasta al dente!"); }
    public void cookSteak() { System.out.println("   👨‍🍳 Chef: Grilling steak medium-rare!"); }
    public void makeSalad() { System.out.println("   👨‍🍳 Chef: Tossing a fresh salad!"); }
    public void makeDessert() { System.out.println("   👨‍🍳 Chef: Plating tiramisu!"); }
}

// 3. Concrete Commands
class PastaOrder implements Order {
    private Chef chef;
    public PastaOrder(Chef chef) { this.chef = chef; }
    public void execute() { chef.cookPasta(); }
}

class SteakOrder implements Order {
    private Chef chef;
    public SteakOrder(Chef chef) { this.chef = chef; }
    public void execute() { chef.cookSteak(); }
}

class SaladOrder implements Order {
    private Chef chef;
    public SaladOrder(Chef chef) { this.chef = chef; }
    public void execute() { chef.makeSalad(); }
}

class DessertOrder implements Order {
    private Chef chef;
    public DessertOrder(Chef chef) { this.chef = chef; }
    public void execute() { chef.makeDessert(); }
}

// 4. Invoker
class Waiter {
    private List<Order> orders = new ArrayList<>();
    
    public void takeOrder(Order order) {
        orders.add(order);
        System.out.println("   🧑‍🍳 Waiter: Writing down order...");
    }
    
    public void sendToKitchen() {
        System.out.println("   🧑‍🍳 Waiter: Sending all orders to kitchen!");
        for (Order order : orders) {
            order.execute();
        }
        orders.clear();
    }
}

// 5. Demo
public class CommandPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Command Pattern Demo                   ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        Chef chef = new Chef();
        Waiter waiter = new Waiter();

        System.out.println("📋 Table 1 orders:");
        waiter.takeOrder(new PastaOrder(chef));
        waiter.takeOrder(new SaladOrder(chef));
        
        System.out.println("\n📋 Table 2 orders:");
        waiter.takeOrder(new SteakOrder(chef));
        waiter.takeOrder(new DessertOrder(chef));

        System.out.println("\n🔥 Rush hour! Sending all to kitchen:");
        waiter.sendToKitchen();
        
        System.out.println("\n💡 Orders were queued and executed together!");
    }
}