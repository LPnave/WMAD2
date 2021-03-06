package pamudithanavaratna.com.styleomega.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.Fragments.CartFragment;
import pamudithanavaratna.com.styleomega.R;

public class Cart extends AppCompatActivity {

    User loggedin;

    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        loggedin= (User)getIntent().getSerializableExtra("loggeduser");

        fragmentManager= getSupportFragmentManager();
        if(findViewById(R.id.cartFragmentContainer)!=null){
            if(savedInstanceState!=null){
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            CartFragment cartFragment = new CartFragment();
            fragmentTransaction.add(R.id.cartFragmentContainer,cartFragment,null);
            fragmentTransaction.commit();
        }

    }


}
