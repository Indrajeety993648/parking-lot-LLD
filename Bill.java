import java.time.LocalDateTime;

/**
 * Represents a parking bill generated when a vehicle exits the parking lot
 */
public class Bill {
    private final Ticket ticket;
    private final LocalDateTime exitTime;
    private final double totalAmount;

    public Bill(Ticket ticket, LocalDateTime exitTime, double totalAmount) {
        this.ticket = ticket;
        this.exitTime = exitTime;
        this.totalAmount = totalAmount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Bill{ticket=" + ticket.getId() + ", exitTime=" + exitTime +
                ", totalAmount=" + totalAmount + "}";
    }
}