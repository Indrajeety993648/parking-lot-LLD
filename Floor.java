import java.util.TreeSet;
import java.util.Comparator;

/**
 * Represents a floor in the parking lot containing multiple parking slots
 */
public class Floor {
    private final int floorNumber;
    private final TreeSet<Slot> slots;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        // TreeSet for efficient slot retrieval sorted by distance to gate
        this.slots = new TreeSet<>(Comparator
                .comparingInt((Slot s) -> s.getDistanceToGate(0))
                .thenComparing(Slot::getId));
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public TreeSet<Slot> getSlots() {
        return slots;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public void removeSlot(Slot slot) {
        slots.remove(slot);
    }

    @Override
    public String toString() {
        return "Floor{floorNumber=" + floorNumber + ", totalSlots=" + slots.size() + "}";
    }
}