
public abstract class SlotDecorator implements Slot {
    protected final Slot slot;

    public SlotDecorator(Slot slot) {
        this.slot = slot;
    }

    @Override
    public int getId() {
        return slot.getId();
    }

    @Override
    public VehicleSize getSize() {
        return slot.getSize();
    }

    @Override
    public boolean isOccupied() {
        return slot.isOccupied();
    }

    @Override
    public void occupy() {
        slot.occupy();
    }

    @Override
    public void vacate() {
        slot.vacate();
    }

    @Override
    public double getBaseRate() {
        return slot.getBaseRate();
    }

    @Override
    public int getDistanceToGate(int gateId) {
        return slot.getDistanceToGate(gateId);
    }

    @Override
    public int compareTo(Slot other) {
        return slot.compareTo(other);
    }
}