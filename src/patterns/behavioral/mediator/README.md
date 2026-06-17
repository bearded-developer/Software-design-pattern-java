# 🏛️ Mediator Pattern

## The Air Traffic Controller

### 📖 The Story
Planes don't talk to each other directly — they talk to the control tower. The tower coordinates landings, takeoffs, and taxiing. If planes talked directly, chaos would ensue. The mediator (tower) keeps communication organized and safe.

**In software terms: Define an object that encapsulates how objects interact, promoting loose coupling.**

### ✅ When to Use
- When many objects communicate in complex ways
- When you want to centralize control logic
- When you want to reduce subclassing

### ⚖️ Pros vs Cons
| ✅ Pros | ❌ Cons |
|---------|--------|
| Reduces coupling between components | Mediator can become a god object |
| Centralizes control logic | |
| Easy to change interaction rules | |