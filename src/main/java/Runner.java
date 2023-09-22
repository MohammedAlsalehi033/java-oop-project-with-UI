import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Runner{
    static int choice;
   static Customer customer1;


    public static void main(String[] args) throws IOException {
        MainScreen m = new MainScreen("Main");
        m.setVisible(true);




//        Customer customer1;
//        Driver driver1;
//        Admin admin1;
//
//
//
//        System.out.println("what kind of user are you ?  \n 1- Customer \n 2- Driver \n 3- Admin");
//        int userType = Utility.inputFromKeyBoard.nextInt();  // this can be used as a once for all input
//        System.out.println("Press:\n1 - Sign in: \n2 - Sign up:\n3- Exit:");
//        choice = Utility.inputFromKeyBoard.nextInt();
//
//
//        switch (choice){
//          // case one is mainly for signing in process
//            case 1->{
//                // email and password is a unified way to sign in for all users
//                System.out.println("email: ");
//                Utility.inputFromKeyBoard.nextLine();
//                String email = Utility.inputFromKeyBoard.nextLine();
//                System.out.println("password: ");
//                String passWord = Utility.inputFromKeyBoard.nextLine();
//
//                // customer first page
//                if (userType == 1) {
//
//                    customer1 = (Customer) Person.signIn(userType, email, passWord);
//                    System.out.println(customer1.toString());
//                    System.out.println("where u wanna go?");
//                    Ride ride = Ride.StartRide("ISB","islamabad");
//                    ride.endRide(customer1.name);
//
//                } else if (userType == 2) {
//                    driver1 = (Driver) Person.signIn(userType,email,passWord);
//                    System.out.println(driver1.toString());
//                    driver1.editProfile();
//                }
//                else {
//                    admin1 = (Admin) Person.signIn(userType,email,passWord);
//                }
//
//           break;
//            }
//
//
//            case 2->{
//                if (userType == 1){
//                    System.out.println("email: ");
//                    Utility.inputFromKeyBoard.nextLine();
//                String email = Utility.inputFromKeyBoard.nextLine();
//                    System.out.println("password: ");
//                String passWord = Utility.inputFromKeyBoard.nextLine();
//
//                    System.out.println("Name: ");
//                    String name = Utility.inputFromKeyBoard.nextLine();
//                    System.out.println("Phone: ");
//                    String phone = Utility.inputFromKeyBoard.next();
//                    System.out.println("CC number: ");
//                    int ccnum = Utility.inputFromKeyBoard.nextInt();
//                    System.out.println("Age: ");
//                    int age = Utility.inputFromKeyBoard.nextInt();
//                    customer1 = new Customer(email, passWord,name,phone,ccnum,age,0);
//                     customer1.signUp();
//
//            } else if (userType == 2) {
//
//                    System.out.println("email: ");
//                    Utility.inputFromKeyBoard.nextLine();
//                    String email = Utility.inputFromKeyBoard.nextLine();
//                    System.out.println("password: ");
//                    String passWord = Utility.inputFromKeyBoard.nextLine();
//                    System.out.println("Name: ");
//                    String name = Utility.inputFromKeyBoard.nextLine();
//                    System.out.println("Phone: ");
//                    String phone = Utility.inputFromKeyBoard.next();
//
//                    double rating = 0;
//                    System.out.println("Driver Licence: ");
//                    boolean driverLicence = true;
//                    System.out.println("Plate number: ");
//                    Utility.inputFromKeyBoard.nextLine();
//                    String plateNumber =  Utility.inputFromKeyBoard.nextLine();
//                    System.out.println("Ride type: ");
//                    String rideType = Utility.inputFromKeyBoard.nextLine();
//                    Vehicle vehicle = new Vehicle(plateNumber,"free", rideType);
//
//                    System.out.println("current Location: ");
//                    String driverLoc = Utility.inputFromKeyBoard.nextLine();
//                    driver1 = new Driver(email, passWord,name,phone,rating,driverLicence,0,vehicle,driverLoc, 0);
//                    driver1.signUp();
//                }
//
//            }
//
//            default->{}
//        }
//        System.out.println();
//
//
//        System.out.println();

}
}
