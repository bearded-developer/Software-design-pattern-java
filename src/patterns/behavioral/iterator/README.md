# 🔄 Iterator Pattern

## The Playlist That Plays Songs One by One

### 📖 The Story
You have a playlist of songs. You don't know if it's stored as an array, a list, or in a database. You just want to play them one by one. The iterator gives you `hasNext()` and `next()` — no matter how the collection is structured.

**In software terms: Provide a way to access elements of a collection sequentially without exposing its underlying structure.**

### ✅ When to Use
- When you want to traverse a collection without knowing its structure
- When you need multiple traversal methods (forward, backward, random)
- When you want a uniform interface for different collection types

### ⚖️ Pros vs Cons
| ✅ Pros | ❌ Cons |
|---------|--------|
| Hides collection implementation | Only for sequential access |
| Multiple traversals possible | |