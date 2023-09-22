import javax.swing.*;

public class DriverScreen extends JFrame{
    private JComboBox comboBox1;
    private JPanel mainPanal;
    private JLabel DriverInfo;
    private JButton Confirm;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton saveNewPasswordAndButton;

    public DriverScreen(String title) {
        super(title);
        this.setContentPane(mainPanal);
        this.pack();

}
}
