import javax.swing.*;
import java.util.ArrayList;


public class ChoseDriver extends JFrame {
    private JComboBox comboBox1;
    private JPanel mainPanel;


    public ChoseDriver(String title, ArrayList<Driver> drivers,String from,String to) {
       super(title);
        for (Driver d:drivers)
        {
            comboBox1.addItem("Driver Name: " + d.name );
        }
        this.setContentPane(mainPanel);
        this.pack();
    }
}
