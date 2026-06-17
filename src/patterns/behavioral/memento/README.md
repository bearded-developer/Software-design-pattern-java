# 💾 Memento Pattern

## The Save Point in a Video Game

### 📖 The Story
You're fighting a boss. You save your game before the battle. You die. You reload the save and try again. The save point captured your state (health, level, inventory) without exposing the game's internals. Later, you restore it.

**In software terms: Capture and externalize an object's internal state so it can be restored later, without violating encapsulation.**

### ✅ When to Use
- When you need undo/redo functionality
- When you need to save and restore state
- When direct access to state would break encapsulation

### ⚖️ Pros vs Cons
| ✅ Pros | ❌ Cons |
|---------|--------|
| Preserves encapsulation boundaries | Can use lots of memory |
| Simplifies the originator | Mementos can expire |
| Undo/redo is easy | |