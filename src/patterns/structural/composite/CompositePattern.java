/**
 * 🌳 Composite Pattern
 * 
 * Story: A file system — files and folders both support the same operations.
 * You can "delete" a file or a folder the same way. Delete a folder, and
 * everything inside gets deleted too. Recursive!
 * 
 * What it does: Lets you compose objects into tree structures and treat
 * individual objects and groups of objects uniformly.
 */

import java.util.ArrayList;
import java.util.List;

// ────────────────────────────────────────────────────────
// 1. Component Interface — what ALL items can do
//    Both File and Folder implement this
// ────────────────────────────────────────────────────────

interface FileSystemItem {
    String getName();
    int getSize();
    void delete();
    void display(String indent);
}

// ────────────────────────────────────────────────────────
// 2. Leaf — a single file. Can't contain children.
// ────────────────────────────────────────────────────────

class File implements FileSystemItem {
    private String name;
    private int size;  // in KB

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getSize() { return size; }

    @Override
    public void delete() {
        System.out.println("   🗑️ Deleting file: " + name + " (" + size + "KB)");
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "📄 " + name + " (" + size + "KB)");
    }
}

// ────────────────────────────────────────────────────────
// 3. Composite — a folder. CAN contain children (files or sub-folders)
// ────────────────────────────────────────────────────────

class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    public void remove(FileSystemItem item) {
        children.remove(item);
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getSize() {
        // Total size = sum of all children's sizes (recursive!)
        int totalSize = 0;
        for (FileSystemItem item : children) {
            totalSize += item.getSize();
        }
        return totalSize;
    }

    @Override
    public void delete() {
        // First delete ALL children (recursive!)
        for (FileSystemItem item : children) {
            item.delete();  // ← If child is a Folder, this calls Folder.delete() → recursive!
        }
        // Then delete the folder itself
        System.out.println("   🗑️ Deleting folder: " + name);
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "📁 " + name + "/ (" + getSize() + "KB)");
        for (FileSystemItem item : children) {
            item.display(indent + "   ");
        }
    }
}

// ────────────────────────────────────────────────────────
// 4. The Demo — build a file system tree!
// ────────────────────────────────────────────────────────

public class CompositePattern {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   Composite Pattern Demo                      ║");
        System.out.println("║   \"File System — Folders Inside Folders\"     ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("📂 Building a file system tree...");
        System.out.println();

        // Create files
        File readme = new File("README.md", 5);
        File mainJava = new File("Main.java", 3);
        File image1 = new File("logo.png", 120);
        File image2 = new File("banner.png", 250);
        File data = new File("data.csv", 45);
        File config = new File("config.xml", 8);
        File oldReport = new File("report_2023.doc", 200);
        File temp = new File("temp.tmp", 2);

        // Create folders and build hierarchy
        Folder root = new Folder("project");
        Folder src = new Folder("src");
        Folder images = new Folder("images");
        Folder docs = new Folder("docs");
        Folder archive = new Folder("archive");
        Folder emptyFolder = new Folder("empty_stuff");

        // Build the tree: root → src, images, docs, archive
        root.add(src);
        root.add(images);
        root.add(docs);
        root.add(archive);
        root.add(emptyFolder);

        // src contains files
        src.add(readme);
        src.add(mainJava);

        // images contains files
        images.add(image1);
        images.add(image2);

        // docs contains a file and a sub-folder (archive)
        docs.add(data);
        docs.add(config);

        // archive contains old files
        archive.add(oldReport);
        archive.add(temp);

        // Display the full tree
        System.out.println("📋 File System Tree:");
        System.out.println("   (Files and folders share the same interface)");
        System.out.println();
        root.display("");

        // Show recursive size calculation
        System.out.println();
        System.out.println("📊 Size Calculation (recursive!):");
        System.out.println("   Total project size: " + root.getSize() + "KB");
        System.out.println("   docs folder size: " + docs.getSize() + "KB");
        System.out.println("   archive folder size: " + archive.getSize() + "KB");
        System.out.println("   empty_folder size: " + emptyFolder.getSize() + "KB");

        // Delete the archive folder
        System.out.println();
        System.out.println("🗑️ Deleting 'archive' folder (this will delete everything inside!):");
        archive.delete();

        System.out.println();
        System.out.println("📋 Updated file system:");
        root.display("");

        System.out.println();
        System.out.println("💡 Notice: We called delete() on BOTH files and folders.");
        System.out.println("   A file deletes itself. A folder deletes children + itself.");
        System.out.println("   Same interface. Different behavior. That's Composite!");
    }
}