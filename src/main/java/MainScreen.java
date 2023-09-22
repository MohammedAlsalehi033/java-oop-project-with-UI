import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    private JButton driverButton;
    private JPanel mainPanal;
    private JButton adminButton;
    private JButton customerButton;

    public MainScreen(String title) {
        super(title);
        this.setContentPane(mainPanal);
        this.pack();
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInScreen c2 = new LogInScreen("Customer",1);
                c2.setVisible(true);
                dispose();
            }
        });
        driverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInScreen c2 = new LogInScreen("Driver",2);
                c2.setVisible(true);
                dispose();
            }
        });
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogInScreen c2 = new LogInScreen("Admin",3);
                c2.setVisible(true);
                dispose();
            }
        });
    }
}
