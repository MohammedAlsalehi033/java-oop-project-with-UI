import java.io.File;
import java.util.Scanner;

public class Utility {

    static double pricePerKM = 25;
    static File customersAccounts = new File("customerAccounts.txt");
    static File adminsAccounts = new File("adminAccounts.txt");
    static File history = new File("history.txt");
    static File driversAccounts = new File("driversAccounts.txt");
    static File tempFile2 = new File("temp2.txt");


    static File balanceFile = new File("balanceFile.txt");
    static Scanner inputFromKeyBoard = new Scanner(System.in);
    public static String inputString(){
        return inputFromKeyBoard.nextLine().trim();
    }
    public static void deleteFile1(File toDelete,File destination){
        File dummyFile = new File(toDelete.getName());
        toDelete.delete();
        destination.renameTo(dummyFile);
    }
    public static boolean checkPasswordStrength(String password){
        int counter = 0 ;
        int lettersCounter = 0;
        for (int i = 0 ; i < password.length() ; i++){
            if (Character.isDigit(password.charAt(i))){
                counter++;
            }
            else if(Character.isLetter(password.charAt(i))){
                lettersCounter++;
            }
            if (password.length()>= 8 && counter >= 2 && lettersCounter >= 2){
                return true;
            }
        }
        System.out.println("Please choose another password:");
        return false;
    }
    public static String checkPhoneNumber (){
        boolean valid = false;
        String number = "";
        while (!valid){
            number = inputString();
            if (number.length() == 11 && number.charAt(0) == '0'&& number.charAt(1) == '3'){
                valid = true;
                for (int i = 0; i < number.length(); i++) {
                    if (!Character.isDigit(number.charAt(i))){
                        valid = false;
                    }
                }
            }
            else
                System.out.println("Number is invalid try again");
        }
        return number;
    }

    int generateRandomNumber (int source , int destination ){
        int[][] distances = {
                //ISB //LHR //
                {0, 3, 5, 7, 10},
                {3, 0, 2, 4, 7},
                {5, 2, 0, 4, 8},
                {7, 4, 6, 0, 3},
        };

        return distances[source][destination] * 460 + (int) (Math.random() * 100);

    }


}
