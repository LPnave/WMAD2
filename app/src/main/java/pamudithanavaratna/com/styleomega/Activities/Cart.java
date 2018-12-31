package pamudithanavaratna.com.styleomega.Activities;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pamudithanavaratna.com.styleomega.Database.User;
import pamudithanavaratna.com.styleomega.Fragments.CartFragment;
import pamudithanavaratna.com.styleomega.Fragments.PayFragment;
import pamudithanavaratna.com.styleomega.R;

public class Cart extends AppCompatActivity {

    User loggedin;

    public User getLoggedin() {
        return loggedin;
    }

    public static FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        loggedin= (User)getIntent().getExtras().getSerializable("loggeduser");

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



/*
    public void OnClickPay (View v){

        fragmentManager.beginTransaction().replace(R.id.cartFragmentContainer,
                new PayFragment(),null).addToBackStack("cart").commit();
    }*/

}
