/**
 * Decorator that adds charging functionality to a parking slot
 */
public class ChargingDecorator extends SlotDecorator {
    private final double chargingRatePerHour;

    public ChargingDecorator(Slot slot, double chargingRatePerHour) {
        super(slot);
        this.chargingRatePerHour = chargingRatePerHour;
    }

    @Override
    public double getExtraCharges(long hours) {
        return slot.getExtraCharges(hours) + chargingRatePerHour * hours;
    }

    @Override
    public String getFeatures() {
        String baseFeatures = slot.getFeatures();
        if ("Basic".equals(baseFeatures)) {
            return "Charging";
        }
        return baseFeatures + ", Charging";
    }

    @Override
    public String toString() {
        return "ChargingDecorator{slot=" + slot + ", chargingRate=" + chargingRatePerHour + "}";
    }
}