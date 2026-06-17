# 📝 Template Method Pattern

## The Recipe — Same Steps, Different Dishes

### 📖 The Story
Every recipe follows the same template: prepare ingredients, cook, serve, clean up. But HOW you do each step depends on what you're making. Pasta? Boil water. Steak? Fire up the grill. Salad? Just chop. The structure is fixed — the details vary.

**In software terms: Define the skeleton of an algorithm in a method, letting subclasses override certain steps without changing the algorithm's structure.**

### ✅ When to Use
- When you have an algorithm with invariant and variant parts
- When you want to avoid code duplication across similar algorithms
- When subclasses should only extend specific parts of the algorithm

### ⚖️ Pros vs Cons
| ✅ Pros | ❌ Cons |
|---------|--------|
| Reuses common code | Can violate Liskov if overused |
| Structure is clear and enforced | Hard to follow with many hooks |
| Easy to add new implementations | |