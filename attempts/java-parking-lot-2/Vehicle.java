public abstract class Vehicle {
    private VehicleType type; 
    private String licensePlate; 

    public Vehicle(VehicleType type, String licensePlate) {
        this.type = type;
        this.licensePlate = licensePlate; 
    }

    public VehicleType getType() {
        return this.type; 
    }

    public String getPlate() {
        return this.licensePlate; 
    }

    @Override 
    public String toString() {
        return this.licensePlate; 
    }
}
