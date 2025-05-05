import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private static ParkingLot instance;
    private List<Level> levels = new ArrayList<>(); 

    private ParkingLot() {}
    
    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void createLevels(Integer numberOfLevels, Map<VehicleType, Integer> levelStructure) {
        for (int i = 0; i < numberOfLevels; i++) {
            Level newLevel = new Level(levelStructure); 
            levels.add(newLevel);
        }
    }

    public void checkAvailability(VehicleType type) {
        for (Level level: levels) {
            level.checkAvailability(type); 
        }
    }
    
    public void parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            level.parkVehicle(vehicle);
        }
    }
    
    public void unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            level.unparkVehicle(vehicle);
        }
    }
}