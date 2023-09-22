import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Payment {

    public static boolean validateVisaCard(long number) {
        // sum of even-place digits in number
        int evenSum = 0;
        int size = (number+"").length();
        String num = number + "";
        for (int i = size - 2; i >= 0; i -= 2) {
            int number2 = Integer.parseInt(num.charAt(i) + "") * 2;
            if(number2 < 9)
                evenSum += number2;
            else
                evenSum += number2 / 10 + number2 % 10;
        }
        //sum of odd-place digits in number
        int oddSum = 0;
        String num2 = number + "";
        for (int i = size - 1; i >= 0; i -= 2) {
            oddSum += Integer.parseInt(num2.charAt(i) + "");
        }
        return  (size >= 13 && size <= 16) &&

                (prefixMatched(number, 4) || prefixMatched(number, 5) ||
                        prefixMatched(number, 37) || prefixMatched(number, 6)) &&
                ((evenSum + oddSum) % 10 == 0);
    }

    public void withDraw (Driver driver, String amount){
        editBalance(driver.name, amount,true,Utility.balanceFile,Utility.tempFile2);
        Utility.deleteFile1(Utility.balanceFile,Utility.tempFile2);
    }
    public static void editBalance(String username, String change,boolean add, File source , File target) {
        try {
            Scanner reader = new Scanner(source);
            PrintWriter writer = new PrintWriter(target);
            String userName1;
            String toChange;
            long balance;
            while (reader.hasNext()){
                userName1 = reader.nextLine();
                toChange = reader.nextLine();
                if (userName1.equals(username)){
                    writer.println(username);
                    if(add) {
                        balance = Integer.parseInt(toChange) + Integer.parseInt(change);
                    }
                    else {
                        balance = Integer.parseInt(toChange) - Integer.parseInt(change);
                    }
                    writer.println(balance);
                } else {
                    writer.println(userName1);
                    writer.println(toChange);
                }
            }
            reader.close();
            writer.close();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());

            Utility.inputFromKeyBoard.nextLine();
        }
    }
    public void deposit(Customer customer,String amount){
        editBalance(customer.name,amount,false,Utility.balanceFile,Utility.tempFile2);
        Utility.deleteFile1(Utility.balanceFile,Utility.tempFile2);
    }
    public static boolean prefixMatched(long number, int d) {

             if ((number+"").length() > (d+"").length())  {
                 String num = number + "";
                 return  Long.parseLong(num.substring(0, (d+"").length())) == d;
             }
             return number == d;
         }
}


