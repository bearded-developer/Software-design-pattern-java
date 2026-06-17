/**
 * 💾 Memento Pattern
 * 
 * Story: A save point in a video game. You can save your progress (create a memento),
 * and later restore it. The game state is saved without exposing its internals.
 * 
 * What it does: Captures and externalizes an object's internal state so it can
 * be restored later, without violating encapsulation.
 */

import java.util.Stack;

// 1. Originator — the game whose state we save
class GameCharacter {
    private int health = 100;
    private int level = 1;
    private String location = "Start";

    public void fightBoss() {
        System.out.println("   ⚔️ Fighting the Dragon!");
        health -= 50;
        if (health > 0) {
            level++;
            location = "Dragon's Lair";
            System.out.println("   🏆 Won! Level up! HP: " + health);
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println("   💥 Took " + damage + " damage. HP: " + health);
    }

    // Save state to memento
    public CharacterMemento save() {
        System.out.println("   💾 Saving game... HP:" + health + " Level:" + level);
        return new CharacterMemento(health, level, location);
    }

    // Restore state from memento
    public void restore(CharacterMemento memento) {
        this.health = memento.getHealth();
        this.level = memento.getLevel();
        this.location = memento.getLocation();
        System.out.println("   🔄 Restored! HP:" + health + " Level:" + level);
    }

    public void status() {
        System.out.println("   📊 Status - HP: " + health + " | Level: " + level + " | At: " + location);
    }
}

// 2. Memento — snapshot of game state (immutable)
class CharacterMemento {
    private final int health;
    private final int level;
    private final String location;

    public CharacterMemento(int health, int level, String location) {
        this.health = health;
        this.level = level;
        this.location = location;
    }

    public int getHealth() { return health; }
    public int getLevel() { return level; }
    public String getLocation() { return location; }
}

// 3. Caretaker — manages save files
class SaveManager {
    private Stack<CharacterMemento> saves = new Stack<>();

    public void saveGame(CharacterMemento memento) {
        saves.push(memento);
        System.out.println("   📂 Saved to slot " + (saves.size()));
    }

    public CharacterMemento loadLastSave() {
        if (!saves.isEmpty()) {
            System.out.println("   📂 Loading most recent save...");
            return saves.pop();
        }
        System.out.println("   ❌ No saves found!");
        return null;
    }
}

// 4. Demo
public class MementoPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Memento Pattern Demo                   ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        GameCharacter hero = new GameCharacter();
        SaveManager saveManager = new SaveManager();

        hero.status();
        
        System.out.println("\n🎮 Playing...");
        hero.fightBoss();
        saveManager.saveGame(hero.save());  // Save after boss
        
        System.out.println("\n🎮 Exploring dangerous area...");
        hero.takeDamage(80);
        hero.status();
        
        System.out.println("\n😱 Oh no! Restoring to last save...");
        hero.restore(saveManager.loadLastSave());
        hero.status();
        
        System.out.println("\n💡 We went back in time! All because of the memento!");
    }
}