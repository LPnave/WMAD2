package pamudithanavaratna.com.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import pamudithanavaratna.com.styleomega.Database.Login;
import pamudithanavaratna.com.styleomega.Database.PaymentDetails;
import pamudithanavaratna.com.styleomega.Database.ShippingDetails;
import pamudithanavaratna.com.styleomega.Database.User;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Login testlog = new Login("pamudithanavaratna@gmail.com","123");
        testlog.save();

        User testuser = new User("pamudithanavaratna@gmail.com","Lahiru","Navaratna","0713031690","123");
        testuser.save();

        ShippingDetails testSD = new ShippingDetails("280,Balagolla, Kengalle","Dharshana Mw","Kandy","Central",20186,testuser);
        testSD.save();

        try {
            PaymentDetails testPD = new PaymentDetails("123546489", 549,
                    new SimpleDateFormat("dd/mm/yyyy").parse("14/03/2019"), testuser);
        }catch (ParseException e){
            e.printStackTrace();
        }

        startActivity(new Intent(Splashscreen.this,Sign_In.class));
        finish();
    }
}
