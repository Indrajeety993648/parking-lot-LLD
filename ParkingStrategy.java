/**
 * Strategy interface for different parking slot allocation strategies
 */
public interface ParkingStrategy {
    /**
     * Allocates the best available slot based on the strategy
     * 
     * @param vehicle        The vehicle requesting parking
     * @param gateId         The entry gate ID
     * @param availableSlots Map of available slots by vehicle size
     * @return The allocated slot or null if no suitable slot found
     */
    Slot allocateSlot(Vehicle vehicle, int gateId, java.util.Map<VehicleSize, java.util.TreeSet<Slot>> availableSlots);

    /**
     * Gets the name of the strategy
     * 
     * @return Strategy name
     */
    String getStrategyName();
}