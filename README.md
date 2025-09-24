# Multilevel Parking Lot System

A comprehensive Java implementation of a multilevel parking lot system using object-oriented design principles, SOLID principles, and design patterns.

## 📊 UML Class Diagram

**[View Complete UML Class Diagram](https://drive.google.com/file/d/15BjXRy2l_rYo9QAuOvNCcwdKY9bPVa-1/view?usp=sharing)**

The diagram shows the complete system architecture with all classes, interfaces, relationships, and design patterns used in the implementation.

## ✨ Features

- **Multilevel Structure**: Support for multiple floors with configurable slots
- **Vehicle Size Support**: SMALL, MEDIUM, LARGE vehicles with flexible slot allocation
- **Extensible Slot Features**: Decorator pattern for adding features like charging, cleaning, etc.
- **Efficient Allocation**: O(log n) slot allocation using TreeSet with nearest-slot strategy
- **Complete Workflow**: Entry gates, ticket generation, exit gates, and bill calculation
- **SOLID Principles**: Clean, maintainable, and extensible design

## 📁 Project Structure

```
Parking lot/
├── VehicleSize.java          # Enum for vehicle sizes
├── Vehicle.java              # Vehicle entity
├── Slot.java                 # Slot interface
├── BasicSlot.java            # Basic slot implementation
├── SlotDecorator.java        # Abstract decorator for slot features
├── ChargingDecorator.java    # Charging feature decorator
├── CleaningDecorator.java    # Cleaning feature decorator
├── Ticket.java               # Parking ticket entity
├── Bill.java                 # Parking bill entity
├── Floor.java                # Floor management
├── EntryGate.java            # Entry gate functionality
├── ExitGate.java             # Exit gate functionality
├── ParkingLot.java           # Main parking lot system
├── Main.java                 # Demo application
├── ParkingLotDiagram.puml    # PlantUML class diagram source
├── run.bat                   # Compilation and execution script
└── README.md                 # Project documentation
```

## 🎨 Design Patterns Used

1. **Decorator Pattern**: For slot features (charging, cleaning, etc.)

   - Allows dynamic addition of features without subclass explosion
   - Features can be combined (e.g., Charging + Cleaning slot)

2. **Strategy Pattern**: For slot allocation strategy using TreeSet

   - O(log n) efficient slot allocation and deallocation
   - Easy to swap different allocation algorithms

3. **Template Method**: In SlotDecorator for common slot operations

## 🏗️ SOLID Principles Applied

- **Single Responsibility**: Each class has a specific, well-defined purpose
- **Open/Closed**: Extensible through decorators without modifying existing code
- **Liskov Substitution**: Decorators and BasicSlot are interchangeable through Slot interface
- **Interface Segregation**: Clean, focused interfaces (Slot, Comparable)
- **Dependency Inversion**: High-level modules depend on abstractions (Slot interface)

## Key Algorithms

- **Slot Allocation**: O(log n) using TreeSet sorted by distance to gate
- **Nearest Slot**: Always allocates the closest available slot to entry gate
- **Size Compatibility**: Smaller vehicles can use larger slots

## 🚀 How to Run

### Quick Start

```bash
# Compile all Java files
javac *.java

# Run the demo
java Main

# Or use the batch file (Windows)
.\run.bat
```

### Example Workflow

1. **Vehicle Entry**: Vehicle enters through entry gate
2. **Slot Allocation**: System finds nearest suitable slot using TreeSet
3. **Ticket Generation**: Ticket generated with entry time and slot details
4. **Parking Duration**: Vehicle parks for specified duration
5. **Vehicle Exit**: Vehicle exits through exit gate
6. **Bill Calculation**: Bill calculated based on time and slot features
7. **Slot Release**: Slot released back to available pool

## 📈 Sample Output

```
=== MULTILEVEL PARKING LOT SYSTEM DEMO ===

Setting up parking lot...
Added floor 1 with 7 slots
Added floor 2 with 2 slots

=== PARKING LOT STATUS ===
Total floors: 2
Entry gates: 2
Exit gates: 1
SMALL slots - Available: 3/3
MEDIUM slots - Available: 3/3
LARGE slots - Available: 3/3
========================

Allocated slot 101 (size: SMALL, features: Basic) to vehicle CAR-123
Ticket generated: Ticket{id=1, slot=101, vehicle=CAR-123, entryTime=...}

Bill generated: Bill{ticket=3, exitTime=..., totalAmount=15.0}
Base charges: $5.0, Extra charges: $10.0, Total: $15.0
```

## 🔮 Future Enhancements

- **Reservation System**: Pre-booking slots with time slots
- **Monthly Parking Passes**: Subscription-based parking
- **Payment Integration**: Multiple payment methods (card, digital wallet)
- **Mobile App Support**: QR code-based entry/exit
- **Real-time Availability Display**: IoT sensor integration
- **Analytics and Reporting**: Usage patterns and revenue tracking
- **Dynamic Pricing**: Peak hour and demand-based pricing

## 🧪 Testing & Demo

The `Main.java` class provides a comprehensive demonstration showing:

- ✅ Multiple vehicle types (Car, SUV, Bike, Truck)
- ✅ Different slot features (Basic, Charging, Cleaning, Combined)
- ✅ Efficient slot allocation and deallocation
- ✅ Bill generation with various charges
- ✅ Real-time system status reporting
- ✅ Extensibility examples for new features

## 🏆 Architecture Benefits

- **Scalability**: Easy to add more floors, gates, and slot types
- **Maintainability**: Clean separation of concerns with SOLID principles
- **Extensibility**: New features via Decorator pattern without code modification
- **Performance**: O(log n) operations for slot management
- **Flexibility**: Configurable pricing strategies and allocation algorithms
