package Vehicles;

public class Truck extends Vehicle {
    public static int truckCount = 0;
    public Truck(String regNum, String col) {
        super(regNum, col, VehicleTypes.Truck);
        truckCount++;
    }
}
