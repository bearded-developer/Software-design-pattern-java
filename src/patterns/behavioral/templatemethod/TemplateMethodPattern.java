/**
 * 📝 Template Method Pattern
 * 
 * Story: A recipe — the steps are always the same: prep, cook, serve.
 * But HOW you prep, cook, and serve depends on WHAT you're making.
 * The recipe template is fixed. The implementation varies.
 * 
 * What it does: Defines the skeleton of an algorithm in a method,
 * letting subclasses override certain steps without changing the structure.
 */

// 1. Abstract Class with Template Method
abstract class Recipe {
    // ★ THE TEMPLATE METHOD — defines the structure
    // Subclasses CANNOT change this (it's final)
    public final void cookDish() {
        System.out.println("   📖 Following recipe...");
        prepareIngredients();
        cook();
        serve();
        cleanUp();
    }

    // Steps that subclasses MUST implement
    protected abstract void prepareIngredients();
    protected abstract void cook();
    
    // Steps with default implementation (can override)
    protected void serve() {
        System.out.println("   🍽️ Serving on a plate. Enjoy!");
    }

    // Common step — same for everyone (hook)
    protected void cleanUp() {
        System.out.println("   🧹 Cleaning up the kitchen.");
    }
}

// 2. Concrete Classes
class PastaRecipe extends Recipe {
    protected void prepareIngredients() { System.out.println("   🥫 Preparing: pasta, tomatoes, garlic, basil"); }
    protected void cook() { System.out.println("   🍝 Boiling pasta and making tomato sauce..."); }
}

class SteakRecipe extends Recipe {
    protected void prepareIngredients() { System.out.println("   🥩 Preparing: ribeye steak, salt, pepper, butter"); }
    protected void cook() { System.out.println("   🔥 Grilling steak medium-rare on high heat..."); }
    protected void serve() { System.out.println("   🥩 Serving steak with red wine reduction. Fancy!"); }
}

class SaladRecipe extends Recipe {
    protected void prepareIngredients() { System.out.println("   🥬 Preparing: lettuce, tomatoes, cucumber, dressing"); }
    protected void cook() { System.out.println("   🥗 No cooking! Just chopping and tossing."); }
    protected void cleanUp() { System.out.println("   🧹 Quick cleanup — just rinsed the board."); }
}

// 3. Demo
public class TemplateMethodPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Template Method Pattern Demo           ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        System.out.println("👉 Cooking Pasta:");
        Recipe pasta = new PastaRecipe();
        pasta.cookDish();
        
        System.out.println("\n👉 Cooking Steak:");
        Recipe steak = new SteakRecipe();
        steak.cookDish();
        
        System.out.println("\n👉 Making Salad:");
        Recipe salad = new SaladRecipe();
        salad.cookDish();
        
        System.out.println("\n💡 All dishes followed the same steps!");
        System.out.println("   But each dish did those steps differently.");
    }
}