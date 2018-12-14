package pamudithanavaratna.com.styleomega.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pamudithanavaratna.com.styleomega.Fragments.SignInFragment;
import pamudithanavaratna.com.styleomega.R;

public class Sign_In extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__in);

        fragmentManager= getSupportFragmentManager();

        if(findViewById(R.id.SignInFragmentContainer)!=null){
            //to avoid overlapping
            if(savedInstanceState!=null){
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            SignInFragment signInFragment = new SignInFragment();

            fragmentTransaction.add(R.id.SignInFragmentContainer,signInFragment);

            fragmentTransaction.commit();
        }
    }

}
