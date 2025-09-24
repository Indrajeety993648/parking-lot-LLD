/**
 * Decorator that adds cleaning service functionality to a parking slot
 */
public class CleaningDecorator extends SlotDecorator {
    private final double cleaningCharge;

    public CleaningDecorator(Slot slot, double cleaningCharge) {
        super(slot);
        this.cleaningCharge = cleaningCharge;
    }

    @Override
    public double getExtraCharges(long hours) {
        return slot.getExtraCharges(hours) + cleaningCharge;
    }

    @Override
    public String getFeatures() {
        String baseFeatures = slot.getFeatures();
        if ("Basic".equals(baseFeatures)) {
            return "Cleaning";
        }
        return baseFeatures + ", Cleaning";
    }

    @Override
    public String toString() {
        return "CleaningDecorator{slot=" + slot + ", cleaningCharge=" + cleaningCharge + "}";
    }
}