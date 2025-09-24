/**
 * Interface representing a parking slot with all its capabilities
 */
public interface Slot extends Comparable<Slot> {
    int getId();

    VehicleSize getSize();

    boolean isOccupied();

    void occupy();

    void vacate();

    double getBaseRate();

    double getExtraCharges(long hours);

    String getFeatures();

    int getDistanceToGate(int gateId);
}