package Vehicles;

public class Car extends Vehicle {
    public static int carCount = 0;
    public Car(String regNum, String col) {
        super(regNum, col, VehicleTypes.Car);
        carCount++;
    }
}
