public class History {
    String customer;
    String driverName;
    String rideType;
    String start;
    String end;
    double bill;
    String time;

    public History() {
    }

    public History(String customer, String driverName, String rideType, String start, String end, double bill, String time) {
        this.customer = customer;
        this.driverName = driverName;
        this.rideType = rideType;
        this.start = start;
        this.end = end;
        this.bill = bill;
        this.time = time;
    }
}
