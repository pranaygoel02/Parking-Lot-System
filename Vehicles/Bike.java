package Vehicles;

public class Bike extends Vehicle {
    public static int bikeCount = 0;
    public Bike(String regNum, String col) {
        super(regNum, col, VehicleTypes.Bike);
        bikeCount++;
    }
}
