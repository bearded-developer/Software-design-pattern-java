/**
 * 🔌 Adapter Pattern
 * 
 * Story: An international traveler with an Indian laptop plug trying to charge in London.
 * The plug doesn't fit the UK socket. A travel adapter bridges the gap.
 * 
 * What it does: Converts one interface to another so incompatible classes can work together.
 * Like a travel adapter for your code.
 */

// ────────────────────────────────────────────────────────
// 1. Target Interface — what the client expects
//    The Indian laptop has a 2-pin charger
// ────────────────────────────────────────────────────────

interface IndianCharger {
    void chargeWithTwoPins();
}

// ────────────────────────────────────────────────────────
// 2. Adaptee — the existing, incompatible interface
//    The UK wall socket with 3 round pins
// ────────────────────────────────────────────────────────

class UKSocket {
    public void providePowerWithThreePins() {
        System.out.println("🔌 [UK Socket] Providing 240V power through 3 round pins.");
    }
}

class USSocket {
    public void providePowerWithTwoFlatPins() {
        System.out.println("🔌 [US Socket] Providing 110V power through 2 flat pins.");
    }
}

class EuropeanSocket {
    public void providePowerWithTwoRoundPins() {
        System.out.println("🔌 [EU Socket] Providing 230V power through 2 round pins.");
    }
}

// ────────────────────────────────────────────────────────
// 3. Adapter — makes incompatible things work together
//    The travel adapter that converts 2-pin Indian to various sockets
// ────────────────────────────────────────────────────────

class UKAdapter implements IndianCharger {
    private UKSocket ukSocket;

    public UKAdapter(UKSocket ukSocket) {
        this.ukSocket = ukSocket;
    }

    @Override
    public void chargeWithTwoPins() {
        System.out.println("🔌 [UK Adapter] Converting Indian 2-pin → UK 3-pin...");
        ukSocket.providePowerWithThreePins();
        System.out.println("✅ Laptop charging happily in the UK!");
    }
}

class USAdapter implements IndianCharger {
    private USSocket usSocket;

    public USAdapter(USSocket usSocket) {
        this.usSocket = usSocket;
    }

    @Override
    public void chargeWithTwoPins() {
        System.out.println("🔌 [US Adapter] Converting Indian 2-pin → US 2-flat-pin...");
        usSocket.providePowerWithTwoFlatPins();
        System.out.println("✅ Laptop charging happily in the US!");
    }
}

class EuropeanAdapter implements IndianCharger {
    private EuropeanSocket euSocket;

    public EuropeanAdapter(EuropeanSocket euSocket) {
        this.euSocket = euSocket;
    }

    @Override
    public void chargeWithTwoPins() {
        System.out.println("🔌 [EU Adapter] Converting Indian 2-pin → EU 2-round-pin...");
        euSocket.providePowerWithTwoRoundPins();
        System.out.println("✅ Laptop charging happily in Europe!");
    }
}

// ────────────────────────────────────────────────────────
// 4. The Client — just wants to charge its laptop
// ────────────────────────────────────────────────────────

class Laptop {
    private String name;

    public Laptop(String name) {
        this.name = name;
    }

    // The laptop only knows about IndianCharger interface
    public void charge(IndianCharger charger) {
        System.out.println("💻 " + name + ": Plugging in...");
        charger.chargeWithTwoPins();
        System.out.println();
    }
}

// ────────────────────────────────────────────────────────
// 5. The Demo — Rajesh travels the world!
// ────────────────────────────────────────────────────────

public class AdapterPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║   Adapter Pattern Demo                               ║");
        System.out.println("║   \"The International Traveler with the Wrong Plug\"   ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println();

        Laptop rajeshLaptop = new Laptop("Rajesh's Dell");

        // Rajesh is in India — no adapter needed
        System.out.println("📍 Location: INDIA (home — no adapter needed)");
        System.out.println("   But wait... all sockets here are Indian. No problem!");
        System.out.println();

        // Rajesh travels to London
        System.out.println("📍 Location: LONDON, UK");
        System.out.println("   😱 Rajesh sees a 3-round-pin socket!");
        IndianCharger ukAdapter = new UKAdapter(new UKSocket());
        rajeshLaptop.charge(ukAdapter);

        // Rajesh travels to New York
        System.out.println("📍 Location: NEW YORK, USA");
        System.out.println("   😱 A 2-flat-pin socket (but different from India)!");
        IndianCharger usAdapter = new USAdapter(new USSocket());
        rajeshLaptop.charge(usAdapter);

        // Rajesh travels to Paris
        System.out.println("📍 Location: PARIS, FRANCE");
        System.out.println("   😱 A 2-round-pin socket!");
        IndianCharger euAdapter = new EuropeanAdapter(new EuropeanSocket());
        rajeshLaptop.charge(euAdapter);

        System.out.println("💡 Notice: Rajesh's laptop NEVER changed.");
        System.out.println("   It always calls chargeWithTwoPins() — the interface it knows.");
        System.out.println("   The adapters do the conversion. The laptop is happy.");
        System.out.println("   That's the Adapter pattern!");
    }
}