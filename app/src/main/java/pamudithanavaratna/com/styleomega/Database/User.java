package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.sql.Blob;

public class User extends SugarRecord<User> implements Serializable {

    public String email;
    public String Fname;
    public String Lname;
    public String ContactNumber;
    public String password;
    //Blob photo;

    public User() {

    }

    public User(String email, String fname, String lname, String contactNumber, String password) {
        this.email = email;
        Fname = fname;
        Lname = lname;
        ContactNumber = contactNumber;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
