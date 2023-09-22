import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends Person implements Serializable{
    private double rating;
    private boolean drivingLicence;

    private String driverLocation;
    private double balance;
    public Vehicle driverVehicle;

    private int ridesCounter;




    public Driver() {
    }

    public Driver(String email, String password,String name, String phoneNumber, double rating, boolean drivingLicence, double balance, Vehicle drivervehicle , String driverLocation, int ridesCounter) {
        super(name, email, password, phoneNumber);
        this.rating = rating;
        this.drivingLicence = drivingLicence;
        this.balance = balance;
        this.driverVehicle = drivervehicle;
        this.driverLocation = driverLocation;
        this.ridesCounter = ridesCounter;
    }




    public  boolean  signUp () {
        ArrayList<Driver> drivers = new ArrayList<>();
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Utility.driversAccounts))) {
            drivers = (ArrayList<Driver>) reader.readObject();
            for (Driver d: drivers) {
                if(this.email.equals(d.email) || this.phoneNumber.equals(d.phoneNumber)){
                    return false;
                }
            }
        }catch (Exception e) {
            System.out.println("Welcome new customer");
        }
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(Utility.driversAccounts))){
            drivers.add(this);
            writer.writeObject(drivers);
            writer.close();
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public static Driver signIn (String email, String password){

        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Utility.driversAccounts))) {
            ArrayList<Driver> drivers;
            drivers = (ArrayList<Driver>) reader.readObject();

            for (Driver d : drivers) {
                if (d.email.equals(email) && d.getPassword().equals(password)) {
                    return d;
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    @Override
    public void editProfile() {
            try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Utility.driversAccounts))) {
                ArrayList<Driver> drivers;
                drivers = (ArrayList<Driver>) reader.readObject();

                for (Driver d : drivers) {
                    if (d.email.equals(this.email) && d.getPassword().equals(this.getPassword())) {
                        d.email = email;
                        d.setPassword(this.getPassword());
                    }
                }

                ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(Utility.driversAccounts));
                writer.writeObject(drivers);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getRidesCounter() {
        return ridesCounter;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setRidesCounter(int ridesCounter) {
        this.ridesCounter = ridesCounter;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nRating: " + rating +
                "\nDrivingLicence: " + drivingLicence +
                "\nLocation: " + driverLocation +
                "\nRides completed: " + ridesCounter +
                "\nDriverVehicle: " + driverVehicle.toString() + "\n";
    }
}
