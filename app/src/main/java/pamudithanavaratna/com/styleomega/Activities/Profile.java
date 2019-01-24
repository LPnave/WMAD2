package pamudithanavaratna.com.styleomega.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import pamudithanavaratna.com.styleomega.Adapters.CustomSharedPreference;
import pamudithanavaratna.com.styleomega.Database.PaymentDetails;
import pamudithanavaratna.com.styleomega.Database.ShippingDetails;
import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.R;

public class Profile extends AppCompatActivity {

    //private SharedPreferences preferences;
    private CustomSharedPreference preference;

    Button savebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        preference = CustomSharedPreference.getInstance();

        //preferences = getSharedPreferences("user", MODE_PRIVATE);
       // long userid = preferences.getLong("userid",0);
        long userid = preference.getALong(getApplicationContext(),"userid");

        final User currentuser = User.findById(User.class,userid);
        String id = Long.toString(userid);
        String email = currentuser.email;
        String fname = currentuser.Fname;
        String lname = currentuser.Lname;
        final String mobilenumber = currentuser.ContactNumber;
        String Password = currentuser.password;


        final ShippingDetails sd = ( ShippingDetails.find(ShippingDetails.class,"user=?",id)).get(0);

         String address = sd.getAddress();
        String streetname = sd.getLane();
        String province = sd.getProvince();
        String district = sd.getCity();
         int postalcode = sd.getPostalcode();

        final PaymentDetails pd = (PaymentDetails.find(PaymentDetails.class,"user=?",id)).get(0);

        String acnumber = pd.getCardnumber();
        int vsc = pd.getVsc();
        final Date expdate = pd.getExpiriyDate();

        final EditText mfn = findViewById(R.id.ProfileFirstName);
        mfn.setText(fname);
        EditText mln = findViewById(R.id.ProfileLastName);
        mln.setText(lname);
        EditText mEmail = findViewById(R.id.ProfileEmail);
        mEmail.setText(email);
        final EditText mcontact = findViewById(R.id.ProfileMobileNumber);
        mcontact.setText(mobilenumber);
        final EditText mpassword = findViewById(R.id.ProfilePassword);
        mpassword.setText(Password);

        final EditText maddress = findViewById(R.id.AddressProfile);
        maddress.setText(address);
        final EditText mstreet = findViewById(R.id.ProfileStreetName);
        mstreet.setText(streetname);
        final EditText mprovince = findViewById(R.id.ProfileProvince);
        mprovince.setText(province);
        final EditText mdistrict = findViewById(R.id.ProfileDistrict);
        mdistrict.setText(district);
        final EditText mpostal = findViewById(R.id.ProfilePostalCode);
        mpostal.setText(String.valueOf(postalcode));

        final EditText mAnumber = findViewById(R.id.ProfileAccountNumber);
        mAnumber.setText(acnumber);
        final EditText mvsc = findViewById(R.id.ProfileVSC);
        mvsc.setText(String.valueOf(vsc));
        final EditText mexpdate = findViewById(R.id.ProfileExpDate);
        SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yy");
        mexpdate.setText(sf.format(expdate));

        savebutton = findViewById(R.id.saveprofilebtn);

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentuser.setContactNumber(mcontact.getText().toString());
                currentuser.setPassword(mpassword.getText().toString());
                currentuser.save();

                sd.setAddress(maddress.getText().toString());
                sd.setLane(mstreet.getText().toString());
                sd.setCity(mdistrict.getText().toString());
                sd.setProvince(mprovince.getText().toString());
                sd.setPostalcode(Integer.parseInt(mpostal.getText().toString()));
                sd.save();

                pd.setCardnumber(mAnumber.getText().toString());
                pd.setVsc(Integer.parseInt(mvsc.getText().toString()));
                pd.setExpiriyDate(new SimpleDateFormat("dd-mm-yyyy").parse(mexpdate.getText().toString(), new ParsePosition(0)));
                pd.save();

                Toast.makeText(getApplicationContext(), "Account Details Updated", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
