/**
 * 🛡️ Proxy Pattern
 * 
 * Story: A credit card — it stands in for real money. You don't carry cash,
 * you carry a proxy. When you pay, the proxy handles it and later talks to the bank.
 * 
 * What it does: A surrogate that controls access to another object.
 * Can lazy-load, add security, log access, or cache results.
 */

// ────────────────────────────────────────────────────────
// 1. Subject Interface — what both real and proxy implement
// ────────────────────────────────────────────────────────

interface Video {
    void play();
    String getTitle();
}

// ────────────────────────────────────────────────────────
// 2. Real Subject — expensive to create (downloads from server)
// ────────────────────────────────────────────────────────

class RealVideo implements Video {
    private String title;
    private String hdContent;

    public RealVideo(String title) {
        this.title = title;
        loadFromServer();  // Expensive operation!
    }

    private void loadFromServer() {
        System.out.println("   🌐 [SERVER] Downloading '" + title + "' (500MB HD video)...");
        try {
            Thread.sleep(100);  // Simulate network delay
        } catch (InterruptedException e) {
            // ignore
        }
        System.out.println("   ✅ [SERVER] Download complete!");
        this.hdContent = "HD Video: " + title + " (high quality)";
    }

    @Override
    public void play() {
        System.out.println("   ▶️ Playing: " + hdContent);
    }

    @Override
    public String getTitle() { return title; }
}

// ────────────────────────────────────────────────────────
// 3. Proxy — lightweight stand-in. Lazy loads the real video.
//    Also adds logging (protection/logging proxy).
// ────────────────────────────────────────────────────────

class VideoProxy implements Video {
    private String title;
    private RealVideo realVideo;  // ← Not created yet! (lazy loading)
    private int playCount = 0;

    public VideoProxy(String title) {
        this.title = title;
        // Notice: NO downloading here! Fast and lightweight.
        System.out.println("   📁 [PROXY] Created proxy for '" + title + "' (instant!)");
    }

    @Override
    public void play() {
        playCount++;
        System.out.println("   📋 [PROXY] Log: Playing '" + title + "' — count #" + playCount);

        // Check age restriction (protection proxy behavior)
        System.out.println("   🛡️ [PROXY] Checking age restriction... Allowed!");

        // Lazy initialization — create the real video ONLY when first needed
        if (realVideo == null) {
            System.out.println("   🚀 [PROXY] First play! Loading real video now...");
            realVideo = new RealVideo(title);
        } else {
            System.out.println("   ♻️ [PROXY] Video already loaded. Reusing.");
        }

        // Delegate to the real video
        realVideo.play();
    }

    @Override
    public String getTitle() { return title; }

    public int getPlayCount() { return playCount; }
}

// ────────────────────────────────────────────────────────
// 4. Protection Proxy — controls access based on permissions
// ────────────────────────────────────────────────────────

class AgeRestrictedVideoProxy implements Video {
    private VideoProxy proxy;
    private int minimumAge;

    public AgeRestrictedVideoProxy(String title, int minimumAge) {
        this.proxy = new VideoProxy(title);
        this.minimumAge = minimumAge;
    }

    public boolean canWatch(int userAge) {
        if (userAge < minimumAge) {
            System.out.println("   🚫 [AGE CHECK] Sorry! You need to be " + minimumAge 
                             + " to watch '" + proxy.getTitle() + "'. You're " + userAge + ".");
            return false;
        }
        System.out.println("   ✅ [AGE CHECK] Age verified: " + userAge + " ≥ " + minimumAge);
        proxy.play();
        return true;
    }

    @Override
    public void play() {
        System.out.println("   ❓ [PROXY] Use canWatch(userAge) to check access first.");
    }

    @Override
    public String getTitle() { return proxy.getTitle(); }
}

// ────────────────────────────────────────────────────────
// 5. The Demo — let's watch some videos!
// ────────────────────────────────────────────────────────

public class ProxyPattern {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   Proxy Pattern Demo                          ║");
        System.out.println("║   \"The Credit Card — Proxy for Real Money\"    ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("🎬 Welcome to PatternFlix — Video Streaming!");
        System.out.println("   We use proxies to lazy-load videos and check age.");
        System.out.println();

        // 1. Virtual Proxy — lazy loading
        System.out.println("📀 CASE 1: Virtual Proxy (Lazy Loading)");
        System.out.println("   Creating a video proxy (no download yet)...");
        VideoProxy proxy = new VideoProxy("Design Patterns Explained");
        System.out.println();
        
        System.out.println("   ⏰ Later, user clicks 'play':");
        proxy.play();  // Downloads only now!
        System.out.println();
        
        System.out.println("   ⏰ User watches again (no re-download):");
        proxy.play();  // No download — reuse!
        System.out.println();

        // 2. Protection Proxy — age restriction
        System.out.println("🔞 CASE 2: Protection Proxy (Age Restriction)");
        AgeRestrictedVideoProxy adultVideo = new AgeRestrictedVideoProxy("18+ Horror Movie", 18);
        System.out.println();
        
        System.out.println("   👦 Kid (age 12) tries to watch:");
        adultVideo.canWatch(12);  // Blocked!
        System.out.println();
        
        System.out.println("   👨 Adult (age 25) tries to watch:");
        adultVideo.canWatch(25);  // Allowed!
        System.out.println();

        System.out.println("💡 Proxies let us add behavior WITHOUT changing the real object:");
        System.out.println("   ✅ Virtual Proxy: Loads video only on first play");
        System.out.println("   ✅ Protection Proxy: Checks age before playing");
        System.out.println("   ✅ Logging Proxy: Tracks play count");
        System.out.println("   The real Video class knows NOTHING about proxies!");
    }
}