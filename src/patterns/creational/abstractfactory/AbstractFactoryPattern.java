/**
 * 🏭 Abstract Factory Pattern
 * 
 * Story: A furniture store that sells matching sets — Victorian or Modern.
 * You don't buy a Victorian sofa and a Modern table. Everything matches.
 * 
 * What it does: Creates families of related objects without needing to know
 * which specific family you're dealing with. "Give me a sofa" always returns
 * a sofa that matches the table and lamp from the same family.
 */

// ────────────────────────────────────────────────────────
// 1. Abstract Products — what each furniture type can do
// ────────────────────────────────────────────────────────

interface Sofa {
    void relax();
    String getStyle();
}

interface Table {
    void putThingsOn();
    String getStyle();
}

interface Lamp {
    void light();
    String getStyle();
}

// ────────────────────────────────────────────────────────
// 2. Concrete Products — Victorian Style
// ────────────────────────────────────────────────────────

class VictorianSofa implements Sofa {
    @Override
    public void relax() {
        System.out.println("🛋️ Sinking into the plush Victorian sofa with fancy golden trim...");
    }

    @Override
    public String getStyle() {
        return "Victorian";
    }
}

class VictorianTable implements Table {
    @Override
    public void putThingsOn() {
        System.out.println("🪑 Placing your tea on the ornate Victorian mahogany table.");
    }

    @Override
    public String getStyle() {
        return "Victorian";
    }
}

class VictorianLamp implements Lamp {
    @Override
    public void light() {
        System.out.println("💡 The Victorian lamp glows warmly through its stained glass shade.");
    }

    @Override
    public String getStyle() {
        return "Victorian";
    }
}

// ────────────────────────────────────────────────────────
// 3. Concrete Products — Modern Style
// ────────────────────────────────────────────────────────

class ModernSofa implements Sofa {
    @Override
    public void relax() {
        System.out.println("🛋️ Flopping onto the sleek, minimalist Modern sofa. Very chic.");
    }

    @Override
    public String getStyle() {
        return "Modern";
    }
}

class ModernTable implements Table {
    @Override
    public void putThingsOn() {
        System.out.println("🪑 Putting your laptop on the glass-topped Modern table.");
    }

    @Override
    public String getStyle() {
        return "Modern";
    }
}

class ModernLamp implements Lamp {
    @Override
    public void light() {
        System.out.println("💡 The Modern lamp casts a cool, white LED light.");
    }

    @Override
    public String getStyle() {
        return "Modern";
    }
}

// ────────────────────────────────────────────────────────
// 4. Abstract Factory — the contract for making matched sets
// ────────────────────────────────────────────────────────

interface FurnitureFactory {
    Sofa createSofa();
    Table createTable();
    Lamp createLamp();
}

// ────────────────────────────────────────────────────────
// 5. Concrete Factories — each makes a matching family
// ────────────────────────────────────────────────────────

class VictorianFactory implements FurnitureFactory {
    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }

    @Override
    public Lamp createLamp() {
        return new VictorianLamp();
    }
}

class ModernFactory implements FurnitureFactory {
    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }

    @Override
    public Lamp createLamp() {
        return new ModernLamp();
    }
}

// ────────────────────────────────────────────────────────
// 6. The Client — just wants furniture, doesn't care how
// ────────────────────────────────────────────────────────

class HomeOwner {
    private final Sofa sofa;
    private final Table table;
    private final Lamp lamp;

    public HomeOwner(FurnitureFactory factory) {
        System.out.println("🏠 Homeowner orders an entire set from " 
                         + factory.getClass().getSimpleName());
        
        // All three come from the same factory — they MATCH
        this.sofa = factory.createSofa();
        this.table = factory.createTable();
        this.lamp = factory.createLamp();
    }

    public void showRoom() {
        System.out.println("   ┌─────────────────────────────────────");
        System.out.println("   │ Style: " + sofa.getStyle());
        System.out.println("   ├─────────────────────────────────────");
        System.out.print("   │ ");
        sofa.relax();
        System.out.print("   │ ");
        table.putThingsOn();
        System.out.print("   │ ");
        lamp.light();
        System.out.println("   └─────────────────────────────────────");
        System.out.println("   ✅ Everything matches! Perfect harmony.");
    }
}

// ────────────────────────────────────────────────────────
// 7. The Demo — let's decorate!
// ────────────────────────────────────────────────────────

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║   Abstract Factory Pattern Demo                  ║");
        System.out.println("║   \"The Furniture Store That Sells Matching Sets\" ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println();

        // Pick a style — change this one line to switch everything!
        System.out.println("🎨 Available styles:");
        System.out.println("   1. Victorian — classic, ornate, fancy");
        System.out.println("   2. Modern    — sleek, minimalist, cool");
        System.out.println();

        // Let's go Victorian first
        FurnitureFactory victorianFactory = new VictorianFactory();
        HomeOwner alice = new HomeOwner(victorianFactory);
        alice.showRoom();

        System.out.println();
        System.out.println("--- Next customer, please! ---");
        System.out.println();

        // Now Modern
        FurnitureFactory modernFactory = new ModernFactory();
        HomeOwner bob = new HomeOwner(modernFactory);
        bob.showRoom();

        System.out.println();
        System.out.println("💡 See how Alice got Victorian EVERYTHING?");
        System.out.println("   And Bob got Modern EVERYTHING?");
        System.out.println("   The only difference was which factory we passed in.");
        System.out.println("   That's Abstract Factory — families that match!");
    }
}