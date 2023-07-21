import Vehicles.*;

public class Main {
    public static void main(String[] args) {

        ParkingPlot plot1 = new ParkingPlot("PR1234", 2, 6);

        plot1.printParkingSlotsStatus();

        plot1.displayFreeCount(VehicleTypes.Car);
        plot1.displayFreeCount(VehicleTypes.Bike);
        plot1.displayFreeCount(VehicleTypes.Truck);

        plot1.displayFreeSlots(VehicleTypes.Car);
        plot1.displayFreeSlots(VehicleTypes.Bike);
        plot1.displayFreeSlots(VehicleTypes.Truck);

        plot1.parkVehicle(VehicleTypes.Car, "KA-01-DB-1234", "black");
        plot1.parkVehicle(VehicleTypes.Car, "KA-02-CB-1334", "red");
        plot1.parkVehicle(VehicleTypes.Car, "KA-01-DB-1133", "black");
        plot1.parkVehicle(VehicleTypes.Car, "KA-05-HJ-8432", "white");
        plot1.parkVehicle(VehicleTypes.Car, "WB-45-HO-9032", "white");
        plot1.parkVehicle(VehicleTypes.Car, "KA-01-DF-8230", "black");
        plot1.parkVehicle(VehicleTypes.Car, "KA-21-HS-2347", "red");

        plot1.displayFreeCount(VehicleTypes.Car);
        plot1.displayFreeCount(VehicleTypes.Bike);
        plot1.displayFreeCount(VehicleTypes.Truck);

        plot1.unparkVehicle("PR1234_2_5");
        plot1.unparkVehicle("PR1234_2_5");
        plot1.unparkVehicle("PR1234_2_7");

        plot1.displayFreeCount(VehicleTypes.Car);
        plot1.displayFreeCount(VehicleTypes.Bike);
        plot1.displayFreeCount(VehicleTypes.Truck);

        plot1.displayFreeSlots(VehicleTypes.Car);
        plot1.displayFreeSlots(VehicleTypes.Bike);
        plot1.displayFreeSlots(VehicleTypes.Truck);

        plot1.displayOccupiedSlots(VehicleTypes.Car);
        plot1.displayOccupiedSlots(VehicleTypes.Bike);
        plot1.displayOccupiedSlots(VehicleTypes.Truck);

        plot1.parkVehicle(VehicleTypes.Bike, "KA-01-DB-1541", "black");
        plot1.parkVehicle(VehicleTypes.Truck, "KA-32-SJ-5389", "orange");
        plot1.parkVehicle(VehicleTypes.Truck, "KL-54-DN-4582", "green");
        plot1.parkVehicle(VehicleTypes.Truck, "KL-12-HF-4542", "green");

        plot1.displayFreeCount(VehicleTypes.Car);
        plot1.displayFreeCount(VehicleTypes.Bike);
        plot1.displayFreeCount(VehicleTypes.Truck);

        plot1.displayFreeSlots(VehicleTypes.Car);
        plot1.displayFreeSlots(VehicleTypes.Bike);
        plot1.displayFreeSlots(VehicleTypes.Truck);

        plot1.displayOccupiedSlots(VehicleTypes.Car);
        plot1.displayOccupiedSlots(VehicleTypes.Bike);
        plot1.displayOccupiedSlots(VehicleTypes.Truck);
    }
}
