package pamudithanavaratna.com.styleomega.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pamudithanavaratna.com.styleomega.R;
import pamudithanavaratna.com.styleomega.Activities.Sign_In;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddressFragment extends Fragment {

    private Button AddressBtn;

    public AddressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_address,container,false);

       AddressBtn= v.findViewById(R.id.AddressNextBtn);
       AddressBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Sign_In.fragmentManager.beginTransaction().replace(R.id.SignInFragmentContainer,
                         new PaymentDetailsFragment(),null).addToBackStack("tag3").commit();
             }
         }

       );

       return v;
    }

}
