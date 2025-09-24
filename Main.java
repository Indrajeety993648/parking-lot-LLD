/**
 * Main class demonstrating the parking lot system workflow
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== MULTILEVEL PARKING LOT SYSTEM DEMO ===\n");

        // Create parking lot system
        ParkingLot parkingLot = new ParkingLot();

        // Setup parking lot structure
        setupParkingLot(parkingLot);

        // Show initial status
        parkingLot.printStatus();

        // Create gates
        EntryGate entryGate1 = new EntryGate(1);
        EntryGate entryGate2 = new EntryGate(2);
        ExitGate exitGate1 = new ExitGate(1);

        parkingLot.addEntryGate(entryGate1);
        parkingLot.addEntryGate(entryGate2);
        parkingLot.addExitGate(exitGate1);

        // Demo workflow
        demonstrateWorkflow(parkingLot, entryGate1, entryGate2, exitGate1);
    }

    private static void setupParkingLot(ParkingLot parkingLot) {
        System.out.println("Setting up parking lot...\n");

        // Floor 1 - Ground floor
        Floor floor1 = new Floor(1);

        // Basic slots
        Slot slot1 = new BasicSlot(101, VehicleSize.SMALL, 5.0, 1);
        Slot slot2 = new BasicSlot(102, VehicleSize.MEDIUM, 8.0, 2);
        Slot slot3 = new BasicSlot(103, VehicleSize.LARGE, 12.0, 3);

        // Slots with charging feature
        Slot slot4 = new ChargingDecorator(
                new BasicSlot(104, VehicleSize.MEDIUM, 8.0, 4), 3.0);
        Slot slot5 = new ChargingDecorator(
                new BasicSlot(105, VehicleSize.LARGE, 12.0, 5), 5.0);

        // Slots with cleaning feature
        Slot slot6 = new CleaningDecorator(
                new BasicSlot(106, VehicleSize.SMALL, 5.0, 6), 10.0);

        // Slot with both charging and cleaning features
        Slot slot7 = new ChargingDecorator(
                new CleaningDecorator(
                        new BasicSlot(107, VehicleSize.LARGE, 12.0, 7), 15.0),
                5.0);

        floor1.addSlot(slot1);
        floor1.addSlot(slot2);
        floor1.addSlot(slot3);
        floor1.addSlot(slot4);
        floor1.addSlot(slot5);
        floor1.addSlot(slot6);
        floor1.addSlot(slot7);

        // Floor 2
        Floor floor2 = new Floor(2);
        Slot slot8 = new BasicSlot(201, VehicleSize.SMALL, 4.0, 8);
        Slot slot9 = new ChargingDecorator(
                new BasicSlot(202, VehicleSize.MEDIUM, 7.0, 9), 3.0);

        floor2.addSlot(slot8);
        floor2.addSlot(slot9);

        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);
    }

    private static void demonstrateWorkflow(ParkingLot parkingLot,
            EntryGate entryGate1,
            EntryGate entryGate2,
            ExitGate exitGate1) {
        System.out.println("=== DEMO WORKFLOW ===\n");

        // Create vehicles
        Vehicle car1 = new Vehicle("CAR-123", VehicleSize.SMALL);
        Vehicle suv1 = new Vehicle("SUV-456", VehicleSize.LARGE);
        Vehicle bike1 = new Vehicle("BIKE-789", VehicleSize.SMALL);
        Vehicle truck1 = new Vehicle("TRUCK-101", VehicleSize.LARGE);

        System.out.println("1. Vehicles entering parking lot:\n");

        // Vehicle 1 enters
        Ticket ticket1 = entryGate1.generateTicket(parkingLot, car1);

        // Vehicle 2 enters
        Ticket ticket2 = entryGate1.generateTicket(parkingLot, suv1);

        // Vehicle 3 enters
        Ticket ticket3 = entryGate2.generateTicket(parkingLot, bike1);

        // Vehicle 4 enters (might not find suitable slot if all large slots taken)
        Ticket ticket4 = entryGate2.generateTicket(parkingLot, truck1);

        // Show status after entries
        parkingLot.printStatus();

        // Simulate some time passing (in real system, hours would pass)
        System.out.println("2. Time passes... vehicles exit:\n");

        // Vehicles exit and generate bills
        if (ticket1 != null) {
            exitGate1.generateBill(parkingLot, ticket1);
            System.out.println();
        }

        if (ticket2 != null) {
            exitGate1.generateBill(parkingLot, ticket2);
            System.out.println();
        }

        if (ticket3 != null) {
            exitGate1.generateBill(parkingLot, ticket3);
            System.out.println();
        }

        if (ticket4 != null) {
            exitGate1.generateBill(parkingLot, ticket4);
            System.out.println();
        }

        // Final status
        parkingLot.printStatus();

        System.out.println("=== DEMO COMPLETED ===");

        // Show extensibility example
        demonstrateExtensibility();
    }

    private static void demonstrateExtensibility() {
        System.out.println("\n=== EXTENSIBILITY DEMO ===");
        System.out.println("The system is designed for easy extension:");
        System.out.println("1. New slot features can be added using Decorator pattern");
        System.out.println("2. New vehicle sizes can be added to VehicleSize enum");
        System.out.println("3. Different allocation strategies can be implemented");
        System.out.println("4. Additional floors and gates can be added dynamically");
        System.out.println("\nExample: Adding a Valet service decorator would be:");
        System.out.println("Slot valetSlot = new ValetDecorator(basicSlot, 20.0);");
        System.out.println("===========================");
    }

}