/**
 * Represents a vehicle in the parking lot system
 */
public class Vehicle {
    private final String id;
    private final VehicleSize size;

    public Vehicle(String id, VehicleSize size) {
        this.id = id;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public VehicleSize getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Vehicle{id='" + id + "', size=" + size + "}";
    }
}