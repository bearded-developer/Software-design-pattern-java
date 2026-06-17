/**
 * 🌉 Bridge Pattern
 * 
 * Story: A TV and its remote control — any remote works with any TV.
 * Separate the abstraction (remote) from the implementation (device).
 * 
 * What it does: Decouples an abstraction from its implementation so both
 * can vary independently. No more class explosion (TV_with_BasicRemote,
 * TV_with_VoiceRemote, Radio_with_BasicRemote...).
 */

// ────────────────────────────────────────────────────────
// 1. Implementor Interface — what devices do
// ────────────────────────────────────────────────────────

interface Device {
    void powerOn();
    void powerOff();
    void setVolume(int percent);
    boolean isPoweredOn();
    int getVolume();
}

// ────────────────────────────────────────────────────────
// 2. Concrete Implementors — actual devices
// ────────────────────────────────────────────────────────

class TV implements Device {
    private boolean on = false;
    private int volume = 10;

    @Override
    public void powerOn() {
        on = true;
        System.out.println("📺 TV: Powering ON. Welcome to Netflix & chill.");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println("📺 TV: Powering OFF. Goodnight!");
    }

    @Override
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("📺 TV: Volume set to " + volume + "%");
    }

    @Override
    public boolean isPoweredOn() { return on; }

    @Override
    public int getVolume() { return volume; }
}

class Radio implements Device {
    private boolean on = false;
    private int volume = 5;

    @Override
    public void powerOn() {
        on = true;
        System.out.println("📻 Radio: Tuning in. Playing some smooth jazz.");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println("📻 Radio: Off. Silence is golden.");
    }

    @Override
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("📻 Radio: Volume set to " + volume + "%");
    }

    @Override
    public boolean isPoweredOn() { return on; }

    @Override
    public int getVolume() { return volume; }
}

class Projector implements Device {
    private boolean on = false;
    private int volume = 0;

    @Override
    public void powerOn() {
        on = true;
        System.out.println("📽️ Projector: Lights off. Movie starting!");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println("📽️ Projector: Shutting down. Great film!");
    }

    @Override
    public void setVolume(int percent) {
        volume = Math.max(0, Math.min(100, percent));
        System.out.println("📽️ Projector: Speakers at " + volume + "%");
    }

    @Override
    public boolean isPoweredOn() { return on; }

    @Override
    public int getVolume() { return volume; }
}

// ────────────────────────────────────────────────────────
// 3. Abstraction — the remote control (the BRIDGE)
//    It HAS a device, but doesn't care which one
// ────────────────────────────────────────────────────────

abstract class RemoteControl {
    protected Device device;  // ← THE BRIDGE: remote contains a device

    public RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void turnOn();
    public abstract void turnOff();
    public abstract void volumeUp();
    public abstract void volumeDown();
}

// ────────────────────────────────────────────────────────
// 4. Refined Abstractions — different kinds of remotes
// ────────────────────────────────────────────────────────

class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        System.out.print("   [Basic Remote] Pressing power button... ");
        device.powerOn();
    }

    @Override
    public void turnOff() {
        System.out.print("   [Basic Remote] Pressing power button... ");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        System.out.print("   [Basic Remote] Volume + ");
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void volumeDown() {
        System.out.print("   [Basic Remote] Volume - ");
        device.setVolume(device.getVolume() - 10);
    }
}

class VoiceRemote extends RemoteControl {
    public VoiceRemote(Device device) {
        super(device);
    }

    @Override
    public void turnOn() {
        System.out.print("   🎤 [Voice Remote] 'Hey device, turn on'... ");
        device.powerOn();
    }

    @Override
    public void turnOff() {
        System.out.print("   🎤 [Voice Remote] 'Hey device, turn off'... ");
        device.powerOff();
    }

    @Override
    public void volumeUp() {
        System.out.print("   🎤 [Voice Remote] 'Hey device, volume up'... ");
        device.setVolume(device.getVolume() + 15);
    }

    @Override
    public void volumeDown() {
        System.out.print("   🎤 [Voice Remote] 'Hey device, volume down'... ");
        device.setVolume(device.getVolume() - 15);
    }
}

// ────────────────────────────────────────────────────────
// 5. The Demo — mix and match!
// ────────────────────────────────────────────────────────

public class BridgePattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   Bridge Pattern Demo                        ║");
        System.out.println("║   \"Any Remote Works With Any Device\"         ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println();

        System.out.println("🎮 Available Devices: TV, Radio, Projector");
        System.out.println("🎮 Available Remotes: Basic, Voice");
        System.out.println("   Total combinations: 3 x 2 = 6");
        System.out.println("   Classes needed: 3 (devices) + 2 (remotes) + 1 (bridge) = 6");
        System.out.println("   Without Bridge: 3 x 2 = 6 classes!");
        System.out.println("   (Add 1 more device or remote, and Bridge pulls ahead!)");
        System.out.println();

        // Mix 1: TV with Basic Remote
        System.out.println("🔄 COMBINATION 1: TV + Basic Remote");
        Device tv = new TV();
        RemoteControl basicForTV = new BasicRemote(tv);
        basicForTV.turnOn();
        basicForTV.volumeUp();
        basicForTV.turnOff();
        System.out.println();

        // Mix 2: Radio with Voice Remote
        System.out.println("🔄 COMBINATION 2: Radio + Voice Remote");
        Device radio = new Radio();
        RemoteControl voiceForRadio = new VoiceRemote(radio);
        voiceForRadio.turnOn();
        voiceForRadio.volumeUp();
        voiceForRadio.volumeDown();
        voiceForRadio.turnOff();
        System.out.println();

        // Mix 3: Projector with Voice Remote
        System.out.println("🔄 COMBINATION 3: Projector + Voice Remote");
        Device projector = new Projector();
        RemoteControl voiceForProjector = new VoiceRemote(projector);
        voiceForProjector.turnOn();
        voiceForProjector.volumeUp();
        voiceForProjector.turnOff();
        System.out.println();

        System.out.println("💡 Any remote works with any device.");
        System.out.println("   Add a new device? Devices don't change.");
        System.out.println("   Add a new remote? Remotes don't change.");
        System.out.println("   That's the Bridge pattern — independent evolution!");
    }
}