/**
 * 🧬 Prototype Pattern
 * 
 * Story: Cloning shapes instead of creating them from scratch.
 * Like cloning a perfect sheep — why grow one when you can copy?
 * 
 * What it does: Creates new objects by copying an existing object (the prototype).
 * Avoids expensive "create from scratch" operations.
 */

import java.util.ArrayList;
import java.util.List;

// ────────────────────────────────────────────────────────
// 1. The Prototype Interface — everything must be cloneable
// ────────────────────────────────────────────────────────

interface Shape {
    Shape clone();    // Returns a copy of itself
    void draw();      // Draw the shape
    String getDetails();
}

// ────────────────────────────────────────────────────────
// 2. Concrete Prototypes — shapes that can clone themselves
// ────────────────────────────────────────────────────────

class Circle implements Shape {
    private int radius;
    private String color;

    public Circle(int radius, String color) {
        // Imagine this constructor is expensive — loading textures, etc.
        this.radius = radius;
        this.color = color;
    }

    // Copy constructor — used for cloning
    // Takes a Circle and copies its fields
    private Circle(Circle target) {
        this.radius = target.radius;
        this.color = target.color;
    }

    @Override
    public Shape clone() {
        return new Circle(this);  // Delegate to copy constructor
    }

    @Override
    public void draw() {
        System.out.println("⚪ Drawing a " + color + " circle of radius " + radius);
    }

    @Override
    public String getDetails() {
        return "Circle [radius=" + radius + ", color=" + color + "]";
    }

    public void setRadius(int radius) { this.radius = radius; }
    public void setColor(String color) { this.color = color; }
}

class Rectangle implements Shape {
    private int width;
    private int height;
    private String color;

    public Rectangle(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    private Rectangle(Rectangle target) {
        this.width = target.width;
        this.height = target.height;
        this.color = target.color;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    @Override
    public void draw() {
        System.out.println("▬ Drawing a " + color + " rectangle " + width + "x" + height);
    }

    @Override
    public String getDetails() {
        return "Rectangle [width=" + width + ", height=" + height + ", color=" + color + "]";
    }

    public void setWidth(int width) { this.width = width; }
    public void setHeight(int height) { this.height = height; }
    public void setColor(String color) { this.color = color; }
}

class Triangle implements Shape {
    private int base;
    private int height;
    private String color;

    public Triangle(int base, int height, String color) {
        this.base = base;
        this.height = height;
        this.color = color;
    }

    private Triangle(Triangle target) {
        this.base = target.base;
        this.height = target.height;
        this.color = target.color;
    }

    @Override
    public Shape clone() {
        return new Triangle(this);
    }

    @Override
    public void draw() {
        System.out.println("🔺 Drawing a " + color + " triangle (base=" + base + ", height=" + height + ")");
    }

    @Override
    public String getDetails() {
        return "Triangle [base=" + base + ", height=" + height + ", color=" + color + "]";
    }

    public void setBase(int base) { this.base = base; }
    public void setHeight(int height) { this.height = height; }
    public void setColor(String color) { this.color = color; }
}

// ────────────────────────────────────────────────────────
// 3. Prototype Registry — stores pre-made prototypes
//    Like having a catalog of ready-to-clone shapes
// ────────────────────────────────────────────────────────

class ShapeRegistry {
    private List<Shape> prototypes = new ArrayList<>();

    public void addPrototype(Shape shape) {
        prototypes.add(shape);
    }

    // Creates a copy of the prototype at the given index
    public Shape createShape(int index) {
        Shape prototype = prototypes.get(index);
        return prototype.clone();  // ← the magic is here!
    }

    public void listPrototypes() {
        System.out.println("📋 Available Prototypes:");
        for (int i = 0; i < prototypes.size(); i++) {
            System.out.println("   [" + i + "] " + prototypes.get(i).getDetails());
        }
    }
}

// ────────────────────────────────────────────────────────
// 4. The Demo — let's clone some shapes!
// ────────────────────────────────────────────────────────

public class PrototypePattern {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   Prototype Pattern Demo                      ║");
        System.out.println("║   \"Cloning Shapes, Not Creating Them\"         ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println();

        // Create our prototype registry with some base shapes
        ShapeRegistry registry = new ShapeRegistry();
        registry.addPrototype(new Circle(10, "Red"));
        registry.addPrototype(new Rectangle(20, 15, "Blue"));
        registry.addPrototype(new Triangle(12, 10, "Green"));

        System.out.println("🔬 Setting up shape prototypes...");
        registry.listPrototypes();
        System.out.println();

        // Now let's clone — much faster than creating from scratch!
        System.out.println("🔄 Cloning from prototypes:");
        System.out.println();

        Shape shape1 = registry.createShape(0);  // Clone the Circle
        System.out.print("   Clone 1: ");
        shape1.draw();

        Shape shape2 = registry.createShape(1);  // Clone the Rectangle
        System.out.print("   Clone 2: ");
        shape2.draw();

        Shape shape3 = registry.createShape(2);  // Clone the Triangle
        System.out.print("   Clone 3: ");
        shape3.draw();

        // Let's modify a clone — it doesn't affect the original
        System.out.println();
        System.out.println("🎨 Modifying a clone (changing color to Purple):");
        if (shape1 instanceof Circle) {
            ((Circle) shape1).setColor("Purple");
            ((Circle) shape1).setRadius(25);
        }
        System.out.print("   Modified clone: ");
        shape1.draw();
        System.out.println("   Original prototype is still unchanged!");
        registry.listPrototypes();

        System.out.println();
        System.out.println("💡 See? The original prototype stayed Red.");
        System.out.println("   We cloned it, modified the copy, and the original is untouched.");
        System.out.println("   That's the Prototype pattern — clone, don't create!");
    }
}