package patterns.structural.facade;

/**
 * 🏪 Facade Pattern
 * 
 * Story: A waiter who handles the complicated kitchen. The customer just says
 * "I want food" and the waiter coordinates everything behind the scenes.
 * 
 * What it does: Provides a simple, unified interface to a complex subsystem.
 * The client doesn't need to know about the kitchen chaos.
 */

// ────────────────────────────────────────────────────────
// 1. Complex Subsystem — lots of moving parts
//    The client should NOT talk to these directly
// ────────────────────────────────────────────────────────

class Chef {
    public void prepareIngredients() {
        System.out.println("   👨‍🍳 Chef: Chopping veggies, marinating meat...");
    }

    public void cook() {
        System.out.println("   👨‍🍳 Chef: Cooking on the stove. Sizzle sizzle!");
    }

    public void plateDish() {
        System.out.println("   👨‍🍳 Chef: Plating the dish beautifully.");
    }
}

class Oven {
    public void preheat(int temp) {
        System.out.println("   🔥 Oven: Preheating to " + temp + "°F...");
    }

    public void bake() {
        System.out.println("   🔥 Oven: Baking to perfection!");
    }
}

class Fridge {
    public boolean hasIngredients(String dish) {
        System.out.println("   ❄️ Fridge: Checking ingredients for " + dish + "...");
        return true;
    }

    public void getIngredients() {
        System.out.println("   ❄️ Fridge: Got fresh ingredients!");
    }
}

class Cashier {
    public void calculateBill(double amount) {
        System.out.println("   💵 Cashier: Calculating bill... Total: $" + amount);
    }

    public void processPayment(String method) {
        System.out.println("   💵 Cashier: Processing " + method + " payment... Done! ✅");
    }

    public void printReceipt() {
        System.out.println("   🧾 Cashier: Printing receipt. Have a nice day!");
    }
}

class Dishwasher {
    public void washDishes() {
        System.out.println("   🧼 Dishwasher: Cleaning up... Done!");
    }
}

class MusicSystem {
    public void playBackgroundMusic() {
        System.out.println("   🎵 Music System: Playing smooth jazz in the background.");
    }
}

// ────────────────────────────────────────────────────────
// 2. The Facade — the waiter who simplifies everything
//    The client ONLY talks to this class
// ────────────────────────────────────────────────────────

class RestaurantWaiter {
    // The facade knows all the subsystems
    private Chef chef = new Chef();
    private Oven oven = new Oven();
    private Fridge fridge = new Fridge();
    private Cashier cashier = new Cashier();
    private Dishwasher dishwasher = new Dishwasher();
    private MusicSystem music = new MusicSystem();

    // Simple method #1: Order food
    // Behind this one call, a LOT happens
    public void orderFood(String dish) {
        System.out.println("   🧑‍🍳 Waiter: Taking order for " + dish + "...");
        
        // The waiter coordinates everything
        music.playBackgroundMusic();
        if (fridge.hasIngredients(dish)) {
            fridge.getIngredients();
            chef.prepareIngredients();
            oven.preheat(375);
            chef.cook();
            oven.bake();
            chef.plateDish();
        }
        
        System.out.println("   🧑‍🍳 Waiter: Here's your " + dish + "! Enjoy! 🍝");
    }

    // Simple method #2: Pay the bill
    public void payBill(double amount, String paymentMethod) {
        System.out.println("   🧑‍🍳 Waiter: Bringing the check...");
        cashier.calculateBill(amount);
        cashier.processPayment(paymentMethod);
        cashier.printReceipt();
    }

    // Simple method #3: Clean up
    public void cleanUp() {
        System.out.println("   🧑‍🍳 Waiter: Cleaning the table...");
        dishwasher.washDishes();
    }
}

// ────────────────────────────────────────────────────────
// 3. The Demo — eating at the restaurant
// ────────────────────────────────────────────────────────

public class FacadePattern {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   Facade Pattern Demo                         ║");
        System.out.println("║   \"The Waiter Who Handles the Kitchen\"        ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("👤 Customer walks into Pattern Restaurant...");
        System.out.println();

        // The customer (client) only talks to the waiter (facade)
        RestaurantWaiter waiter = new RestaurantWaiter();

        System.out.println("📋 CUSTOMER: \"I'd like spaghetti Bolognese, please!\"");
        System.out.println();
        waiter.orderFood("Spaghetti Bolognese");
        System.out.println();

        System.out.println("📋 CUSTOMER: \"Can I have the check?\"");
        System.out.println();
        waiter.payBill(24.99, "Credit Card");
        System.out.println();

        System.out.println("📋 CUSTOMER: \"Great meal! Goodbye!\"");
        waiter.cleanUp();

        System.out.println();
        System.out.println("💡 The customer called ONLY 3 methods:");
        System.out.println("   1. orderFood()");
        System.out.println("   2. payBill()");
        System.out.println("   3. cleanUp()");
        System.out.println();
        System.out.println("   Behind the scenes, these 3 methods triggered:");
        System.out.println("   Chef, Oven, Fridge, Cashier, Dishwasher, MusicSystem");
        System.out.println("   The customer has NO IDEA about any of them.");
        System.out.println("   That's the Facade pattern — simplicity hiding complexity!");
    }
}