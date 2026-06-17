/**
 * 👁️ Observer Pattern
 * 
 * Story: YouTube — you subscribe to a channel. When the creator uploads,
 * ALL subscribers get notified. The creator doesn't care WHO subscribed,
 * just that everyone gets the update.
 * 
 * What it does: Defines a one-to-many dependency between objects so that
 * when one object changes state, all dependents are notified.
 */

import java.util.ArrayList;
import java.util.List;

// 1. Subject
class YouTubeChannel {
    private String name;
    private List<Subscriber> subscribers = new ArrayList<>();
    private String latestVideo;

    public YouTubeChannel(String name) { this.name = name; }

    public void subscribe(Subscriber sub) { subscribers.add(sub); }
    public void unsubscribe(Subscriber sub) { subscribers.remove(sub); }

    public void uploadVideo(String title) {
        this.latestVideo = title;
        System.out.println("📹 " + name + " uploaded: " + title);
        notifySubscribers();
    }

    private void notifySubscribers() {
        for (Subscriber sub : subscribers) {
            sub.update(name, latestVideo);
        }
    }
}

// 2. Observer Interface
interface Subscriber {
    void update(String channelName, String videoTitle);
}

// 3. Concrete Observers
class User implements Subscriber {
    private String name;
    public User(String name) { this.name = name; }
    
    public void update(String channel, String video) {
        System.out.println("   🔔 " + name + " got notification: '" + channel + "' uploaded '" + video + "'!");
    }
}

// 4. Demo
public class ObserverPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║   Observer Pattern Demo                  ║");
        System.out.println("╚══════════════════════════════════════════╝");
        System.out.println();

        YouTubeChannel channel = new YouTubeChannel("TechWithTim");
        
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        channel.subscribe(alice);
        channel.subscribe(bob);
        channel.subscribe(charlie);

        System.out.println("🎬 Channel uploads first video:");
        channel.uploadVideo("Java Design Patterns Explained");
        
        System.out.println("\n👋 Bob unsubscribes...");
        channel.unsubscribe(bob);
        
        System.out.println("\n🎬 Channel uploads again:");
        channel.uploadVideo("Kotlin vs Java 2025");

        System.out.println("\n💡 Bob didn't get the second notification (unsubscribed)");
    }
}