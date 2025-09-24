import java.util.*;

/**
 * Nearest parking strategy - allocates the slot closest to the entry gate
 * This is the default strategy that prioritizes convenience for customers
 */
public class NearestParkingStrategy implements ParkingStrategy {

    @Override
    public Slot allocateSlot(Vehicle vehicle, int gateId, Map<VehicleSize, TreeSet<Slot>> availableSlots) {
        // Check slots from vehicle size upwards (small vehicle can use larger slot)
        for (VehicleSize size : VehicleSize.values()) {
            if (size.ordinal() >= vehicle.getSize().ordinal()) {
                TreeSet<Slot> slots = availableSlots.get(size);

                // Find first available slot (TreeSet is sorted by distance)
                Iterator<Slot> iterator = slots.iterator();
                while (iterator.hasNext()) {
                    Slot slot = iterator.next();
                    if (!slot.isOccupied()) {
                        iterator.remove(); // Remove from available slots
                        System.out.println("NearestStrategy: Allocated slot " + slot.getId() +
                                " (distance: " + slot.getDistanceToGate(gateId) +
                                ", size: " + slot.getSize() +
                                ", features: " + slot.getFeatures() +
                                ") to vehicle " + vehicle.getId());
                        return slot;
                    }
                }
            }
        }

        System.out.println("NearestStrategy: No suitable slot available for vehicle: " + vehicle);
        return null;
    }

    @Override
    public String getStrategyName() {
        return "Nearest Parking Strategy";
    }
}