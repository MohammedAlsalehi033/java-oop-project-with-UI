import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerScreen extends JFrame {
    private JPanel mainPanel;
    private JButton addBalanceButton;
    private JButton searchForARideButton;
    String [] fromAndTo ={"Islamabad","lahore","Peshawar","Karachi"};
    private JComboBox<String> comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JLabel CustomerInfo;

    private String from;
    private String to;
    public CustomerScreen(String title,Customer customer) {

        super(title);
        comboBox2.addItem("Islamabad");
        comboBox2.addItem("lahore");
        comboBox2.addItem("Peshawar");
        comboBox2.addItem("Karachi");
        comboBox3.addItem("Islamabad");
        comboBox3.addItem("lahore");
        comboBox3.addItem("Peshawar");
        comboBox3.addItem("Karachi");

        this.setContentPane(mainPanel);
        this.pack();

        CustomerInfo.setText(customer.toString());
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                from = comboBox2.getSelectedItem().toString();
            }
        });
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                from = comboBox3.getSelectedItem().toString();
            }
        });

        searchForARideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                ArrayList<Driver> driverArrayList = Ride.findRide(from);
                ChoseDriver c2 = new ChoseDriver("sad",driverArrayList,from,to);
                c2.setVisible(true);
                dispose();
            }
        });
    }


}
