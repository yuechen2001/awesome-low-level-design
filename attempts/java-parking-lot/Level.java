import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Level {
    private List<ParkingSpot> spots = new ArrayList<>(); 

    public Level(Map<VehicleType, Integer> count) {
        for (Map.Entry<VehicleType, Integer> entry: count.entrySet()) {
            VehicleType type = entry.getKey();
            Integer value = entry.getValue(); 
            for (int i = 0; i < value; i++) {
                ParkingSpot newSpot = new ParkingSpot(type); 
                spots.add(newSpot); 
            }
        }
    }
    
    public synchronized void parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot: spots) {
            spot.parkVehicle(vehicle);
        }
    }

    public synchronized void unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot: spots) {
            spot.unparkVehicle(vehicle);
        }
    }

    public void checkAvailability(VehicleType type) {
        for (ParkingSpot spot: spots) {
            spot.checkAvailability(type);
        }
    }
}