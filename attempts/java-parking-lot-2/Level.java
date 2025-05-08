import java.util.List;
import java.util.ArrayList;

public class Level {
    private List<ParkingSpot> spots = new ArrayList<>(); 
    private Integer levelNumber; 

    public Level(int numSpots, int levelNumber) {
        for (int i = 1; i < numSpots + 1; i++) {
            // Create a mix of spot types
            VehicleType spotType;
            if (i % 3 == 0) {
                spotType = VehicleType.TRUCK;
            } else if (i % 3 == 1) {
                spotType = VehicleType.CAR;
            } else {
                spotType = VehicleType.MOTORCYCLE;
            }
            ParkingSpot newSpot = new ParkingSpot(spotType, i);
            this.spots.add(newSpot);
        }
        
        this.levelNumber = levelNumber;    
    }
    
    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot: spots) {
            if (spot.parkVehicle(vehicle)) {
                return true; 
            }
        }
        System.out.println("There is no available spots in Level " + this.levelNumber.toString() + " for type " + vehicle.getType().name() + ".");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot: spots) {
            if (spot.releaseVehicle(vehicle)) {
                return true; 
            }
        }
        System.out.println("Vehicle not found on Level " + this.levelNumber.toString() + ".");
        return false;
    }

    public String reportStatus() {
        String levelStatus = "";

        for (ParkingSpot spot: spots) {
            levelStatus += spot.reportStatus(); 
        }

        return "Level " + this.getLevelNumber() + " availability: \n" + levelStatus;
    }

    public Integer getLevelNumber() {
        return this.levelNumber; 
    }
}
