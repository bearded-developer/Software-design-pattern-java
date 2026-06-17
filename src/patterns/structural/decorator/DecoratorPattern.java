/**
 * 🎄 Decorator Pattern
 * 
 * Story: Adding toppings to a plain burger — cheese, bacon, avocado.
 * Each topping wraps the previous one. The original burger is still there.
 * 
 * What it does: Dynamically adds responsibilities to objects by wrapping them.
 * More flexible than inheritance — stack decorators however you want.
 */

// ────────────────────────────────────────────────────────
// 1. Component Interface — what all burgers can do
// ────────────────────────────────────────────────────────

interface Burger {
    String getDescription();
    double getCost();
}

// ────────────────────────────────────────────────────────
// 2. Concrete Component — the base burger
// ────────────────────────────────────────────────────────

class PlainBurger implements Burger {
    @Override
    public String getDescription() {
        return "🍔 Plain burger";
    }

    @Override
    public double getCost() {
        return 5.00;
    }
}

// ────────────────────────────────────────────────────────
// 3. Decorator (abstract) — wraps a Burger and delegates
// ────────────────────────────────────────────────────────

abstract class BurgerDecorator implements Burger {
    protected Burger burger;  // ← the burger being wrapped

    public BurgerDecorator(Burger burger) {
        this.burger = burger;
    }

    // Subclasses override getDescription() and getCost()
    // They add their own behavior, then delegate to the wrapped burger
}

// ────────────────────────────────────────────────────────
// 4. Concrete Decorators — each adds one topping
// ────────────────────────────────────────────────────────

class CheeseDecorator extends BurgerDecorator {
    public CheeseDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " + 🧀 Cheese";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 1.50;
    }
}

class BaconDecorator extends BurgerDecorator {
    public BaconDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " + 🥓 Bacon";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 2.00;
    }
}

class AvocadoDecorator extends BurgerDecorator {
    public AvocadoDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " + 🥑 Avocado";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 1.75;
    }
}

class JalapenoDecorator extends BurgerDecorator {
    public JalapenoDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " + 🌶️ Jalapeños";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 0.75;
    }
}

class LettuceDecorator extends BurgerDecorator {
    public LettuceDecorator(Burger burger) {
        super(burger);
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + " + 🥬 Lettuce";
    }

    @Override
    public double getCost() {
        return burger.getCost() + 0.50;
    }
}

// ────────────────────────────────────────────────────────
// 5. The Demo — let's build some burgers!
// ────────────────────────────────────────────────────────

public class DecoratorPattern {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   Decorator Pattern Demo                      ║");
        System.out.println("║   \"Building Burgers, One Topping at a Time\"   ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("🍔 Welcome to Pattern Burger!");
        System.out.println("   Every burger starts plain. You add toppings.");
        System.out.println("   Each topping WRAPS the previous burger.");
        System.out.println();

        // Basic burger
        Burger plain = new PlainBurger();
        System.out.println("1️⃣  " + plain.getDescription() + " = $" + plain.getCost());
        System.out.println();

        // Add cheese
        Burger cheeseburger = new CheeseDecorator(new PlainBurger());
        System.out.println("2️⃣  " + cheeseburger.getDescription() + " = $" + cheeseburger.getCost());
        System.out.println();

        // Add bacon + cheese
        Burger baconCheese = new BaconDecorator(new CheeseDecorator(new PlainBurger()));
        System.out.println("3️⃣  " + baconCheese.getDescription() + " = $" + baconCheese.getCost());
        System.out.println();

        // The "Everything" burger — stack ALL the decorators!
        Burger everything = new JalapenoDecorator(
            new AvocadoDecorator(
                new BaconDecorator(
                    new CheeseDecorator(
                        new LettuceDecorator(
                            new PlainBurger()
                        )
                    )
                )
            )
        );
        System.out.println("4️⃣  The 'EVERYTHING' Burger:");
        System.out.println("   " + everything.getDescription());
        System.out.println("   💰 Total: $" + everything.getCost());
        System.out.println();

        // Show the stack structure
        System.out.println("🔍 Here's what's happening inside:");
        System.out.println("   Order of wrapping (outside → in):");
        System.out.println("   Jalapeño → Avocado → Bacon → Cheese → Lettuce → Plain");
        System.out.println("   When you call getDescription(), it chains through ALL layers!");
        System.out.println();

        System.out.println("💡 Without Decorator, we'd need classes like:");
        System.out.println("   BaconCheeseBurger, BaconCheeseAvocadoBurger, etc.");
        System.out.println("   With 5 toppings, that's 32 classes! 😱");
        System.out.println("   With Decorator? 5 topping classes + 1 burger = 6. Clean!");
    }
}