package pamudithanavaratna.com.styleomega.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pamudithanavaratna.com.styleomega.Database.Login;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Login testlog = new Login("pamudithanavaratna@gmail.com","123");
        testlog.save();

        startActivity(new Intent(Splashscreen.this,Sign_In.class));
        finish();
    }
}
