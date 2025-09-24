import java.time.LocalDateTime;

/**
 * Represents an entry gate where vehicles enter the parking lot
 */
public class EntryGate {
    private final int id;

    public EntryGate(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * Generates a ticket for a vehicle entering the parking lot
     * 
     * @param lot     The parking lot system
     * @param vehicle The vehicle entering
     * @return Ticket if slot allocated successfully, null otherwise
     */
    public Ticket generateTicket(ParkingLot lot, Vehicle vehicle) {
        Slot slot = lot.allocateSlot(vehicle, id);
        if (slot == null) {
            System.out.println("No available slot for vehicle: " + vehicle);
            return null;
        }

        slot.occupy();
        Ticket ticket = new Ticket(lot.nextTicketId(), slot, vehicle, LocalDateTime.now());
        System.out.println("Ticket generated: " + ticket);
        return ticket;
    }

    @Override
    public String toString() {
        return "EntryGate{id=" + id + "}";
    }
}