package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.io.Serializable;
import java.sql.Blob;

public class User extends SugarRecord implements Serializable {

    String email;
    String Fname;
    String Lname;
    int ContactNumber;
    String password;
    //Blob photo;

    public User() {

    }

    public User(String email, String fname, String lname, int contactNumber, String password) {
        this.email = email;
        Fname = fname;
        Lname = lname;
        ContactNumber = contactNumber;
        this.password = password;
    }
}
