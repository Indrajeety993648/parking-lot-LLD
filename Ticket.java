import java.time.LocalDateTime;

/**
 * Represents a parking ticket isued when a vehicle enters the parking lot
 */
public class Ticket {
    private final int id;
    private final Slot slot;
    private final Vehicle vehicle;
    private final LocalDateTime entryTime;

    public Ticket(int id, Slot slot, Vehicle vehicle, LocalDateTime entryTime) {
        this.id = id;
        this.slot = slot;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }

    public int getId() {
        return id;
    }

    public Slot getSlot() {
        return slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "Ticket{id=" + id + ", slot=" + slot.getId() +
                ", vehicle=" + vehicle.getId() + ", entryTime=" + entryTime + "}";
    }
}