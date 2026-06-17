/**
 * 🪶 Flyweight Pattern
 * 
 * Story: A library that shares books — everyone reads the same copy.
 * The book's content (intrinsic) is shared. Who's reading and which page (extrinsic) is unique.
 * 
 * What it does: Shares common parts of objects across many uses to save memory.
 * "Don't create the same thing twice — reuse it."
 */

import java.util.HashMap;
import java.util.Map;

// ────────────────────────────────────────────────────────
// 1. Flyweight — the shared book (intrinsic state)
// ────────────────────────────────────────────────────────

class Book {
    private String title;      // Intrinsic — same for everyone
    private String author;     // Intrinsic — same for everyone
    private String isbn;       // Intrinsic — same for everyone

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        // Imagine this constructor does heavy work — loading from database, etc.
        System.out.println("   📚 [LOADING] Creating NEW book: \"" + title + "\" by " + author);
    }

    // The extrinsic state (reader name, page number) is passed as parameters
    public void read(String readerName, int page) {
        System.out.println("   👤 " + readerName + " is reading \"" + title 
                         + "\" at page " + page);
    }

    public String getTitle() { return title; }
}

// ────────────────────────────────────────────────────────
// 2. Flyweight Factory — manages shared book instances
//    Ensures each unique book is created only ONCE
// ────────────────────────────────────────────────────────

class Library {
    private Map<String, Book> books = new HashMap<>();

    public Book getBook(String title, String author, String isbn) {
        // Check if we already have this book
        if (!books.containsKey(isbn)) {
            // Create a new book only if it doesn't exist
            books.put(isbn, new Book(title, author, isbn));
        } else {
            System.out.println("   ♻️ [REUSING] Book \"" + title + "\" already exists in library!");
        }
        return books.get(isbn);  // Return the shared instance
    }

    public int getTotalUniqueBooks() {
        return books.size();
    }
}

// ────────────────────────────────────────────────────────
// 3. The Demo — 10 people reading 3 books
// ────────────────────────────────────────────────────────

public class FlyweightPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   Flyweight Pattern Demo                     ║");
        System.out.println("║   \"The Library That Shares Books\"            ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("📖 Welcome to Pattern Library!");
        System.out.println("   We have many readers but only need ONE copy of each book.");
        System.out.println();

        Library library = new Library();

        System.out.println("👥 10 readers want to read 3 different books:");
        System.out.println("   - Harry Potter (5 readers)");
        System.out.println("   - Lord of the Rings (3 readers)");
        System.out.println("   - 1984 (2 readers)");
        System.out.println();

        // 5 people read Harry Potter — only 1 book object needed!
        System.out.println("📚 READINGS:");
        Book hp = library.getBook("Harry Potter", "J.K. Rowling", "HP-001");
        hp.read("Alice", 42);
        hp.read("Bob", 107);
        hp.read("Charlie", 15);
        hp.read("Diana", 203);
        hp.read("Eve", 88);
        System.out.println();

        // 3 people read Lord of the Rings
        Book lotr = library.getBook("Lord of the Rings", "J.R.R. Tolkien", "LOTR-001");
        lotr.read("Frank", 150);
        lotr.read("Grace", 320);
        lotr.read("Hank", 1);
        System.out.println();

        // 2 people read 1984
        Book nineteen84 = library.getBook("1984", "George Orwell", "1984-001");
        nineteen84.read("Ivy", 50);
        nineteen84.read("Jack", 199);
        System.out.println();

        // Let someone request an already-created book again
        System.out.println("🔄 Someone else wants Harry Potter (should reuse):");
        Book hpAgain = library.getBook("Harry Potter", "J.K. Rowling", "HP-001");
        hpAgain.read("Karen", 256);

        System.out.println();
        System.out.println("📊 STATS:");
        System.out.println("   Total readers: 10");
        System.out.println("   Unique books created: " + library.getTotalUniqueBooks() + " (NOT 10!)");
        System.out.println("   Memory saved: " + (10 - library.getTotalUniqueBooks()) + " book objects!");
        System.out.println();
        System.out.println("💡 Without Flyweight: 10 book objects in memory.");
        System.out.println("   With Flyweight: Only 3 book objects (shared across 10 readers).");
        System.out.println("   Same content, shared. Unique context, separate.");
        System.out.println("   That's the Flyweight pattern — sharing is caring!");
    }
}