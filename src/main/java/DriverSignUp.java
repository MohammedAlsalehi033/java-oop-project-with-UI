import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class DriverSignUp extends JFrame {
    private JTextField Email;

    private JTextField age;
    private JTextField CCnun;
    private JTextField phone;
    private JTextField Name;
    private JPanel mainPanal;
    private JButton Submit;
    private JComboBox RideType;
    private JComboBox VehiclCondot;
    private JComboBox CurrentLocation;
    private JComboBox Driverlicence;
    private JPasswordField passwordField;

    public DriverSignUp(String title) {
        super(title);
        this.setContentPane(mainPanal);
        this.pack();
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Driver driver1;

                    String email = Email.getText().toString();

                    String passWord = Arrays.toString(passwordField.getPassword());

                    String name = Name.getText().toString();

                    String phone2 = phone.getText().toString();

                    double rating = 0;

                    boolean driverLicence = true;


                    String plateNumber = "khgjghjk";
                    String rideType = RideType.getSelectedItem().toString();
                    String carCondition =  VehiclCondot.getSelectedItem().toString();
                    Vehicle vehicle = new Vehicle(plateNumber,carCondition, rideType);
                    String driverLocation = CurrentLocation.getSelectedItem().toString();
                    driver1 = new Driver(email, passWord,name,phone2,rating,driverLicence,0,vehicle, driverLocation, 0);
                    driver1.signUp();
                System.out.println("done");
            }
        });
    }
}
