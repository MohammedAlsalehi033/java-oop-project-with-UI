import java.io.Serializable;

public class Vehicle implements Serializable {
    private String plateNumber;
    String condition;
    String rideType;

    public Vehicle() {
    }


    public Vehicle(String plateNumber, String condition, String rideType) {
        this.plateNumber = plateNumber;
        this.condition = condition;
        this.rideType = rideType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }


    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return
                " plateNumber='" + plateNumber + '\'' +
                        ", condition='" + condition + '\'' +
                        ' ';
    }
}
