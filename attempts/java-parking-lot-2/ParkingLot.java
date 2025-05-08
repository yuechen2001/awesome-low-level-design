import java.util.List;
import java.util.ArrayList;

public class ParkingLot {
    private static ParkingLot INSTANCE = null; 
    private List<Level> levels = new ArrayList<>(); 

    private ParkingLot(int numLevels, int numSpots) {
        for (int i = 1; i < numLevels + 1; i++) {
            Level newLevel = new Level(numSpots, i); 
            this.levels.add(newLevel); 
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        for (Level l: levels) {
            if (l.parkVehicle(vehicle)) {
                System.out.println(vehicle.toString() + " is parked.");
                return;
            } 
        }
        System.out.println("The parking lot is full.");
    }

    public void releaseVehicle(Vehicle vehicle) {
        for (Level l: levels) {
            if (l.unparkVehicle(vehicle)) {
                System.out.println(vehicle.toString() + " is unparked.");
                return;
            } 
        }
        System.out.println("Your vehicle cannot be found.");
    }

    public void reportStatus() {
        String totalStatus = "";

        for (Level l: levels) {
            totalStatus += l.reportStatus(); 
        }

        System.out.println("Here is the availability of the parking lot right now: \n" + totalStatus); 
    }

    public static synchronized ParkingLot initialize(int numLevels, int numSpots) {
        if (INSTANCE == null) {
            INSTANCE = new ParkingLot(numLevels, numSpots); 
        } 
        return INSTANCE; 
    }

    public static ParkingLot getInstance() throws IllegalStateException {
        if (INSTANCE == null) {
            throw new IllegalStateException("Parking lot has not been initialized!"); 
        } 
        return INSTANCE; 
    }
}
