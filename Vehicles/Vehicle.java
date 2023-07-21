package Vehicles;

public class Vehicle {
    public String regNum;
    public String color;
    VehicleTypes type;

    public static int count = 0;

    protected Vehicle(String regNum, String col, VehicleTypes type) {
        this.regNum = regNum;
        this.color = col;
        switch (type) {
            case Bike:
            case Car:
            case Truck:
                this.type = type;
                break;
            default:

                throw new Error(type + " is an invalid vehicle type");
        }
        count++;
    }
}
