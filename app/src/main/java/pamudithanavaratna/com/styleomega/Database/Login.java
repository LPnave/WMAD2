package pamudithanavaratna.com.styleomega.Database;

import com.orm.SugarRecord;

public class Login extends SugarRecord {

    String useremail;
    String password;

    public Login() {

    }

    public Login(String useremail, String password) {
        this.useremail = useremail;
        this.password = password;
    }

    public String getUseremail() {
        return useremail;
    }

    public String getPassword() {
        return password;
    }
}
