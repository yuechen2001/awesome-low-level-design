import java.util.HashMap;
import java.util.Map;

public class ParkingLotDemo {
    public static void main(String[] args) {
        System.out.println("Starting Parking Lot Demo");
        
        // Get the singleton instance of ParkingLot
        ParkingLot parkingLot = ParkingLot.getInstance();
        
        // Create parking structure with multiple levels
        System.out.println("Creating parking structure...");
        
        // Define level structure - how many spots of each type per level
        Map<VehicleType, Integer> levelStructure = new HashMap<>();
        levelStructure.put(VehicleType.CAR, 3);
        levelStructure.put(VehicleType.MOTORCYCLE, 2);
        levelStructure.put(VehicleType.TRUCK, 1);
        
        // Create 3 levels with the same structure
        parkingLot.createLevels(3, levelStructure);
        
        // Create some vehicles
        Vehicle car1 = new Car();
        Vehicle car2 = new Car();
        Vehicle truck1 = new Truck();
        Vehicle motorcycle1 = new Motorcycle();
        
        // Check initial availability
        System.out.println("\nInitial availability check:");
        parkingLot.checkAvailability(VehicleType.CAR);
        parkingLot.checkAvailability(VehicleType.TRUCK);
        parkingLot.checkAvailability(VehicleType.MOTORCYCLE);
        
        // Park vehicles
        System.out.println("\nParking vehicles...");
        parkVehicleWithStatus(parkingLot, car1);
        parkVehicleWithStatus(parkingLot, car2);
        parkVehicleWithStatus(parkingLot, truck1);
        parkVehicleWithStatus(parkingLot, motorcycle1);
        
        // Create additional vehicles to demonstrate parking failures
        System.out.println("\nDemonstrating parking failures:");
        
        // Scenario 1: Try to park more cars than capacity
        System.out.println("\nScenario 1: Exceeding capacity for a vehicle type");
        Vehicle[] extraCars = new Vehicle[10]; // We only created 3 car spots per level
        for (int i = 0; i < extraCars.length; i++) {
            extraCars[i] = new Car();
            System.out.println("\nTrying to park extra car #" + (i+1));
            parkVehicleWithStatus(parkingLot, extraCars[i]);
        }
        
        // Scenario 2: Try to park a car in a spot that's already occupied
        System.out.println("\nScenario 2: Already occupied spot");
        Vehicle duplicateCar = new Car();
        // We'll attempt to park in the same spot that already has car1
        System.out.println("\nAttempting to park a car in an already occupied spot");
        parkVehicleWithStatus(parkingLot, duplicateCar);
        
        // Check availability after parking
        System.out.println("\nAvailability after parking:");
        parkingLot.checkAvailability(VehicleType.CAR);
        parkingLot.checkAvailability(VehicleType.TRUCK);
        parkingLot.checkAvailability(VehicleType.MOTORCYCLE);
        
        // Unpark a vehicle
        System.out.println("\nUnparking car1...");
        // In a real scenario, you might want to track which parking spot
        // each vehicle was assigned to
        unparkVehicleWithStatus(parkingLot, car1);
        
        // Check availability after unparking
        System.out.println("\nAvailability after unparking:");
        parkingLot.checkAvailability(VehicleType.CAR);
    }
    
    // Helper methods to demonstrate parking/unparking with status messages
    private static void parkVehicleWithStatus(ParkingLot parkingLot, Vehicle vehicle) {
        System.out.println("Attempting to park " + vehicle.getType() + "...");
        try {
            // In your implementation, you might need to adapt this based on 
            // how your parkVehicle method is designed to return success/failure
            parkingLot.parkVehicle(vehicle);
            System.out.println("Successfully parked " + vehicle.getType());
        } catch (Exception e) {
            System.out.println("Failed to park " + vehicle.getType() + ": " + e.getMessage());
        }
    }
    
    private static void unparkVehicleWithStatus(ParkingLot parkingLot, Vehicle vehicle) {
        System.out.println("Attempting to unpark " + vehicle.getType() + "...");
        try {
            // Similarly, adapt this based on your implementation
            parkingLot.unparkVehicle(vehicle);
            System.out.println("Successfully unparked " + vehicle.getType());
        } catch (Exception e) {
            System.out.println("Failed to unpark " + vehicle.getType() + ": " + e.getMessage());
        }
    }
}
