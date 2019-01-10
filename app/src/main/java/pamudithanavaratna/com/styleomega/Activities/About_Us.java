package pamudithanavaratna.com.styleomega.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;
import pamudithanavaratna.com.styleomega.R;

public class About_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Element version = new Element();
        version.setTitle("Version 1.0");

       // Element ads = new Element();
       // ads.setTitle()

        View aboutpage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.splashlogo)
                .setDescription("We are an online clothing store bringing you the latest in the world of fashion")
                .addItem(version)
                .addGroup("Connect with us")
                .addEmail("pamudithanavaratna@gamil.com")
                .addFacebook("pamudithanavaratne")
                .addInstagram("lp_nave")
                .addGitHub("LPnave")
                .create();

        setContentView(aboutpage);
    }
}
