# 🏛️ Visitor Pattern

## The Museum Visitor Looking at Different Exhibits

### 📖 The Story
A museum has paintings, sculptures, and artifacts. A curator examines them. A tourist takes selfies. An art critic critiques them. Each "visitor" does something different with each exhibit — without the exhibits changing. The operation (visiting) is separated from the structure (exhibits).

**In software terms: Define new operations on a set of objects without changing the objects themselves.**

### ✅ When to Use
- When you need many operations across a stable object structure
- When you want to add operations without changing the elements
- When operation logic doesn't belong inside the elements

### ⚖️ Pros vs Cons
| ✅ Pros | ❌ Cons |
|---------|--------|
| Adding new operations is easy | Adding new elements is hard |
| Related operations are grouped in one visitor | Can break encapsulation |
| Elements don't need to change | |