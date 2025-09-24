/**
 * Basic implementation of a parking slot without any extra features
 */
public class BasicSlot implements Slot {
    private final int id;
    private final VehicleSize size;
    private boolean occupied;
    private final double baseRate;
    private final int distanceToGate;

    public BasicSlot(int id, VehicleSize size, double baseRate, int distanceToGate) {
        this.id = id;
        this.size = size;
        this.baseRate = baseRate;
        this.distanceToGate = distanceToGate;
        this.occupied = false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public VehicleSize getSize() {
        return size;
    }

    @Override
    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public void occupy() {
        occupied = true;
    }

    @Override
    public void vacate() {
        occupied = false;
    }

    @Override
    public double getBaseRate() {
        return baseRate;
    }

    @Override
    public double getExtraCharges(long hours) {
        return 0;
    }

    @Override
    public String getFeatures() {
        return "Basic";
    }

    @Override
    public int getDistanceToGate(int gateId) {
        return distanceToGate;
    }

    @Override
    public int compareTo(Slot other) {
        // Compare by distance first, then by id for consistency
        int distanceComparison = Integer.compare(this.distanceToGate, other.getDistanceToGate(0));
        if (distanceComparison == 0) {
            return Integer.compare(this.id, other.getId());
        }
        return distanceComparison;
    }

    @Override
    public String toString() {
        return "BasicSlot{id=" + id + ", size=" + size + ", occupied=" + occupied +
                ", baseRate=" + baseRate + ", distance=" + distanceToGate + "}";
    }
}