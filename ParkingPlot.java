import Vehicles.VehicleTypes;
import Vehicles.*;

class ParkingSlot {
    String slotId;
    boolean isOccupied;
    VehicleTypes type;
    Vehicle vehicle;
    ParkingSlot(String slotId, VehicleTypes type) {
        this.slotId = slotId;
        this.isOccupied = false;
        this.type = type;
    }
}

public class ParkingPlot {
    String plotId;
    int numberOfFloors;
    int numberOfSlotsPerFloor;
    ParkingSlot slots[][];
    ParkingPlot(String plotId, int numberOfFloors, int numberOfSlotsPerFloor) {
        this.plotId = plotId;
        this.numberOfFloors = numberOfFloors;
        this.numberOfSlotsPerFloor = numberOfSlotsPerFloor;
        slots = new ParkingSlot[numberOfFloors][numberOfSlotsPerFloor];
        makeParkingSlots();
        System.out.println("Created parking lot with " + numberOfFloors + " floors and " + numberOfSlotsPerFloor + " slots per floor");
    }

    private void makeParkingSlots() {
        for(int i = 0; i<numberOfFloors; i++) {
            for(int j = 0; j<numberOfSlotsPerFloor; j++) {
                slots[i][j] = new ParkingSlot("F" + (i + 1) + "S" + (j + 1), j == 0 ? VehicleTypes.Truck : (j>2 ? VehicleTypes.Car : VehicleTypes.Bike));
            }
        }
    }
    
    public void printParkingSlotsStatus() {
        for(ParkingSlot floor[]: slots) {
            for(ParkingSlot slot: floor) {
                System.out.print("[" + (slot.isOccupied ? "*" : "-" ) + "]");
            }
            System.out.println();
        }
    }

    public void displayFreeCount(VehicleTypes type) {
        int floorIndex = 1;
        for(ParkingSlot floor[]: slots) {
            int count = 0;
            for(ParkingSlot slot: floor) {
                if(!slot.isOccupied && slot.type == type) {
                    count++;
                }
            }
            System.out.println("Number of free " + type +" slots in floor "+ floorIndex +": " + count);
            floorIndex++;
        }
    }

    private int[] getFreeSlot(VehicleTypes type) {
        int floorIndex = 0;
        for(ParkingSlot floor[]: slots) {
            int count = 0;
            for(ParkingSlot slot: floor) {
                if(!slot.isOccupied && slot.type == type) {
                    return new int[]{floorIndex, count};
                }
                count++;
            }
            floorIndex++;
        }
        return null;
    }
    
    private void displaySlots(VehicleTypes type, boolean isOccupied) {
        int floorIndex = 1;
        for(ParkingSlot floor[]: slots) {
            System.out.print("Free " + type +" slots in floor "+ floorIndex +": ");
            for(ParkingSlot slot: floor) {
                if(slot.isOccupied == isOccupied && slot.type == type) {
                    System.out.print(slot.slotId + " ");
                }
            }
            System.out.println();
            floorIndex++;
        }
    }

    public void displayFreeSlots(VehicleTypes type) {
        displaySlots(type, false);
    }
   
    public void displayOccupiedSlots(VehicleTypes type) {
        displaySlots(type, true);
    }

    private boolean checkIfVehicleAlreadyParked(String regNum) {
        for(ParkingSlot floor[]: slots) {
            for(ParkingSlot slot: floor) {
                if(slot.isOccupied && slot.vehicle.regNum.equals(regNum)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean CheckIfVehicleAlreadyUnparked(int floorIndex, int slotIndex) {
        return !slots[floorIndex][slotIndex].isOccupied;
    }

    public void parkVehicle(VehicleTypes type, String regNum, String color) {
        if(checkIfVehicleAlreadyParked(regNum)) {
            System.out.println("Vehicle with registration number " + regNum + " is already parked");
            return;
        }
        int[] freeSlot = getFreeSlot(type);
        if(freeSlot == null) {
            System.out.println("Parking Lot Full for " + type);
            return;
        }
        int freeFloorIndex = freeSlot[0];
        int freeSlotIndex = freeSlot[1];
        Vehicle v;
        switch(type) {
            case Car:
                v = new Car(regNum, color);
                break;
            case Bike:
                v = new Bike(regNum, color);
                break;
            case Truck:
                v = new Truck(regNum, color);
                break;
            default:
                throw new Error(type + " is an invalid vehicle type");
        }
        
        slots[freeFloorIndex][freeSlotIndex].isOccupied = true;
        slots[freeFloorIndex][freeSlotIndex].vehicle = v;
        Ticket t = new Ticket(plotId, freeFloorIndex + 1, freeSlotIndex + 1);
        System.out.println("Parked " + type + " with registration number " + regNum + " and color " + color + ". Ticket Id: " + t.getTicketId());
    }

    public void unparkVehicle(String ticketId) {
        String[] ticketIdParts = ticketId.split("_");
        if(!ticketIdParts[0].equals(plotId)) {
            System.out.println("Invalid ticket id");
            return;
        }
        int floorIndex = Integer.parseInt(ticketIdParts[1]);
        int slotIndex = Integer.parseInt(ticketIdParts[2]);
        if(floorIndex > numberOfFloors || slotIndex > numberOfSlotsPerFloor) {
            System.out.println("Invalid ticket id");
            return;
        }
        if(CheckIfVehicleAlreadyUnparked(floorIndex - 1, slotIndex - 1)) {
            System.out.println("Invalid ticket id");
            return;
        }
        ParkingSlot slot = slots[floorIndex - 1][slotIndex - 1];
        if(!slot.isOccupied) {
            System.out.println("Invalid ticket id");
            return;
        }
        Vehicle v = slot.vehicle;
        slot.isOccupied = false;
        slot.vehicle = null;
        System.out.println("Unparked vehicle with registration number " + v.regNum + " and color " + v.color);
    }

}