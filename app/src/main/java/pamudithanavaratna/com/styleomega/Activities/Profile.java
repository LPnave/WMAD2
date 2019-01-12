package pamudithanavaratna.com.styleomega.Activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pamudithanavaratna.com.styleomega.Database.PaymentDetails;
import pamudithanavaratna.com.styleomega.Database.ShippingDetails;
import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.R;

public class Profile extends AppCompatActivity {

    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        preferences = getSharedPreferences("user", MODE_PRIVATE);
        long userid = preferences.getLong("userid",0);

        User currentuser = User.findById(User.class,userid);
        String id = Long.toString(userid);
        String email = currentuser.email;
        String fname = currentuser.Fname;
        String lname = currentuser.Lname;
        String mobilenumber = currentuser.ContactNumber;
        String Password = currentuser.password;

        String address = null;
        String streetname= null;
        String province= null;
        String district= null;
        int postalcode=0;

        List<ShippingDetails> sdlist =  ShippingDetails.find(ShippingDetails.class,"user=?",id);
        for(ShippingDetails sd : sdlist) {
           address = sd.getAddress();
             streetname = sd.getLane();
             province = sd.getProvince();
             district = sd.getCity();
             postalcode = sd.getPostalcode();
        }

        String acnumber= null;
        int vsc=0;
        Date expdate= null;

        List<PaymentDetails> pdlist = PaymentDetails.find(PaymentDetails.class,"user=?",id);
        for(PaymentDetails pd : pdlist) {
            acnumber = pd.getCardnumber();
            vsc = pd.getVsc();
            expdate = pd.getExpiriyDate();
        }

        EditText mfn = findViewById(R.id.ProfileFirstName);
        mfn.setText(fname);
        EditText mln = findViewById(R.id.ProfileLastName);
        mln.setText(lname);
        EditText mEmail = findViewById(R.id.ProfileEmail);
        mEmail.setText(email);
        EditText mcontact = findViewById(R.id.ProfileMobileNumber);
        mcontact.setText(mobilenumber);
        EditText mpassword = findViewById(R.id.ProfilePassword);
        mpassword.setText(Password);

        EditText maddress = findViewById(R.id.AddressProfile);
        maddress.setText(address);
        EditText mstreet = findViewById(R.id.ProfileStreetName);
        mstreet.setText(streetname);
        EditText mprovince = findViewById(R.id.ProfileProvince);
        mprovince.setText(province);
        EditText mdistrict = findViewById(R.id.ProfileDistrict);
        mdistrict.setText(district);
        EditText mpostal = findViewById(R.id.ProfilePostalCode);
        mpostal.setText(String.valueOf(postalcode));

        EditText mAnumber = findViewById(R.id.ProfileAccountNumber);
        mAnumber.setText(acnumber);
        EditText mvsc = findViewById(R.id.ProfileVSC);
        mvsc.setText(String.valueOf(vsc));
        EditText mexpdate = findViewById(R.id.ProfileExpDate);
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy");
        mexpdate.setText(sf.format(expdate));




    }
}
