import java.time.LocalDateTime;
import java.time.Duration;

/**
 * Represents an exit gate where vehicles leave the parking lot
 */
public class ExitGate {
    private final int id;

    public ExitGate(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * Generates a bill for a vehicle exiting the parking lot
     * 
     * @param lot    The parking lot system
     * @param ticket The ticket of the exiting vehicle
     * @return Bill with calculated charges
     */
    public Bill generateBill(ParkingLot lot, Ticket ticket) {
        Slot slot = ticket.getSlot();
        slot.vacate();

        LocalDateTime exitTime = LocalDateTime.now();
        long hours = Duration.between(ticket.getEntryTime(), exitTime).toHours();
        if (hours == 0)
            hours = 1; // Minimum 1 hour charge

        double baseCharges = slot.getBaseRate() * hours;
        double extraCharges = slot.getExtraCharges(hours);
        double totalAmount = baseCharges + extraCharges;

        lot.releaseSlot(slot);

        Bill bill = new Bill(ticket, exitTime, totalAmount);
        System.out.println("Bill generated: " + bill);
        System.out.println("Base charges: $" + baseCharges +
                ", Extra charges: $" + extraCharges +
                ", Total: $" + totalAmount);
        return bill;
    }

    @Override
    public String toString() {
        return "ExitGate{id=" + id + "}";
    }
}