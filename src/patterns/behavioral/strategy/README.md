# 🎯 Strategy Pattern

## Choosing a Different Route on Google Maps

### 📖 The Story
You're going to the airport. Google Maps offers: "Fastest route (15 min)", "Scenic route (45 min)", "Avoid tolls". Each is a different ALGORITHM for calculating the route. You pick one at runtime. The map doesn't change — just the strategy for how to get there.

**In software terms: Define a family of algorithms, put each in a separate class, and make them interchangeable at runtime.**

### ✅ When to Use
- When you have multiple algorithms for the same task
- When you want to choose algorithms at runtime
- When algorithms use different trade-offs (speed vs. beauty)

### ⚖️ Pros vs Cons
| ✅ Pros | ❌ Cons |
|---------|--------|
| Algorithms are independent classes | Clients must know about strategies |
| Easy to add new strategies | Overhead of extra objects |
| Eliminates conditional statements | |