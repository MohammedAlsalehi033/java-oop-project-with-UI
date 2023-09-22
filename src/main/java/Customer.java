import java.io.*;
import java.util.ArrayList;

public class Customer extends Person implements Serializable{

    private double balance;
    public int age;
    private long CCNumber;

    public Customer() {
    }

    public Customer(String email, String password, String name, String phoneNumber, long CCNumber, int age, double balance) {
        super(name, email, password, phoneNumber);
        this.balance = balance;
        this.age = age;
        this.CCNumber = CCNumber;
    }

    public  boolean  signUp () {
        ArrayList<Customer> customers = new ArrayList<>();
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Utility.customersAccounts))) {
            customers = (ArrayList<Customer>) reader.readObject();
            for (Customer c: customers) {
                if(this.email.equals(c.email) || this.phoneNumber.equals(c.phoneNumber) || (this.CCNumber == (c.CCNumber))){
                    return false;
                }
            }
        }catch (Exception e) {
            System.out.println("Welcome new customer");
        }
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(Utility.customersAccounts))){
            customers.add(this);
            writer.writeObject(customers);
            writer.close();
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public static Customer signIn(String email , String password) {
        Customer customer = new Customer();
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Utility.customersAccounts))) {
            ArrayList<Customer> customers;
            customers = (ArrayList<Customer>) reader.readObject();

            for (Customer c : customers) {
                if (c.email.equals(email) && c.getPassword().equals(password)) {
                    return c;
                }
            }

        }catch (Exception e) {

        }
            return customer;
        }


    public void editProfile() {
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Utility.customersAccounts))) {
            ArrayList<Customer> customers;
            customers = (ArrayList<Customer>) reader.readObject();

            for (Customer d : customers) {
                if (d.email.equals(this.email) && d.getPassword().equals(this.getPassword())) {
                    d.email = email;
                    d.setPassword(this.getPassword());
                }
            }

            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(Utility.customersAccounts));
            writer.writeObject(customers);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getCCnumber() {
        return CCNumber;
    }

    public void setCCnumber(int CCnumber) {
        this.CCNumber = CCnumber;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                " balance=" + balance +
                        ", age=" + age +
                        ", CCNumber=" + CCNumber +
                        ' ';
    }
}
