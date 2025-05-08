public class ParkingLotMain {
    
    public static void main(String[] args) {
        // 1. Initialize parking lot with multiple levels and spots
        ParkingLot parkingLot = ParkingLot.initialize(3, 5); // 3 levels, 5 spots each
        System.out.println("Parking lot initialized with 3 levels, 5 spots each");
        
        // Create different types of vehicles
        Car car1 = new Car("CA-1234");
        Car car2 = new Car("CA-5678");
        Car car3 = new Car("CA-9012");
        Truck truck1 = new Truck("TR-1234");
        
        // Check initial availability
        System.out.println("\n--- Initial status ---");
        parkingLot.reportStatus();
        
        // 4. Test parking (entry) functionality
        System.out.println("\n--- Testing vehicle entry ---");
        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(truck1);
        
        // 5. Check updated availability
        System.out.println("\n--- Status after parking ---");
        parkingLot.reportStatus();
        
        // 4. Test releasing (exit) functionality
        System.out.println("\n--- Testing vehicle exit ---");
        parkingLot.releaseVehicle(car1);
        parkingLot.releaseVehicle(truck1);
        
        // Check if spots are released properly
        System.out.println("\n--- Status after exits ---");
        parkingLot.reportStatus();
        
        // Test parking when lot is almost full
        System.out.println("\n--- Testing parking lot capacity ---");
        Car car4 = new Car("CA-3456");
        Car car5 = new Car("CA-7890");
        Car car6 = new Car("CA-1357");
        Car car7 = new Car("CA-2468");
        Car car8 = new Car("CA-3690");
        
        parkingLot.parkVehicle(car3);
        parkingLot.parkVehicle(car4);
        parkingLot.parkVehicle(car5);
        parkingLot.parkVehicle(car6);
        parkingLot.parkVehicle(car7);
        parkingLot.parkVehicle(car8); // Should show "parking lot is full" message
        
        // 6. Test concurrent access (simplified simulation)
        System.out.println("\n--- Testing concurrent access ---");
        Thread entryThread = new Thread(() -> {
            Car threadCar = new Car("TH-1234");
            parkingLot.parkVehicle(threadCar);
        });
        
        Thread exitThread = new Thread(() -> {
            parkingLot.releaseVehicle(car5);
        });
        
        entryThread.start();
        exitThread.start();
        
        try {
            entryThread.join();
            exitThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Final status
        System.out.println("\n--- Final parking lot status ---");
        parkingLot.reportStatus();
    }
}