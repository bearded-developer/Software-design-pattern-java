# 👁️ Observer Pattern

## YouTube Subscribers Getting Notifications

### 📖 The Story
You subscribe to a YouTube channel. When the creator uploads a new video, EVERY subscriber gets notified. The creator doesn't call each person individually — they just notify their subscriber list. You can unsubscribe anytime and stop getting updates.

**In software terms: Define a one-to-many dependency so that when one object changes state, all dependents are notified automatically.**

### ✅ When to Use
- When changes to one object require changing others
- When you don't know how many objects need to change
- When you want loose coupling between subject and observers

### ⚖️ Pros vs Cons
| ✅ Pros | ❌ Cons |
|---------|--------|
| Loose coupling between subject and observers | Observers notified in random order |
| Supports broadcast communication | Can cause memory leaks if not unregistered |
| Easy to add/remove observers | |