import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignUpForCustomer extends JFrame{
    private JTextField Email;

    private JTextField age;
    private JTextField CCnun;
    private JTextField phone;
    private JTextField Name;
    private JPanel mainPanal;
    private JButton Submit;
    private JPasswordField passwordField;

    public SignUpForCustomer(String title) {
        super(title);
        this.setContentPane(mainPanal);
        this.pack();
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String email = Email.getText().toString();

                String passWord = Arrays.toString(passwordField.getPassword());

                    String name = Name.getText().toString();

                    String phone2 = phone.getText().toString();

                    long ccnum = Long.parseLong(CCnun.getText().toString());


                    int age2 = Integer.parseInt(age.getText().toString());

                    Customer customer1 = new Customer(email, passWord,name,phone2,ccnum,age2,0);
                     customer1.signUp();
            }
        }
        );
    }

}
