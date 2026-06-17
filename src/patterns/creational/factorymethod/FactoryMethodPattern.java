/**
 * 🏭 Factory Method Pattern
 * 
 * Story: A toy factory that makes different toys for different kids.
 * The factory knows HOW to deliver toys, but sub-factories know WHAT to create.
 * 
 * What it does: Defines a method for creating objects, but lets subclasses
 * decide which exact object to create. Like saying "make a toy" and getting
 * the right toy without knowing how it was made.
 */

import java.util.ArrayList;
import java.util.List;

// ────────────────────────────────────────────────────────
// 1. The Product — what all toys have in common
// ────────────────────────────────────────────────────────

interface Toy {
    void play();
    String getName();
}

// ────────────────────────────────────────────────────────
// 2. Concrete Products — actual toys kids can play with
// ────────────────────────────────────────────────────────

class Car implements Toy {
    private String name = "🏎️ Sports Car";

    @Override
    public void play() {
        System.out.println("🏎️ Vroom vroom! You're racing down the highway at 200 mph!");
    }

    @Override
    public String getName() {
        return name;
    }
}

class Doll implements Toy {
    private String name = "🎎 Princess Doll";

    @Override
    public void play() {
        System.out.println("🎎 Tea time! Would you like some imaginary cookies?");
    }

    @Override
    public String getName() {
        return name;
    }
}

class Robot implements Toy {
    private String name = "🤖 Mega Robot X-9000";

    @Override
    public void play() {
        System.out.println("🤖 BEEP BOOP! I will protect the galaxy from evil aliens!");
    }

    @Override
    public String getName() {
        return name;
    }
}

class Puzzle implements Toy {
    private String name = "🧩 1000-Piece Puzzle";

    @Override
    public void play() {
        System.out.println("🧩 Hmm... where does this piece go? Oh! It's a castle!");
    }

    @Override
    public String getName() {
        return name;
    }
}

// ────────────────────────────────────────────────────────
// 3. The Creator — with the factory method
//    This is the abstract factory. It defines the process.
//    Subclasses will define what product to create.
// ────────────────────────────────────────────────────────

abstract class ToyFactory {
    
    // ★ The factory method — subclasses must implement this
    // They decide WHICH toy to create
    public abstract Toy createToy();
    
    // This is the template of how to deliver a toy.
    // It calls the factory method internally.
    public void deliverToy() {
        System.out.println("📦 Preparing your toy...");
        
        Toy toy = createToy();  // ← calls the factory method!
        
        System.out.println("✅ Created: " + toy.getName());
        System.out.print("🎮 Let's play! ");
        toy.play();
        System.out.println("📤 Toy delivered! Come again!");
        System.out.println();
    }
}

// ────────────────────────────────────────────────────────
// 4. Concrete Creators — each knows what to create
// ────────────────────────────────────────────────────────

class CarFactory extends ToyFactory {
    @Override
    public Toy createToy() {
        return new Car();
    }
}

class DollFactory extends ToyFactory {
    @Override
    public Toy createToy() {
        return new Doll();
    }
}

class RobotFactory extends ToyFactory {
    @Override
    public Toy createToy() {
        return new Robot();
    }
}

class PuzzleFactory extends ToyFactory {
    @Override
    public Toy createToy() {
        return new Puzzle();
    }
}

// ────────────────────────────────────────────────────────
// 5. The Demo — let's run the toy factory!
// ────────────────────────────────────────────────────────

public class FactoryMethodPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   Factory Method Pattern Demo        ║");
        System.out.println("║   \"The Toy Factory\"                 ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();
        System.out.println("🎪 Welcome to the Toy Factory!");
        System.out.println("   We have 4 different toy factories.");
        System.out.println("   Each knows how to make ONE type of toy.");
        System.out.println();

        // Create different factories
        ToyFactory carFactory = new CarFactory();
        ToyFactory dollFactory = new DollFactory();
        ToyFactory robotFactory = new RobotFactory();
        ToyFactory puzzleFactory = new PuzzleFactory();

        // Let each factory do its thing
        System.out.println("👦 Kid 1: \"I want a car!\"");
        carFactory.deliverToy();

        System.out.println("👧 Kid 2: \"I want a doll!\"");
        dollFactory.deliverToy();

        System.out.println("👦 Kid 3: \"I want a robot!\"");
        robotFactory.deliverToy();

        System.out.println("👧 Kid 4: \"I want a puzzle!\"");
        puzzleFactory.deliverToy();

        System.out.println("💡 Notice: All factories use the SAME deliverToy() method.");
        System.out.println("   But each creates a DIFFERENT toy because they override createToy().");
        System.out.println("   That's the Factory Method pattern in action!");
    }
}