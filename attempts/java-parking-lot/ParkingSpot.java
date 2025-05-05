public class ParkingSpot {
    private Vehicle vehicle = null; 
    private VehicleType type; 

    public ParkingSpot(VehicleType type) {
        this.type = type; 
    }

    public boolean isOccupied() {
        return this.vehicle != null; 
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (this.vehicle == null && vehicle.getType() == this.type) {
            this.vehicle = vehicle; 
            System.out.println("Vehicle successfully parked."); 
        }
    }

    public synchronized void unparkVehicle(Vehicle vehicle) {
        if (vehicle == this.vehicle) {
            this.vehicle = null; 
            System.out.println("Vehicle successfully un-parked."); 
        }
    }

    public void checkAvailability(VehicleType type) {
        if (this.type == type && this.vehicle == null) {
            System.out.println("There is an available spot for vehicle of type:" + type.toString());
        }
    }
}