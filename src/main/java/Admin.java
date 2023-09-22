import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Person implements Serializable{


    public void deleteAccount() {

    }

    public void changeAdminInfo() {

    }

    public void showRideHistory() {

    }

    public Admin() {
        super();
    }

    public Admin(String email, String password, String name, String phoneNumber) {
        super(email, password, name, phoneNumber);
    }

    public  boolean  signUp () {

        ArrayList<Admin> admins = new ArrayList<>();
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Utility.adminsAccounts))) {
             admins = (ArrayList<Admin>) reader.readObject();
            for (Admin c: admins) {
                if(this.email.equals(c.email) || this.phoneNumber.equals(c.phoneNumber)){
                    return false;
                }
            }
        }catch (Exception e) {
            System.out.println("Welcome new customer");
        }
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(Utility.adminsAccounts))){
            admins.add(this);
            writer.writeObject(admins);
            writer.close();
            return true;

        }catch (Exception e){
            System.out.println("Error");
        }
        return false;
    }

    public static Admin signIn(String email, String password) {
        Admin admin = new Admin();
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Utility.customersAccounts))) {
            ArrayList<Admin> admins;
             admins= (ArrayList<Admin>) reader.readObject();

            for (Admin a : admins) {
                if (a.email.equals(email) && a.getPassword().equals(password)) {
                    return a;
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            Utility.inputFromKeyBoard.nextLine();
        }
        return admin;
    }


    public static void searchHistory(String customerName) {
        try (Scanner reader = new Scanner(Utility.driversAccounts)) {
            while (reader.hasNext()) {
                String record = reader.nextLine();

                Scanner scanner = new Scanner(record);
                scanner.useDelimiter(",");
                System.out.println("Customer: " + customerName + " History: ");
                if (scanner.next().equals(customerName)) {
                    System.out.println("Driver Name: " + scanner.next());
                    System.out.println("Vehicle Type: " + scanner.next());
                    System.out.println("From : " + scanner.next());
                    System.out.println("To: " + scanner.next());
                    System.out.println("bill: " + scanner.next());
                    System.out.println("Date: " + scanner.next());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void editProfile() {
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Utility.adminsAccounts))) {
            ArrayList<Admin> admins;
            admins = (ArrayList<Admin>) reader.readObject();

            for (Admin d : admins) {
                if (d.email.equals(this.email) && d.getPassword().equals(this.getPassword())) {
                    d.email = email;
                    d.setPassword(this.getPassword());
                }
            }

            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(Utility.adminsAccounts));
            writer.writeObject(admins);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

