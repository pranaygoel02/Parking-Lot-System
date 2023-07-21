public class Ticket {
    int floor;
    int slot;
    String plotId;
    public Ticket(String plotId, int floor, int slot) {
        this.plotId = plotId;
        this.floor = floor;
        this.slot = slot;
    }

    public String getTicketId() {
        return plotId + "_" + floor + "_" + slot;
    }
}
