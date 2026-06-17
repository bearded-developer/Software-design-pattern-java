/**
 * 🏗️ Builder Pattern
 * 
 * Story: Building a custom pizza, one topping at a time.
 * No more constructors with 15 parameters where nobody knows what "true, false, true" means.
 * 
 * What it does: Lets you build complex objects step-by-step.
 * Each method returns the builder itself so you can chain calls.
 * At the end, call build() to get the final object.
 */

import java.util.ArrayList;
import java.util.List;

// ────────────────────────────────────────────────────────
// 1. The Product — the complex thing we're building
// ────────────────────────────────────────────────────────

class Pizza {
    private String crust;
    private String sauce;
    private String cheese;
    private final List<String> toppings = new ArrayList<>();
    private boolean extraCheese;
    private boolean wellDone;

    // No constructor with 15 params! Just setters.
    public void setCrust(String crust) { this.crust = crust; }
    public void setSauce(String sauce) { this.sauce = sauce; }
    public void setCheese(String cheese) { this.cheese = cheese; }
    public void addTopping(String topping) { this.toppings.add(topping); }
    public void setExtraCheese(boolean extraCheese) { this.extraCheese = extraCheese; }
    public void setWellDone(boolean wellDone) { this.wellDone = wellDone; }

    public void describe() {
        System.out.println("🍕 Your Pizza:");
        System.out.println("   Crust: " + crust);
        System.out.println("   Sauce: " + sauce);
        System.out.println("   Cheese: " + cheese + (extraCheese ? " + EXTRA CHEESE 🧀" : ""));
        System.out.println("   Toppings: " + (toppings.isEmpty() ? "None" : String.join(", ", toppings)));
        System.out.println("   Baked: " + (wellDone ? "Well done (crispy!)" : "Normal"));
        System.out.println("   ✅ Ready to eat! Bon appétit!");
    }
}

// ────────────────────────────────────────────────────────
// 2. The Builder Interface — step-by-step construction
// ────────────────────────────────────────────────────────

interface PizzaBuilder {
    PizzaBuilder setCrust(String crust);
    PizzaBuilder setSauce(String sauce);
    PizzaBuilder setCheese(String cheese);
    PizzaBuilder addTopping(String topping);
    PizzaBuilder extraCheese();
    PizzaBuilder wellDone();
    Pizza build();
}

// ────────────────────────────────────────────────────────
// 3. The Concrete Builder — builds the actual pizza
// ────────────────────────────────────────────────────────

class CustomPizzaBuilder implements PizzaBuilder {
    private Pizza pizza = new Pizza();

    @Override
    public PizzaBuilder setCrust(String crust) {
        pizza.setCrust(crust);
        return this;  // ← return this enables chaining!
    }

    @Override
    public PizzaBuilder setSauce(String sauce) {
        pizza.setSauce(sauce);
        return this;
    }

    @Override
    public PizzaBuilder setCheese(String cheese) {
        pizza.setCheese(cheese);
        return this;
    }

    @Override
    public PizzaBuilder addTopping(String topping) {
        pizza.addTopping(topping);
        return this;
    }

    @Override
    public PizzaBuilder extraCheese() {
        pizza.setExtraCheese(true);
        return this;
    }

    @Override
    public PizzaBuilder wellDone() {
        pizza.setWellDone(true);
        return this;
    }

    @Override
    public Pizza build() {
        return pizza;  // ← return the finished product
    }
}

// ────────────────────────────────────────────────────────
// 4. Predefined Pizza Recipes (using the builder)
// ────────────────────────────────────────────────────────

class PizzaMenu {
    public static Pizza margherita() {
        return new CustomPizzaBuilder()
            .setCrust("Classic")
            .setSauce("Tomato")
            .setCheese("Mozzarella")
            .addTopping("Basil")
            .build();
    }

    public static Pizza pepperoni() {
        return new CustomPizzaBuilder()
            .setCrust("Thin")
            .setSauce("Tomato")
            .setCheese("Mozzarella")
            .addTopping("Pepperoni")
            .addTopping("Oregano")
            .build();
    }

    public static Pizza veggieSupreme() {
        return new CustomPizzaBuilder()
            .setCrust("Whole Wheat")
            .setSauce("Pesto")
            .setCheese("Vegan Cheese")
            .addTopping("Bell Peppers")
            .addTopping("Mushrooms")
            .addTopping("Olives")
            .addTopping("Onions")
            .addTopping("Spinach")
            .extraCheese()
            .build();
    }

    public static Pizza hawaiian() {
        return new CustomPizzaBuilder()
            .setCrust("Pan")
            .setSauce("Tomato")
            .setCheese("Mozzarella")
            .addTopping("Ham")
            .addTopping("Pineapple")  // Yes, pineapple belongs on pizza.
            .wellDone()
            .build();
    }
}

// ────────────────────────────────────────────────────────
// 5. The Demo — let's build some pizzas!
// ────────────────────────────────────────────────────────

public class BuilderPattern {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   Builder Pattern Demo                        ║");
        System.out.println("║   \"Building a Pizza, One Topping at a Time\"   ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("🍕 Welcome to Pattern Pizza! 🍕");
        System.out.println("   Where every pizza is built step-by-step.");
        System.out.println();

        // Predefined pizzas from our menu
        System.out.println("📋 ORDER 1: Margherita (from menu)");
        Pizza margherita = PizzaMenu.margherita();
        margherita.describe();
        System.out.println();

        System.out.println("📋 ORDER 2: Pepperoni (from menu)");
        Pizza pepperoni = PizzaMenu.pepperoni();
        pepperoni.describe();
        System.out.println();

        System.out.println("📋 ORDER 3: Veggie Supreme (from menu)");
        Pizza veggie = PizzaMenu.veggieSupreme();
        veggie.describe();
        System.out.println();

        System.out.println("📋 ORDER 4: Custom Pizza (build your own!)");
        Pizza customPizza = new CustomPizzaBuilder()
            .setCrust("Stuffed Crust")
            .setSauce("BBQ")
            .setCheese("Cheddar")
            .addTopping("Chicken")
            .addTopping("Bacon")
            .addTopping("Jalapeños")
            .extraCheese()
            .wellDone()
            .build();
        customPizza.describe();
        System.out.println();

        System.out.println("💡 See how clean that was?");
        System.out.println("   No 'new Pizza(true, false, true, null, ...)' confusion.");
        System.out.println("   Each step is readable. Each method name tells you what it does.");
        System.out.println("   That's the Builder pattern — building complex things simply.");
    }
}