/**
 * 🏛️ Visitor Pattern
 * 
 * Story: A museum visitor looking at different exhibits. Each exhibit is different
 * (painting, sculpture, artifact), but the visitor can "visit" each one.
 * The visitor adds new operations without changing the exhibits themselves.
 * 
 * What it does: Lets you define new operations on a set of objects without
 * changing the objects themselves. The operation code is in the visitor.
 */

// 1. Visitor Interface
interface MuseumVisitor {
    void visit(Painting painting);
    void visit(Sculpture sculpture);
    void visit(Artifact artifact);
}

// 2. Element Interface
interface Exhibit {
    void accept(MuseumVisitor visitor);
}

// 3. Concrete Elements
class Painting implements Exhibit {
    private String title = "Mona Lisa";
    public String getTitle() { return title; }
    public void accept(MuseumVisitor visitor) { visitor.visit(this); }
}

class Sculpture implements Exhibit {
    private String name = "David";
    public String getName() { return name; }
    public void accept(MuseumVisitor visitor) { visitor.visit(this); }
}

class Artifact implements Exhibit {
    private String origin = "Ancient Egypt";
    public String getOrigin() { return origin; }
    public void accept(MuseumVisitor visitor) { visitor.visit(this); }
}

// 4. Concrete Visitors
class Curator implements MuseumVisitor {
    public void visit(Painting p) { System.out.println("   👩‍🎨 Curator examines painting: " + p.getTitle()); }
    public void visit(Sculpture s) { System.out.println("   👩‍🎨 Curator examines sculpture: " + s.getName()); }
    public void visit(Artifact a) { System.out.println("   👩‍🎨 Curator examines artifact from: " + a.getOrigin()); }
}

class Tourist implements MuseumVisitor {
    public void visit(Painting p) { System.out.println("   🧳 Tourist takes selfie with: " + p.getTitle()); }
    public void visit(Sculpture s) { System.out.println("   🧳 Tourist says 'Wow!' at: " + s.getName()); }
    public void visit(Artifact a) { System.out.println("   🧳 Tourist reads plaque from: " + a.getOrigin()); }
}

class ArtCritic implements MuseumVisitor {
    public void visit(Painting p) { System.out.println("   🧐 Critic analyzes brushstrokes of: " + p.getTitle()); }
    public void visit(Sculpture s) { System.out.println("   🧐 Critic critiques the proportions of: " + s.getName()); }
    public void visit(Artifact a) { System.out.println("   🧐 Critic questions the authenticity from: " + a.getOrigin()); }
}

// 5. Demo
public class VisitorPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Visitor Pattern Demo                   ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        Exhibit[] museum = {new Painting(), new Sculpture(), new Artifact()};
        
        MuseumVisitor[] visitors = {new Curator(), new Tourist(), new ArtCritic()};
        
        for (MuseumVisitor visitor : visitors) {
            System.out.println("👤 " + visitor.getClass().getSimpleName() + " walks into the museum:");
            for (Exhibit exhibit : museum) {
                exhibit.accept(visitor);
            }
            System.out.println();
        }
        
        System.out.println("💡 We added 3 visitors. The exhibits NEVER changed!");
        System.out.println("   Want a new visitor? Just add one — no exhibit changes needed.");
    }
}