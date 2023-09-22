import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

public class LogInScreen extends JFrame {

    private JPanel mainPanel;
    private JButton button1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton signUpButton;

    Customer customer1;
    Driver driver1;
    Admin admin1;

    public LogInScreen(String title,int IdToGo) {
        super(title);
        this.setContentPane(mainPanel);
        this.pack();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (IdToGo == 1){
                        System.out.println(textField1.getText());
                        String email = textField1.getText();
                        String passWord = Arrays.toString(passwordField1.getPassword());

                        customer1 = (Customer) Person.signIn(1, email, passWord);
                        CustomerScreen screen = new CustomerScreen("Cus",customer1);
                        screen.setVisible(true);
                        dispose();
                    }else if(IdToGo == 2){
                        System.out.println(Arrays.toString(passwordField1.getPassword()));
                        String email = textField1.getText();
                        String passWord = Arrays.toString(passwordField1.getPassword());
                        try {
                            Driver driver1;
                            driver1 = (Driver) Person.signIn(2, email, passWord);
                            System.out.println(driver1);
                            DriverScreen screen = new DriverScreen("Cus");
                            screen.setVisible(true);
                            dispose();
                        }catch (Exception ee){
                            JOptionPane.showMessageDialog(null,"PassWord or Email is Wrong ");
                        }

                    }
                    else {
                        System.out.println(textField1.getText());
                        String email = textField1.getText();
                        String passWord = Arrays.toString(passwordField1.getPassword());
                        Admin admin1;
                        admin1 = (Admin) Person.signIn(3, email, passWord);
                        AdminScreen screen = new AdminScreen("Cus");
                        screen.setVisible(true);
                        dispose();
                    }
                }catch (Exception e1){

                }


            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {


                if (IdToGo == 3){
                     throw new RuntimeException();
                 }

                else if (IdToGo == 1){
                SignUpForCustomer signUp = new SignUpForCustomer("signUp");
                signUp.setVisible(true);
                dispose();
                }
                else if (IdToGo == 2){
                     DriverSignUp driverSignUp= new DriverSignUp("signUp");
                    driverSignUp.setVisible(true);
                    dispose();
                }

            }catch (Exception ee){
                    JOptionPane.showMessageDialog(null,"Admin Can't Sign Up");
                }
            }

        });
    }


}
