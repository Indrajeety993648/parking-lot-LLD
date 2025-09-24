import java.util.*;

/**
 * Main class representing the entire parking lot system
 * Manages floors, gates, and slot allocation strategy using Strategy pattern
 */
public class ParkingLot {
    private final List<Floor> floors;
    private final List<EntryGate> entryGates;
    private final List<ExitGate> exitGates;
    private int ticketCounter = 1;

    // Strategy pattern for parking allocation
    private ParkingStrategy parkingStrategy;

    // Efficient data structure for slot allocation - TreeSet for O(log n)
    // operations
    // Map vehicle size to available slots sorted by distance
    private final Map<VehicleSize, TreeSet<Slot>> availableSlots;

    public ParkingLot() {
        this.floors = new ArrayList<>();
        this.entryGates = new ArrayList<>();
        this.exitGates = new ArrayList<>();
        this.availableSlots = new HashMap<>();

        // Default strategy is nearest parking
        this.parkingStrategy = new NearestParkingStrategy();

        // Initialize TreeSets for each vehicle size
        for (VehicleSize size : VehicleSize.values()) {
            availableSlots.put(size, new TreeSet<>(Comparator
                    .comparingInt((Slot s) -> s.getDistanceToGate(0))
                    .thenComparing(Slot::getId)));
        }
    }

    /**
     * Constructor with custom parking strategy
     * 
     * @param strategy The parking allocation strategy to use
     */
    public ParkingLot(ParkingStrategy strategy) {
        this();
        this.parkingStrategy = strategy;
        System.out.println("ParkingLot initialized with: " + strategy.getStrategyName());
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
        // Add all slots from the floor to available slots
        for (Slot slot : floor.getSlots()) {
            availableSlots.get(slot.getSize()).add(slot);
        }
        System.out.println("Added floor " + floor.getFloorNumber() +
                " with " + floor.getSlots().size() + " slots");
    }

    public void addEntryGate(EntryGate gate) {
        entryGates.add(gate);
        System.out.println("Added entry gate: " + gate.getId());
    }

    public void addExitGate(ExitGate gate) {
        exitGates.add(gate);
        System.out.println("Added exit gate: " + gate.getId());
    }

    public int nextTicketId() {
        return ticketCounter++;
    }

    /**
     * Allocates a slot using the current parking strategy
     * 
     * @param vehicle The vehicle requesting parking
     * @param gateId  The gate ID (for distance calculation)
     * @return Allocated slot or null if no suitable slot available
     */
    public Slot allocateSlot(Vehicle vehicle, int gateId) {
        return parkingStrategy.allocateSlot(vehicle, gateId, availableSlots);
    }

    /**
     * Sets a new parking strategy
     * 
     * @param strategy The new parking strategy to use
     */
    public void setParkingStrategy(ParkingStrategy strategy) {
        this.parkingStrategy = strategy;
        System.out.println("Parking strategy changed to: " + strategy.getStrategyName());
    }

    /**
     * Gets the current parking strategy
     * 
     * @return The current parking strategy
     */
    public ParkingStrategy getParkingStrategy() {
        return parkingStrategy;
    }

    /**
     * Releases a slot back to the available slots pool
     * 
     * @param slot The slot to release
     */
    public void releaseSlot(Slot slot) {
        availableSlots.get(slot.getSize()).add(slot);
        System.out.println("Released slot " + slot.getId() + " back to available pool");
    }

    /**
     * Gets current status of the parking lot
     */
    public void printStatus() {
        System.out.println("\n=== PARKING LOT STATUS ===");
        System.out.println("Total floors: " + floors.size());
        System.out.println("Entry gates: " + entryGates.size());
        System.out.println("Exit gates: " + exitGates.size());

        for (VehicleSize size : VehicleSize.values()) {
            int available = (int) availableSlots.get(size).stream()
                    .filter(slot -> !slot.isOccupied()).count();
            int total = availableSlots.get(size).size();
            System.out.println(size + " slots - Available: " + available + "/" + total);
        }
        System.out.println("========================\n");
    }

    // Getters
    public List<Floor> getFloors() {
        return floors;
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public List<ExitGate> getExitGates() {
        return exitGates;
    }
}