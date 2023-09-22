import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Ride implements Serializable {
    private String pickUpLocation;
    private String dropToLocation;
    private Date record;

    private double bill;

    private Driver driver;

    public Ride() {
    }

    public Ride(String pickUpLocation, String dropToTime, Date record, double bill,Driver driver) {
        this.pickUpLocation = pickUpLocation;
        this.dropToLocation = dropToTime;
        this.record = record;
        this.bill = bill;
        this.driver = driver;
    }


    public static ArrayList<Driver>  findRide (String from) {
        ArrayList<Driver> availableDrivers = new ArrayList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Utility.driversAccounts))) {
            ArrayList<Driver> drivers = (ArrayList<Driver>) reader.readObject();
            for (Driver d :drivers) {
                if(d.getDriverLocation().equals(from)){
                    availableDrivers.add(d);
                }
            }

        } catch (Exception e) {
            System.out.println();
        }
        System.out.println(from);
        System.out.println(availableDrivers.toString());
        return availableDrivers;
    }

        public static Ride StartRide(String from,String whereto){
        ArrayList<Driver> drivers = findRide(from);

            for (int i = 0; i < drivers.size(); i++) {
                System.out.println((i + 1)+ "- " +drivers.get(i).toString());
            }
            System.out.println("select the desired driver ");
            int choice = Utility.inputFromKeyBoard.nextInt();


            Date rideTime = Calendar.getInstance().getTime();

            Ride ride = new Ride(from,whereto,rideTime,100,drivers.get(choice));
            System.out.println("the code should stop after this stage to make it look realistic (as if the customer is really taking the ride)");
            return ride;


    }
    public void endRide(String customerName)  {



        // edit customer and driver balance
         rateDriver();
         recordRideToHistory(customerName);




    }

    private void recordRideToHistory (String customerName){
        ArrayList<History> histories;
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Utility.history))){
            histories = (ArrayList<History>) reader.readObject();
            History h = new History(customerName,driver.name,driver.driverVehicle.rideType,pickUpLocation,dropToLocation,bill,new SimpleDateFormat("yyyy-MM-dd_HH:mm").format(record));
            histories.add(h);

            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(Utility.history));
            writer.writeObject(histories);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private void rateDriver (){
        System.out.println("enter Driver Rating");
        double rating = Utility.inputFromKeyBoard.nextDouble();
        double totalRating = driver.getRating() * driver.getRidesCounter();
        double newRating = (totalRating + rating) / (driver.getRidesCounter() + 1);
        driver.setRating(newRating);
        driver.setRidesCounter(driver.getRidesCounter() + 1);
        driver.editProfile();


    }




    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public String getDropToTime() {
        return dropToLocation;
    }

    public void setDropToTime(String dropToTime) {
        this.dropToLocation = dropToTime;
    }

    public Date getRecord() {
        return record;
    }

    public void setRecord(Date record) {
        this.record = record;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }
}
