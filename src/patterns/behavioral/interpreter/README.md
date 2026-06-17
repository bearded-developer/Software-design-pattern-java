# 📖 Interpreter Pattern

## The Calculator That Understands "Five Plus Three"

### 📖 The Story
You want a calculator that can parse "3 4 +" and understand it means "add 3 and 4". You define a mini-language with grammar rules: numbers are terminal expressions, operators are non-terminal that combine them. The interpreter reads the language and evaluates it.

**In software terms: Given a language, define a grammar and an interpreter that evaluates sentences in it.**

### ✅ When to Use
- When you have a simple language to interpret
- When the grammar is stable and not too complex
- When you need to evaluate expressions repeatedly

### ⚖️ Pros vs Cons
| ✅ Pros | ❌ Cons |
|---------|--------|
| Easy to define new expressions | Complex grammars are hard to maintain |
| Grammar is explicit and changeable | Many classes for complex languages |