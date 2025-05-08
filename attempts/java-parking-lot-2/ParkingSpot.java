public class ParkingSpot {
    private Vehicle vehicle; 
    private VehicleType type; 
    private Integer lotNumber; 

    public ParkingSpot(VehicleType type, Integer lotNumber) {
        this.vehicle = null; 
        this.type = type; 
        this.lotNumber = lotNumber;
    }

    public boolean isAvailable() {
        return this.vehicle == null; 
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (this.isAvailable() && vehicle.getType() == this.type) {
            this.vehicle = vehicle; 
            return true; 
        }
        return false; 
    }

    public boolean releaseVehicle(Vehicle vehicle) {
        if (vehicle == this.vehicle) {
            this.vehicle = null;
            return true; 
        }
        return false; 
    }

    public String reportStatus() {
        if (this.isAvailable()) {
            return "Parking Spot " + this.lotNumber.toString() + " is available.\n"; 
        }
        return "X Parking Spot " + this.lotNumber.toString() + " is occupied.\n"; 
    }

    public Integer getLotNumber() {
        return this.lotNumber; 
    }
}
