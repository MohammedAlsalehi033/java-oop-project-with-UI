import java.io.Serializable;

public abstract class Person implements Serializable {


    protected String name;
    protected String email;
    private String password;
    protected String  phoneNumber;

    public Person() {
    }



    public Person(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public abstract void editProfile ();

    public static Person signIn (int a, String email,String password){

        if (a == 1){


            return Customer.signIn(email,password);
        } else if (a == 2) {
            return Driver.signIn(email,password);
        }
        else {
            return Admin.signIn(email,password);

        }


    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return
                "Name='" + name + '\'' +
                "\nPhoneNumber=" + phoneNumber +
                ' ';
    }
}
