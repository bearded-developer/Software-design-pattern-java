/**
 * ⛓️ Chain of Responsibility Pattern
 * 
 * Story: Customer support — Junior → Senior → Manager.
 * Each level tries to handle the problem. If they can't, they pass it up.
 * 
 * What it does: Passes a request along a chain of handlers until one handles it.
 */

// 1. The Request
class SupportTicket {
    private String issue;
    private int severity;  // 1 = easy, 5 = very hard

    public SupportTicket(String issue, int severity) {
        this.issue = issue;
        this.severity = severity;
    }

    public String getIssue() { return issue; }
    public int getSeverity() { return severity; }
}

// 2. Handler
abstract class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNext(SupportHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void handle(SupportTicket ticket);
}

// 3. Concrete Handlers
class JuniorSupport extends SupportHandler {
    @Override
    public void handle(SupportTicket ticket) {
        if (ticket.getSeverity() <= 2) {
            System.out.println("   🟢 Junior: Handled '" + ticket.getIssue() + "' (easy fix!)");
        } else if (nextHandler != null) {
            System.out.println("   🟡 Junior: Escalating '" + ticket.getIssue() + "' to Senior...");
            nextHandler.handle(ticket);
        }
    }
}

class SeniorSupport extends SupportHandler {
    @Override
    public void handle(SupportTicket ticket) {
        if (ticket.getSeverity() <= 4) {
            System.out.println("   🔵 Senior: Investigating '" + ticket.getIssue() + "'... Resolved!");
        } else if (nextHandler != null) {
            System.out.println("   🟠 Senior: Escalating '" + ticket.getIssue() + "' to Manager...");
            nextHandler.handle(ticket);
        }
    }
}

class Manager extends SupportHandler {
    @Override
    public void handle(SupportTicket ticket) {
        System.out.println("   🔴 Manager: Handling '" + ticket.getIssue() + "' personally!");
    }
}

// 4. Demo
public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   Chain of Responsibility Pattern Demo       ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println();

        // Build the chain
        SupportHandler junior = new JuniorSupport();
        SupportHandler senior = new SeniorSupport();
        SupportHandler manager = new Manager();
        junior.setNext(senior);
        senior.setNext(manager);

        // Create tickets
        SupportTicket[] tickets = {
            new SupportTicket("Forgot password", 1),
            new SupportTicket("Refund for $50", 3),
            new SupportTicket("Legal lawsuit", 5),
            new SupportTicket("Change username", 2)
        };

        for (SupportTicket ticket : tickets) {
            System.out.println("📞 Issue: '" + ticket.getIssue() + "' (severity: " + ticket.getSeverity() + ")");
            junior.handle(ticket);
            System.out.println();
        }

        System.out.println("💡 Each ticket found the RIGHT handler automatically!");
    }
}