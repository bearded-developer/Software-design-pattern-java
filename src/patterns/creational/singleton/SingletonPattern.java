/**
 * 🏭 Singleton Pattern
 * 
 * Story: The one and only coffee machine in the office.
 * 
 * What it does: Ensures only ONE object of this class ever exists.
 * Everyone shares the same instance.
 * 
 * Run it: Hit the play button and watch it work.
 */

public class SingletonPattern {

    // ──────────────────────────────────────────────
    // The heart of the pattern: one static instance
    // This is the "eager" version — created at class load time
    // ──────────────────────────────────────────────
    private static SingletonPattern instance = new SingletonPattern();

    // Private constructor: nobody can call "new" from outside
    private SingletonPattern() {
        System.out.println("🛠️ Singleton created! First time. One instance forever.");
    }

    // The only way to get the instance
    public static SingletonPattern getInstance() {
        return instance;
    }

    // ──────────────────────────────────────────────
    // Business methods — what the singleton actually does
    // ──────────────────────────────────────────────

    public void serveCoffee() {
        System.out.println("☕ Here's your coffee. Made with love.");
    }

    public void logMessage(String message) {
        System.out.println("📝 LOG: " + message);
    }

    // ──────────────────────────────────────────────
    // Let's prove it works
    // ──────────────────────────────────────────────

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   Singleton Pattern Demo             ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();

        // Get the singleton instance
        SingletonPattern singleton = SingletonPattern.getInstance();
        System.out.println("✅ Got first reference to Singleton.");

        // Try to get it again
        SingletonPattern sameSingleton = SingletonPattern.getInstance();
        System.out.println("✅ Got second reference to Singleton.");

        // Are they the same? Let's check
        System.out.println();
        System.out.println("🔍 Are they the same object? " + (singleton == sameSingleton));
        System.out.println("   (If true, it's working. There's only ONE.)");

        // Use the singleton
        System.out.println();
        singleton.serveCoffee();
        singleton.logMessage("Singleton pattern demo completed!");

        System.out.println();
        System.out.println("💡 See? Both references point to the same coffee machine.");
        System.out.println("   No duplicate. No chaos. Just one Singleton.");
    }
}