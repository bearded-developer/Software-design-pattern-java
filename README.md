# 🏗️ Gang of Four Design Patterns in Java

## The Architect's Journey: From Blueprint to Masterpiece

---

### Once Upon a Time, in a Kingdom of Chaos...

Imagine you're a master chef who just inherited a chaotic kitchen. Spices are everywhere. Pots and pans are scattered. Nobody knows where the ladles go. Every time someone orders a dish, the kitchen descends into madness. "Where's the salt? Who moved the pepper? Why is the oven preheating for a salad?"

This is what software looked like in the early days. Every developer cooked up their own solution. Code was messy, unpredictable, and impossible to maintain.

Then, in 1994, four brilliant minds — Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides — sat down and said, "Enough is enough." They studied hundreds of successful software projects, looking for patterns. Not rigid rules, but **reusable solutions** to common problems. They became known as the **Gang of Four (GoF)** .

Their discovery changed software forever. They found that great software, like great architecture, follows patterns. A bridge in France and a bridge in Japan look different, but the *pattern* of a bridge — span, support, load distribution — is the same. The same is true for software.

This project is your journey through those 23 timeless patterns. Each pattern comes with:
- **A story** — because we remember stories better than syntax
- **A diagram** — because a picture is worth a thousand lines of code
- **Live code** — because the best way to learn is by running
- **Wisdom from the trenches** — because 20 years in the industry teaches you what books don't

---

## 🗺️ The Map of Patterns

The GoF patterns are divided into three neighborhoods, each solving a different kind of problem:

### 🏗️ Creational Patterns — "How are things born?"
These patterns deal with object creation. Instead of creating objects directly using `new`, these patterns give you more flexibility and control.

| # | Pattern | What It Solves | Story |
|---|---------|---------------|-------|
| 1 | **Singleton** | "I need exactly one of these, and everyone must share it" | The kingdom's one and only coffee machine |
| 2 | **Factory Method** | "Let subclasses decide what to create" | A toy factory that makes different toys |
| 3 | **Abstract Factory** | "I need families of related objects" | Furniture store selling matching sets |
| 4 | **Builder** | "This object is too complex to build in one step" | Building a custom pizza, one topping at a time |
| 5 | **Prototype** | "Creating from scratch is expensive, let me clone" | Cloning a sheep instead of growing one |

### 🔗 Structural Patterns — "How are things organized?"
These patterns deal with how classes and objects are composed to form larger structures.

| # | Pattern | What It Solves | Story |
|---|---------|---------------|-------|
| 6 | **Adapter** | "These two things don't fit together" | A travel adapter for a foreign socket |
| 7 | **Bridge** | "I need to separate what things are from how they work" | A TV and its remote control |
| 8 | **Composite** | "I want to treat groups of objects like single objects" | A file system with folders inside folders |
| 9 | **Decorator** | "I need to add features without changing the original" | Adding toppings to a plain burger |
| 10 | **Facade** | "This system is too complex, give me a simple face" | A waiter who handles the complicated kitchen |
| 11 | **Flyweight** | "I have too many objects, share what's common" | A library sharing books instead of owning them |
| 12 | **Proxy** | "I need a stand-in for the real thing" | A credit card — proxy for real money |

### 🧠 Behavioral Patterns — "How do things communicate?"
These patterns deal with how objects interact and distribute responsibility.

| # | Pattern | What It Solves | Story |
|---|---------|---------------|-------|
| 13 | **Chain of Responsibility** | "Let the right handler figure it out" | Customer support — level 1, level 2, level 3 |
| 14 | **Command** | "Turn a request into an object" | A waiter taking your order on a pad |
| 15 | **Interpreter** | "I need a mini-language" | A calculator that reads "five plus three" |
| 16 | **Iterator** | "Let me go through items one by one" | A playlist shuffling through songs |
| 17 | **Mediator** | "Stop talking to each other, talk to me" | An air traffic controller |
| 18 | **Memento** | "Let me save and restore my state" | A save point in a video game |
| 19 | **Observer** | "Notify me when something changes" | YouTube subscribers getting notifications |
| 20 | **State** | "My behavior changes when my state changes" | A traffic light changing colors |
| 21 | **Strategy** | "Let me swap algorithms at runtime" | Choosing a different route on Google Maps |
| 22 | **Template Method** | "I have the skeleton, you fill in the steps" | A recipe — cook, add spices, serve |
| 23 | **Visitor** | "Let me add operations to a group of classes" | A museum visitor looking at different exhibits |

---

## 🎯 How to Use This Project

```bash
# Compile any pattern
javac src/patterns/creational/singleton/*.java

# Run it
java src.patterns.creational.singleton.SingletonPattern
```

Or simply open the project in IntelliJ IDEA and click the green ▶️ button on any pattern file.

---

## 📚 The Three Categories Explained

### 🏗️ Creational — The Art of Creation
Think of these patterns as different ways to *birth* objects. Sometimes you need exactly one (Singleton). Sometimes you want the flexibility to create different types without knowing the exact class (Factory). Sometimes you need to build something complex step-by-step (Builder). These patterns remove the stress of "how do I make this thing?" from your code.

### 🔗 Structural — The Art of Organization
Ever tried to fit a square peg in a round hole? That's what structural patterns solve. They help you organize classes and objects into larger, working structures. They're the glue, the bridges, and the shortcuts that make complex systems feel simple.

### 🧠 Behavioral — The Art of Communication
Objects need to talk to each other. But if everyone talks to everyone, you get chaos. Behavioral patterns bring order to the conversation. They define clear protocols for who talks to whom, when, and how.

---

## 💡 A Note from a Senior Developer

*"I've been writing Java for over two decades. I've seen codebases that made me cry and codebases that made me smile. The difference? Patterns. Not because patterns are magic, but because they give you a vocabulary. When a junior dev says 'I think we need an Adapter here,' everyone knows what they mean. You don't need to explain it every time. That's the real power of patterns — they're a shared language that lets teams move faster."*

---

## 🧭 Your Learning Path

| Level | Patterns to Learn | Why |
|-------|-------------------|-----|
| 🟢 Beginner | Singleton, Factory, Adapter, Observer, Strategy | You'll use these weekly |
| 🟡 Intermediate | Builder, Decorator, Facade, Command, State, Proxy | You'll use these monthly |
| 🔴 Advanced | Abstract Factory, Prototype, Bridge, Composite, Flyweight, Chain, Mediator, Memento, Template, Visitor, Interpreter | You'll use these when you need them |

---

## 🏃‍♂️ Ready to Start?

Pick a pattern and dive in. Every folder is self-contained. Read the story, look at the diagram, run the code. That's the order — story first, then diagram, then code. Your brain learns better that way.

Welcome to the journey. After 23 patterns, you'll never look at code the same way again.

---

*"Design patterns are not about having a solution. They're about having a language to describe the problem."* — Someone wise, probably a GoF member