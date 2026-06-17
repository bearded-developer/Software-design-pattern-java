# 🔄 State Pattern

## The Traffic Light Changing Colors

### 📖 The Story
A traffic light behaves differently depending on its current state. Green → go. Yellow → slow down. Red → stop. The light object stays the same, but its BEHAVIOR changes with its internal state. Each state knows what to do and which state comes next.

**In software terms: Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.**

### ✅ When to Use
- When an object's behavior depends on its state
- When you have large conditional statements based on state
- When state transitions are explicit and well-defined

### ⚖️ Pros vs Cons
| ✅ Pros | ❌ Cons |
|---------|--------|
| Eliminates massive if/else statements | More classes to manage |
| Each state is a separate class | State transitions can be complex |
| Easy to add new states | |