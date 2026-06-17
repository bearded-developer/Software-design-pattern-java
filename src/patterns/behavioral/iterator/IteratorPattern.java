/**
 * 🔄 Iterator Pattern
 * 
 * Story: A playlist shuffling through songs. You don't know HOW the playlist
 * stores songs (array? list? database?). You just know you can go NEXT.
 * 
 * What it does: Provides a way to access elements of a collection sequentially
 * without exposing the underlying structure.
 */

import java.util.ArrayList;
import java.util.List;

// 1. Iterator Interface
interface SongIterator {
    boolean hasNext();
    String next();
}

// 2. Collection
class Playlist {
    private List<String> songs = new ArrayList<>();
    
    public void addSong(String song) { songs.add(song); }
    
    public SongIterator createIterator() {
        return new SequentialIterator(songs);
    }
}

// 3. Concrete Iterator
class SequentialIterator implements SongIterator {
    private List<String> songs;
    private int position = 0;
    
    public SequentialIterator(List<String> songs) { this.songs = songs; }
    
    public boolean hasNext() { return position < songs.size(); }
    
    public String next() { return songs.get(position++); }
}

// 4. Demo
public class IteratorPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Iterator Pattern Demo                  ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        Playlist playlist = new Playlist();
        playlist.addSong("Bohemian Rhapsody");
        playlist.addSong("Stairway to Heaven");
        playlist.addSong("Hotel California");
        playlist.addSong("Imagine");

        System.out.println("🎵 Playing songs one by one:");
        SongIterator it = playlist.createIterator();
        while (it.hasNext()) {
            System.out.println("   ▶️ Now playing: " + it.next());
        }
        
        System.out.println("\n💡 We iterated without knowing HOW songs are stored!");
    }
}